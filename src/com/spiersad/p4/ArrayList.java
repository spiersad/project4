package com.spiersad.p4;

import java.util.Iterator;

/**
 * @author Adrian Spiers
 * @param <T> generic
 */
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

    /**
     * saves the element in the first slot of the array. It then removes that slot and returns that saved value
     * @return returns the first object in the array
     * @throws IndexOutOfBoundsException throws an error if trying to remove from empty list
     */
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

    /**
     * saves the element in the last slot of the array. It then removes that slot and returns that saved value
     * @return returns the last object in the array
     * @throws IndexOutOfBoundsException throws an error if trying to remove from empty list
     */
	@Override
	public T removeLast() throws IndexOutOfBoundsException {
		if (index == 0) throw new IndexOutOfBoundsException(list.toString());
		T saved = list[index - 1];
		index--;
		list[index] = null;
		return saved;
	}

    /**
     * searches for and saves the element in the  array. It then removes the slot of that element and returns that saved value
     * @param element element to be removed
     * @return returns the element that is removed
     * @throws IndexOutOfBoundsException throws an error if trying to remove from empty list
     * @throws ElementNotFoundException throws an error if element is not present in the list
     */
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

    /**
     * returns the first element of the array
     * @return first element of the array
     * @throws IndexOutOfBoundsException throws an error if trying to remove from empty list
     */
	@Override
	public T first() throws IndexOutOfBoundsException {
		if (index == 0) throw new IndexOutOfBoundsException(list.toString());
		return list[0];
	}

    /**
     * returns the last element of the array
     * @return last element of the array
     * @throws IndexOutOfBoundsException throws an error if trying to remove from empty list
     */
	@Override
	public T last() throws IndexOutOfBoundsException {
		if (index == 0) throw new IndexOutOfBoundsException(list.toString());
		return list[index-1];
	}

    /**
     * searches for the target and returns true if it is there
     * @param target element being searched for
     * @return true if element is in the list else false
     * @throws IndexOutOfBoundsException throws an error if trying to remove from empty list
     */
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

    /**
     * checks if empty
     * @return true if empty
     */
	@Override
	public boolean isEmpty() {
		return index == 0;
	}

    /**
     * checks size of list
     * @return size of list
     */
	@Override
	public int size() {
		return index;
	}

    /**
     * Creates a new iterator of type ArrayIterator
     * @return the created iterator
     */
	@Override
	public Iterator<T> iterator() {
		ArrayIterator<T> it = new ArrayIterator<T>(list);
		return it;
	}

    /**
     * converts the list to a string and returns it
     * @return the built string
     */
	@Override
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < index; i++){
			buffer.append(list[i].toString())
			.append(' ');
		}
		return buffer.toString();
	}

    /**
     * will double the array in case of running out of room
     */
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
