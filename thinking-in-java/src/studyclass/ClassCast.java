package studyclass;

class Building {}
class House extends Building {}

public class ClassCast {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        House house = houseType.cast(b);
    }
}
