package _14_sort_algorithm.bai_tap.bai_tap1;

public class InsertSort {
    public static int[] array = {2,6,9,3,1,-7,11,-2,0};

    public static void insertionSort(int[] array) {
        int arrayLength = array.length;
        int temp, j;
        for (int i = 1; i < arrayLength; i++) {
            temp = array[i];
            j = i - 1;

            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println("Before: ");
        for (int elements : array){
            System.out.print(elements+" ");
        }

        System.out.println("\nAfter: ");
        insertionSort(array);
        for (int elements : array){
            System.out.print(elements+" ");
        }
    }
}
