package LPRO_DQL;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

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
        // et on trouve dans la valeur <String> de cette map, la chaine de caractère

        assertThat(firstResult.getKey(), is(0));
        //Assertions.assertThat(firstResult.getKey()).isEqualTo(0);  //cette ligne c'est la même chose que la précédente, choisissez l'écriture qui vous plait le plus

        //2e verification:  que contient la chaine de caractère?
        Assertions.assertThat(firstResult.getValue()).isEqualTo(" \n");
    }

    @Test
    public void listeAvecUnEntierPositif() {
        //given
        final Exercice exercice = new Exercice();
        final List<Integer> listeEntiers = new ArrayList<>();
        listeEntiers.add(158);
        //when
        final var actual = exercice.f1(100, listeEntiers);
        //then
        //Assertions.assertThat(actual).isZero();
        var firstResult = actual.entrySet().iterator().next();
        //dans le 1er element de la Map<Int, String> on trouve la clé qui est une entier qui contient le nombre d'entiers positifs trouvés
        // et on trouve dans la valeur <String> de cette map, la chaine de caractère

        assertThat(firstResult.getKey(), is(0));
        //Assertions.assertThat(firstResult.getKey()).isEqualTo(0);  //cette ligne c'est la même chose que la précédente, choisissez l'écriture qui vous plait le plus

        //2e verification:  que contient la chaine de caractère?
        Assertions.assertThat(firstResult.getValue()).isEqualTo("158 \n");
    }

    @Test
    public void listeAvecPlusieursEntiersPositifs() {
        //given
        final Exercice exercice = new Exercice();
        final List<Integer> listeEntiers = new ArrayList<>();
        listeEntiers.add(158);
        listeEntiers.add(445);
        listeEntiers.add(200);

        listeEntiers.add(-1);
        listeEntiers.add(-2);
        //when
        final var actual = exercice.f1(5, listeEntiers);
        //then
        //Assertions.assertThat(actual).isZero();
        Integer firstKey = actual.keySet().stream().findFirst().get();
        Assertions.assertThat(actual.get(firstKey)).isEqualTo("158 445 200 \n");
        Assertions.assertThat(firstKey).isEqualTo(2);


        /*
        boolean expectedValueFound1 = false;
        boolean expectedValueFound2 = false;
        String[] tableauEntiers = actual.get(firstKey).split(" ");
        for (String entier : tableauEntiers) {
            //entier = entier.trim();
            if(entier.equals("158")) {
                expectedValueFound1 = true;
            } else if(entier.equals("220")) {
                expectedValueFound2 = true;
            }
        }
        assertTrue(expectedValueFound1);
        assertTrue(expectedValueFound2);*/
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
        Integer firstKey = actual.keySet().stream().findFirst().get();
        Assertions.assertThat(firstKey).isEqualTo(1);
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

        Integer firstKey = actual.keySet().stream().findFirst().get();
        Assertions.assertThat(firstKey).isEqualTo(5);
    }


    @Test
    public void listeAvecEntierNegatifEtEntierPositif() {
        //given
        final Exercice exercice = new Exercice();
        final List<Integer> listeEntiers = new ArrayList<>();
        listeEntiers.add(-9);
        listeEntiers.add(-15);
        listeEntiers.add(9);
        listeEntiers.add(19);

        //when
        final var actual = exercice.f1(4, listeEntiers);

        //then
        var firstResult = actual.entrySet().iterator().next();
        Assertions.assertThat(firstResult.getKey()).isEqualTo(2);
        Assertions.assertThat(firstResult.getValue()).isEqualTo("9 19 \n");
    }

    //Version 2.0
    /*   @Test
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
        Assertions.assertThat(firstResult.getKey()).isZero();  //cette ligne c'est la même chose que la précédente, choisissez l'écriture qui vous plait le plus

        //2e verification:  que contient la chaine de caractère?
        Assertions.assertThat(firstResult.getValue()).isEqualTo("\n");
    }

    @Test
    public void listeAvecUnEntierPositif() {
        //given
        final Exercice exercice = new Exercice();
        final List<Integer> listeEntiers = new ArrayList<>();
        listeEntiers.add(1);
        //when
        final var actual = exercice.f1(1, listeEntiers);
        //then
        var firstResult = actual.entrySet().iterator().next();
        Assertions.assertThat(firstResult.getKey()).isZero();
        //2e verification:  que contient la chaine de caractère?
        Assertions.assertThat(firstResult.getValue()).isEqualTo("1 \n");
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
        var firstResult = actual.entrySet().iterator().next();
        Assertions.assertThat(firstResult.getKey()).isEqualTo(1);
        //2e verification:  que contient la chaine de caractère?
        Assertions.assertThat(firstResult.getValue()).isEqualTo("\n");

    }*/

/*
    @Test
    @Parameters({
            "actual, expected"
    })
    public void beTestable(String actual, String expected) {
      assertThat((actual), is(expected));
    }*/
}
