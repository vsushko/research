package ru.vsprog.fauler;

/**
 * User: vsa
 * Date: 08.04.14
 * Time: 9:39
 */
public abstract class Price {
    abstract int getPriceCode();

    public abstract double getCharge(int daysRented);

    public abstract int getFrequentRenterPoints(int daysRented);


}

class ChildrensPrice extends Price {

    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented -3) * 1.5;
        return result;
    }

    // бонус за аренду новинки на два дня
    public int getFrequentRenterPoints(int daysRented) {
        if ((getPriceCode() == Movie.CHILDRENS) &&
                daysRented > 1)
            return 2;
        return 1;
    }

    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }
}

class NewReleasePrice extends Price {

    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    // бонус за аренду новинки на два дня
    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }

    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
}

class RegularPrice extends Price {

    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;
    }

    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    public int getFrequentRenterPoints(int daysRented) {
        if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
            return 2;
        return 1;
    }

}