package com.spiersad.p4;

/**
 * @author Adrian Spiers
 * @param <T> generic
 */
public class LinkedBinarySearchTree<T extends Comparable<T>> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T> {

	protected BinaryTreeNode<T> grandParent;

	protected enum Direction{
		left, right;
	}

	public LinkedBinarySearchTree() {
		super();
	}

    /**
     * adds an element in a binary search tree
     * @param element to be added
     */
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
	}

    /**
     * removes and returns an element from the tree
     * @param targetElement to be removed
     * @return element that has been removed
     * @throws ElementNotFoundException throws an exception if the list is empty
     */
	@Override
	public T removeElement(T targetElement) throws ElementNotFoundException {
		search(root, targetElement);
		if (current == null) throw new ElementNotFoundException();
		T save = current.element;
		
		if (current.left == null && current.right == null){
			if (current == root)
				root = null;
			else if (parent.right == current)
				parent.right = current = null;
			else
				parent.left = current = null;
		}
		else if (current.left == null && current.right != null){
			if(current == root)
				root = current.right;
			else if (parent.right == current)
				parent.right = current.right;
			else
				parent.left = current.right;
		}
		else if (current.left != null && current.right == null){
			if(current == root)
				root = current.left;
			else if (parent.right == current)
				parent.right = current.left;
			else
				parent.left = current.left;
		}
		else if (current.left != null && current.right != null){
			if (current.right.left == null){
				current.right.left = current.left;
				if(current == root)
					root = current.right;
				else if (parent.right == current)
					parent.right = current.right;
				else
					parent.left = current.right;
			}
			else{
				BinaryTreeNode<T> tempCurrent = current.right;
				BinaryTreeNode<T> tempParent = current.right;
				while (tempCurrent.left != null){
					tempParent = tempCurrent;
					tempCurrent = tempCurrent.left;
				}
				if (tempCurrent.right != null)
					tempParent.left = tempCurrent.right;
				tempCurrent.right = current.right;
				tempCurrent.left = current.left;
				if(current == root)
					root = tempCurrent;
				else if (parent.right == current)
					parent.right = tempCurrent;
				else
					parent.left = tempCurrent;
				tempCurrent = tempParent = null;
			}
			current = parent = null;
		}
        count--;
		return save;
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
}
