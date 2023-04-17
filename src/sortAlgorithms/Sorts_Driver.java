package sortAlgorithms;

public class Sorts_Driver {
	public static void main(String[] args) {

		Integer[] foo = { 33,22,55,77,6,99,0,101,32,9,-7,55 };

		printList(foo);
		System.out.println();

		sortC(foo);

		printList(foo);
		System.out.println();
		
		int loc = binSearch(foo, 101);
		if(loc == -1)System.out.println(101 + " not found.");
		else System.out.println(101 + " found at index " + loc);

	}
	
	public static <T extends Comparable<T>> int binSearch(T[] arr, T key) {
		int start = 0, last = arr.length;
		int mid = (start+last)/2;
		while((start < last) && !arr[mid].equals(key)) {
			if(arr[mid].compareTo(key)<0) {
				start = mid + 1;
			}
			else {
				last = mid;
			}
			mid = (start+last)/2;
		}
		if(arr[mid].equals(key))return mid;
		else return -1;
	}

	public static <T extends Comparable<T>> int seqSearch(T[] arr, T key) {
		for (int i = 0; i < arr.length; i++)
			if (key.equals(arr[i]))
				return i;
		return -1;
	}

	public static <T extends Comparable<T>> void sortC(T[] arr) {

		T temp = null;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < (arr.length - i); j++) {
				if (arr[j - 1].compareTo(arr[j]) > 0) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	public static <T extends Comparable<T>> void sortB(T[] arr) {

	}

	public static <T extends Comparable<T>> void sortA(T[] arr) {
		// for each item in the list
		for (int i = 0; i < arr.length; i++) {
			T key = arr[i];
			int j = i - 1;
			// compare the key to each element in the unsorted part of the list
			while ((j > -1) && (arr[j].compareTo(key) > 0)) {

				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
			System.out.println("key = " + key + " index [" + (j + 1) + "]");
			printList(arr);
		}
	}

	public static <T> void printList(T[] arr) {
		for (T t : arr) {
			System.out.print(t + " ");
		}
		System.out.println();
	}
}