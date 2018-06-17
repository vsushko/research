package vsushko.func;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {

    public static void main(String[] args) {

        // BiConsumer
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        // accepts two input arguments and returns no result
        BiConsumer<Integer, String> biConsumer =
                (key, value) -> System.out.println("Key:" + key + " Value:" + value);
        map.forEach(biConsumer);
        // ------------------------------------------------------------------------------------

        // BiFunction
        // accepts two arguments and produces a result
        BiFunction<Integer, Integer, String> biFunction =
                (num1, num2) -> "Result: " + (num1 + num2);
        System.out.println(biFunction.apply(20, 25));
        // ------------------------------------------------------------------------------------

        // BinaryOperator
        // Represents an operation upon two operands of the same type, producing a result
        // of the same type as the operands
        BinaryOperator<Integer> operator1 = (a, b) -> a + b;
        System.out.println(operator1.apply(5, 7));

        BinaryOperator<String> operator2 = (s1, s2) -> s1 + s2;
        System.out.println(operator2.apply("s1 ", "s2"));

        BinaryOperator<Integer> operator = (a, b) -> a + b;
        Function<Integer, Integer> function = n -> n * 2;

        // Using andThen()
        System.out.println(operator.andThen(function).apply(1, 6));

        Comparator<Integer> comparator = (a, b) -> (a.compareTo(b));

        // Using maxBy()
        BinaryOperator<Integer> opMax = BinaryOperator.maxBy(comparator);
        System.out.println("Max: " + opMax.apply(5, 6));
        System.out.println("Max: " + opMax.apply(9, 6));

        // Using minBy()
        BinaryOperator<Integer> opMin = BinaryOperator.minBy(comparator);
        System.out.println("Min: " + opMin.apply(5, 6));
        System.out.println("Min: " + opMin.apply(9, 6));
        // ------------------------------------------------------------------------------------

        // BiPredicate
        // Represents a predicate (boolean-valued function) of two arguments
        BiPredicate<Integer, String> condition = (i, s) -> i > 20 && s.startsWith("T");
        System.out.println(condition.test(10, "One"));
        System.out.println(condition.test(30, "Two"));
        System.out.println(condition.test(30, "Three"));
        // ------------------------------------------------------------------------------------

    }


}
