package com.spiersad.p4;

import java.util.Iterator;

/**
 * @author Adrian Spiers
 * @param <T> generic
 */
public class BinaryTreeIterator<T> implements Iterator<T> {
	protected BinaryTreeNode<T> node;
	ArrayUnorderedList<T> list;
	Iterator<T> listIt;
	protected enum Traversal {
		VLR, LVR, LRV;
	}

	public BinaryTreeIterator(BinaryTreeNode<T> treeNode, Traversal order) {
		node = treeNode;
		makelist(order);
	}

    /**
     * checks to see if the tree iterator has more elements
     * @return true if the tree iterator has more elements
     */
	@Override
	public boolean hasNext() {
		return listIt.hasNext();
	}

    /**
     * returns the next element in the iterator
     * @return the next element in the iterator
     */
	@Override
	public T next() {
		return listIt.next();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	protected void makelist(Traversal traversal){
		list = new ArrayUnorderedList<T>();
		if (traversal == Traversal.VLR)
			preOrder(node);
		else if (traversal == Traversal.LVR)
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
