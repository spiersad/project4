package com.spiersad.p4;

public class BinaryTreeNode<T> {
	protected T element;
	protected BinaryTreeNode<T> left, right;

	public BinaryTreeNode() {
		element = null;
		left = null;
		right = null;
	}

	BinaryTreeNode (T obj) {
		element = obj;
		left = null;
		right = null;
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
