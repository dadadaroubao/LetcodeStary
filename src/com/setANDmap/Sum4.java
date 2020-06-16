package com.setANDmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4 {

	public static void main(String[] args) {
		int[] a= {-1,0,1,2,-1,-4};
		List<List<Integer>> list=fourSum(a,-1);
		System.out.println(list.toString());
		
	}

	public static List<List<Integer>> fourSum(int[] nums,int target) {
		 List<List<Integer>> ans = new ArrayList<List<Integer>>();
	     int len = nums.length;
	     if(nums == null || len < 4) return ans;
	     Arrays.sort(nums); // 排序
	     for(int i=0;i<len-3;i++) {//
	    	 if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
	    	 int min=nums[i]+nums[i+1]+nums[i+2]+nums[i+3];
	    	 if(min>target)
	    		 continue;
	    	 int max=nums[i]+nums[len-1]+nums[len-2]+nums[len-3];
	    	 if(max<target)
	    		 continue;
	    	 //第二层循环j，初始值指向i+1
	    	 for(int j=i+1;j<len-2;j++) {
	    		 if(j>i+1&&nums[j]==nums[j-1]){
	                    continue;
	              }
	    		    //定义指针k指向j+1
	                int k=j+1;
	                //定义指针h指向数组末尾
	                int h=len-1;
	                //获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏，忽略
	                int min2=nums[k]+nums[i]+nums[j]+nums[k+1];
	                if(min2>target){
	                    continue;
	                }
	                //获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略
	                int max2=nums[j]+nums[i]+nums[h]+nums[h-1];
	                if(max2<target){
	                    continue;
	                }
	                //开始k指针和h指针的表演，计算当前和，如果等于目标值，k++并去重，h--并去重，当当前和大于目标值时h--，当当前和小于目标值时k++
	                while(k<h) {
	                	int sum=nums[k]+nums[i]+nums[j]+nums[h];
	                	if(sum==target) {
	                		ans.add(Arrays.asList(nums[i],nums[j],nums[k],nums[h]));
	                		while (k<h && nums[k] == nums[k+1]) k++; // 去重
	                        while (k<h && nums[h] == nums[h-1]) h--; // 去重
	                        k++;
	                        h--;
	                	}else if(sum>target) h--;
	                	 else if(sum<target) k++; 
	                }

	    	 }
	    	
	     }   
		return ans;
	}
}
/*给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
注意：
答案中不可以包含重复的四元组。
示例：
给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
*/
