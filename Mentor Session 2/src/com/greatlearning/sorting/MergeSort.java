package com.greatlearning.sorting;

public class MergeSort {

	public void sortArray(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;

			sortArray(arr, start, mid);
			sortArray(arr, mid + 1, end);

			merge(arr, start, mid, end);
		}
	}

	public void merge(int[] arr, int start, int mid, int end) {
		int size1 = mid - start + 1;
		int size2 = end - mid;

		int leftArray[] = new int[size1];
		int rightArray[] = new int[size2];

		for (int i = 0; i < size1; i++) {
			leftArray[i] = arr[start + i];
		}

		for (int i = 0; i < size2; i++) {
			rightArray[i] = arr[mid + 1 + i];
		}

		int i = 0, j = 0;

		int k = start;
		/*
		 * we continue the loop till both the arrays have elements the moment on array
		 * ends we come out of the loop
		 */
		while (i < size1 && j < size2) {
			if (leftArray[i] <= rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}

		while (i < size1) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < size2) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}

}