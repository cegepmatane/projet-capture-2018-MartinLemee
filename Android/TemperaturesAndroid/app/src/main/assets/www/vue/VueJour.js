var VueJour = (function(){
	var vueJour = document.getElementById("page-liste-temperature-jour").innerHTML;
	
	return function(listeTemperatureDonnee){
		this.afficher = function(){
			document.getElementsByTagName("body")[0].innerHTML = vueJour;
			var listeTemperature = document.getElementById("liste-temperature-jour");
			/*var li="";
			for(var numeroTemperature in listeTemperatureDonnee){
				li += '<li><a href="#temperature/'+
                numeroTemperature +
                '"> Heure: ' + listeTemperatureDonnee[numeroTemperature].heure+
				'     Valeur: '+ listeTemperatureDonnee[numeroTemperature].valeur+'°C'
                "</a></li>";
			}*/
			//listeTemperature.innerHTML = li;
		}
	};
	
})();