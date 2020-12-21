package _14_thuat_toan_sap_xep_.bai_tap.baitap_tt_sx_chen;

public class InsertionSort {
    public static void insertionSort(int[] arr){
        for (int i=1; i<arr.length; i++){
            int currentElement = arr[i];
            int j;
            for (j=i-1; j>=0 && arr[j] > currentElement; j--){
                arr[j+1]=arr[j];
            }
            arr[j+1]=currentElement;
        }
    }

    public static void main(String[] args) {
        int[] arr = {7,9,11,5,-21,3,18,-2,1};
        insertionSort(arr);
        for (int element : arr){
            System.out.print(element+"\t");
        }
    }
}
