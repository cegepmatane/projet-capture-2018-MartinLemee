<?php
	header("Content-type: text/xml");
	echo '<?xml version="1.0" encoding="UTF-8"?>';
	//print_r($_GET);
	
	include ("../BDD.php");

	$sql = "SELECT AVG(temperature) as TemperatureMoyenne, MAX(temperature) as TemperatureMaximum, MIN(temperature) as TemperatureMinimun, to_char(moment, 'MM') as mois FROM capteurtemperature WHERE to_char(moment, 'YYYY') like :annee GROUP BY to_char(moment, 'MM');";
	$requeteListeTemperature = $basededonnees->prepare($sql);
	$requeteListeTemperature->bindParam(':annee',  $_GET['annee']);
	$requeteListeTemperature->execute();
	$listeTemperature = $requeteListeTemperature->fetchAll(PDO::FETCH_OBJ);
	//print_r($listeTemperature);
	
	?>

<meteo>
	<annee><?=$_GET['annee']?></annee>
	<?php foreach($listeTemperature as $temperature) 
	{ ?>
	<mois><?=$temperature->mois?></mois>
	<temperature>
		<max><?=$temperature->temperaturemaximum?></max>
		<min><?=$temperature->temperatureminimun?></min>
		<moyenne><?=$temperature->temperaturemoyenne?></moyenne>
	</temperature>
	<?php } ?>
</meteo>



