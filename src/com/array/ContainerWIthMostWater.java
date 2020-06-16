package com.array;

public class ContainerWIthMostWater {

	/*11 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。]
	 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，
	 * 使得它们与 x 轴共同构成的容器可以容纳最多的水。说明：你不能倾斜容器，且 n 的值至少为 2。*/
	
	public static void main(String[] args) {
		int[] h= {1,8,6,2,5,4,8,3,7};
		int n=maxArea(h);
		System.out.println(n);
	}
	public static int maxArea(int[] height) {
		int start=0;
		int end=height.length-1;
		int x=end -start;
		int y=Math.min(height[start], height[end]);
		int max=x*y;
		while(start!=end) {
			if(height[start]<=height[end])
				start++;
			else
				end--;
			x=end -start;
			y=Math.min(height[start], height[end]);
			int temp=x*y;
			if(temp>max) {
				max=temp;
			}
		}
		return max;
    }

}
