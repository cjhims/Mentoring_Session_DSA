package com.greatlearning.sorting;

import java.util.Scanner;

import com.greatlearning.sorting.BinarySearch;
import com.greatlearning.sorting.MergeSort;
import com.greatlearning.sorting.RotateArray;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array:");
		int size = sc.nextInt();
		System.out.println("Enter " + size + " elements:");
		int arr[] = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}

		MergeSort ms = new MergeSort();
		ms.sortArray(arr, 0, size - 1);
		System.out.println("Sorted Array: ");
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
		RotateArray ra = new RotateArray();
		ra.leftRotate(arr, size / 2, size);
		System.out.println("Rotated Array: ");
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + ", ");
		}

		BinarySearch bs = new BinarySearch();
		System.out.println("Please enter the element whose position you want to find:");
		int k = sc.nextInt();
		int pos = bs.binarySearch(arr, k);
		if (pos != -1)
			System.out.println(k + " was found at " + pos);
		else
			System.out.println(k + " was not found in the array");
		sc.close();

	}

}