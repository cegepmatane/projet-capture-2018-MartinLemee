<?php
	header("Content-type: text/xml");
	echo '<?xml version="1.0" encoding="UTF-8"?>';
	//print_r($_GET);
	
	include ("../BDD.php");

	$sql = "SELECT AVG(temperature) as TemperatureMoyenne, MAX(temperature) as TemperatureMaximum, MIN(temperature) as TemperatureMinimun, to_char(moment, 'DD') as jour FROM capteurtemperature WHERE to_char(moment, 'YYYY') like :annee AND to_char(moment, 'MM') like :mois GROUP BY to_char(moment, 'DD');";
	$requeteListeTemperature = $basededonnees->prepare($sql);
	$requeteListeTemperature->bindParam(':annee',  $_GET['annee']);
	$requeteListeTemperature->bindParam(':mois',  $_GET['mois']);
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
		<max><?=$temperature->temperaturemaximum?></max>
		<min><?=$temperature->temperatureminimun?></min>
		<moyenne><?=$temperature->temperaturemoyenne?></moyenne>
	</temperature>
	<?php } ?>
</meteo>



