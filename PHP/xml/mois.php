<?php
	header("Content-type: text/xml");
	echo '<?xml version="1.0" encoding="UTF-8"?>';
	//print_r($_GET);
	
	include ("../BDD.php");

	$sql = "SELECT AVG(valeur) as TemperatureMoyenne, MAX(valeur) as TemperatureMaximum, MIN(valeur) as TemperatureMinimun, DAY(moment) as jour FROM temperature WHERE YEAR(moment) = ".$_GET['annee']." AND MONTH(moment) = ".$_GET['mois']." GROUP BY DAY(moment);";
	$requeteListeTemperature = $basededonnees->prepare($sql);
	$requeteListeTemperature->execute();
	$listeTemperature = $requeteListeTemperature->fetchAll(PDO::FETCH_OBJ);
	//print_r($listeTemperature);
	
	?>

<meteo>
	<mois><?=$_GET['annee']?>-<?=$_GET['mois']?></mois>
	<?php foreach($listeTemperature as $temperature) 
	{ ?>
	<jour><?=$temperature->jour?></jour>
	<temperature>
		<max><?=$temperature->TemperatureMaximum?></max>
		<min><?=$temperature->TemperatureMinimun?></min>
		<moyenne><?=$temperature->TemperatureMoyenne?></moyenne>
	</temperature>
	<?php } ?>
</meteo>



