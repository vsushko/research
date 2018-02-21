package studyclass;
 /*
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

interface Factory<T> {
    T create();
}

class Part {
    @Override
    public String toString() {
         return getClass().getSimpleName();
    }
    static List<Factory<? extends Part>> partFactories =
            new ArrayList<Factory<? extends Part>>();
    static {
        partFactories.add((Factory<? extends Part>) new FuelFilter.Factory());
    }
    private static Random rand = new Random(47);
    public static Part createRandom() {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}

class Filter extends Part {}

class FuelFilter extends Filter {
    // Создание фабрики для каждого конкретного типа

    static class Factory implements Factory<FuelFilter> {
        public FuelFilter create() {
            return new FuelFilter();
        }
    }

}
*/

















public class RegisteredFactories {
}
