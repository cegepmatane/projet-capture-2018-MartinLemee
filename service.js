var temperatureDAO = require('./TemperatureDAO');
var http = require('http');

var repondre = async function(requete, reponse)
{
    if('GET' === requete.method)
	  {
        if('/CapteurTemperature/liste' === requete.url || '/CapteurTemperature/liste/' === requete.url)
		    {
          var listeTemperature = await temperatureDAO.listerTemperature();
			    reponse.end(JSON.stringify(listeTemperature));
        }

        if(trouvailles = requete.url.match(/\/CapteurTemperature\/([0-9]+)\/?/))
		    {
			       numero = trouvailles[1];
			       console.log('match une seule temperature ' + numero);

			       var temperature = await TemperatureDAO.chercherTemperature(numero);
			       console.log('temperature reçu de la base ' + JSON.stringify(temperature));
			       reponse.end(JSON.stringify(temperature));
		     }
    }

    if('POST' === requete.method)
    {
        var uri = '';
        requete.on('data', function(message){ uri += message;});
        requete.on('end', function()
        {
          uri = decodeURI(uri);
          uri = uri.replace(/%3A/g, ":").replace(/%2C/g,",");
          [cle, temperature] = uri.split("=");
          console.log(temperature);
          temperature = JSON.parse(temperature).temperature; // recupere la racine
          console.log("Temperature : " + temperature.temperature);
          console.log(JSON.stringify(temperature));
          temperatureDAO.ajouterMouton(temperature);//await
        });

    }
    reponse.end('');
}

var serveur = http.createServer(repondre);
serveur.listen(8080);
