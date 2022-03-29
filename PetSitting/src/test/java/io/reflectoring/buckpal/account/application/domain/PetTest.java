package io.reflectoring.buckpal.account.application.domain;

import io.reflectoring.buckpal.account.domain.bookingPet.Animal;
import io.reflectoring.buckpal.account.domain.bookingPet.Booking;
import io.reflectoring.buckpal.account.domain.bookingPet.Gardien;
import io.reflectoring.buckpal.account.domain.bookingPet.Proprietaire;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

public class PetTest {
    @Test
    void UserStory0001() {
        var joe = new Proprietaire("joe");
        var rex = new Animal("rex");
        var helena = new Gardien("helena");
        var dateDebut = LocalDateTime.of(2020, Month.APRIL, 01, 13, 00);
        var dateFin = LocalDateTime.of(2020, Month.APRIL, 03, 13, 00);


        var result = joe.DemandeDeBooking(rex, helena, dateDebut, dateFin);

        assertThat(result).isSameAs(new BookingErreur());
    }

    @Test
    void UserStory0002() {
        var joe = new Proprietaire("joe");
        var rex = new Animal("rex");
        var helena = new Gardien("helena");
        var dateDebut = LocalDateTime.of(2020, Month.APRIL, 01, 13, 00);
        var dateFin = LocalDateTime.of(2020, Month.APRIL, 03, 13, 00);

        var result = joe.DemandeDeBooking(rex, helena, dateDebut, dateFin);

        assertThat(result).isEqualTo(new Booking(rex, helena, dateDebut, dateFin));
        assertThat(true).isNotEqualTo(false)
    }
}
