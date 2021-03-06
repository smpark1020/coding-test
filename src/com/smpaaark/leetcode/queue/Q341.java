package com.smpaaark.leetcode.queue;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Q341 {

    class NestedIterator implements Iterator<Integer> {

        Stack<NestedInteger> stack = new Stack<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            flattenNestedList(nestedList);
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                return null;
            }

            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty() && !stack.peek().isInteger()) {
                NestedInteger nestedInteger = stack.pop();
                flattenNestedList(nestedInteger.getList());
            }

            return !stack.isEmpty();
        }

        private void flattenNestedList(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }

    }

    interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();

    }

}
