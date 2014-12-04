import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * Created by Sébastien on 04/12/14.
 */
public class Reconnaissance {

    private Dictionnaire dico;
    private String regle;
    private ArrayList<Page> pages;
    ClasseUnion classes;
    int limiteReconnaissance;

    public Reconnaissance(Dictionnaire dico,String regex,int k){
        this.dico = dico;
        this.regle = regex;
        pages = new ArrayList<Page>();
        classes = new ClasseUnion();
        this.limiteReconnaissance = k;

    }

    public void reconnaitreMots(BufferedReader texte,Page page) throws IOException {
        Pattern pattern = compile(regle);
        Matcher matcher;

        ArrayList<String> mots = new ArrayList<String>();
        String ligne;
        while ((ligne=texte.readLine())!=null){
            matcher = pattern.matcher(ligne);
            while(matcher.find()){
                if(dico.rechercher(matcher.group()) == true){
                    mots.add(matcher.group());
                }

            }
        }

        page.setReconnus(mots);
        pages.add(page.getIdentifiant(),page);
        classes.creer(page.getIdentifiant());



    }

    public void grouperPages(){
        Page x;
        Page y;
        ArrayList<String> tmp;
        for(int i=0;i<pages.size();i++){
            x = pages.get(i);
            for(int j=0;j<pages.size();j++){
                if(!(i==j)){
                    y = pages.get(j);
                    tmp = y.getReconnus();

                    tmp.retainAll(x.getReconnus());

                    if(tmp.size()>=limiteReconnaissance)
                        classes.union(i,j);
                }
            }

        }
    }
}
