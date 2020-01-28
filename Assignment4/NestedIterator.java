package Assignment4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* Q10
Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,1,2,1,1].

Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,4,6].
 */

public class NestedIterator implements Iterator<Integer> {

	private LinkedList<NestedInteger> list ;

	public NestedIterator(List<NestedInteger> nestedList) {
		list = new LinkedList<NestedInteger>();
		for(int i = 0; i < nestedList.size(); i++) {
			list.add(nestedList.get(i));
		}
	}

	private void breakDownList(List<NestedInteger> nestedList) {
		for(int i = nestedList.size()-1; i >= 0; i--) {
			list.addFirst(nestedList.get(i));
		}
	}

	@Override
	public Integer next() {
		if(hasNext()) {
			return list.remove().getInteger();
		}else {
			return null;
		}
	}

	@Override
	public boolean hasNext() {
		while(!list.isEmpty()) {
			if(list.element().isInteger()) {
				return true;
			}else{
				breakDownList(list.remove().getList());
			}
		}
		return false;
	}

	public static void main(String[] args) {
		
		List<NestedInteger> mainList = new ArrayList<>();
        
		List<NestedInteger> l1 = new ArrayList<>();
		l1.add(new NestIntClass(1));
		l1.add(new NestIntClass(1));

		NestIntClass n1 = new NestIntClass(2);

		List<NestedInteger> l2 = new ArrayList<>();
		l2.add(new NestIntClass(1));
		l2.add(new NestIntClass(1));

		mainList.add(new NestIntClass(l1));
		mainList.add(n1);
		mainList.add(new NestIntClass(l2));

		NestedIterator it = new NestedIterator(mainList);
		while (it.hasNext()) {
           System.out.println(it.next());
		}
	}
}
