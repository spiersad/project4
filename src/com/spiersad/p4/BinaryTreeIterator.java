package com.spiersad.p4;

import java.util.Iterator;

public class BinaryTreeIterator<T> implements Iterator<T> {
	protected BinaryTreeNode<T> node;
	ArrayUnorderedList<T> list;
	Iterator<T> listIt;
	protected enum Traveral {
		VLR, LVR, LRV;
	}

	public BinaryTreeIterator(BinaryTreeNode<T> treeNode, Traveral order) {
		node = treeNode;
		makelist(order);
	}

	@Override
	public boolean hasNext() {
		return listIt.hasNext();
	}

	@Override
	public T next() {
		return listIt.next();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	protected void makelist(Traveral traveral){
		list = new ArrayUnorderedList<T>();
		if (traveral == Traveral.VLR)
			preOrder(node);
		else if (traveral == Traveral.LVR)
			inOrder(node);
		else 
			postOrder(node);
		listIt = list.iterator();
	}
	
	protected void preOrder(BinaryTreeNode<T> search){
		if (search != null){
			list.addToRear(search.element);
			preOrder(search.left);
			preOrder(search.right);
		}
	}
	
	protected void inOrder(BinaryTreeNode<T> search){
		if (search != null){
			inOrder(search.left);
			list.addToRear(search.element);
			inOrder(search.right);
		}
	}
	
	protected void postOrder(BinaryTreeNode<T> search){
		if (search != null){
			postOrder(search.left);
			postOrder(search.right);
			list.addToRear(search.element);
		}
	}
}
