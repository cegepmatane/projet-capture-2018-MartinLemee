var VueAnnee = (function(){
	var vueAnnee = document.getElementById("page-liste-temperature-annee").innerHTML;
	
	return function(listeTemperatureDonnee){
		this.afficher = function(){
			document.getElementsByTagName("body")[0].innerHTML = vueAnnee;
			/*var listeTemperature = document.getElementById("liste-temperature-annee");
			var li="";
			for(var numeroTemperature in listeTemperatureDonnee){
				li += '<li><a href="#temperature/'+
                numeroTemperature +
                '"> Mois: ' + listeTemperatureDonnee[numeroTemperature].heure+
				'     Valeur: '+ listeTemperatureDonnee[numeroTemperature].valeur+'°C'
                "</a></li>";
			}*/
			//listeTemperature.innerHTML = li;
		}
	};
})();