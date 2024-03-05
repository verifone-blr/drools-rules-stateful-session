package com.verifone.drools;

import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.verifone.drools.repository.ApplicationRepository;
import com.verifone.drools.service.Passport;

public class StatefulValidation {

   public static void main(String[] args) {

      List<Passport> passports = ApplicationRepository.getPassports();

      KieContainer kieClasspathContainer = KieServices.Factory.get().getKieClasspathContainer();
      KieSession kieSession = kieClasspathContainer.newKieSession("StatefulValidation");

      passports.forEach(kieSession::insert);
      kieSession.fireAllRules();
      kieSession.dispose();

      System.out.println("==================================================");

      passports.stream()
            .forEach(eachPassport -> System.out.println(eachPassport + " validation " + eachPassport.getValidation()));

   }

}
