package com.spiersad.p4;

public class LinkedBinarySearchTree<T extends Comparable<T>> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T> {

	protected BinaryTreeNode<T> grandParent;

	protected enum Direction{
		left, right;
	}

	public LinkedBinarySearchTree() {
		super();
	}

	@Override
	public void addElement(T element) {
		BinaryTreeNode<T> temp = new BinaryTreeNode<T>();
		temp.element = element;
		if (count == 0) {
			root = temp;
			count++;
		}
		else {
			Direction childDirection = null;
			current = root;
			while (current != null){
				parent = current;
				if (current.element.compareTo(element) > 0){
					current = current.left;
					childDirection = Direction.left;
				}
				else{
					current = current.right;
					childDirection = Direction.right;
				}
			}
			if (childDirection == Direction.left)
				parent.left = temp;
			else 
				parent.right = temp;
			count++;
		}
		//checkBalance();
	}

	@Override
	public T removeElement(T targetElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAllOccurrences(T targetElement) {
		// TODO Auto-generated method stub

	}

	@Override
	public T removeMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findMax() {
		// TODO Auto-generated method stub
		return null;
	}

	protected void checkBalance(){

		root.calculateBalance();
		parent = grandParent = null;
		current = root;
		int left, right;
		if (current.left == null)
			left = 0;
		else
			left = current.left.balance;
		if (current.right == null)
			right = 0;
		else
			right = current.right.balance;
		while (current.balance >= 2 && (left >= 2 || right >= 2)){
			grandParent = parent;
			parent = current;
			if (left > right)
				current = current.left;
			else if (left < right)
				current = current.right;
			if (current.left == null)
				left = 0;
			else
				left = current.left.balance;
			if (current.right == null)
				right = 0;
			else
				right = current.right.balance;
		}
		/*if (current.balance == 2 && (left == 1 || right == 1)){
			if (parent == null && left > 0){
				root = root.left;
				root.right = current;
				current.left = null;
			}
			else if (parent == null && right > 0){
				root = root.right;
				root.left = current;
				current.right = null;
			}
		}*/
	}
}
