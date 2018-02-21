package studycollections;

import java.util.*;

public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> ints = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        Integer[] moreInts = { 6,7,8,9,0 };
        ints.addAll(Arrays.asList(moreInts));
        Collections.addAll(ints, 11, 12, 13);
        Collections.addAll(ints, moreInts);

        List<Integer> list = Arrays.asList(14,15,16);
        list.set(0,99);

        Iterator<Integer> it = ints.iterator();
        while (it.hasNext()) {
            Integer integer = it.next();
            System.out.println(integer);
        }

    }
}
