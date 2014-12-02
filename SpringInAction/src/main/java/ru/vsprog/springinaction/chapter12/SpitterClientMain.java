package ru.vsprog.springinaction.chapter12;


import ru.vsprog.springinaction.chapter6.Spitter;
import ru.vsprog.springinaction.chapter7.Spittle;

import java.io.IOException;

public class SpitterClientMain {
  private final SpitterClient hard;
  private final SpitterClient easy;
  
  public SpitterClientMain(SpitterClient hard, SpitterClient easy) {
    this.hard = hard;
    this.easy = easy;
  }
  
  public void go() {
    Spitter spitter = new Spitter();
    spitter.setUsername("cwagon");
    spitter.setFullName("Chuck Wagon");
    spitter.setEmail("cwagon@habuma.com");
    spitter.setPassword("letmein01");
    spitter.setUpdateByEmail(false);
    easy.postSpitter(spitter);
    
    
    Spittle[] spittles = hard.retrieveSpittlesForSpitter("habuma");
    for (Spittle spittle : spittles) {
      System.out.println(spittle.getSpitter().getUsername() + "-->  " + spittle.getText());
    }
    
    System.out.println("===========================");
    
    spittles = easy.retrieveSpittlesForSpitter("habuma");
    for (Spittle spittle : spittles) {
      System.out.println(spittle.getSpitter().getUsername() + "-->  " + spittle.getText());
    }      
  }
  
  
  public static void main(String[] args) throws IOException {
    
    SpitterClientMain main = new SpitterClientMain(
            new SpitterClientTheHardWay(),
            new RestTemplateSpitterClient()
            );
    
    main.go();
  }
}
