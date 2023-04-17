package sortAlgorithms;

public class Sorts_Driver {
	public static void main(String[] args) {

		Integer[] foo = { 1, 2, 3, 4, 0 };

		printList(foo);
		System.out.println();

		sortC(foo);

		printList(foo);
		System.out.println();

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