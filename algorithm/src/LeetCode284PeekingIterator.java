/*
Given an Iterator class interface with methods: next() and hasNext(), design 
and implement a PeekingIterator that support the peek() operation -- it essentially 
peek() at the element that will be returned by the next call to next().

Example:

Assume that the iterator is initialized to the beginning of the list: [1,2,3].

Call next() gets you 1, the first element in the list.
Now you call peek() and it returns 2, the next element. Calling next() after that still return 2. 
You call next() the final time and it returns 3, the last element. 
Calling hasNext() after that should return false.

Follow up: How would you extend your design to be generic and work with all types, not just integer?
*/

import java.util.*;


// 69.59% 46ms
public class LeetCode284PeekingIterator implements Iterator<Integer> {
	int peekNum;
	boolean usePeek;
	Iterator<Integer> iterator;

	public LeetCode284PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.peekNum = 0;
	    this.usePeek = false;
	    this.iterator = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (this.usePeek) {
			return this.peekNum;
		} else {
			this.peekNum = this.iterator.next();
	        this.usePeek = true;
			return this.peekNum;
		}
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (this.usePeek) {
	    	this.usePeek = false;
	    	return this.peekNum;
	    } else {
	    	return this.iterator.next();
	    }
	}

	@Override
	public boolean hasNext() {
	    if (this.usePeek) return true;
	    else return this.iterator.hasNext();
	}
}