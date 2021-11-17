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
    public void faireUnThéSansSucre() {
        //given
        final Exercice distributeurDeBoisson = new Exercice();

        //when
        final String actual = distributeurDeBoisson.f1();
        //then
        assertThat(actual, is("T::"));
        Assertions.assertThat(actual).isEqualTo("T::");
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
