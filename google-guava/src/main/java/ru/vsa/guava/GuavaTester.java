package ru.vsa.guava;

import com.google.common.base.*;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.*;
import com.google.common.math.BigIntegerMath;
import com.google.common.math.IntMath;
import com.google.common.math.LongMath;
import com.google.common.primitives.*;

import java.io.IOException;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by vsa
 * Date: 24.03.2015.
 */
public class GuavaTester {
    public static void main(String[] args) throws IllegalAccessException {
        GuavaTester guavaTester = new GuavaTester();

        Integer value1 = null;
        Integer value2 = new Integer(10);

        // Optional.fromNullable - allows passed parameter to be null.
        Optional<Integer> a = Optional.fromNullable(value1);

        // Optional.of = throws NullPointerException if passed parameter is null
        Optional<Integer> b = Optional.of(value2);

        System.out.println(guavaTester.sum(a, b));

        System.out.println("---------------------------------------------------");

        try {
            System.out.println(guavaTester.sqrt(-3.0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(guavaTester.sum(null, 3));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(guavaTester.getValue(6));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---------------------------------------------------");

        List<Integer> numbers = new ArrayList<Integer>();

        numbers.add(new Integer(5));
        numbers.add(new Integer(2));
        numbers.add(new Integer(15));
        numbers.add(new Integer(51));
        numbers.add(new Integer(53));
        numbers.add(new Integer(35));
        numbers.add(new Integer(45));
        numbers.add(new Integer(32));
        numbers.add(new Integer(43));
        numbers.add(new Integer(16));

        Ordering ordering = Ordering.natural();
        System.out.println("Input list: ");
        System.out.println(numbers);

        Collections.sort(numbers, ordering);
        System.out.println("Sorted list: ");
        System.out.println(numbers);

        System.out.println("========================");
        System.out.println("List is sored: " + ordering.isOrdered(numbers));
        System.out.println("Minimum: " + ordering.min(numbers));
        System.out.println("Maximum: " + ordering.max(numbers));

        Collections.sort(numbers, ordering.reverse());
        System.out.println("Reverse: " + numbers);

        numbers.add(null);
        System.out.println("Null added to Sorted List: ");
        System.out.println(numbers);

        Collections.sort(numbers, ordering.nullsFirst());
        System.out.println("Null first Sorted List: ");
        System.out.println(numbers);
        System.out.println("==========================");

        List<String> names = new ArrayList<String>();

        names.add("Ram");
        names.add("Shyam");
        names.add("Mohan");
        names.add("Sohan");
        names.add("Ramesh");
        names.add("Suresh");
        names.add("Naresh");
        names.add("Mahesh");
        names.add(null);
        names.add("Vikas");
        names.add("Deepak");

        System.out.println("Another List: ");
        System.out.println(names);

        Collections.sort(names, ordering.nullsFirst().reverse());
        System.out.println("Null first then reverse sorted list: ");
        System.out.println(names);

        System.out.println("------------------------------------------");

        Student s1 = new Student("Mahesh" , "Parashar", 1, "VI");
        Student s2 = new Student("Suresh" , null, 3, null);

        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
        /*Objects.toStringHelper(s1)
                .add("Name", s1.getFirstName() + " " + s1.getLastName())
                .add("Class", s1.getClassName())
                .add("Roll No", s1.getRollNo())
                .toString());*/

        guavaTester.testRange();

        try {
            guavaTester.showcaseThrowable();
        } catch (InvalidInputException e) {
            // get the root cause
            System.out.println(Throwables.getRootCause(e));
        } catch (Exception e) {
            // get the stack trace in string format
            System.out.println(Throwables.getStackTraceAsString(e));
        }

        try {
            guavaTester.showcaseThrowable1();
        } catch (Exception e) {
            System.out.println(Throwables.getStackTraceAsString(e));
        }

        LoadingCache<String, Employee> employeeCach = CacheBuilder.newBuilder()
                // maximum 100 records can be cached
                .maximumSize(100)
                // cache will expire after 30 minutes of access
                .expireAfterAccess(30, TimeUnit.MINUTES)
                // build the cache loader
                .build(new CacheLoader<String, Employee>() {
                    @Override
                    public Employee load(String empId) throws Exception {
                        return getFromDatabase(empId);
                    }
                });

        try {
            // on first invocation, cache will be populated with corresponding
            // employee record
            System.out.println("Invocation #1");
            System.out.println(employeeCach.get("100"));
            System.out.println(employeeCach.get("103"));
            System.out.println(employeeCach.get("110"));

            //second invocation, data will be returned from cache
            System.out.println("Invocation #2");
            System.out.println(employeeCach.get("100"));
            System.out.println(employeeCach.get("103"));
            System.out.println(employeeCach.get("110"));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // create a multiset collection
        Multiset<String> multiset = HashMultiset.create();

        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("d");
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("b");
        multiset.add("b");
        multiset.add("b");

        // print the occurrence of an element
        System.out.println("Occurrence of 'b' : " + multiset.count("b"));

        // print the total size of the multiset
        System.out.println("Total size: " + multiset.size());

        // get the distinct elements of the multiset as set
        Set<String> set = multiset.elementSet();

        // display the elements of the set
        System.out.print("Set [");

        for (String s : set) {
            System.out.print(s + " ");
        }

        System.out.println("]");

        // display the distinct elements of the multiset with their occurrence count
        System.out.println("MultiSet [");

        for (Multiset.Entry<String> entry : multiset.entrySet()) {
            System.out.println("Element: " + entry.getElement() + ", Occurrence(s): " + entry.getCount());
        }
        System.out.println("]");

        // remove extra occurrences
        multiset.remove("b", 2);

        // print the occurrence of an elements
        System.out.println("Occurrence of 'b' " + multiset.count("b"));

        Multimap<String, String> multimap = guavaTester.getMultimap();

        List<String> lowestList = (List<String>) multimap.get("lower");
        System.out.println("Initial lower case list");
        System.out.println(lowestList.toString());

        lowestList.add("f");
        System.out.println("Modified lower case list");
        System.out.println(lowestList.toString());

        List<String> upperList = (List<String>) multimap.get("upper");
        System.out.println("Initial upper case list");
        System.out.println(upperList.toString());

        Map<String, Collection<String>> map = multimap.asMap();
        System.out.println("Multimap as a map");

        for (Map.Entry<String, Collection<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            Collection<String> value = multimap.get("lower");
            System.out.println(key + ": " + value);
        }

        System.out.println("Keys of Multimap");
        Set<String> keys = multimap.keySet();

        for (String key : keys) {
            System.out.println(key);
        }

        System.out.println("Values of Multimap");
        Collection<String> values = multimap.values();
        System.out.println(values);

        BiMap<Integer, String> empIDNameMap = HashBiMap.create();

        empIDNameMap.put(new Integer(101), "Mahesh");
        empIDNameMap.put(new Integer(102), "Sohan");
        empIDNameMap.put(new Integer(103), "Ramesh");

        // Emp Id of Employee "Mahesh"
        System.out.println(empIDNameMap.inverse().get("Mahesh"));


        //Table<R,C,V> == Map<R,Map<C,V>>
        //
        //  Company: IBM, Microsoft, TCS
        //  IBM 		-> {101:Mahesh, 102:Ramesh, 103:Suresh}
        //  Microsoft 	-> {101:Sohan, 102:Mohan, 103:Rohan }
        //  TCS 		-> {101:Ram, 102: Shyam, 103: Sunil }

        // create a table
        Table<String, String, String> employeeTable = HashBasedTable.create();

        //initialize the table with employee details
        employeeTable.put("IBM", "101","Mahesh");
        employeeTable.put("IBM", "102","Ramesh");
        employeeTable.put("IBM", "103","Suresh");

        employeeTable.put("Microsoft", "111","Sohan");
        employeeTable.put("Microsoft", "112","Mohan");
        employeeTable.put("Microsoft", "113","Rohan");

        employeeTable.put("TCS", "121","Ram");
        employeeTable.put("TCS", "122","Shyam");
        employeeTable.put("TCS", "123","Sunil");

        // get Map corresponding to IBM
        Map<String, String> ibmEmployees = employeeTable.row("IBM");

        System.out.println("List of IBM Employees");

        for (Map.Entry<String, String> entry : ibmEmployees.entrySet()) {
            System.out.println("Emp Id: " + entry.getKey() + ", Name: " + entry.getValue());
        }

        // get all the unique keys of the table
        Set<String> employers = employeeTable.rowKeySet();
        System.out.println("Employers: ");

        for (String employer : employers) {
            System.out.println(employer + " ");
        }

        System.out.println();

        // get a Map corresponding to 102
        Map<String, String> employerMap = employeeTable.column("102");

        for (Map.Entry<String, String> entry : employerMap.entrySet()) {
            System.out.println("Employer: " + entry.getKey() + ", Name: " + entry.getValue());
        }

        guavaTester.testJoiner();
        guavaTester.testSplitter();
        guavaTester.testCharMatcher();
        guavaTester.testCaseFormat();
        guavaTester.testBytes();

        guavaTester.testShorts();
        guavaTester.testInts();
        guavaTester.testLongs();
        guavaTester.testFloats();
        guavaTester.testDoubles();
        guavaTester.testChars();
        guavaTester.testBooleans();

        guavaTester.testIntMath();
        guavaTester.testLongMath();
        guavaTester.testBigIntegerMath();

    }

    public double sqrt(double input) throws IllegalAccessException {
        Preconditions.checkArgument(input > 0.0, "Illegal Argument passed: Negative value %s.", input);
        return Math.sqrt(input);
    }

    public int sum(Integer a, Integer b) {
        a = Preconditions.checkNotNull(a, "IllegalArgument passed: First parameter is Null");
        b = Preconditions.checkNotNull(a, "IllegalArgument passed: Second parameter is Null");
        return a + b;
    }

    public int getValue(int input) {
        int[] data = {1, 2, 3, 4, 5};
        Preconditions.checkElementIndex(input, data.length, "Illegal Argument passed: Invalid index");
        return 0;
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        // Optional.isPresent - checks the value is present or not
        System.out.println("First parameter is present: " + a.isPresent());
        System.out.println("First parameter is present: " + b.isPresent());

        // Optional.or - returns the value if present otherwise returns
        // the default value passed.
        Integer value1 = a.or(new Integer(0));

        // Optional.get = gets the value, value should be present
        Integer value2 = b.get();

        return value1 + value2;
    }

    public void testRange() {
        // create a range[a,b] = {x | a <= x <= b}
        Range<Integer> range1 = Range.closed(0, 9);
        System.out.print("[0,9]: ");
        printRange(range1);

        System.out.println("5 is present: " + range1.contains(5));
        System.out.println("(1,2,3) is present: " + range1.containsAll(Ints.asList(1, 2, 3)));
        System.out.println("Lower Bound: " + range1.lowerEndpoint());
        System.out.println("Upper Bound: " + range1.upperEndpoint());

        // create a range(a,b) = { x | a < x < b }
        Range<Integer> range2 = Range.open(0, 9);
        System.out.print("(0,9): ");
        printRange(range2);

        // create a range (a, b] = { x | a < x <= b }
        Range<Integer> range3 = Range.openClosed(0, 9);
        System.out.print("(0,9]: ");
        printRange(range3);

        // create a range [a,b) = { x | a <= x < b
        Range<Integer> range4 = Range.closedOpen(0, 9);
        System.out.print("[0,9): ");
        printRange(range4);

        // create an open ended range (9, infinity
        Range<Integer> range5 = Range.greaterThan(9);
        System.out.println("(9, infinity): ");
        System.out.println("Lower Bound present: " + range5.lowerEndpoint());
        System.out.println("Upper Bound present: " + range5.hasUpperBound());

        Range<Integer> range6 = Range.closed(3, 5);
        printRange(range6);

        // check a subrange [3,5] in [0,9]
        System.out.println("[0,9] encloses [3,5]: " + range1.encloses(range6));

        Range<Integer> range7 = Range.closed(9, 20);
        printRange(range7);

        // check ranges o be connected
        System.out.println("[0,9] is connected [9,20] " + range1.isConnected(range7));

        Range<Integer> range8 = Range.closed(5, 15);

        // intersection
        printRange(range1.intersection(range8));

        // span
        printRange(range1.span(range8));

    }

    public void printRange(Range<Integer> range) {
        System.out.print("[ ");

        for (int grade : ContiguousSet.create(range, DiscreteDomain.integers())) {
            System.out.print(grade + " ");
        }

        System.out.println("]");
    }

    public void showcaseThrowable() throws InvalidInputException {
        try {
            sqrtT(-3.0);
        } catch (Throwable t) {
            // check the type of exception and throw it
            Throwables.propagateIfInstanceOf(t, InvalidInputException.class);
            Throwables.propagate(t);
        }
    }

    public void showcaseThrowable1() {
        try {
            int[] data = {1, 2, 3};
            getValue(data, 4);
        } catch (Throwable t) {
            Throwables.propagateIfInstanceOf(t, IndexOutOfBoundsException.class);
            Throwables.propagate(t);
        }
    }

    public double sqrtT(double input) throws InvalidInputException {
        if (input < 0) {
            throw new InvalidInputException();
        }
        return Math.sqrt(input);
    }

    public double getValue(int[] list, int index) throws IndexOutOfBoundsException {
        return list[index];
    }

    public void dummyIO() throws IOException {
        throw new IOException();
    }

    private static Employee getFromDatabase(String empId) {
        Employee e1 = new Employee("Mahesh", "Finance", "100");
        Employee e2 = new Employee("Rohan", "IT", "103");
        Employee e3 = new Employee("Sohan", "Admin", "110");

        Map<String, Employee> database = new HashMap<String, Employee>();

        database.put("100", e1);
        database.put("103", e2);
        database.put("110", e3);

        System.out.println("Database hit for " + empId);

        return database.get(empId);
    }

    public Multimap<String, String> getMultimap() {
        // Map<String, List<String>>
        // lowe -> a,b,c,d,e
        // upper -> A,B,C,D

        Multimap<String, String> multimap = ArrayListMultimap.create();

        multimap.put("lower", "a");
        multimap.put("lower", "b");
        multimap.put("lower", "c");
        multimap.put("lower", "d");
        multimap.put("lower", "e");

        multimap.put("upper", "A");
        multimap.put("upper", "B");
        multimap.put("upper", "C");
        multimap.put("upper", "D");

        return multimap;
    }

    public void testJoiner() {
        System.out.println(Joiner.on(",")
                .skipNulls()
                .join(Arrays.asList(1, 2, 3, 4, 5, null, 6)));
    }

    public void testSplitter() {
        System.out.println(Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("the ,quick, ,brown, fox, jumps, over, the, lazy, little dog."));
    }

    public void testCharMatcher() {
        // only digits
        System.out.println(CharMatcher.DIGIT.retainFrom("mahesh123"));
        System.out.println(CharMatcher.WHITESPACE.trimAndCollapseFrom("     Mahesh     Parashar ", ' '));

        // trim whitespace at ends, and replace/collapse whitespace into single spaces
        System.out.println(CharMatcher.JAVA_DIGIT.replaceFrom("mahesh1233", "*"));

        // eliminate all characters that aren't digits or lowercase
        System.out.println(CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom("mahesh1233"));
    }

    public void testCaseFormat() {
        String data = "test_data";
        System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "test-data"));
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test_data"));
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "test_data"));
    }

