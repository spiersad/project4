package com.spiersad.p4;

public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {

	public ArrayUnorderedList() {
		super();
	}

	public ArrayUnorderedList(int arraysize) {
		super(arraysize);
	}

    /**
     * adds to the front of the list
     * @param element to be added
     */
	@Override
	public void addToFront(T element) {
		doubler();
		for (int i = index; i > 0; i--){
			list[i]=list[i-1];
		}
		list[0] = element;
		index++;
	}

    /**
     * adds to the rear of the list
     * @param element to be added
     */
	@Override
	public void addToRear(T element) {
		doubler();
		list[index] = element;
		index++;
	}

    /**
     * adds to the list after a specific element
     * @param element to be added
     * @param target to be added after
     * @throws ElementNotFoundException
     */
	@Override
	public void addAfter(T element, T target) throws ElementNotFoundException {
		doubler();
		int found = -1;
		for (int i = 0; i < index; i++){
			if (list[i] == element){
				found = i;
				break;
			}
		}
		if (found == -1) throw new ElementNotFoundException();
		found++;
		for (int i = index; i > found; i--){
			list[i]=list[i-1];
		}
		list[found] = element;
		index++;
	}

}
