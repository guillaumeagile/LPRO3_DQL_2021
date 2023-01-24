package LPRO_DQL;

import junitparams.JUnitParamsRunner;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class TestVide {


        @Before
        public void initialise() {
        }

        @Test
        public void PremierTest() {
            //given

            //when

            //ASSERT
            assertThat(0, is(0));

            Assertions.assertThat(0).isZero();  //cette ligne c'est la même chose que la précédente, choisissez l'écriture qui vous plait le plus


        }
}
