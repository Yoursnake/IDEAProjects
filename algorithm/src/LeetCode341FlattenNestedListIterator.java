/*
Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,1,2,1,1].

Example 2:

Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,4,6].
*/

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

//// 4ms 51%
//public class LeetCode341FlattenNestedListIterator implements Iterator<Integer> {
//
//	private int index;
//	private int size;
//	private LeetCode341FlattenNestedListIterator currIterator;
//	private List<NestedInteger> nestedList;
//	private static Stack<LeetCode341FlattenNestedListIterator> stack = new Stack<>();
//
//	public LeetCode341FlattenNestedListIterator(List<NestedInteger> nestedList) {
//        index = 0;
//        this.nestedList = nestedList;
//        currIterator = this;
//
//        // 删除所有没有元素的 NestedInteger
//		for (NestedInteger n : new ArrayList<>(nestedList)) {
//			if (isEmpty(n)) nestedList.remove(n);
//		}
//
//		size = nestedList.size();
//	}
//
//	// 判断一个 NestedInteger 对象中是否没有元素
//	private boolean isEmpty(NestedInteger n) {
//		if (n.isInteger()) {
//			return false;
//		} else {
//			if (n.getList().size() == 0) {
//				return true;
//			} else {
//				boolean flag = true;
//				for (NestedInteger tmp : n.getList()) {
//					flag = flag & isEmpty(tmp);
//				}
//				return flag;
//			}
//		}
//	}
//
//    // O(n)
//    @Override
//    public Integer next() {
//        NestedInteger curr = currIterator.nestedList.get(currIterator.index);
//
//        if (curr.isInteger()) {
//        	int tmp = curr.getInteger();
//	        currIterator.index++;   // 每拿到一个数，当前的迭代器 index++
//
//        	while (!stack.isEmpty() && !currIterator.hasNext()) {
//        		currIterator = stack.pop();
//        		currIterator.index++;   // 当退出一个迭代器后，新的迭代器已经走过一个 list，所以 index++
//        	}
//        	return tmp;
//        } else {
//        	stack.push(currIterator);
//        	currIterator = new LeetCode341FlattenNestedListIterator(curr.getList());
//        	return this.next();
//        }
//    }
//
//    // O(1)
//    @Override
//    public boolean hasNext() {
//        return index < size;
//    }
//}

// 4ms 51% 官方解法
public class LeetCode341FlattenNestedListIterator implements Iterator<Integer> {

	private static Stack<NestedInteger> stack = new Stack<>();

	public LeetCode341FlattenNestedListIterator(List<NestedInteger> nestedList) {
		for (int i = nestedList.size() - 1; i >= 0; i--) {
			stack.push(nestedList.get(i));
		}
	}

	// O(1)
	@Override
	public Integer next() {
		return stack.pop().getInteger();
	}

	// O(n)
	@Override
	public boolean hasNext() {
		while (!stack.isEmpty()) {
			NestedInteger n = stack.peek();
			if (n.isInteger()) {
				return true;
			}

			stack.pop();
			for (int i = n.getList().size() - 1; i >= 0; i--) {
				stack.push(n.getList().get(i));
			}
		}

		return false;
	}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */