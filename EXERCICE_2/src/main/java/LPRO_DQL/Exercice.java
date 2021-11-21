
package LPRO_DQL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


//COMPILER AVEC JDK 15 !!!!!
public class Exercice {
        public Map<Integer, String> compteNbValeursInfZeroEtAjouteValeursSup(int NbValue, List<Integer> ListeValue) {
            var MapRenvoi = new HashMap<Integer, String>();
            int NbValueInfZero = 0;
            String ListeStringOfValueSupZeo = "";
            for (int i = 0; i < ListeValue.size() && i < NbValue; i++) {
                int nbExtact = ListeValue.get(i);
                if (nbExtact >= 0) {
                    ListeStringOfValueSupZeo = ListeStringOfValueSupZeo + (nbExtact + " ");
                } else {
                    NbValueInfZero++;
                }
            }
            ListeStringOfValueSupZeo += ("\n");
            MapRenvoi.put(NbValueInfZero, ListeStringOfValueSupZeo);
            return MapRenvoi;
        }
    }