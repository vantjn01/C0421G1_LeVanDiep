package _13_linear_binary.optional_baitap;

public class Binary_search {
    public static int binarySearch(int[] array, int left, int right, int data) {
        int mid = 0;
        if (right >= left) {
            mid = (right + left) / 2;
            if (data == array[mid]) {
                return mid;
            } else if (data > array[mid]) {
                return binarySearch(array, mid + 1, right, data);
            } else {
                return binarySearch(array, left, right - 1, data);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array = new int[10];
        int number;

        long startTime = System.currentTimeMillis();
        for (int i=0; i<array.length; i++){
            number = (int) Math.floor(Math.random()*10);
            array[i]=number;
        }

        for (int arr: array){
            System.out.print(arr+" ");
        }

        int value = Binary_search.binarySearch(array,0,array.length-1,0);
        long endTime = System.currentTimeMillis();
        System.out.println("\nIndex of 31 is: "+value);
        System.out.println("Execution time: "+(endTime-startTime)+" miliseconds");
    }
}
