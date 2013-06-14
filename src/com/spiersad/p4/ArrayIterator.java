package com.spiersad.p4;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T>{
	T[] itList;
	int current;
	
	public ArrayIterator(T[] list) {
		itList = list;
		current = 0;
	}

	@Override
	public boolean hasNext() {
		return itList[current+1] != null;
	}

	@Override
	public T next() {
		current++;
		return itList[current-1];
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub	
	}

}
