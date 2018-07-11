package vsushko.func;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;

/**
 * @author Vasiliy Sushko
 */
public class Main {

    public static void main(String[] args) {
        // BiConsumer
        // Represents an operation that accepts two input arguments and returns no result
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

        int firstNumber = 0, secondNumber = 1;
        booleanSupplier = () -> firstNumber > secondNumber;
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
        // DoubleToLongFunction
        // Represents a function that accepts a double-valued argument and produces a long-valued result
        DoubleToLongFunction dtlFunction1 = (d) -> (int) d;
        System.out.println(dtlFunction1.applyAsLong(45.50));
        System.out.println(dtlFunction1.applyAsLong(Double.MAX_VALUE));

        DoubleToLongFunction dtlFunction2 = (d) -> {
            Double doubleVal = new Double(d);
            return doubleVal.longValue();
        };
        System.out.println(dtlFunction2.applyAsLong(789.456));
        // ------------------------------------------------------------------------------------
        // DoubleUnaryOperator
        // Represents an operation on a single double-valued operand that produces a double-valued result
        DoubleUnaryOperator duOperator = (d) -> d * d;
        System.out.println(duOperator.applyAsDouble(4.5));
        System.out.println(duOperator.applyAsDouble(15.7));

        DoubleUnaryOperator duOperator1 = (d) -> d * d;
        DoubleUnaryOperator duOperator2 = (d) -> d + 1000;

        // Using andThen()
        System.out.println(duOperator1.andThen(duOperator2).applyAsDouble(4.5));
        // Using compose()
        System.out.println(duOperator1.compose(duOperator2).applyAsDouble(4.5));
        System.out.println(duOperator1.compose(duOperator2).applyAsDouble(4.5));
        // ------------------------------------------------------------------------------------
        // Function
        // Represents a function that accepts one argument and produces a result
        Function<Integer, String> isEvenOrOddFunction = (t) -> {
            if (t % 2 == 0) {
                return t + " is even number";
            } else {
                return t + " is odd number";
            }
        };

        System.out.println(isEvenOrOddFunction.apply(5));
        System.out.println(isEvenOrOddFunction.apply(8));

        Function<Integer, String> fizzOrBuzzFunction = (i) -> {
            if (i % 15 == 0) {
                return "FizzBuzz";
            } else if (i % 3 == 0) {
                return "Fizz";
            } else if (i % 5 == 0) {
                return "Buzz";
            } else {
                return String.valueOf(i);
            }
        };
        for (int i = 1; i <= 100; i++) {
            System.out.println(fizzOrBuzzFunction.apply(i));
        }

        Function<Integer, Integer> minusFiveFunction = t -> (t - 5);
        Function<Integer, Integer> multipliesTwoFunction = t -> (t * 2);

        // Using andThen() method
        System.out.println(minusFiveFunction.andThen(multipliesTwoFunction).apply(50));
        // Using compose function
        System.out.println(minusFiveFunction.compose(multipliesTwoFunction).apply(50));
        // ------------------------------------------------------------------------------------
        // IntBinaryOperator
        // Represents an operation upon two int-valued operands and producing an int-valued result
        IntBinaryOperator ibOperator1 = (a, b) -> a + b;
        System.out.println(ibOperator1.applyAsInt(5, 4));

        IntBinaryOperator ibOperator2 = (a, b) -> a - b;
        System.out.println(ibOperator2.applyAsInt(5, 4));

        IntBinaryOperator ibOperator3 = (a, b) -> a * b;
        System.out.println(ibOperator3.applyAsInt(5, 4));
        // ------------------------------------------------------------------------------------
        // IntConsumer
        // Represents an operation that accepts a single int-valued argument and returns no result
        IntConsumer intConsumer = a -> System.out.println(a * a);
        intConsumer.accept(5);
        intConsumer.accept(10);

        IntConsumer intConsumer1 = a -> System.out.println(a * a);
        IntConsumer intConsumer2 = a -> System.out.println(a * 100);

        // Using andThen()
        intConsumer1.andThen(intConsumer2).accept(5);
        intConsumer1.andThen(intConsumer2).accept(50);
        // ------------------------------------------------------------------------------------
        // IntFunction
        // Represents a function that accepts an int-valued argument and produces a result
        IntFunction<String> stringIntFunction = (x) -> Integer.toString(x);
        System.out.println(stringIntFunction.apply(3).length());
        // ------------------------------------------------------------------------------------
        // IntPredicate
        // Represents a predicate (boolean-valued function) of one int-valued argument
        IntPredicate intPredicate = a -> a > 0;
        System.out.println(intPredicate.test(5));
        System.out.println(intPredicate.test(-5));

        IntPredicate intPredicate1 = a -> a > 0;
        IntPredicate intPredicate2 = a -> a == 10;

        // Using and()
        System.out.println(intPredicate1.and(intPredicate2).test(5));
        // Using or()
        System.out.println(intPredicate1.or(intPredicate2).test(12));
        // Using negate()
        System.out.println(intPredicate2.negate().test(10));
        // ------------------------------------------------------------------------------------
        // IntSupplier
        // Represents a supplier of int-valued results
        IntSupplier supplier1 = () -> Integer.MAX_VALUE;
        System.out.println(supplier1.getAsInt());

        int firstInt = 5, secondInt = 10;
        IntSupplier supplier2 = () -> firstInt * secondInt;
        System.out.println(supplier2.getAsInt());
        // ------------------------------------------------------------------------------------
        // IntToDoubleFunction
        //

        // ------------------------------------------------------------------------------------
        // IntToLongFunction
        //

        // ------------------------------------------------------------------------------------
        // IntUnaryOperator
        //

        // ------------------------------------------------------------------------------------
        // LongBinaryOperator
        //

        // ------------------------------------------------------------------------------------
        // LongConsumer
        //

        // ------------------------------------------------------------------------------------
        // LongFunction
        //

        // ------------------------------------------------------------------------------------
        // LongPredicate
        //

        // ------------------------------------------------------------------------------------
        // LongSupplier
        //

        // ------------------------------------------------------------------------------------
        // LongToDoubleFunction
        //

        // ------------------------------------------------------------------------------------
        // LongToIntFunction
        //

        // ------------------------------------------------------------------------------------
        // ObjDoubleConsumer
        //

        // ------------------------------------------------------------------------------------
        // ObjIntConsumer
        //

        // ------------------------------------------------------------------------------------
        // ObjLongConsumer
        //

        // ------------------------------------------------------------------------------------
        // Predicate
        //

        // ------------------------------------------------------------------------------------
        // Supplier
        //

        // ------------------------------------------------------------------------------------
        // ToDoubleBiFunction
        //

        // ------------------------------------------------------------------------------------
        // ToDoubleFunction
        //

        // ------------------------------------------------------------------------------------
        // ToIntBiFunction
        //

        // ------------------------------------------------------------------------------------
        // ToIntFunction
        //

        // ------------------------------------------------------------------------------------
        // ToLongBiFunction
        //

        // ------------------------------------------------------------------------------------
        // ToLongFunction
        //

        // ------------------------------------------------------------------------------------
        // UnaryOperator
        //
    }
}
