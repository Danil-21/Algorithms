import java.util.Arrays;

public class Exercise3 {

    public static void main(String[] args) {
        int[] arr1 = {3, 0, 2, 3, 1};
        int[] arr2 = {2, 2, 0, 3};

        sort(arr1);
        sort(arr2);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void sort(int[] arr) {
        if (arr.length == 0) return;

        int min = arr[0];
        int max = arr[0];
        for (int val : arr) {
            min = Math.min(min, val);
            max = Math.max(max, val);
        }

        int range = max - min + 1;
        int[] count = new int[range];

        for (int val : arr) {
            int offset = val - min;
            count[offset]++;
        }

        int index = 0;

        for (int level = 0; level < count.length; level++) {
            for (int repeat = 0; repeat < count[level]; repeat++) {
                arr[index++] = level;
            }
        }
    }
}
