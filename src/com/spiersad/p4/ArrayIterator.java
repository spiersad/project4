package com.spiersad.p4;

import java.util.Iterator;

/**
 * @author Adrian Spiers
 * @param <T> generic
 */
public class ArrayIterator<T> implements Iterator<T>{
	T[] itList;
	int current;
	
	public ArrayIterator(T[] list) {
		itList = list;
		current = 0;
	}

    /**
     * used to check if iterator has more
     * @return returns true if the iterator has more items to be returned
     */
	@Override
	public boolean hasNext() {
		return itList[current] != null;
	}

    /**
     * used to return the next element in the iterator
     * @return returns the next element in the iterator
     */
	@Override
	public T next() {
		current++;
		return itList[current-1];
	}

    /**
     *
     */
	@Override
	public void remove() {
		// TODO Auto-generated method stub	
	}

}
