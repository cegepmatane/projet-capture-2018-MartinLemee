<?php
	header("Content-type: text/xml");
	echo '<?xml version="1.0" encoding="UTF-8"?>';
	//print_r($_GET);
	
	include ("../BDD.php");

	$sql = "SELECT AVG(valeur) as TemperatureMoyenne, MAX(valeur) as TemperatureMaximum, MIN(valeur) as TemperatureMinimun, MONTH(moment) as mois FROM temperature WHERE YEAR(moment) = ".$_GET['annee']." GROUP BY MONTH(moment);";
	$requeteListeTemperature = $basededonnees->prepare($sql);
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
		<max><?=$temperature->TemperatureMaximum?></max>
		<min><?=$temperature->TemperatureMinimun?></min>
		<moyenne><?=$temperature->TemperatureMoyenne?></moyenne>
	</temperature>
	<?php } ?>
</meteo>



