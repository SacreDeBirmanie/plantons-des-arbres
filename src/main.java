/**
 * Created by Sébastien on 03/12/14.
 */

import javafx.application.Application;

import java.io.BufferedReader;

public class main  {

    public static void main(String[] args) {
        Dictionnaire dictionnaire = new Dictionnaire();


        BufferedReader br = LectureFichier.lireFichier(args[1]);
        String ligne;
        while( (ligne=br.readLine())!=null){
            dictionnaire.ajouter(ligne,"Ca mange pas de pain !");
        }

        Reconnaissance reconnaissance = new Reconnaissance(dictionnaire,"[A-Za-z]+");

        String[] fichiers = LectureFichier.listeFichiers(args[0]);
        Page page;
        for(int i =0; i<fichiers.length;i++){
            br = LectureFichier.lireFichier(fichiers[i]);
           ligne = br.readLine();
            page = new Page(Integer.parseInt(ligne));
            page.setReconnus(reconnaissance.reconnaitreMots(br,page));

        }

        reconnaissance.grouperPages();
    }

}
