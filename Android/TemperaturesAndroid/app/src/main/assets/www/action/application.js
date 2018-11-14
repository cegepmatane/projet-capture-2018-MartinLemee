(function(){
	var instance = this;
	
	var lancer = function(){
		//$('#donnees').load('http://167.114.152.43:22/script.php');
		this.vueJour = new VueJour();
		window.addEventListener("hashchange",naviguer);
		naviguer();
	}
	var naviguer = function(){
		var hash = window.location.hash;
		if(!hash){
			var vueJour = new VueJour();
			vueJour.afficher();
		}else if(hash.match(/^#vue-jour/)){
			var vueJour = new VueJour();
			vueJour.afficher();
		}else if(hash.match(/^#vue-mois/)){
			var vueMois = new VueMois();
			vueMois.afficher();
		}else if(hash.match(/^#vue-annee/)){
			var vueAnnee = new VueAnnee();
			vueAnnee.afficher();
		}
	}
	lancer();
	
})();