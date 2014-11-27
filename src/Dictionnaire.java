import java.util.ArrayList;

public class Dictionnaire {
	
	private Noeud<String,String> dico;

	public Dictionnaire(Noeud<String,String> dicos) {
		super();
		this.dico = dicos;
	}

	
	public void ajouter(String mot, String definition){
		Noeud<String,String> tmp = dico;
		for (int i = 0; i < mot.length(); i++) {
	        tmp = tmp.ajouterNoeud(String.valueOf(mot.charAt(i)));
	    }
		tmp.ajouterValeur(definition);
	}
	
	public void supprimer(String mot){
		if(mot.length()==0) {
			
		}
	}
	
	public boolean rechercher(String mot){
		Noeud<String,String> tmp = dico;
		for (int i = 0; i < mot.length(); i++) {
			if(tmp != null)
				tmp = tmp.recupererFils(String.valueOf(mot.charAt(i)));
			else
				break;
		}
		if(tmp == null)
			return false;
		else if(tmp.contientValeur())
				return true;
		else
			return true;
		
	}
	
	public ArrayList<String> retournerMots(){
		
	}

}
