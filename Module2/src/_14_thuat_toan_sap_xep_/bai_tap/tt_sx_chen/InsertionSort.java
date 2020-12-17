package _14_thuat_toan_sap_xep_.bai_tap.tt_sx_chen;

public class InsertionSort {
    public static void insertionSort(double[] arr){
        for (int i=1; i<arr.length; i++){
            double currentElement = arr[i];
            int j;
            for (j=i-1; j>=0 && arr[j] > currentElement; j--){
                    arr[j+1]=arr[j];
            }
            arr[j+1]=currentElement;
        }
    }

    public static void main(String[] args) {
        double[] arr = {1, 9, 3.2, 6.6, 5.7, -4.5};
        insertionSort(arr);
        for (int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
