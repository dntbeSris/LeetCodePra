package com.leetcode.practice;


/**
 *给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class FindMedianSortedArrays {


    /**
     * O(n) 解法
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {


        int length = nums1.length + nums2.length;

        int[] combine = new int[length];

        int i = 0,j = 0,k = 0;

        while (i < nums1.length && j < nums2.length){
            int t1 = nums1[i];
            int t2 = nums2[j];
            if(t1 <= t2){
                combine[k++] = t1;
                i++;
            }else {
                combine[k++] = t2;
                j++;
            }
        }
        if(i < nums1.length){
            for(int l = i;l<nums1.length;l++){
                combine[k++] = nums1[l];
            }
        }
        if(j < nums2.length){
            for(int l = j;l<nums2.length;l++){
                combine[k++] = nums2[l];
            }
        }

        if(length % 2 == 0){
            return (double) (combine[length/2] + combine[length/2 -1]) /2;
        }else {
            return combine[length/2];
        }

    }

    public static void main(String[] args) {
        new FindMedianSortedArrays().findMedianSortedArrays(new int[]{1,2},new int[]{3,4});
    }
}
