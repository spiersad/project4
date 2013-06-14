package com.spiersad.p4;

import java.util.Iterator;

public class ArrayList<T> implements ListADT<T>{
	final private int DEFAULT_ARRAY = 100;
	protected T[] list;
	protected int index;

	public ArrayList() {
		list = (T[]) new Object[DEFAULT_ARRAY];
		index = 0;
	}

	public ArrayList(int arraySize) {
		list = (T[]) new Object[arraySize];
		index = 0;
	}

	@Override
	public T removeFirst() throws IndexOutOfBoundsException {
		if (index == 0) throw new IndexOutOfBoundsException(list.toString());
		T saved = list[0];
		index--;
		for (int i = 0; i < index; i++ ){
			list[i] = list[i+1];
		}
		list[index] = null;
		return saved;
	}

	@Override
	public T removeLast() throws IndexOutOfBoundsException {
		if (index == 0) throw new IndexOutOfBoundsException(list.toString());
		T saved = list[index - 1];
		index--;
		list[index] = null;
		return saved;
	}

	@Override
	public T remove(T element) throws IndexOutOfBoundsException, ElementNotFoundException {
		if (index == 0) throw new IndexOutOfBoundsException(list.toString());
		int savedInt;
		T saved = null;
		for (int i = 0; i < index; i++){
			if (element == list[i]){
				savedInt = i;
				saved = list[i];
				break;
			}
		}
		if (saved == null) throw new ElementNotFoundException();
		index--;
		for (int i = 0; i < index; i++ ){
			list[i] = list[i+1];
		}
		list[index] = null;
		return saved;
	}

	@Override
	public T first() throws IndexOutOfBoundsException {
		if (index == 0) throw new IndexOutOfBoundsException(list.toString());
		return list[0];
	}

	@Override
	public T last() throws IndexOutOfBoundsException {
		if (index == 0) throw new IndexOutOfBoundsException(list.toString());
		return list[index-1];
	}

	@Override
	public boolean contains(T target) throws IndexOutOfBoundsException {
		if (index == 0) throw new IndexOutOfBoundsException(list.toString());
		boolean returned = false;
		for (int i = 0; i < index; i++){
			if (list[i] == target){
				returned = true;
				break;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return index == 0;
	}

	@Override
	public int size() {
		return index;
	}

	@Override
	public Iterator<T> iterator() {
		ArrayIterator<T> it = new ArrayIterator<>(list);
		return it;
	}

	@Override
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < index; i++){
			buffer.append(list[i].toString())
			.append(' ');
		}
		return buffer.toString();
	}
	
	protected void doubler() {
		if (list.length == index-1){
			T[] temp = (T[]) new Object[list.length*2];
			for (int i = 0; i < index; i++){
				temp[i] = list[i];
			}
			list = temp;
		}
	}
}
