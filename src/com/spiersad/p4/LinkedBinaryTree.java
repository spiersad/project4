package com.spiersad.p4;

import java.util.Iterator;

/**
 * @author Adrian Spiers
 * @param <T> generic
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T>{
	protected int count;
	protected BinaryTreeNode<T> root, current, parent;

	public LinkedBinaryTree() {
		root = null;
		count = 0;
	}

    /**
     * removes the roots left sub tree
     * @throws ElementNotFoundException throws an exception if the roots left sub tree is empty
     */
	@Override
	public void removeLeftSubtree() throws ElementNotFoundException {
		if (root.left == null)throw new ElementNotFoundException();
		count = count - root.left.numChildren();
		root.left = null;
	}

    /**
     * removes the roots left sub tree
     * @throws ElementNotFoundException throws an exception if the roots right sub tree is empty
     */
	@Override
	public void removeRightSubtree() throws ElementNotFoundException {
		if (root.right == null)throw new ElementNotFoundException();
		count = count - root.right.numChildren();
		root.right = null;		
	}

    /**
     * removes all the elements from the tree
     * @throws ElementNotFoundException throws an exception if the tree is empty
     */
	@Override
	public void removeAllElements() throws ElementNotFoundException {
		if (root == null)throw new ElementNotFoundException();
		root = null;
		count = 0;
	}

    /**
     * checks the tree to see if it is empty
     * @return true if empty
     */
	@Override
	public boolean isEmpty() {
		return count == 0;
	}

    /**
     * returns the number of elements in the tree
     * @return count of all elements in the tree
     */
	@Override
	public int size() {
		return count;
	}

    /**
     * searches the tree for a specific element
     * @param targetElement to be searched for
     * @return true if the tree contains the element
     */
	@Override
	public boolean contains(T targetElement) {
		search(root, targetElement);
		return (current != null);
	}

    /**
     * searches the tree for a specific element and returns it
     * @param targetElement to be searched for
     * @return the element being searched for
     * @throws ElementNotFoundException throws exception if the tree does not contain the element
     */
	@Override
	public T find(T targetElement) throws ElementNotFoundException {
		search(root, targetElement);
		if (current == null) throw new ElementNotFoundException();
		return current.element;
	}

    /**
     * creates an inorder iterator
     * @return the created iterator
     */
	@Override
	public Iterator<T> iteratorInOrder() {
		BinaryTreeIterator<T> it = new BinaryTreeIterator<T>(root, BinaryTreeIterator.Traversal.LVR);
		return it;
	}

    /**
     * creates an preorder iterator
     * @return the created iterator
     */
	@Override
	public Iterator<T> iteratorPreOrder() {
		BinaryTreeIterator<T> it = new BinaryTreeIterator<T>(root, BinaryTreeIterator.Traversal.VLR);
		return it;
	}

    /**
     * creates an postorder iterator
     * @return the created iterator
     */
	@Override
	public Iterator<T> iteratorPostOrder() {
		BinaryTreeIterator<T> it = new BinaryTreeIterator<T>(root, BinaryTreeIterator.Traversal.LRV);
		return it;
	}

	@Override
	public Iterator<T> iteratorLevelOrder() {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * generic search for binary trees. When it finds the element it leaves current on the element and parent above it
     * @param node to be searched from
     * @param element to be searched for
     */
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
