/*
Given a data stream input of non-negative integers a1, a2, ..., an,
 ..., summarize the numbers seen so far as a list of disjoint intervals.

For example, suppose the integers from the data stream are 
1, 3, 7, 2, 6, ..., then the summary will be:

[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]
 
Follow up:

What if there are lots of merges and the number of disjoint 
intervals are small compared to the data stream's size?
*/

import java.util.*;

// // 74ms 94%
// public class LeetCode352DataStreamasDisjointIntervals {
// 	List<int[]> list;

// 	/** Initialize your data structure here. */
//     public LeetCode352DataStreamasDisjointIntervals() {
//         list = new ArrayList<>();
//     }
    
//     // O(n) 
//     public void addNum(int val) {
//     	if (list.size() == 0) list.add(new int[] {val, val});

//         int i = 0;
//         // 找第一个比 val 大的区间（如果没有，则 i == list.size()）
//         while (i < list.size()) {
//         	if (val < list.get(i)[0]) break;
//         	i++;
//         }

//         if (i == list.size()) {
//         	// 如果没有找到，判断是否能将 val 结合到已有区间
//         	if (list.get(list.size() - 1)[1] == val - 1) {
//         		list.get(list.size() - 1)[1] = val;
//         	} else if (list.get(list.size() - 1)[1] < val - 1) {
//         		list.add(new int[] {val, val});
//         	}
//         } else if (i == 0) {
//         	// 如果是 i == 0，判断是否能将 val 结合到已有区间
//         	if (val + 1 == list.get(0)[0]) {
//         		list.get(0)[0] = val;
//         	} else if (val + 1 < list.get(0)[0]) {
//         		list.add(0, new int[] {val, val});
//         	}
//         } else {
//         	// 如果 i - 1 和 i 均有区间
//         	if (val - 1 == list.get(i - 1)[1] && val + 1 == list.get(i)[0]) {
//         		list.get(i)[0] = list.get(i - 1)[0];
//         		list.remove(i - 1);
//         	} else if (val - 1 == list.get(i - 1)[1]) {
//         		list.get(i - 1)[1] = val;
//         	} else if (val + 1 == list.get(i)[0]) {
//         		list.get(i)[0] = val;
//         	} else if (list.get(i - 1)[1] < val - 1 && val + 1 < list.get(i)[0]) {
//         		list.add(i, new int[] {val, val});
//         	}
//         }
//     }
    
//     public int[][] getIntervals() {
//         int[][] res = new int[list.size()][2];
//         for (int i = 0; i < list.size(); i++) {
//         	res[i][0] = list.get(i)[0];
//         	res[i][1] = list.get(i)[1];
//         }

//         return res;
//     }
// }

// TreeMap: 75ms 93%
public class LeetCode352DataStreamasDisjointIntervals {
	// TreeMap 的 key 表示一个区间的起始值，value 表示区间
	TreeMap<Integer, int[]> tree;

	/** Initialize your data structure here. */
    public LeetCode352DataStreamasDisjointIntervals() {
        tree = new TreeMap<>();
    }
    
    // O(logn)
    public void addNum(int val) {
    	if (tree.containsKey(val)) return;

    	Ineger l = tree.lowerKey(val);
    	Ineger h = tree.higherKey(val);

    	if (l != null && h != null && tree.get(l)[1] == val - 1 && val + 1 == tree.get(h)[0]) {
    		tree.get(l)[1] = tree.get(h)[1];
    		tree.remove(h);
    	} else if (h != null && val + 1 == tree.get(h)[0]) {
    		tree.put(val, new int[] {val, tree.get(h)[1]});
    		tree.remove(h);
    	} else if (l != null && val - 1 <= tree.get(l)[1]) {
    		tree.get(l)[1] = Math.max(val, tree.get(l)[1]);	// 由于 l 是区间起始值，所以无法判断 val 一定比 tree.get(l)[1] 大
    	} else {
    		tree.put(val, new int[] {val, val});
    	}
    }
    
    public int[][] getIntervals() {
    	int[][] res = new int[tree.size()][];
    	int i = 0;
        for (int[] interval : tree.values()) {
        	res[i++] = interval;
        }

        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */