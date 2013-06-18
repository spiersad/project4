package com.spiersad.p4;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		LinkedBinarySearchTree<Word> tree = new LinkedBinarySearchTree<Word>();


		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a sentence of only words, charecters, and spaces");
		String in = scanner.nextLine();
		//scanner.close();


		in = in.replaceAll("[^A-Za-z0-9 ]", "").toUpperCase();
		String[] parts = in.split(" ");
		for (int i = 0; i < parts.length; i++){
			Word temp = new Word(parts[i]);
			Iterator<Word> it = tree.iteratorInOrder();
			Word current = null;
			while (it.hasNext()){
				current = it.next();
				if (temp.string.equals(current.string))
					break;
			}
			if (current == null)
				tree.addElement(temp);
			else if (temp.string.equals(current.string))
				current.count++;
			else
				tree.addElement(temp);
		}



		Iterator<Word> it = tree.iteratorInOrder();
		while(it.hasNext()){
			Word current = it.next();
			System.out.println("word:  " + current.string + "\tcount:  " + current.count);
		}


		
		System.out.println("Enter a word to remove");
		in = scanner.next().toUpperCase();

		it = tree.iteratorInOrder();
		Word current = null;
		while (it.hasNext()){
			current = it.next();
			if (in.equals(current.string)){
				if (current.count > 1){
					current.count--;
					break;
				}
				else
					try {
						tree.removeElement(current);
					} catch (ElementNotFoundException e) {
						e.printStackTrace();
					}
				System.out.println(in + " Removed");
				break;
			}
		}
		if (in.equals(current.string) == false)
			System.out.println(in + " not found");
		scanner.close();
		
		it = tree.iteratorInOrder();
		while(it.hasNext()){
			Word current1 = it.next();
			System.out.println("word:  " + current1.string + "\tcount:  " + current1.count);
		}
	}
}
