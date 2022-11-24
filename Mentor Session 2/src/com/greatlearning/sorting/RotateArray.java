package com.greatlearning.sorting;

public class RotateArray {

	public void leftRotate(int[] arr, int pos, int size) {
		for (int i = 0; i < pos; i++) {
			int temp = arr[0];
			for (int j = 0; j < size - 1; j++) {
				arr[j] = arr[j + 1];
			}
			arr[size - 1] = temp;
		}
	}

}