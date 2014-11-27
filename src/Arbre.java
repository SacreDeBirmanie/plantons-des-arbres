public interface Arbre<type> {
	
	public boolean estFeuille();
	public Arbre<type> recupererFils(type etq );
	public type retournerValeur();
	
}
