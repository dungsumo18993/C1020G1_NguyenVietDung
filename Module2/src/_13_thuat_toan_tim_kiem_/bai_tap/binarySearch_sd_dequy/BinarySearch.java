package _13_thuat_toan_tim_kiem_.bai_tap.binarySearch_sd_dequy;

public class BinarySearch {
    public static int binarySearch(int arr[], int low, int high, int value){
        if (high>=low){
            int mid = (low+high)/2;
            if (arr[mid]==value){
                return mid;
            }
            if (arr[mid]>value){
                return binarySearch(arr,low,mid-1,value);
            } else {
                return binarySearch(arr,mid+1,high,value);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,6,7,9,11,21,27,35,42,55,68,73,81,93};
        System.out.println(binarySearch(arr,0,15,0));
        System.out.println(binarySearch(arr,0,15,27));

    }
}
