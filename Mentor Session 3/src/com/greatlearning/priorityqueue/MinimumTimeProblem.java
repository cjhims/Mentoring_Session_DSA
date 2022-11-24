package com.greatlearning.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumTimeProblem {
	//priority queue
	//helps us to find out max pending orders
	//as naturally the priority queue takes in the min value first 
	// but we are using collections.reverseorder to reverse the ordering and consider the max value first
	private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());

	//get the input

	public void getInput() {
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter the totaol number of mango milkshakes: ");
		queue.add(sc.nextInt());
		System.out.println("Enter the totaol number of orange milkshakes: ");
		queue.add(sc.nextInt());
		System.out.println("Enter the totaol number of pineapple milkshakes: ");
		queue.add(sc.nextInt());
		sc.close();
	}
	
	//print the result
	public static void main(String[] args) {
		//creating object instance
		MinimumTimeProblem min = new MinimumTimeProblem();
		//read the input
		min.getInput();
		//process algorithm
		int result = min.getMinimumSeconds();
		//print data
		System.out.println("Minimum seconds required: "+result);

	}

	private int getMinimumSeconds() {
		int minSeconds = 0;
		while(!queue.isEmpty()) {
			int val1 =queue.peek() == null?1:queue.poll();
			int val2 =queue.peek() == null?1:queue.poll();
			if(val1==0&&val2>0) {
				minSeconds=minSeconds+val1;
				break;
			}
			if(val2==0&&val1>0) {
				minSeconds=minSeconds+val1;
				break;
		}
			if(val1>0&&val2>0) {
				val1--;
				val2--;
				minSeconds++;
			}
			if(val1>0) {
				queue.add(val1);
			}
			if(val2>0) {
				queue.add(val2);
			}
		
	}
		return minSeconds;
}
}
