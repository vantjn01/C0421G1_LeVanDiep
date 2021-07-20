package _14_sort_algorithm.bai_tap.bai_tap2;

public class InsertionSort {
    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] numbers = {2,6,9,3,1,-7,11,-2,0};
        InsertionSort sort = new InsertionSort();
        sort.insertionSort(numbers);
        sort.printArray(numbers);
    }
}
