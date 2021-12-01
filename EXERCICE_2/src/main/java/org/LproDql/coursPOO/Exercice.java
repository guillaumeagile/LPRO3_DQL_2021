package org.LproDql.coursPOO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Exercice {

    public Map<Integer, String> compteLesNegatifsEtCOnstruitUneChaineAvecLesPositifs
        (int nombreDeValeursAnalysees, List<Integer> valeursAAnalyser) {

        int nombreDEntierNegatifs = extraireLesNombresNegatifs(nombreDeValeursAnalysees, valeursAAnalyser).size();

        StringBuilder suiteDesEntiersPositifs = new StringBuilder();
        String s = extraireLesNombresPositifs(nombreDeValeursAnalysees, valeursAAnalyser)
            .stream().map(Object::toString).collect(Collectors.joining(" "));
        suiteDesEntiersPositifs.append(s);


        return ajouteUnRetourChariotEtPlanceLesElementsDansLaMap( nombreDEntierNegatifs, suiteDesEntiersPositifs);
        }

        public List<Integer> extraireLesNombresPositifs(int nombreDeValeursAnalysees, List<Integer> valeursAAnalyser) {
        return valeursAAnalyser.stream().limit(nombreDeValeursAnalysees).filter(x -> x >= 0).collect(Collectors.toList());

    }

    private HashMap<Integer, String> ajouteUnRetourChariotEtPlanceLesElementsDansLaMap(
        int nombreDEntierNegatifs,
        StringBuilder suiteDesEntiersPositifs) {
        HashMap<Integer, String> aRetourner = new HashMap<>();
        suiteDesEntiersPositifs.append("\n");
        aRetourner.put(nombreDEntierNegatifs, suiteDesEntiersPositifs.toString());
        return aRetourner;
    }

    public List<Integer> extraireLesNombresNegatifs(int nombreDeValeursAnalysees, List<Integer> valeursAAnalyser) {
        return valeursAAnalyser.stream().limit(nombreDeValeursAnalysees).filter(x -> x < 0).collect(Collectors.toList());
    }
}
