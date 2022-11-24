package com.greatlearning.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LeastCommonAncestor {

	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	public static void main(String[] args) {
		//initializing the input
		TreeNode tree = new TreeNode(10);
		tree.left = new TreeNode(20);
		tree.right = new TreeNode(30);
		tree.left.left = new TreeNode(40);
		tree.left.right = new TreeNode(50);
		tree.right.left = new TreeNode(60);
		tree.right.right = new TreeNode(70);
		
		int n1 = 40;
		int n2 = 70;
		
		//process
		int result = getLCA(tree,n1,n2);
		
		System.out.println("Least common ancestor of "+n1+" & "+n2+" is: "+result);
		
	}

	private static int getLCA(TreeNode tree, int n1, int n2) {
		List<Integer> path1 = new ArrayList<Integer>();
		List<Integer> path2= new ArrayList<Integer>();
		
		boolean isN1present = findpath(tree,n1,path1);
		boolean isN2present = findpath(tree,n2,path2);
		
		if(!isN1present&&!isN2present) {
			System.out.println("Both the given nodes are not present!");
			return -1;}
	    else if(!isN1present) {
			System.out.println("Given node value "+n1+" not present!");
			return -1;}
		else if(!isN2present) {
			System.out.println("Given node value "+n2+" not present!");
			return -1;}
		else {
			int i =0;
			for(;i<path1.size()&&i<path2.size();i++) {
				if(path1.get(i)!=path2.get(i)) {
					break;
				}
			}return path1.get(i-1);
		}
		
	}

	private static boolean findpath(TreeNode tree, int n1, List<Integer> path1) {
		if(tree==null)
		return false;
		
			path1.add(tree.data);
			if(tree.data==n1) {
				return true;
			}
			if(tree.left!=null&&findpath(tree.left,n1,path1)) {
				return true;
			}
			if(tree.right!=null&&findpath(tree.right,n1,path1)) {
				return true;
			}
			
			//if n1 is not present in both left and right subtree
			path1.remove(path1.size()-1);
			
			return false;
	}

}
