package LPRO_DQL;

import java.util.List;

public class Exercice {

    public int f1(int a1, List<Integer> a2) {
        int a5 = 0;
        for (int a3=0; a3 < a2.size() && a3 < a1; a3 ++) {
                int a6 = a2.get(a3);
                if (a6 >=0) {
                    System.out.println(a6 + " ");
                }
                else {
                    a5 ++;
                }
        }
        System.out.println("\n");
        return a5;
    }
}
