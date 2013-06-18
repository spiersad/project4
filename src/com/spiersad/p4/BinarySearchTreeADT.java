package com.spiersad.p4;

public interface BinarySearchTreeADT<T> {

	public void addElement (T element);

	public T removeElement (T targetElement) throws ElementNotFoundException;

	public void removeAllOccurrences (T targetElement);

	public T removeMin();

	public T removeMax();

	public T findMin();

	public T findMax();
}
