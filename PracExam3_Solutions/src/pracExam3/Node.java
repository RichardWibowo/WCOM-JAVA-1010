package pracExam3;
//DO NOT MODIFY
public class Node {
	private Character data;
	private Node next;
	
	public Character getData() {
		return data;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setData(Character data) {
		this.data = data;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node() {
		setData(null);
		setNext(null);
	}
	
	public Node(Character data) {
		setData(data);
		setNext(null);
	}
	
	public Node(Character data, Node node) {
		setData(data);
		setNext(node);
	}	
	
	public String toString() {
		return data+"";
	}
}
