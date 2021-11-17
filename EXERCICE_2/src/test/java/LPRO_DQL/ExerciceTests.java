package LPRO_DQL;

import LPRO_DQL.Exercice;
import junitparams.JUnitParamsRunner;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


@RunWith(JUnitParamsRunner.class)
public class ExerciceTests {

    @Before
    public void initialise() {

    }

    @Test
    public void PremierCas() {
        //given
        final Exercice exercice = new Exercice();

        //when
        final String actual = exercice.f1();
        //then
        assertThat(actual, is(""));
        Assertions.assertThat(actual).isEqualTo("");
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
