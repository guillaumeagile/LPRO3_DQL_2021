package LPRO_DQL;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import junitparams.JUnitParamsRunner;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(JUnitParamsRunner.class)
public class ExerciceTests {

    @Before
    public void initialise() {
    }

    // !!! pour comprendre comment marche une Map/HashMap en java, lisez ceci:  https://www.data-transitionnumerique.com/java-hashmap/

    @Test
    public void listeVide() {
        //given
        final Exercice exercice = new Exercice();
        final List<Integer> listeEntiers = new ArrayList<>();
        //when
        final var actual = exercice.f1(1, listeEntiers);
        //ASSERT
        var firstResult = actual.entrySet().iterator().next();
        //dans le 1er element de la Map<Int, String> on trouve la clé qui est une entier qui contient le nombre d'entiers positifs trouvés
        // eton trouve dans la valeur <String> de cette map, la chaine de caractère

        assertThat(firstResult.getKey(), is(0));
        //Assertions.assertThat(firstResult.getKey()).isEqualTo(0);  //cette ligne c'est la même chose que la précédente, choisissez l'écriture qui vous plait le plus

        //2e verification:  que contient la chaine de caractère?
        Assertions.assertThat(firstResult.getValue()).isEqualTo("\n");
    }

    @Test
    public void listeAvecUnEntierPositif() {
        //given
        final Exercice exercice = new Exercice();
        final List<Integer> listeEntiers = new ArrayList<>();
        listeEntiers.add(158);
        //when
        final var actual = exercice.f1(1, listeEntiers);
        //then
        //Assertions.assertThat(actual).isZero();
        assertTrue(actual.containsKey(0));
        boolean expectedValueFound = false;

        String[] tableauEntiers = actual.get(0).split(" ");

        for (int i = 0; i < tableauEntiers.length; i++) {
            if(tableauEntiers[i].equals("158")) {
                expectedValueFound = true;
            }
        }

        assertTrue(expectedValueFound);
    }

    @Test
    public void listeAvecPlusieursEntiersPositifs() {
        //given
        final Exercice exercice = new Exercice();
        final List<Integer> listeEntiers = new ArrayList<>();
        listeEntiers.add(158);
        listeEntiers.add(220);
        listeEntiers.add(445);

        listeEntiers.add(-1);
        listeEntiers.add(-2);
        //when
        final var actual = exercice.f1(100, listeEntiers);
        //then
        //Assertions.assertThat(actual).isZero();
        boolean expectedValueFound1 = false;
        boolean expectedValueFound2 = false;
        boolean expectedValueFound3 = false;

        String[] tableauEntiers = actual.get(2).split(" ");

        for (int i = 0; i < tableauEntiers.length; i++) {
            if(tableauEntiers[i].equals("158")) {
                expectedValueFound1 = true;
            } else if(tableauEntiers[i].equals("220")) {
                expectedValueFound2 = true;
            } else if(tableauEntiers[i].equals("445")) {
                expectedValueFound3 = true;
            }
        }

        assertTrue(expectedValueFound1);
        assertTrue(expectedValueFound2);
        assertTrue(expectedValueFound3);
    }

    @Test
    public void listeAvecUnEntierNegatif() {
        //given
        final Exercice exercice = new Exercice();
        final List<Integer> listeEntiers = new ArrayList<>();
        listeEntiers.add(-1);

        //when
        final var actual = exercice.f1(1, listeEntiers);
        //then
        assertTrue(actual.containsKey(1));
    }

    @Test
    public void listeAvecPlusieursEntiersNegatifs() {
        //given
        final Exercice exercice = new Exercice();
        final List<Integer> listeEntiers = new ArrayList<>();
        listeEntiers.add(-1);
        listeEntiers.add(-2);
        listeEntiers.add(-3);
        listeEntiers.add(-4);
        listeEntiers.add(-5);
        listeEntiers.add(100);
        listeEntiers.add(200);

        //when
        final var actual = exercice.f1(100, listeEntiers);
        //then
        assertTrue(actual.containsKey(5));
    }

/*
    @Test
    @Parameters({
            "actual, expected"
    })
    public void beTestable(String actual, String expected) {
      assertThat((actual), is(expected));
    }*/
}
