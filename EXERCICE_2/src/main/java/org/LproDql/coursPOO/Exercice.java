package org.LproDql.coursPOO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Exercice {


    public Map<Integer, String> compteLesNegatifsEtCOnstruitUneChaineAvecLesPositifs(int nombreDeValeursAnalysees, List<Integer> valeursAAnalyser) {

        HashMap<Integer, String> aRetourner = new HashMap<>();
        int nombreDEntierNegatifs = 0;
        StringBuilder suiteDesEntiersPositifs = new StringBuilder();
        for (int i = 0; i < valeursAAnalyser.size() && i < nombreDeValeursAnalysees; i++) {
            Integer nombreExtrait = valeursAAnalyser.get(i);
            if (nombreExtrait >= 0) {
                suiteDesEntiersPositifs.append(String.format("%d ", nombreExtrait));
            } else {
                nombreDEntierNegatifs++;
            }
        }
        return ajouteUnRetourChariotEtPlanceLesElementsDansLaMap(aRetourner, nombreDEntierNegatifs, suiteDesEntiersPositifs);
    }

    public ArrayList<Integer> extraireLesNombresPositifs(int nombreDeValeursAnalysees, List<Integer> valeursAAnalyser) {

        ArrayList<Integer> aRetourner = new ArrayList<Integer>();

        for (int i = 0; i < valeursAAnalyser.size() && i < nombreDeValeursAnalysees; i++) {
            Integer nombreExtrait = valeursAAnalyser.get(i);
            aRetourner.add(nombreExtrait);
        }
        return aRetourner;
    }

    public List<Integer> extraireLesNombresPositifs_v2(int nombreDeValeursAnalysees, List<Integer> valeursAAnalyser) {

        return valeursAAnalyser.stream().limit(nombreDeValeursAnalysees).filter(x -> x >= 0).collect(Collectors.toList());

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
