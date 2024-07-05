package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice {

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println("Main Started\n");
		System.out.println();
		sol.textCase(new int[] {1,3}, new int[] {2});
		sol.textCase(new int[] {1,2}, new int[] {3,4});
		System.out.println("Main Completed");
	}
}

class Solution {
	
	int testCase = 0;
	
	
	void textCase(int[] nums1, int[] nums2) {
		 System.out.println("Test-"+(testCase+1));
		 for(int i =0; i< nums1.length ; i++) {
			 System.out.print(nums1[i]+ ", ");
		 }
		 System.out.println();
		 for(int i =0; i< nums2.length ; i++) {
			 System.out.print(nums2[i] + ", ");
		 }
		 System.out.println("\n");
		 double result = findMedianSortedArrays(nums1, nums2);
		 System.out.println("Result=>" + result);
		 System.out.println();
		 testCase++;
	}
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	 int pt1 = 0, pt2 = 0;
    	 ArrayList<Integer> arr = new ArrayList<Integer>();
    	 while(pt2 < nums2.length && pt1 < nums1.length) {
    		  if(nums1[pt1] > nums2[pt2]) {
    			 arr.add(nums2[pt2]);
    			 pt2++;
    		 } else {
    			 arr.add(nums1[pt1]);
    			 pt1++;
    		 }
    	 }
    	 while(pt2 < nums2.length) {
    		 arr.add(nums2[pt2]);
			 pt2++;
    	 } while (pt1 < nums1.length) {
    		 arr.add(nums1[pt1]);
			 pt1++;
    	 }
    	 System.out.println("Arr->" + arr);
    	 if(arr.size() % 2 == 0) {
    		 int mid = arr.size()/2;
    		 return (arr.get(mid) + arr.get(mid-1))/2.0;
    	 } else {
    		 int mid = arr.size()/2;
    		 return arr.get(mid);
    	 }
    }
}
