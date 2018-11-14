<?php
	header("Content-type: text/xml");
	echo '<?xml version="1.0" encoding="UTF-8"?>';
	//print_r($_GET);
	
	include ("../BDD.php");


/*SELECT AVG(valeur) as TemperatureMoyenne, MAX(valeur) as TemperatureMaximum, MIN(valeur) as TemperatureMinimun, MONTH(moment) as mois FROM temperature WHERE YEAR(moment) = 2018 GROUP BY MONTH(moment) 
UNION 
SELECT AVG(valeur) as TemperatureMoyenne, MAX(valeur) as TemperatureMaximum, MIN(valeur) as TemperatureMinimun, 'TOUS' as mois FROM temperature WHERE YEAR(moment) = 2018  
mais plutot
SELECT valeur, YEAR(moment) as annee, MONTH(moment) as mois, DAY(moment) as jour, HOUR(moment) as heure FROM temperature WHERE YEAR(moment) = 2018 AND MONTH(moment) = 9 AND DAY(moment) = 5 
*/

	$sql = "SELECT valeur, YEAR(moment) as annee, MONTH(moment) as mois, DAY(moment) as jour, HOUR(moment) as heure FROM temperature WHERE YEAR(moment) = ".$_GET['annee']." AND MONTH(moment) = ".$_GET['mois']." AND DAY(moment) = ".$_GET['jour']." ";
	$requeteListeTemperature = $basededonnees->prepare($sql);
	$requeteListeTemperature->execute();
	$listeTemperature = $requeteListeTemperature->fetchAll(PDO::FETCH_OBJ);
	//print_r($listeTemperature);
	
	?>

<meteo>
	<jour><?=$listeTemperature[0]->annee?>-<?=$listeTemperature[0]->mois?>-<?=$listeTemperature[0]->jour?></jour>
	<?php foreach($listeTemperature as $temperature) 
	{ ?>
	<heure><?=$temperature->heure?></heure>
	<temperature><?=$temperature->valeur?></temperature>
	<?php } ?>
</meteo>



