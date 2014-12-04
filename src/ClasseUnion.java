import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sébastien on 03/12/14.
 */
public class ClasseUnion {

    private static int pNull = -1;
    private ArrayList<Integer> ensemble;


    public ClasseUnion(){


    }
    public void creer(int x ){ //crée la classe {x}, dont x est le représentant.
        ensemble.add(x,pNull);

    }
    public void union(int v, int w){ //réunit les classes de représentants v et w
        if(classe(v) == classe(w))
            ensemble.add(classe(v),classe(w));
    }

    public int classe(int x){ //retourne le représentant de la classe contenant x
        int parentPrecedent = x;
        int parentSuivant = ensemble.get(x);
        while(!(pNull == parentSuivant)){
            parentPrecedent = parentSuivant;
            parentSuivant = ensemble.get(parentSuivant);
        }

        return parentPrecedent;

    }

}
