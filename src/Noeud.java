import java.util.ArrayList;

public class Noeud<Etq,Valeur> {
	
	private Etq etiquette;
	private ArrayList<Noeud<Etq,Valeur>> fils;
	private Valeur feuille;

    public Noeud() {
        this.etiquette = null;
        this.fils = null;
        this.feuille = null;
    }

    public Noeud(Etq etiquette) {
        this.etiquette = etiquette;
        this.fils = new ArrayList<Noeud<Etq,Valeur>>();
        this.feuille = null;
    }

	public Noeud(Etq etiquette, ArrayList<Noeud<Etq,Valeur>> fils) {
		this.etiquette = etiquette;
		this.fils = fils;
		this.feuille = null;
	}
	
	public Etq getEtiquette() {
		return etiquette;
	}
	public void setEtiquette(Etq etiquette) {
		this.etiquette = etiquette;
	}
	public ArrayList<Noeud<Etq,Valeur>> getFils() {
		return fils;
	}
	public void setFils(ArrayList<Noeud<Etq,Valeur>> fils) {
		this.fils = fils;
	} 
	
	public boolean estFeuille(){
		return (this.fils.size()==0);
	}
	
	public boolean contientValeur(){
		return(this.feuille != null);
	}
	
	public Noeud<Etq,Valeur> recupererFils(Etq etq ){
		Noeud<Etq,Valeur> retour = null;
		for(Noeud<Etq,Valeur> arb : this.fils) 
			if(arb.estFeuille()!=true && arb.retournerValeur().equals(etq)){
				retour = (Noeud<Etq,Valeur>)arb;
				break;
			}
		return retour;
	}
	
	public Noeud<Etq,Valeur> ajouterNoeud(Etq etiquette){
		Noeud<Etq,Valeur> n = this.recupererFils(etiquette);
		if(n == null){
			n = new Noeud<Etq,Valeur>(etiquette);
			this.fils.add(n);
		}
		return n;	
	}
	
	public void ajouterValeur(Valeur feuille){
		this.feuille = feuille;
		
	}
		
	
	public Etq retournerValeur(){
		return etiquette;
	}
	
	public boolean supprimer(Etq etiquette){
		return fils.remove(this.recupererFils(etiquette));
	}
	
}
