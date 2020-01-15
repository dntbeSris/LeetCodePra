package com.leetcode.practice;

import java.util.HashMap;
import java.util.Map;


/**
 *给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {

    /*
    * 另一种思路，先排序，然后用头尾指针判断和目标值的大小进行移动。坏处就是排序算法的不稳定，好处就是节省map的临时存储空间。
    *
    */
    public int[] twoSum(int[] nums, int target) {

        if(nums == null || nums.length <= 0){
            return null;
        }

        int[] result = new int[2];

        Map<Integer,Integer> map = new HashMap<>(16);

        for(int i=0;i<nums.length;i++){

            if(map.containsKey(nums[i])){
                result[0] = i;
                result[i] = map.get(nums[i]);
            }

            map.put(target-nums[i],i);

        }


        return result;
    }



}
