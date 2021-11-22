package LPRO_DQL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


//COMPILER AVEC JDK 15 !!!!!
public class Exercice {

    public Map<Integer, String> f1(int nombreDeValeursAnalysees, List<Integer> valeursAAnalyser) {
        var aRetourner = new HashMap<Integer, String>();
        int nombreDEntierNegatifs = 0;
        var suiteDesEntiersPositifs = new StringBuilder();
        for (int i = 0; i < valeursAAnalyser.size() && i < nombreDeValeursAnalysees; i++) {
            int nombreExtrait = valeursAAnalyser.get(i);
            if (nombreExtrait >= 0) {
                suiteDesEntiersPositifs.append(String.format("%d ", nombreExtrait));
            } else {
                nombreDEntierNegatifs++;
            }
        }
        suiteDesEntiersPositifs.append("\n");
        aRetourner.put(nombreDEntierNegatifs, suiteDesEntiersPositifs.toString());
        return aRetourner;
    }
}
