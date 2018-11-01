<?php 
try{
	$baseDeDonnees = new PDO('mysql:host=localhost;dbname=temperatures;charset=utf8','root','',array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION));
}catch(Exception $e){
	die('Erreur: '.$e->getMessage());
}

$requete = $baseDeDonnees->prepare('SELECT * FROM temperatures WHERE id=? ORDER BY date');
//requete classée par date. WHERE id = ? sujet à changement
//$requete->execute(array($_GET['valeur'], $_GET['date']));

echo '<ul>';
while($donnees = $req->fetch()){
	echo '<li>' . $donnees['date'] . ' : ' . $donnees['valeur'] . '°C)</li>';
}
echo '</ul>';
$requete->closeCursor();

?>