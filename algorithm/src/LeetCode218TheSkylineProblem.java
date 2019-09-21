/*
A city's skyline is the outer contour of the silhouette formed 
by all the buildings in that city when viewed from a distance. 
Now suppose you are given the locations and height of all the 
buildings as shown on a cityscape photo (Figure A), write a 
program to output the skyline formed by these buildings 
collectively (Figure B).

Buildings Skyline Contour
The geometric information of each building is represented by 
a triplet of integers [Li, Ri, Hi], where Li and Ri are the x 
coordinates of the left and right edge of the ith building, 
respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, 
Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume 
all buildings are perfect rectangles grounded on an absolutely 
flat surface at height 0.

For instance, the dimensions of all buildings in Figure A are 
recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

The output is a list of "key points" (red dots in Figure B) in 
the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely 
defines a skyline. A key point is the left endpoint of a horizontal 
line segment. Note that the last key point, where the rightmost 
building ends, is merely used to mark the termination of the skyline, 
and always has zero height. Also, the ground in between any two adjacent 
buildings should be considered part of the skyline contour.

For instance, the skyline in Figure B should be represented 
as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

Notes:

The number of buildings in any input list is guaranteed to be in the range [0, 10000].

The input list is already sorted in ascending order by the left x position Li.

The output list must be sorted by the x position.

There must be no consecutive horizontal lines of equal height in the output skyline. 
For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; 
the three lines of height 5 should be merged into one in the final output as 
such: [...[2 3], [4 5], [12 7], ...]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode218TheSkylineProblem {
    // sweep line + heap : 93.50%
	public List<List<Integer>> getSkyline(int[][] buildings) {
		List<BuildingLine> buildingLines = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		MaxHeap heap = new MaxHeap(buildings.length);

		for (int i = 0; i < buildings.length; i++) {
			int[] building = buildings[i];
			buildingLines.add(new BuildingLine(i, 1, building[0], building[2]));
			buildingLines.add(new BuildingLine(i, -1, building[1], building[2]));
		}

		Collections.sort(buildingLines);

		for (BuildingLine line : buildingLines) {
			if (line.type == 1) {
				if (line.h > heap.findMaxHeight()) {
					List<Integer> tmpList = new ArrayList<>(Arrays.asList(line.x, line.h));
					res.add(tmpList);
				}
				heap.add(line.h, line.id);
			} else {
				int h = line.h;
				heap.remove(line.id);
				if (h > heap.findMaxHeight()) {
					List<Integer> tmpList = new ArrayList<>(Arrays.asList(line.x, heap.findMaxHeight()));
					res.add(tmpList);
				}
			}
		}

		return res;
	}

	private class BuildingLine implements Comparable<BuildingLine> {
		int id;
		int type;
		int x;
		int h;

		public BuildingLine(int id, int type, int x, int h) {
			this.id = id;
			this.type = type;
			this.x = x;
			this.h = h;
		}

		public int compareTo(BuildingLine l) {
			if (this.x == l.x) return (l.type * l.h - this.type * this.h);

			return this.x - l.x;
		}		
    }

    private class MaxHeap {
    	private List<int[]> data;
    	private int[] idx;		// 表示 BuildingLine 对象 id 为 i 的数据所在 data 中的索引，主要用于 remove

    	public MaxHeap(int capacity) {
    		this.data = new ArrayList<>();
    		this.idx = new int[capacity];
    	}

    	private int parent(int k) {
    		return (k - 1) / 2;
    	}

    	private int leftChild(int k) {
    		return k * 2 + 1;
    	}

    	private int rightChild(int k) {
    		return k * 2 + 2;
    	}

    	private void swap(int i, int j) {
    		// idx 交换
    		int tmpIdx = this.idx[this.data.get(i)[1]];
    		this.idx[this.data.get(i)[1]] = this.idx[this.data.get(j)[1]];
    		this.idx[this.data.get(j)[1]] = tmpIdx;

    		// 堆中的数据交换
    		int[] tmpData = this.data.get(i);
    		this.data.set(i, this.data.get(j));
    		this.data.set(j, tmpData);
    	}

    	private void siftUp(int k) {
    		while (k > 0) {
    			int p = this.parent(k);

    			if (this.data.get(p)[0] > this.data.get(k)[0]) break;

    			this.swap(p, k);
    			k = p;
    		}
    	}

    	private void siftDown(int k) {
    		while (this.leftChild(k) < this.data.size()) {
    			int j = this.leftChild(k);

    			if (j + 1 < this.data.size() &&
    				this.data.get(j)[0] < this.data.get(j + 1)[0])
    				j++;

    			if (this.data.get(j)[0] < this.data.get(k)[0]) break;

    			this.swap(j, k);
    			k = j;
    		}
    	}

    	public void add(int h, int id) {
    		int size = this.data.size();

    		this.idx[id] = size;
    		this.data.add(new int[] {h, id});
    		siftUp(this.idx[id]);
    	}

    	public int findMaxHeight() {
    		if (data.isEmpty()) return 0;
    		else return data.get(0)[0];
    	}

    	public void remove(int id) {
    		int tmpIdx = this.idx[id];
    		int size = this.data.size();

    		this.swap(tmpIdx, size - 1);
    		this.data.remove(size - 1);
    		if (tmpIdx < this.data.size()) {
                this.siftUp(tmpIdx);
                this.siftDown(tmpIdx);
            }
    	}
    }
}