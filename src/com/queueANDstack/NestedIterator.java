package com.queueANDstack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {

	private Stack<NestedInteger> stack;
	
    public NestedIterator(List<NestedInteger> nestedList) {
    	this.stack = new Stack<NestedInteger>();
        int len = nestedList.size();
        for(int i = len - 1; i >= 0; i--){
            this.stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {  	
		return stack.pop().getInteger();
        
    }

    @Override
    public boolean hasNext() {
    	while(!stack.isEmpty()) {
    		 NestedInteger pop = stack.peek();
    		 if(pop.isInteger()) {
    			 return true;
    		 }
    		 stack.pop();
    		 List<NestedInteger> tmp = pop.getList();
             for(int i = tmp.size() - 1; i >= 0; i--){
                 this.stack.push(tmp.get(i));
             }
    	}
		return false;
        
    }
}

interface NestedInteger {

	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a nested
	// list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}