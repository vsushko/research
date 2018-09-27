package vsushko.algorithms.searching;

/**
 * @author vsushko
 */
public class LinearSearchRecursive {

    public static void main(String[] args) {
        int arr[] = {12, 34, 54, 2, 3};
        int x = 3;
        int index = recSearch(arr, 0, arr.length - 1, x);
        if (index != -1) {
            System.out.println("Element " + x + " is present at index " + index);
        } else {
            System.out.println("Element " + x + " is not present");
        }
    }

    // Recursive Method to search x in arr[l..r]
    private static int recSearch(int arr[], int l, int r, int x) {
        if (r < l) {
            return -1;
        }
        if (arr[l] == x) {
            return l;
        }
        return recSearch(arr, l + 1, r, x);
    }
}


