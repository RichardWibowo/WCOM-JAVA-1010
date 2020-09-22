package w5l1;

public class node {
	
	
	private int data;
	private node next;
	
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public node getNext() {
		return next;
	}
	public void setNext(node next) {
		this.next = next;
	}
	public node() {
		next = null;
		data = 0;
	}
	public node(int data) {
		next = null;
		setData(data);
	}
	public node(int data, node next) {
		setData(data);
		setNext(next);
	}

}
