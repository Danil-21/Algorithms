import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise1 {

    public static void main(String[] args) {

        double[] arr = {0.30, 0.95, 0.05, 0.60};
        double[] arr2 = {0.40, 0.01, 0.99};

        int s = arr.length;

        System.out.println(Arrays.toString(arr));
        bucketSort(arr, s);
        System.out.println(Arrays.toString(arr));
    }

    public static void bucketSort(double[] arr, int s) {
        if (arr.length == 0) return;

        List<List<Double>> buckets = new ArrayList<>(s);

        for (int i = 0; i < s; i++) {
            buckets.add(new ArrayList<>());
        }

        for (double val : arr) {
            if (!(val >= 0 && val <= 1.0)) {
                return;
            }

            int index = Math.min(s - 1, (int) (val * s));
            buckets.get(index).add(val);
        }

//        System.out.println(buckets);

        int index = 0;
        for (List<Double> bucket : buckets) {
//            System.out.printf("До сортировки: %s\n", bucket);
            insertionSort(bucket);
//            System.out.printf("После сортировки: %s\n", bucket);

            for (double val : bucket) {
                arr[index++] = val;
            }

//            System.out.println(Arrays.toString(arr));
        }
    }

    private static void insertionSort(List<Double> bucket) {
        for (int i = 1; i < bucket.size(); i++) {
            double key = bucket.get(i);
            int j = i - 1;

            while (j >= 0 && bucket.get(j) > key) {
                bucket.set(j + 1, bucket.get(j));
                j--;
            }

            bucket.set(j + 1, key);
        }
    }
}
