import IO.*;

public class QuickSort {
    
    public static void quickSort(int[]v) {
        if (v == null || v.length <= 1)
            return;
        quickSort(v, 0, v.length-1);
    }
    private static void quickSort(int[]v, int low, int high) {
        int index = partition(v, low, high);

        if (index-1 > low)
            partition(v, low, index-1);
        if (index < high)
            partition(v, index, high);
    }
    public static int partition (int[]v, int left, int right) {
        int i = left, j = right, tmp, pivot = v[(left+right)/2];

        while (i <= j) {
            while (pivot > v[i])
                i++;
            while (pivot < v[j])
                j--;
            if (i <= j) {
                tmp = v[i];
                v[i] = v[j];
                v[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] a = new int[5];
		a[0] = 6;
		a[1] = 9;
		a[2] = 4;
		a[3] = 5;
		a[4] = 2;

		QuickSort.quickSort(a);
		for (int i=0; i<a.length; i++) {
			IO.println(a[i]);
		}
    }
}
