package bases;/*  Наследование. Пример из книги Б. Эккеля
    Конструкторы с параметрами.
 */

class Game {
    Game(int i) {
        System.out.println("In game");
    }
}
class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        System.out.println("In board game");
    }
}
class Chess extends BoardGame {
    Chess() {
        super(10);
        System.out.println("In chess");
    }
    public static void main(String[] args) {
        Chess x = new Chess();
    }
}