    private void testBytes() {
        byte[] byteArray = {1, 2, 3, 4, 5, 5, 7, 9, 9};

        // convert array of primitives to array of objects
        List<Byte> objectArray = Bytes.asList(byteArray);
        System.out.println(objectArray.toString());

        // convert array of objects to array of primitives
        byteArray = Bytes.toArray(objectArray);
        System.out.print("[ ");

        for (int i = 0; i < byteArray.length; i++) {
            System.out.print(byteArray[i] + " ");
        }

        System.out.println("]");

        byte data = 5;

        // check if element is present in the list of primitives or not
        System.out.println("5 is in list? " + Bytes.contains(byteArray, data));

        // Returns the index
        System.out.println("Index of 5: " + Bytes.indexOf(byteArray, data));

        // Returns the last index maximum
        System.out.println("Last index of 5: " + Bytes.lastIndexOf(byteArray, data));
    }

    private void testShorts() {
        short[] shortArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // convert array of primitives to array of objects
        List<Short> objectArray = Shorts.asList(shortArray);
        System.out.println(objectArray.toString());

        // convert array of objects to array of primitives
        shortArray = Shorts.toArray(objectArray);

        System.out.println("[ ");
        for (int i = 0; i < shortArray.length; i++) {
            System.out.print(shortArray[i] + " ");
        }
        System.out.println("]");

        short data = 5;

        // check if element is present in the list of primitives or not
        System.out.println("5 is in list? " + Shorts.contains(shortArray, data));

        // returns the minimum
        System.out.println("Min: " + Shorts.min(shortArray));

        // returns the maximum
        System.out.println("Max: " + Shorts.max(shortArray));

        data = 2400;

        // get the byte array from an integer
        byte[] byteArray = Shorts.toByteArray(data);

        for (int i = 0; i < byteArray.length; i++) {
            System.out.println(byteArray[i] + " ");
        }
    }

