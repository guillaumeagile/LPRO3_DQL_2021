
package LPRO_DQL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercice {

    public Map<Integer, String> compteLesNegatifsEtCOnstruitUneChaineAvecLesPositifs(int nombreDeValeursAnalysees, List<Integer> valeursAAnalyser) {
        HashMap<Integer, String> aRetourner = new HashMap<>();
        StringBuilder suiteDesEntiersPositifs = new StringBuilder();
        for (int i = 0; i < valeursAAnalyser.size() && i < nombreDeValeursAnalysees  ; i++) {
            Integer nombreExtrait = listeDesEntiersPositifs(valeursAAnalyser).get(i);
            suiteDesEntiersPositifs.append(String.format("%d ", nombreExtrait));
        }
        return ajouteUnRetourChariotEtPlanceLesElementsDansLaMap(aRetourner, listeDesEntiersNegatifs(valeursAAnalyser).size(), suiteDesEntiersPositifs);
    }

    public List<Integer> listeDesEntiersNegatifs( List<Integer> valeursAAnalyser ) {
        List<Integer> listeEntierNegatif = new ArrayList<>();
        for (int i = 0; i < valeursAAnalyser.size() ; i++) {
            Integer nombreExtrait = valeursAAnalyser.get(i);
            if (nombreExtrait < 0) {
                listeEntierNegatif.add(nombreExtrait);
            }
        }
        return listeEntierNegatif;
    }

    public List<Integer> listeDesEntiersPositifs( List<Integer> valeursAAnalyser ) {
        List<Integer> listeEntierPositif = new ArrayList<>();
        for (int i = 0; i < valeursAAnalyser.size() ; i++) {
            Integer nombreExtrait = valeursAAnalyser.get(i);
            if (nombreExtrait >= 0) {
                listeEntierPositif.add(nombreExtrait);
            }
        }
        return listeEntierPositif;
    }

    private HashMap<Integer, String> ajouteUnRetourChariotEtPlanceLesElementsDansLaMap(
            HashMap<Integer, String> aRetourner,
            int nombreDEntierNegatifs,
            StringBuilder suiteDesEntiersPositifs) {
        suiteDesEntiersPositifs.append("\n");
        HashMap<Integer, String> nouvelleHashMap = (HashMap<Integer, String>) aRetourner.clone();
        nouvelleHashMap.put(nombreDEntierNegatifs, suiteDesEntiersPositifs.toString());
        return nouvelleHashMap;
    }
}