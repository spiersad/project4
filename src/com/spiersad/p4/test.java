package com.spiersad.p4;

import java.util.Iterator;

public class test {
	
	public static void main(String[] args) {
		/*ArrayUnorderedList<Integer> list = new ArrayUnorderedList<Integer>();
		list.addToRear(5);
		list.addToRear(6);
		list.addToRear(7);
		list.addToRear(8);
		list.addToRear(9);
		list.addToRear(10);
		try {
			list.removeFirst();
			list.removeLast();
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<Integer> it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());*/
		
		LinkedBinarySearchTree<Integer> tree = new LinkedBinarySearchTree<Integer>();
		tree.addElement(20);
		tree.addElement(15);
		tree.addElement(10);
		tree.addElement(25);
		tree.addElement(30);
		tree.addElement(16);
		tree.addElement(24);
		Iterator<Integer> it = tree.iteratorInOrder();
		while (it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
		it = tree.iteratorPostOrder();
		while (it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
		it = tree.iteratorPreOrder();
		while (it.hasNext())
			System.out.print(it.next() + " ");
	}

}
