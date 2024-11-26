package Lezione17;
import IO.*;
import java.util.*;
@SuppressWarnings("unused")
public class Sorting {
	//Merge Sort (n log n, al massimo n)
	public static void mergeSort(int[]v) {
		if (v==null || v.length <=1)
			return;

		mergeSort(v, 0, v.length-1);
	}
	/*Questo è un commento javadoc che si fa partire con "/**" e va a definire i parametri utilizzati nel metodo*
	/**
	 * Lavora ricorsivamente su una lista, che viene divisa a metà finchè non abbiamo array di un elemento.
	 Una volta ottenuto ciò, effettuiamo i confronti per ordinare l'array
	 * @param v il vettore da ordinare
	 * @param low L'estremo sinistro del range di v da ordinare
	 * @param high L'estremo destro del range di v da ordinare
	 */
	private static void mergeSort(int[] v, int low, int high)  {
		if (high <= low)
			return;

		int mid = (low + high)/2;
		mergeSort(v, low, mid);
		mergeSort(v, mid+1, high);
		merge(v, low, mid, high);
		return;
	}
	private static void merge(int[] v, int low, int mid, int high) {
		//Creiamo due sottoarray temporanei
		int[] leftArray = new int[mid-low+1];
		int[] rightArray = new int[high-mid];

		//Copio gli elementi negli array
		for (int i=0; i<leftArray.length; i++) {
			leftArray[i] = v[low+i];
		}
		for (int i=0; i<rightArray.length; i++) {
			rightArray[i] = v[mid+1+i];
		}
		
		//Creo gli iteratori per scadire leftArray e rightArray  
		int leftIndex = 0;
		int rightIndex = 0;

		//Eseguo il merge vero e proprio
		//Copio in modo ordinato lA e rA su v nel 
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
			else { //ho finito uno dei due array
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

	
	/**
	* Effettua la partizione di una porzione dell'array, spostando sulla sinistra gli elementi minori o uguali 
	* del valore pivot, e sulla destra gli elementi maggiori o uguali al valore del pivot.
	* Utilizza come pivot il valore in posizione mediana della porzione passata come input. 
	* @param arr L'array contenente il sottoarray da partizionare
	* @param left L'estremo sinistro del sottoarray 
	* @param right L'estremo destro del sottoarray 
	* @return La posizione assunta dal valore pivot a termine del partizionamento 
	*         (gli elementi a sinistra saranno tutti minori o uguali ad esso, 
	*         e gli elementi a destra saranno tutti maggiori o uguali ad esso)
	*/
	static int partition(int[] arr, int left, int right) //Non mettendo nè public ne private, il metodo sarà in 
	{         	// modalità di visibilità "default", facendo così sarà visibile solo all'interno del package
		int i = left, j = right, tmp;

		int pivot = arr[(left + right) / 2];

		while (i <= j) {
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
				}
		  	}
		return i;
	}

	/**
	* Implementa il metodo quick sort per ordinare in senso crescente un array di interi
	* @param v Il vettore da ordinare
	* @param low L'estremo sinistro del range di v da ordinare
	* @param high L'estremo destro del range di v da ordinare
	*/
	public static void quickSort(int[] v) 
	{
		quickSort(v, 0, v.length-1);
	}
	private static void quickSort(int[] v, int low, int high) 
	{
		int index = partition(v, low, high);

		if (low < index - 1)
			quickSort(v, low, index - 1);

		if (index < high)
			quickSort(v, index, high);
	}


	
	public static void main(String[] args) {
		int[] a = new int[5];
		a[0] = 6;
		a[1] = 9;
		a[2] = 4;
		a[3] = 5;
		a[4] = 2;

		Sorting.mergeSort(a);
		for (int i=0; i<a.length; i++) {
			IO.println(a[i]);
		}
	}
}
