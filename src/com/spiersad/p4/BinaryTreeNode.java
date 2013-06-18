package com.spiersad.p4;

public class BinaryTreeNode<T> {
	protected T element;
	protected BinaryTreeNode<T> left, right;
	int balance;

	public BinaryTreeNode() {
		element = null;
		left = null;
		right = null;
		balance = 0;
	}

	BinaryTreeNode (T newElement) {
		element = newElement;
		left = null;
		right = null;
		balance = 0;
	}

	public int numChildren() {

		int count = 0;

		if (left != null)
			count = 1 + left.numChildren();
		if (right != null)
			count = count + 1 + right.numChildren();

		return count;
	}
}
