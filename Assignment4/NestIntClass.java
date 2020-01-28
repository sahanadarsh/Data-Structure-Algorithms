package Assignment4;

import java.util.List;

public class NestIntClass implements NestedInteger {

	List<NestedInteger> list = null;
	int n = 0;
	boolean isInteger;

	NestIntClass(int num) {
		isInteger = true;
		n = num;
	}

	NestIntClass(List<NestedInteger> aList) {
		isInteger = false;
		list = aList;
	}

	public boolean isInteger() {
		return isInteger;
	}

	public Integer getInteger() {
		return n;
	}

	public List<NestedInteger> getList() {
		return list;
	}

}
