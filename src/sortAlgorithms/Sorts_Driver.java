package sortAlgorithms;

public class Sorts_Driver {
	public static void main(String[] args) {

		String[] foo = { "a", "i", "e", "o", "y", "u" };

		printList(foo);
		System.out.println();

		sort(foo);

		printList(foo);
		System.out.println();

		/*
		 * int loc = binSearch(foo, 101); if(loc == -1)System.out.println(101 +
		 * " not found."); else System.out.println(101 + " found at index " + loc);
		 */

	}

	public static <T extends Comparable<T>> int binSearch(T[] arr, T key) {
		int start = 0, last = arr.length;
		int mid = (start + last) / 2;
		while ((start < last) && !arr[mid].equals(key)) {
			if (arr[mid].compareTo(key) < 0) {
				start = mid + 1;
			} else {
				last = mid;
			}
			mid = (start + last) / 2;
		}
		if (arr[mid].equals(key))
			return mid;
		else
			return -1;
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

	public static void sort(String[] a) {
		if (a.length <= 1) {
			return;
		}
		String[] first = new String[a.length / 2];
		String[] second = new String[a.length - first.length];
		// Copy the first half of a into first, the second half into second
		for (int i = 0; i < first.length; i++) {
			first[i] = a[i];
		}
		for (int i = 0; i < second.length; i++) {
			second[i] = a[first.length + i];
		}
		sort(first);
		sort(second);
		merge(first, second, a);
	}

	private static void merge(String[] arr1, String[] arr2, String[] result) {
		// Merge both halves into a sorted array
		int i = 0, j = 0, k = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i].compareTo(arr2[j]) < 0) {
				// arr[i] is smaller
				result[k++] = arr1[i++];
			} else {
				result[k++] = arr2[j++];
			}
		}
		// see if there are any elements left between start and middle
		while (i != arr1.length) {
			result[k++] = arr1[i++];
		}
		while (j != arr2.length) {
			result[k++] = arr2[j++];
		}

	}

	public static <T extends Comparable<T>> void sortB(T[] arr) {
		int lastSorted = arr.length;
		for (int i = 0; i < lastSorted; i++) {
			// find the max
			int maxIndex = findMax(arr, 0, lastSorted);
			// swap with last sorted
			lastSorted--;
			T temp = arr[lastSorted];
			arr[lastSorted] = arr[maxIndex];
			arr[maxIndex] = temp;
		}
	}

	private static <T extends Comparable<T>> int findMax(T[] arr, int first, int last) {
		// find the max value between index first (inclusive) and index last(exclusive)
		int maxIndex = first;
		for (int i = first + 1; i < last; i++) {
			if (arr[maxIndex].compareTo(arr[i]) < 0)
				maxIndex = i;
		}
		return maxIndex;
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