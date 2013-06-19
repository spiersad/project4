package com.spiersad.p4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		LinkedBinarySearchTree<Word> tree = new LinkedBinarySearchTree<Word>();


		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a sentence of only words, characters, and spaces");
		String in = scanner.nextLine();

        //adds all the elements from the input
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


        //shows the current tree of words inorder
		Iterator<Word> it = tree.iteratorInOrder();
		while(it.hasNext()){
			Word current = it.next();
			System.out.println("word:  " + current.string + "\tcount:  " + current.count);
		}


		//asks for a word to be removed
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

        //prints the list again
		it = tree.iteratorInOrder();
		while(it.hasNext()){
			Word current1 = it.next();
			System.out.println("word:  " + current1.string + "\tcount:  " + current1.count);
		}


        //prints the list to file or to terminal
        System.out.println("press 1 to print this list to file or anything else to see it again.");
        int inInt = scanner.nextInt();
        scanner.close();

        if (inInt == 1){
            PrintWriter writer = null;
            try {
                writer = new PrintWriter("out.txt");
                it = tree.iteratorInOrder();
                while(it.hasNext()){
                    Word crnt = it.next();
                    writer.println("word:  " + crnt.string + "\tcount:  " + crnt.count);
                }
                writer.close();
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else {
            it = tree.iteratorInOrder();
            while(it.hasNext()){
                Word current1 = it.next();
                System.out.println("word:  " + current1.string + "\tcount:  " + current1.count);
            }
        }
	}
}
