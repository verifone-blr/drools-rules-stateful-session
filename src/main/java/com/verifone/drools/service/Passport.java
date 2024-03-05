package com.verifone.drools.service;

import java.time.LocalDate;
import java.util.Objects;

public class Passport {

   private String passportNumber;

   private String name;

   private LocalDate expiresOn;

   private int unusedVisaPages;

   private int age;

   private Validation validation = Validation.UNKNOWN;

   private Passport() {
   }

   public LocalDate getExpiresOn() {
      return expiresOn;
   }

   public void setExpiresOn(LocalDate expiresOn) {
      this.expiresOn = expiresOn;
   }

   public boolean isExpired() {
      return expiresOn.isBefore(LocalDate.now());
   }

   public String getPassportNumber() {
      return passportNumber;
   }

   public String getName() {
      return name;
   }

   public int getUnusedVisaPages() {
      return unusedVisaPages;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public Validation getValidation() {
      return validation;
   }

   public void setValidation(Validation validation) {
      this.validation = validation;
   }

   @Override
   public String toString() {
      return String.format("Passport[no:%s, name:%s]", passportNumber, name);
   }

   public static PassportBuilder newBuilder() {
      return new PassportBuilder();
   }

   public static final class PassportBuilder {

      private String passportNumber;

      private String name;

      private LocalDate expiresOn;

      private int unusedVisaPages;

      private int age;

      private PassportBuilder() {
      }

      public PassportBuilder withPassportNumber(String passportNumber) {
         this.passportNumber = passportNumber;
         return this;
      }

      public PassportBuilder withName(String name) {
         this.name = name;
         return this;
      }

      public PassportBuilder withExpiresOn(LocalDate expiresOn) {
         this.expiresOn = expiresOn;
         return this;
      }

      public PassportBuilder withUnusedVisaPages(int unusedVisaPages) {
         this.unusedVisaPages = unusedVisaPages;
         return this;
      }

      public PassportBuilder withAge(int age) {
         this.age = age;
         return this;
      }

      public Passport build() {
         Passport passport = new Passport();
         passport.passportNumber = passportNumber;
         passport.name = name;
         passport.expiresOn = expiresOn;
         passport.unusedVisaPages = unusedVisaPages;
         passport.age = age;
         return passport;
      }
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      Passport passport = (Passport) o;
      return Objects.equals(passportNumber, passport.passportNumber);
   }

   @Override
   public int hashCode() {
      return Objects.hash(passportNumber);
   }

}
