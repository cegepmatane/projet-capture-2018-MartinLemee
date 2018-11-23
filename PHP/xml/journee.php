<?php
	header("Content-type: text/xml");
	echo '<?xml version="1.0" encoding="UTF-8"?>';
	//print_r($_GET);
	
    include ("../BDD.php");
    date_default_timezone_set('America/Toronto');
    $annee = date('Y');
    $mois = date('m');
    $jour = date('d');
    $heure = date('H');

	$sqlCalcul = "SELECT 
                    AVG(temperature) as TemperatureMoyenne, 
                    MAX(temperature) as TemperatureMaximum, 
                    MIN(temperature) as TemperatureMinimun
                FROM capteurtemperature 
                WHERE to_char(moment, 'YYYY') like :annee 
                AND to_char(moment, 'MM') like :mois 
                AND to_char(moment, 'DD') like :jour;";     

	$requeteCalculTemperature = $basededonnees->prepare($sqlCalcul);
	$requeteCalculTemperature->bindParam(':annee', $annee);
	$requeteCalculTemperature->bindParam(':mois', $mois);
    $requeteCalculTemperature->bindParam(':jour', $jour);
	$requeteCalculTemperature->execute();
    $calculTemperature = $requeteCalculTemperature->fetchAll(PDO::FETCH_OBJ);
    
    $sqlTemperatureActuelle = "SELECT temperature as temperatureactuelle
                FROM capteurtemperature 
                WHERE to_char(moment, 'YYYY') like :annee 
                AND to_char(moment, 'MM') like :mois 
                AND to_char(moment, 'DD') like :jour
                AND to_char(moment, 'HH24') like :heure;";     

	$requeteTemperatureActuelle = $basededonnees->prepare($sqlTemperatureActuelle);
	$requeteTemperatureActuelle->bindParam(':annee', $annee);
	$requeteTemperatureActuelle->bindParam(':mois', $mois);
    $requeteTemperatureActuelle->bindParam(':jour', $jour);
    $requeteTemperatureActuelle->bindParam(':heure', $heure);
	$requeteTemperatureActuelle->execute();
	$temperatureActuelle = $requeteTemperatureActuelle->fetchAll(PDO::FETCH_OBJ);
	
	?>

<meteo>
	<date>
        <annee><?=$annee?></annee>
        <mois><?=$mois?></mois>
        <jour><?=$jour?></jour>
	    <heure><?=$heure?></heure>
    </date>
    <temperature>
        <actuelle><?=$temperatureActuelle[0]->temperatureactuelle?></actuelle>
		<max><?=$calculTemperature[0]->temperaturemaximum?></max>
		<min><?=$calculTemperature[0]->temperatureminimun?></min>
		<moyenne><?=$calculTemperature[0]->temperaturemoyenne?></moyenne>
	</temperature>
</meteo>