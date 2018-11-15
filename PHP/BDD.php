<?php
    $usager = 'root';
    $motdepasse = 'root';
    $hote = 'localhost';
    $base = 'meteo';
    $basededonnees = new PDO('pgsql:dbname='.$base.' host='.$hote.'', $usager, $motdepasse);
?>