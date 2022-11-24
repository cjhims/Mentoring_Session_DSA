package com.greatlearning.sorting;

public class BinarySearch {

	public int binarySearch(int arr[], int k) {
		int size = arr.length;

		int pivot = findPivot(arr, 0, size - 1);

		if (pivot == -1)// no rotation
			return binarySearchImpl(arr, 0, size - 1, k);
		else if (arr[pivot] == k)
			return pivot;
		else if (arr[0] < k)
			return binarySearchImpl(arr, 0, pivot - 1, k);
		else
			return binarySearchImpl(arr, pivot + 1, size - 1, k);
	}

	public int binarySearchImpl(int arr[], int start, int end, int k) {
		if (end < start)
			return -1;

		int mid = (start + end) / 2;

		if (arr[mid] == k)
			return mid;
		else if (arr[mid] > k)
			return binarySearchImpl(arr, start, mid - 1, k);
		else
			return binarySearchImpl(arr, mid + 1, end, k);
	}

	public int findPivot(int arr[], int start, int end) {
		if (end < start)
			return -1;
		else if (end == start)
			return start;
		int mid = (start + end) / 2;
		if (mid < end && arr[mid] > arr[mid + 1]) {
			return mid;
		} else if (mid > start && arr[mid] < arr[mid - 1]) {
			return (mid - 1);
		} else if (arr[start] >= arr[mid]) {
			return findPivot(arr, start, mid - 1);
		} else {
			return findPivot(arr, mid + 1, end);
		}

	}

}