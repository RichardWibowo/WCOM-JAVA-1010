package pracExam2;

//DO NOT MODIFY
public class Node {
	private Double data;
	private Node next;

	public Double getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}

	public void setData(Double data) {
		this.data = data;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node() {
		setData(null);
		setNext(null);
	}

	public Node(Double data) {
		setData(data);
		setNext(null);
	}

	public Node(Double data, Node node) {
		setData(data);
		setNext(node);
	}

	public String toString() {
		return data + "";
	}
}
