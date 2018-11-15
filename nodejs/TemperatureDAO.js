var postgresql = require('pg');
var chaineDeConnection = 'postgres://postgres:adminadmin@localhost:5432/meteo';

exports.listerTemperature = async function()
{
    console.log("TemperatureDAO.listerTemperature()");
    var basededonnees = new postgresql.Client(chaineDeConnection);
    await basededonnees.connect();
    var curseurListeTemperature = await basededonnees.query('SELECT * FROM public.capteurtemperature');

    var listeTemperature = {}; var position = 0;
    curseurListeTemperature.rows.forEach
        (
              capteurtemperature=>
              {
                    console.log("DAO:" + capteurtemperature.temperature);
                    listeTemperature[position++] = capteurtemperature;
              }
        );

        return listeTemperature;
}

exports.chercherTemperature = async function(numero)
{
    console.log("TemperatureDAO.chercherTemperature()");
    var basededonnees = new postgresql.Client(chaineDeConnection);
	  await basededonnees.connect();
    var sql = 'select * from capteurtemperature where id = ' + numero;
	  console.log(sql);
    var curseurListeTemperature = await basededonnees.query(sql);
	  var temperature = curseurListeTemperature.rows[0];
	  return temperature;
}

exports.ajouterTemperature = async function(temperature)
{
    console.log("TemperatureDAO.ajouterTemperature()");
    var basededonnees = new postgresql.Client(chaineDeConnection);
    await basededonnees.connect();
    var sql = 'INSERT INTO capteurtemperature(temperature, moment) VALUES('+ temperature + ', "now")';
    console.log(sql);
    var curseurListeTemperature = await basededonnees.query(sql);
	  var temperature = curseurListeTemperature.rows[0];
	  return temperature;
}
