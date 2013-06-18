package com.spiersad.p4;

import java.util.Iterator;

import com.spiersad.p4.BinaryTreeIterator.Traveral;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T>{
	protected int count;
	protected BinaryTreeNode<T> root, current, parent;

	public LinkedBinaryTree() {
		root = null;
		count = 0;
	}

	@Override
	public void removeLeftSubtree() throws ElementNotFoundException {
		if (root.left == null)throw new ElementNotFoundException();
		count = count - root.left.numChildren();
		root.left = null;
	}

	@Override
	public void removeRightSubtree() throws ElementNotFoundException {
		if (root.right == null)throw new ElementNotFoundException();
		count = count - root.right.numChildren();
		root.right = null;		
	}

	@Override
	public void removeAllElements() throws ElementNotFoundException {
		if (root == null)throw new ElementNotFoundException();
		root = null;
		count = 0;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean contains(T targetElement) {
		search(root, targetElement);
		return (current != null);
	}

	@Override
	public T find(T targetElement) throws ElementNotFoundException {
		search(root, targetElement);
		if (current == null) throw new ElementNotFoundException();
		return current.element;
	}

	@Override
	public Iterator<T> iteratorInOrder() {
		BinaryTreeIterator<T> it = new BinaryTreeIterator<T>(root, Traveral.LVR);
		return it;
	}

	@Override
	public Iterator<T> iteratorPreOrder() {
		BinaryTreeIterator<T> it = new BinaryTreeIterator<T>(root, Traveral.VLR);
		return it;
	}

	@Override
	public Iterator<T> iteratorPostOrder() {
		BinaryTreeIterator<T> it = new BinaryTreeIterator<T>(root, Traveral.LRV);
		return it;
	}

	@Override
	public Iterator<T> iteratorLevelOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	protected void search(BinaryTreeNode<T> node, T element){
		BinaryTreeNode<T> temp = node;
		current = null;
		parent = null;
		if (element.equals(root.element)){
			current = root;
		}
		if (temp.left != null){
			if (element.equals(temp.left.element)){
				current = temp.left;
				parent = temp;
			}
			else
				search(temp.left, element);
		}
		if (temp.right != null){
			if (element.equals(temp.right.element)){
				current = temp.right;
				parent = temp;
			}
			else
				search(temp.right, element);
		}
	}

}
