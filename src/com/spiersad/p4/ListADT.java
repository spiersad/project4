package com.spiersad.p4;

import java.util.Iterator;

public interface ListADT<T> {

	public T removeFirst () throws IndexOutOfBoundsException;

	public T removeLast () throws IndexOutOfBoundsException;

	public T remove (T element) throws IndexOutOfBoundsException, ElementNotFoundException;

	public T first () throws IndexOutOfBoundsException;

	public T last () throws IndexOutOfBoundsException;

	public boolean contains (T target) throws IndexOutOfBoundsException;

	public boolean isEmpty();

	public int size();

	public Iterator<T> iterator();

	public String toString();
}
