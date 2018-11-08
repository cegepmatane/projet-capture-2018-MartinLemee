<?php

    $usager = 'root';
    $motdepasse = 'qwerty';
    $hote = 'localhost';
    $base = 'meteo';
    $dsn = 'mysql:dbname='.$base.';host=' . $hote;
    $basededonnees = new PDO($dsn, $usager, $motdepasse);

?>