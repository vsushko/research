package ru.vsprog.fauler;

import java.util.Enumeration;
import java.util.Vector;

/**
 * User: vsa
 * Date: 06.04.14
 * Time: 16:22
 */
public class Customer {
    private String _name;
    private Vector _rentals = new Vector();
    private double result;

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        Enumeration rentals = _rentals.elements();
        String result = "Учет аренды для " + getName() + "\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            // показать результаты для этой аренды
            result += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf(each.getCharge()) + "\n";
        }

        // добавить нижний колонтитул
        result += "Сумма задолженности соствляет " + String.valueOf(getTotalCharge()) + "\n";
        result += "Вы заработали " + String.valueOf(getTotalFrequentRenterPoints()) +
                " очков за активность";

        return result;
    }

    public String htmlStatement() {
        Enumeration rentals = _rentals.elements();
        String result = "<h1>Операции ареды для <em>" + getName() +
                "</em></h1><p>\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            // показать результаты по каждой аренде
            result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<br>\n";
        }
        // добавить нижний колонтитул
        result += "<p>Ваша задолженность оставляет <em>" +
                String.valueOf(getTotalCharge()) + "</em><p>\n";
        result += "На этой аренде вы заработали <em>" +
                String.valueOf(getTotalFrequentRenterPoints()) +
                "</em> очков заактивность<p>";
        return result;
    }

    public double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }

        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

}
