package ru.vsprog.springinaction.chapter3;

/**
 * Created by vsa
 * Date: 06.11.14.
 */
public class Coconut {
    public Coconut() {
    }

    public void drinkThemBothUp() {
        System.out.println("You put the lime in the coconut....");
        System.out.println("and dink 'em both up...");
        System.out.println("You put the lime in the coconut....");
        lime.drink();
    }

    private Lime lime;

    public void setLime(Lime lime) {
        this.lime = lime;
    }

}
