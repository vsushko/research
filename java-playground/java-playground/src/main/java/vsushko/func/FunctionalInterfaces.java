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

        BiConsumer<String, String> biConsumer2 = (x, y) -> {
            System.out.println(x);
            System.out.println(y);
        };
        biConsumer2.accept("String 1", "String 2");
        
        BiConsumer<Integer, Integer> biConsumer3 = (i1, i2) -> System.out.println(i1 + i2);
        BiConsumer<Integer, Integer> biConsumer4 = (i1, i2) -> System.out.println(i1 - i2);

        biConsumer3.andThen(biConsumer4).accept(10, 11);
        // ------------------------------------------------------------------------------------
        // BiFunction
        // accepts two arguments and produces a result
        BiFunction<Integer, Integer, String> biFunction = (num1, num2) -> "Result: " + (num1 + num2);
        System.out.println(biFunction.apply(20, 25));
        
        BiFunction<Integer, Integer, Integer> biFunction2 = (i1, i2) -> i1 + i2;
        Function<Integer, Integer> function1 = (n) -> n * n;

        // using andThen()
        System.out.println(biFunction2.andThen(function1).apply(2, 4));
        System.out.println(biFunction2.andThen(function1).apply(3, 5));
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
        BiPredicate<Integer, String> condition1 = (i, s) -> i > 20;
        BiPredicate<Integer, String> condition2 = (i, s) -> s.startsWith("T");

        System.out.println(condition1.and(condition2).test(10, "One"));
        System.out.println(condition1.and(condition2).test(30, "Two"));
        System.out.println(condition1.or(condition2).test(30, "Three"));
        System.out.println(condition1.and(condition2).negate().test(30, "Three"));
        // ------------------------------------------------------------------------------------
        // BooleanSupplier
        // represents a supplier with boolean-valued results
        BooleanSupplier booleanSupplier = () -> true;
        System.out.println(booleanSupplier.getAsBoolean());

        int x = 0, y= 1;
        booleanSupplier = () -> x > y;
        System.out.println(booleanSupplier.getAsBoolean());

        booleanSupplier = () -> "String".equals("String");
        System.out.println(booleanSupplier.getAsBoolean());
        // ------------------------------------------------------------------------------------
        // Consumer
        // Represents an operation that accepts a single input argument and returns no result
        Consumer<Integer> consumer1 = i -> {
            System.out.println(i + i);
        };
        Consumer<Integer> consumer2 = i -> {
            System.out.println(i - i);
        };
        consumer1.andThen(consumer2).accept(1);

        Consumer<Integer> consumerInt = i -> {
            System.out.println("Integer value = " + i);
        };
        consumerInt.accept(5);
        consumerInt.accept(8);
        // ------------------------------------------------------------------------------------
        // DoubleBinaryOperator
        // Represents an operation upon two double-valued operands and producing a double-valued result
        DoubleBinaryOperator dBinaryOperator1 = (a, b) -> (a + b);
        DoubleBinaryOperator dBinaryOperator2 = (a, b) -> (a - b);
        DoubleBinaryOperator dBinaryOperator3 = (a, b) -> (a * b);
        DoubleBinaryOperator dBinaryOperator4 = (a, b) -> (a / b);

        System.out.println(dBinaryOperator1.applyAsDouble(5, 6));
        System.out.println(dBinaryOperator2.applyAsDouble(8, -10));
        System.out.println(dBinaryOperator3.applyAsDouble(8, 5));
        System.out.println(dBinaryOperator4.applyAsDouble(8, 4));
        // ------------------------------------------------------------------------------------
        // DoubleConsumer
        // Represents an operation that accepts a single double-valued argument and returns no result
        DoubleConsumer doubleConsumer = (a) -> System.out.println(a);
        // Using accept()
        doubleConsumer.accept(4.5);
        DoubleConsumer doubleConsumer2 = (b) -> System.out.println(b * 2);
        // Using andThen()
        doubleConsumer.andThen(doubleConsumer2).accept(10);
        // ------------------------------------------------------------------------------------
        // DoubleFunction
        // Represents a function that accepts a double-valued argument and produces a result
        DoubleFunction doubleFunction = (x) -> x * 2;
        System.out.println(doubleFunction.apply(3.14));
        DoubleFunction<String> doubleFunctionString = (x) -> "double value: " + x;
        System.out.println(doubleFunctionString.apply(0.123));
        // ------------------------------------------------------------------------------------
       // DoublePredicate
        // Represents a predicate (boolean-valued function) of one double-valued argument
        DoublePredicate notZero = (x) -> x == 0;
        DoublePredicate moreThanOne = (x) -> x > 1;
        DoublePredicate lessThanTen = (x) -> x < 10;
        System.out.println(notZero.negate().or(lessThanTen).and(moreThanOne).test(21.12));
        System.out.println(notZero.negate().or(lessThanTen).and(moreThanOne).test(0.12));
        // ------------------------------------------------------------------------------------
        // DoubleSupplier
        // Represents a supplier of double-valued results
        DoubleSupplier randomSupplier = () -> Math.random() * 10000;
        System.out.println(randomSupplier.getAsDouble());
        double firstDouble = 8;
        double secondDouble = 7;
        DoubleSupplier divisionSupplier = () -> firstDouble / secondDouble;
        System.out.println(divisionSupplier.getAsDouble());
        // ------------------------------------------------------------------------------------
        // DoubleToIntFunction
        // Represents a function that accepts a double-valued argument and produces an int-valued result
        DoubleToIntFunction doubleToIntFunction = (d) -> (int) d;
        System.out.println(doubleToIntFunction.applyAsInt(4.5));
        System.out.println(doubleToIntFunction.applyAsInt(Double.MAX_VALUE));
        DoubleToIntFunction doubleToIntFunction2 = (d) -> {
            Double doubleValue = new Double(d);
            return doubleValue.intValue();
        };
        System.out.println(doubleToIntFunction2.applyAsInt(45.846));
        System.out.println(doubleToIntFunction2.applyAsInt(99.9089));
        // ------------------------------------------------------------------------------------
    }


}
