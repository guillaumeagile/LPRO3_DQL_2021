package LPRO_DQL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


//COMPILER AVEC JDK 15 !!!!!
public class Exercice {

    public Map<Integer, String> compteNombreValeursInferieurAZeroEtAjouteLesValeursPositives(int nombreDeValeursAAnalyser, List<Integer> listBase) {
        var renvoi = new HashMap<Integer, String>();
        int nombreValeursInferieuresAZero = 0;
        String ChaineDeValeursPositives = "";
        for (int i = 0; i < listBase.size() && i < nombreDeValeursAAnalyser; i++) {
            int nombreExtrait = listBase.get(i);
            if (nombreExtrait >= 0) {
                ChaineDeValeursPositives = ChaineDeValeursPositives + (nombreExtrait + " ");
            } else {
                nombreValeursInferieuresAZero++;
            }
        }
        ChaineDeValeursPositives += ("\n");
        renvoi.put(nombreValeursInferieuresAZero, ChaineDeValeursPositives);
        return renvoi;
    }
}
