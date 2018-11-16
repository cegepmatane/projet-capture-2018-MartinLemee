<?php
	header("Content-type: text/xml");
	echo '<?xml version="1.0" encoding="UTF-8"?>';
	//print_r($_GET);
	
	include ("../BDD.php");

	$sql = "SELECT temperature, to_char(moment, 'YYYY') as annee, to_char(moment, 'MM') as mois, to_char(moment, 'DD') as jour, to_char(moment, 'HH24') as heure FROM capteurtemperature WHERE to_char(moment, 'YYYY') like :annee AND to_char(moment, 'MM') like :mois AND to_char(moment, 'DD') like :jour;";
	$requeteListeTemperature = $basededonnees->prepare($sql);
	$requeteListeTemperature->bindParam(':annee',  $_GET['annee']);
	$requeteListeTemperature->bindParam(':mois',  $_GET['mois']);
	$requeteListeTemperature->bindParam(':jour',  $_GET['jour']);
	$requeteListeTemperature->execute();
	$listeTemperature = $requeteListeTemperature->fetchAll(PDO::FETCH_OBJ);
	//print_r($listeTemperature);
	
	?>

<meteo>
	<jour><?=$listeTemperature[0]->annee?>-<?=$listeTemperature[0]->mois?>-<?=$listeTemperature[0]->jour?></jour>
	<?php foreach($listeTemperature as $temperature) 
	{ ?>
	<heure><?=$temperature->heure?></heure>
	<temperature><?=$temperature->temperature?></temperature>
	<?php } ?>
</meteo>



