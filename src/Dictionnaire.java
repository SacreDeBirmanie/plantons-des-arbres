import java.util.ArrayList;

public class Dictionnaire {
	
	private Noeud<String,String> dico;

    public Dictionnaire(){
        this.dico =new Noeud<String, String>();
    }

	public Dictionnaire(Noeud<String,String> dicos) {
		super();
		this.dico = dicos;
	}

	
	public void ajouter(String mot, String definition){
        if(dico == null)
            dico = new Noeud<String, String>();
            Noeud<String,String> tmp = dico;
            for (int i = 0; i < mot.length(); i++) {
                tmp = tmp.ajouterNoeud(String.valueOf(mot.charAt(i)));
            }
            tmp.ajouterValeur(definition);
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
			return false;
		
	}

}
