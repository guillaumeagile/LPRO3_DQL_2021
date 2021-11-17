package LPRO_DQL;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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

    @Test
    public void listeVide() {
        //given
        final Exercice exercice = new Exercice();
        final List<Integer> listeEntiers = new ArrayList<>();
        //when
        final int actual = exercice.f1(1, listeEntiers);
        //then
        assertThat(actual, is(0));
        Assertions.assertThat(actual).isEqualTo(0);  //cette ligne c'est la même chose que la précédente, choisissez l'écriture qui vous plait le plus
    }

    @Test
    public void listeAvecUnEntierPositif() {
        //given
        final Exercice exercice = new Exercice();
        final List<Integer> listeEntiers = new ArrayList<>();
        listeEntiers.add(1);
        //when
        final int actual = exercice.f1(1, listeEntiers);
        //then
        Assertions.assertThat(actual).isZero();
    }

    @Test
    public void listeAvecUnEntierNegatif() {
        //given
        final Exercice exercice = new Exercice();
        final List<Integer> listeEntiers = new ArrayList<>();
        listeEntiers.add(-1);
        //when
        final int actual = exercice.f1(1, listeEntiers);
        //then
        assertThat(actual, is(1));

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
