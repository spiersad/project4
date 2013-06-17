package com.spiersad.p4;

public class Word implements Comparable<Word>{
	
	protected String string;
	protected int count;
	
	public Word(String newString){
		string = newString;
		count = 1;
	}

	@Override
	public int compareTo(Word obj) {
		return string.compareTo(obj.string);
	}
}
