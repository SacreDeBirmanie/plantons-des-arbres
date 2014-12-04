import java.io.*;
import java.util.ArrayList;

/**
 * Created by Sébastien on 03/12/14.
 */
public class LectureFichier {

    public LectureFichier(String dos){

    }

    public static BufferedReader lireFichier(String nom) {
        BufferedReader buff = null;
        try {
            InputStream flux = new FileInputStream(nom);
            InputStreamReader lecture = new InputStreamReader(flux);
            buff = new BufferedReader(lecture);
    /*        while ((ligne=buff.readLine())!=null){
                System.out.println(ligne);
            }
            buff.close();*/
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return buff;
    }

    public static String[] listeFichiers(String dossier) {
        File directory = new File(dossier);
        if(!directory.exists()){
            System.out.println("Le fichier/répertoire '"+dossier+"' n'existe pas");
            return null;
        }else {
            if (!directory.isDirectory()) {
                System.out.println("Le chemin '" + dossier + "' correspond à un fichier et non à un répertoire");
                return null;
            } else {
                return directory.list();
            }
        }
    }


}
