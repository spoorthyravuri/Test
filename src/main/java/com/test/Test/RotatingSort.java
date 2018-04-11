package com.test.Test;

public class RotatingSort {
	
	public static void check(int[] arr) {
		int segStartIndex = 0;
		int segEndIndex = 0;
		int i = 0;
		boolean isSegAvailable = true;
		while(arr[i] < arr[i+1]) {
			if(i >= arr.length - 1) {
				isSegAvailable = false;
			} else {
				i++;
			}
		}
		segStartIndex = i;
		while(i < arr.length - 1 && arr[i] >= arr[i+1]) {
			i++;
		}
		segEndIndex = i;
		if(isSegAvailable) {
			boolean isStartingMatching = false;
			boolean isEndingMatching  = false;
			if(segStartIndex == 0) {
				isStartingMatching = true;
			} else if(segEndIndex == arr.length - 1) {
				isStartingMatching = true;
			} else if(arr[segEndIndex] <= arr[segStartIndex - 1]) {
				isStartingMatching = true;
			}
			
			if(segEndIndex == arr.length - 1) {
				isEndingMatching = true;
			} else if(segEndIndex == 0) {
				isEndingMatching = true;
			} else if(arr[segStartIndex] <= arr[segEndIndex + 1]) {
				isEndingMatching = true;
			}
			
			if(isStartingMatching && isEndingMatching) {
//				if(!checkIfSorted(arr, segEndIndex + 1, arr.length)) {
//					System.out.println("no");
//				} else {
					System.out.println("yes");
					System.out.println((segStartIndex + 1) + " " + (segEndIndex + 1));
//				}
				
			} else {
				System.out.println("no");
			}
		}
	}
	
	public static boolean checkIfSorted(int[] arr, int startInd, int endInd) {
		while(endInd - 1 > startInd) {
			if(arr[startInd] > arr[startInd + 1]) {
				return false;
			}
			startInd++;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 2, 1};
		check(arr);
	}
}
