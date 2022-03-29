package io.reflectoring.buckpal.account.application.domain;

import io.reflectoring.buckpal.account.domain.bookingPet.Animal;
import io.reflectoring.buckpal.account.domain.bookingPet.Booking;
import io.reflectoring.buckpal.account.domain.bookingPet.Gardien;

import java.time.LocalDateTime;

public class  BookingErreur  extends Booking   {
    public BookingErreur() {
        super(null, null, null, null);
    }
}