    private void testInts() {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        //convert array of primitives to array of objects
        List<Integer> objectArray = Ints.asList(intArray);
        System.out.println(objectArray.toString());

        //convert array of objects to array of primitives
        intArray = Ints.toArray(objectArray);
        System.out.print("[ ");

        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }

        System.out.println("]");

        //check if element is present in the list of primitives or not
        System.out.println("5 is in list? " + Ints.contains(intArray, 5));

        //Returns the minimum
        System.out.println("Min: " + Ints.min(intArray));

        //Returns the maximum
        System.out.println("Max: " + Ints.max(intArray));

        //get the byte array from an integer
        byte[] byteArray = Ints.toByteArray(20000);

        for (int i = 0; i < byteArray.length; i++) {
            System.out.print(byteArray[i] + " ");
        }
    }

    private void testLongs() {
        long[] longArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        //convert array of primitives to array of objects
        List<Long> objectArray = Longs.asList(longArray);
        System.out.println(objectArray.toString());

        //convert array of objects to array of primitives
        longArray = Longs.toArray(objectArray);
        System.out.print("[ ");

        for (int i = 0; i < longArray.length; i++) {
            System.out.print(longArray[i] + " ");
        }

        System.out.println("]");

        //check if element is present in the list of primitives or not
        System.out.println("5 is in list? " + Longs.contains(longArray, 5));

        //Returns the minimum
        System.out.println("Min: " + Longs.min(longArray));

        //Returns the maximum
        System.out.println("Max: " + Longs.max(longArray));

        //get the byte array from an integer
        byte[] byteArray = Longs.toByteArray(20000);

        for (int i = 0; i < byteArray.length; i++) {
            System.out.print(byteArray[i] + " ");
        }
    }

    private void testFloats() {
        float[] floatArray = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f};

        //convert array of primitives to array of objects
        List<Float> objectArray = Floats.asList(floatArray);
        System.out.println(objectArray.toString());

        //convert array of objects to array of primitives
        floatArray = Floats.toArray(objectArray);
        System.out.print("[ ");

        for (int i = 0; i < floatArray.length; i++) {
            System.out.print(floatArray[i] + " ");
        }

        System.out.println("]");

        //check if element is present in the list of primitives or not
        System.out.println("5.0 is in list? " + Floats.contains(floatArray, 5.0f));

        //return the index of element
        System.out.println("5.0 position in list " + Floats.indexOf(floatArray, 5.0f));

        //Returns the minimum
        System.out.println("Min: " + Floats.min(floatArray));

        //Returns the maximum
        System.out.println("Max: " + Floats.max(floatArray));
    }

    private void testDoubles() {
        double[] doubleArray = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0};

        //convert array of primitives to array of objects
        List<Double> objectArray = Doubles.asList(doubleArray);
        System.out.println(objectArray.toString());

        //convert array of objects to array of primitives
        doubleArray = Doubles.toArray(objectArray);
        System.out.print("[ ");

        for (int i = 0; i < doubleArray.length; i++) {
            System.out.print(doubleArray[i] + " ");
        }

        System.out.println("]");

        //check if element is present in the list of primitives or not
        System.out.println("5.0 is in list? " + Doubles.contains(doubleArray, 5.0f));

        //return the index of element
        System.out.println("5.0 position in list " + Doubles.indexOf(doubleArray, 5.0f));

        //Returns the minimum
        System.out.println("Min: " + Doubles.min(doubleArray));

        //Returns the maximum
        System.out.println("Max: " + Doubles.max(doubleArray));
    }

    private void testChars() {
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        //convert array of primitives to array of objects
        List<Character> objectArray = Chars.asList(charArray);
        System.out.println(objectArray.toString());

        //convert array of objects to array of primitives
        charArray = Chars.toArray(objectArray);
        System.out.print("[ ");

        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i] + " ");
        }

        System.out.println("]");

        //check if element is present in the list of primitives or not
        System.out.println("c is in list? " + Chars.contains(charArray, 'c'));

        //return the index of element
        System.out.println("c position in list " + Chars.indexOf(charArray, 'c'));

        //Returns the minimum
        System.out.println("Min: " + Chars.min(charArray));

        //Returns the maximum
        System.out.println("Max: " + Chars.max(charArray));
    }

    private void testBooleans() {
        boolean[] booleanArray = {true, true, false, true, true, false, false};

        // convert array of primitives to array of objects
        List<Boolean> objectArray = Booleans.asList(booleanArray);
        System.out.println(objectArray.toString());

        // convert array of objects to array of primitives
        booleanArray = Booleans.toArray(objectArray);
        System.out.print("[ ");

        for (int i = 0; i < booleanArray.length; i++) {
            System.out.print(booleanArray[i] + " ");
        }

        System.out.println("]");

        //check if element is present in the list of primitives or not
        System.out.println("true is in list? " + Booleans.contains(booleanArray, true));

        //return the first index of element
        System.out.println("true position in list " + Booleans.indexOf(booleanArray, true));

        //Returns the count of true values
        System.out.println("true occurred: " + Booleans.countTrue());

        //Returns the comparisons
        System.out.println("false Vs true: " + Booleans.compare(false, true));
        System.out.println("false Vs false: " + Booleans.compare(false, false));
        System.out.println("true Vs false: " + Booleans.compare(true, false));
        System.out.println("true Vs true: " + Booleans.compare(true, true));
    }

    private void testIntMath() {
        try {
            System.out.println(IntMath.checkedAdd(Integer.MAX_VALUE, Integer.MAX_VALUE));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println(IntMath.divide(100, 5, RoundingMode.UNNECESSARY));

        try {
            // exception will be thrown as 100 is not completely divisible by 3
            // thus rounding is required, and RoundingMode is set as UNNECESSARY
            System.out.println(IntMath.divide(100, 3, RoundingMode.UNNECESSARY));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Log2(2): " + IntMath.log2(2, RoundingMode.HALF_EVEN));
        System.out.println("Log10(10): " + IntMath.log10(10, RoundingMode.HALF_EVEN));
        System.out.println("sqrt(100): " + IntMath.sqrt(IntMath.pow(10, 2), RoundingMode.HALF_EVEN));
        System.out.println("gcd(100, 50): " + IntMath.gcd(100, 50));
        System.out.println("modulus(100, 50): " + IntMath.mod(100, 50));
        System.out.println("factorial(5): " + IntMath.factorial(5));
        System.out.println();
    }

    private void testLongMath() {
        try {
            System.out.println(LongMath.checkedAdd(Long.MAX_VALUE, Long.MAX_VALUE));

        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println(LongMath.divide(100, 5, RoundingMode.UNNECESSARY));
        try {
            //exception will be thrown as 100 is not completely divisible by 3
            // thus rounding is required, and RoundingMode is set as UNNESSARY
            System.out.println(LongMath.divide(100, 3, RoundingMode.UNNECESSARY));

        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Log2(2): " + LongMath.log2(2, RoundingMode.HALF_EVEN));
        System.out.println("Log10(10): " + LongMath.log10(10, RoundingMode.HALF_EVEN));
        System.out.println("sqrt(100): " + LongMath.sqrt(LongMath.pow(10, 2), RoundingMode.HALF_EVEN));
        System.out.println("gcd(100,50): " + LongMath.gcd(100, 50));
        System.out.println("modulus(100,50): " + LongMath.mod(100, 50));
        System.out.println("factorial(5): " + LongMath.factorial(5));
    }

    private void testBigIntegerMath() {

        System.out.println(BigIntegerMath.divide(BigInteger.TEN, new BigInteger("2"), RoundingMode.UNNECESSARY));

        try {
            //exception will be thrown as 100 is not completely divisible by 3
            // thus rounding is required, and RoundingMode is set as UNNESSARY
            System.out.println(BigIntegerMath.divide(BigInteger.TEN, new BigInteger("3"), RoundingMode.UNNECESSARY));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Log2(2): " + BigIntegerMath.log2(new BigInteger("2"), RoundingMode.HALF_EVEN));
        System.out.println("Log10(10): " + BigIntegerMath.log10(BigInteger.TEN, RoundingMode.HALF_EVEN));
        System.out.println("sqrt(100): " + BigIntegerMath.sqrt(BigInteger.TEN.multiply(BigInteger.TEN), RoundingMode.HALF_EVEN));
        System.out.println("factorial(5): " + BigIntegerMath.factorial(5));
    }

}
