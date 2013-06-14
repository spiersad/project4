package com.spiersad.p4;

import java.util.Iterator;

public interface BinaryTreeADT<T> {

	public void removeLeftSubtree() throws ElementNotFoundException;

	public void removeRightSubtree() throws ElementNotFoundException;

	public void removeAllElements() throws ElementNotFoundException;

	public boolean isEmpty();

	public int size();

	public boolean contains (T targetElement);

	public T find (T targetElement) throws ElementNotFoundException;

	public String toString();

	public Iterator<T> iteratorInOrder();

	public Iterator<T> iteratorPreOrder();

	public Iterator<T> iteratorPostOrder();

	public Iterator<T> iteratorLevelOrder();
}
