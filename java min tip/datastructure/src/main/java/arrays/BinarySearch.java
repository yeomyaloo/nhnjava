package arrays;

public class BinarySearch {
    int key;
    int[] arr;

    public BinarySearch() {
    }

    public BinarySearch(int[] arr, int key) {
        this.arr = arr;
        this.key = key;

    }

    public static int binarySearch(int[] arr, int key) {
        int mid;
        int start = 0;
        int end = arr.length;
        while(start <= end){
            mid = (start+end) / 2;

            if (key == arr[mid]) {
                return mid;
            }else if (key < mid){
                end = mid - 1;
            } else if (key > mid) {
                start = mid + 1;
            }

        }
        return -1;
    }

}
