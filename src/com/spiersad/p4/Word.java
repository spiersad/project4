package com.spiersad.p4;

/**
 * @author Adrian Spiers
 */
public class Word implements Comparable<Word>{
	
	protected String string;
	protected int count;
	
	public Word(String newString){
		string = newString;
		count = 1;
	}

    /**
     * compare two word's string values
     * @param obj to compared to
     * @return negative value if the word's string is less than the compared word's string, a positive value if the
     * word's string is greater than the compared word's string, and 0 if the are equal
     */
	@Override
	public int compareTo(Word obj) {
		return string.compareTo(obj.string);
	}
}
