import IO.*;
public class MergeSort {

    public static void mergeSort(int[]v) {
        if (v == null || v.length <= 1)
            return;
        mergeSort(v, 0, v.length-1);
    }
    private static void mergeSort(int[]v, int low, int high) {
        if (high <= low)
            return;
        
        int mid = (high + low)/2;
        mergeSort(v, mid+1, high);
        mergeSort(v, low, mid);
        merge(v, low, mid, high);
    }
    private static void merge(int[]v, int low, int mid, int high) {
        int[] leftArray = new int[mid-low+1];
        int[] rightArray = new int[high-mid];

        for (int i=0; i<leftArray.length; i++)
            leftArray[i] = v[low+i];
        for (int i=0; i<rightArray.length; i++)
            rightArray[i] = v[mid+1+i];

        int leftIndex = 0, rightIndex = 0;

        for (int i=low; i<=high; i++) {
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    v[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else {
                    v[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            else {
                if (leftIndex < leftArray.length) {
                    v[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else if (rightIndex < rightArray.length) {
                    v[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
        }
        return;
    }


    public static void main(String[] args) {
		int[] a = new int[5];
		a[0] = 6;
		a[1] = 9;
		a[2] = 4;
		a[3] = 5;
		a[4] = 2;

		MergeSort.mergeSort(a);
		for (int i=0; i<a.length; i++) {
			IO.println(a[i]);
		}
	}
}
