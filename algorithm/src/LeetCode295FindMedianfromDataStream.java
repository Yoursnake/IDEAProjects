/*
Median is the middle value in an ordered integer list. If the size of the 
list is even, there is no middle value. So the median is the mean of the 
two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
 

Follow up:

If all integer numbers from the stream are between 0 and 100, how would you optimize it?
If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
*/

import java.util.PriorityQueue;

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

// addNum O(1) findMedian O(nlogn) 5% 538ms
// public class LeetCode295FindMedianfromDataStream {
//     List<Integer> list;

//     /** initialize your data structure here. */
//     public LeetCode295FindMedianfromDataStream() {
//         this.list = new ArrayList<>();;
//     }
    
//     public void addNum(int num) {
//         this.list.add(num);
//     }
    
//     public double findMedian() {
//         Collections.sort(list);
        
//         int mid = this.list.size() / 2;
//         if (this.list.size() % 2 == 1) {
//             return this.list.get(mid);
//         } else {
//             return (this.list.get(mid - 1) + this.list.get(mid)) / 2.0;
//         }
//     }
// }

// // 插入排序 addNum O(logn + n) findMedian O(1) 36.63% 119ms
// public class LeetCode295FindMedianfromDataStream {

// 	private List<Integer> list;

//     /** initialize your data structure here. */
//     public LeetCode295FindMedianfromDataStream() {
//         list = new ArrayList<>();
//     }
    
//     public void addNum(int num) {
// 		int left = 0;
// 		int right = list.size();

// 		while (left < right) {
// 			int mid = (right - left) / 2 + left;
// 			if (list.get(mid) < num) left = mid + 1;
// 			else right = mid;
// 		}

// 		list.add(left, num);
//     }
    
//     public double findMedian() {
//     	int size = list.size();
//     	int mid = size / 2;

// 		if (size % 2 == 1) return list.get(mid);
// 		else return (list.get(mid - 1) + list.get(mid)) * 1.0 / 2;
//     }
// }


 // Heap: addNum O(logn) findMedian O(1) 83.15% 108ms
 public class LeetCode295FindMedianfromDataStream {

 	/*
 	两个Heap，maxHeap 装所有数的前面一半，minHeap 装所有数的后面一半
 	每次都 maxHeap 装一个，minHeap 装一个
 	如果 maxHeap 装 num 的时候比 minHeap 最小值大，则把 minHeap 最小值装进 maxHeap，然后把 num 装进 minHeap
 	如果 minHeap 装 num 的时候比 maxHeap 最大值小，则把 maxHeap 最大值装进 minHeap，然后把 num 装进 maxHeap
 	这样保证了 maxHeap 一定装前一半，minHeap 一定装后一半
 	*/
 	private PriorityQueue<Integer> maxHeap;
 	private PriorityQueue<Integer> minHeap;
 	private int size;

     /** initialize your data structure here. */
     public LeetCode295FindMedianfromDataStream() {
 	    maxHeap = new PriorityQueue<>((a, b) -> (b - a));
 	    minHeap = new PriorityQueue<>((a, b) -> (a - b));
 	    size = 0;
     }
    
     public void addNum(int num) {
     	// maxHeap 或 minHeap 大小为 0 的情况
     	if (maxHeap.size() == 0) {
 		    maxHeap.add(num);
 		    size++;
 		    return;
 	    } else if (minHeap.size() == 0) {
     		if (num < maxHeap.peek()) {
 			    minHeap.offer(maxHeap.poll());
 			    maxHeap.offer(num);
 		    } else {
 			    minHeap.add(num);
 		    }
 		    size++;
 		    return;
 	    }

     	if (maxHeap.size() <= minHeap.size()) {
     		if (num > minHeap.peek()) {
     			maxHeap.offer(minHeap.poll());
     			minHeap.offer(num);
 		    } else {
     			maxHeap.offer(num);
 		    }
 	    } else {
     		if (num < maxHeap.peek()) {
     			minHeap.offer(maxHeap.poll());
     			maxHeap.offer(num);
 		    } else {
 			    minHeap.offer(num);
 		    }
 	    }

     	size++;
     }
    
     public double findMedian() {
 		if (size % 2 == 1) return maxHeap.peek();
 		else return (maxHeap.peek() + minHeap.peek()) * 1.0 / 2;
     }
 }
