package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
	Node sentinel; //this will be the entry point to your linked list (the head)


	public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
		sentinel=new Node(0); //Note that the root's data is not a true part of your data set!
	}

	//implement all methods in interface, and include the getRoot method we made for testing purposes. Feel free to implement private helper methods!

	public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
		return sentinel;
	}

	@Override
	public boolean insert(double elt, int index) {
		Node a = sentinel;
		Node newN = new Node(elt);

		if(index < 0 || index > size()) {
			return false;
		}
		if(a.next == null) {
			a.next = newN;
			newN.next = a;
			newN.prev = a;
			a.prev = newN;
			return true;
		} else {
			for(int i = 0; i < index ; i++) {
				a = a.next;
			}
			Node b = a.next;
			a.next = newN;
			newN.prev = a;
			newN.next = b;
			b.prev = newN;
			return true;
		}

	}

	@Override
	public boolean remove(int index) {
		Node a = this.sentinel;

		if(index > size() || index < 0) {
			return false;
		}
		if(a.next == sentinel) {
			a.next = null;
		}

		for(int i = 0; i < index; i++) {
			a = a.next;
		}
		Node b = a.next;
		a.next = b.next;
		a.next.prev = a;
		return true;

	}

	@Override
	public double get(int index) {
		Node a = sentinel;
		if (a.next== null) {
			return Double.NaN;
		}else if (index > size() || index < 0) {
			return Double.NaN;
		}else if (a.next != null){
			for (int i = 0; i <= index; i++) {
				a = a.next;
			}
			return a.data;
		}
		return Double.NaN;


	}

	@Override
	public int size() {
		Node a = sentinel.next;
		int size = 0;
		if(a == null) {
			return 0;
		} else {
			while(a != sentinel) {
				size++;
				a = a.next;
			}
		}
		return size;
	}

	@Override
	public boolean isEmpty() {
		Node sent = sentinel;
		if(sent.next == sentinel) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void clear() {
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
	}
}