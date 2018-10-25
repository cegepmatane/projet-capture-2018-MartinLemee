var meteoDAO = require('./TemperatureDAO');
var http = require('http');

var repondre = async function(requete, reponse)
{
    if('GET' === requete.method)
	  {

    }

    if('POST' === requete.method)
    {

    }
}

var serveur = http.createServer(repondre);
serveur.listen(8080);
