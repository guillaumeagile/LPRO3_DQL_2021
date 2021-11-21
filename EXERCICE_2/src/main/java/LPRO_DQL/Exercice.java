package LPRO_DQL;

import java.util.*;
import java.util.stream.Collectors;


//COMPILER AVEC JDK 15 !!!!!
public class Exercice {

    public Map<Integer, String> f1(int nbrIterationsMax, List<Integer> integerList) {
        var tableauRetour = new HashMap<Integer, String>();

        long nbreDeNegatifs = integerList.stream().limit(((long) nbrIterationsMax)).filter(integer -> integer < 0).collect(Collectors.counting());
        String listeDePositifs = integerList.stream().limit(((long) nbrIterationsMax)).filter(integer -> integer >= 0).map( Object::toString ).collect(Collectors.joining(" ")) + ("\n");

        tableauRetour.put(((int) nbreDeNegatifs), listeDePositifs);
        return tableauRetour;
    }

    /* public Map<Integer, String> f1(int a1, List<Integer> a2) {
        var a7 = new HashMap<Integer, String>();
        int a5 = 0;
        String a9 = "";
        for (int a3 = 0; a3 < a2.size() && a3 < a1; a3++) {
            int a6 = a2.get(a3);
            if (a6 >= 0) {
                a9 = a9 + (a6 + " ");
            } else {
                a5++;
            }
        }
        a9 += ("\n");
        a7.put(a5, a9);
        return a7;
    }*/

   
}
