import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Sébastien on 03/12/14.
 */
public class LectureFichier {
    string dossier;

    public LectureFichier(string dos){
        this->dossier = dos;

    }

    public BufferedReader lireFichier(string nom){
    try{
        InputStream flux=new FileInputStream(nom);
        InputStreamReader lecture=new InputStreamReader(flux);
        BufferedReader buff=new BufferedReader(lecture);
        String ligne;
/*        while ((ligne=buff.readLine())!=null){
            System.out.println(ligne);
        }
        buff.close();*/
    }
    catch (Exception e){
        System.out.println(e.toString());
    }

    public void lireDossier{


    }


}
