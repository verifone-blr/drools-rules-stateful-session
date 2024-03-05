package com.verifone.drools.repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.verifone.drools.service.Passport;

public class ApplicationRepository {

   public static final String PASSPORT_1 = "ABCD0001";

   public static final String PASSPORT_2 = "ABCD0002";

   public static final String PASSPORT_3 = "ABCD0003";

   public static final String PASSPORT_4 = "ABCD0004";

   public static List<Passport> getPassports() {
      List<Passport> passports = new ArrayList<>();

      passports.add(Passport.newBuilder().withPassportNumber(PASSPORT_1).withName("A").withUnusedVisaPages(1)
            .withExpiresOn(LocalDate.of(2017, Month.DECEMBER, 17)).withAge(50).build());

      passports.add(Passport.newBuilder().withPassportNumber(PASSPORT_2).withName("B").withUnusedVisaPages(0)
            .withExpiresOn(LocalDate.of(2045, Month.MAY, 11)).withAge(12).build());

      passports.add(Passport.newBuilder().withPassportNumber(PASSPORT_3).withName("C").withUnusedVisaPages(20)
            .withExpiresOn(LocalDate.of(2047, Month.NOVEMBER, 25)).withAge(16).build());

      passports.add(Passport.newBuilder().withPassportNumber(PASSPORT_4).withName("D").withUnusedVisaPages(10)
            .withExpiresOn(LocalDate.of(2045, Month.APRIL, 10)).withAge(17).build());

      return passports;
   }

}
