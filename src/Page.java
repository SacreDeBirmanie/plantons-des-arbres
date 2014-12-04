import java.util.ArrayList;

/**
 * Created by Sébastien on 04/12/14.
 */
public class Page{
    private int identifiant;
    private ArrayList<String> reconnus;

    public Page(int identifiant){
        this.identifiant = identifiant;
        this.reconnus = new ArrayList<String>();
    }

    public int getIdentifiant(){
        return this.identifiant;
    }

    public ArrayList<String> getReconnus(){
        return this.reconnus;

    }

    public void setReconnus(ArrayList<String> mots){
        this.reconnus = mots;

    }


}
