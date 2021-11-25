package org.LproDql.coursPOO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


//COMPILER AVEC JDK 15 !!!!!
public class Exercice {


    public Map<Integer, String> compteLesNegatifsEtCOnstruitUneChaineAvecLesPositifs(int nombreDeValeursAnalysees, List<Integer> valeursAAnalyser) {
        var aRetourner = new HashMap<Integer, String>();
        int nombreDEntierNegatifs = 0;
        var suiteDesEntiersPositifs = new StringBuilder();
        for (int i = 0; i < valeursAAnalyser.size() && i < nombreDeValeursAnalysees  ; i++) {
            var nombreExtrait = valeursAAnalyser.get(i);
            if (nombreExtrait >= 0) {
                suiteDesEntiersPositifs.append(String.format("%d ", nombreExtrait));
            } else {
                nombreDEntierNegatifs++;
            }
        }
        return ajouteUnRetourChariotEtPlanceLesElementsDansLaMap(aRetourner, nombreDEntierNegatifs, suiteDesEntiersPositifs);
    }

    private HashMap<Integer, String> ajouteUnRetourChariotEtPlanceLesElementsDansLaMap(
        HashMap<Integer, String> aRetourner,
        int nombreDEntierNegatifs,
        StringBuilder suiteDesEntiersPositifs) {
        suiteDesEntiersPositifs.append("\n");
        var nouvelleHashMap = (HashMap<Integer, String>) aRetourner.clone();
        nouvelleHashMap.put(nombreDEntierNegatifs, suiteDesEntiersPositifs.toString());
        return nouvelleHashMap;
    }
}
