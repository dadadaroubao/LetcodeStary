package com.setANDmap;

import java.util.HashMap;
import java.util.Map;


public class NUmberOfBoomerangs {
	
	public static void main(String[] args) {
		int[][] a= {{0,0},{1,0},{2,0}};
		System.out.println(numberOfBoomerangs(a));
	}
	
	public static int numberOfBoomerangs(int[][] points) {
		int res=0;
		for(int i=0;i<points.length;i++) {
			Map<Integer,Integer> map=new HashMap<Integer, Integer>();//存不同的点到i的距离和出现的频次
			for(int j=0;j<points.length;j++) {
				if(j!=i) {
					// 计算距离时不进行开根运算, 以保证精度（反正距离相等）
                    int dis = dis(points[i], points[j] );
                    map.put(dis, map.getOrDefault(dis, 0) + 1);
				}
			}
			// 排列组合，例如：三个数选两个并且可以改变顺序，也就是A32 = 3 * 2
            for (int dis : map.keySet() ) {
                res += (map.get(dis) ) * (map.get(dis) - 1);
            }
		}
		return res;
	}

	private static int dis(int[] is, int[] is2) {
		
		return (is[0]-is2[0])*(is[0]-is2[0])+(is[1]-is2[1])*(is[1]-is2[1]);
	}

}
/*给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。

找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。

示例:

输入:
[[0,0],[1,0],[2,0]]

输出:
2

解释:
两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
*/
