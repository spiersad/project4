package com.spiersad.p4;

public class IndexOutOfBoundsException extends Exception{

	public IndexOutOfBoundsException(String string) {
		super("Out of bounds" + string);
	}
}
