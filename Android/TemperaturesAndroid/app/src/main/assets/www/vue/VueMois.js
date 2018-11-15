var VueMois = (function(){
	var vueMois = document.getElementById("page-liste-temperature-mois").innerHTML;
	
	return function(listeTemperatureDonnee){
		this.afficher = function(){
			document.getElementsByTagName("body")[0].innerHTML = vueMois;
			/*var listeTemperature = document.getElementById("liste-temperature-mois");
			var li="";
			for(var numeroTemperature in listeTemperatureDonnee){
				li += '<li><a href="#temperature/'+
                numeroTemperature +
                '"> Jour: ' + listeTemperatureDonnee[numeroTemperature].heure+
				'     Valeur: '+ listeTemperatureDonnee[numeroTemperature].valeur+'°C'
                "</a></li>";
			}*/
			//listeTemperature.innerHTML = li;
		}
	};
})();