package w5l1;

public class Link {
	private node head;

	public Link() {
		head = null;
	}

	public void addFirst(int data) {
		node n = new node(data, head);
		head = n;
	}

	public void removeFirst() {
		head = head.getNext();
	}

	public int size() {
		int n = 0;
		node current = head;
		while (current != null) {
			n++;
			current = current.getNext();
		}
		return n;
	}

	public int get(int idx) {
		node current = head;
		for (int i = 0; i < idx; i++) {
			current = current.getNext();
		}
		return current.getData();
	}

	public void set(int idx, int data) {
		node current = head;
		for (int i = 0; i < idx; i++) {
			current = current.getNext();
		}
		current.setData(data);
	}

	public int sum() {
		node current = head;
		int sum = 0;
		while (current != null) {
			sum += current.getData();
			current = current.getNext();
		}
		return sum;
	}

	public int removeLast() {
		node current = head;

		while (current.getNext().getNext() != null) {
			current = current.getNext();
		}
		int rem = current.getNext().getData();
		current.setNext(null);

		return rem;

	}

	public void add(int idx, int data){
		if(idx== 0){ 
			node n= new node(data,head); 
			head = n;return;
			}
		node current= head;
		for(int i= 0; i< idx-1; i++){
			current= current.getNext();
			}
		
		node n= new node(data,current.getNext());
		
		current.setNext(n);
	}

	public void remove(int idx){
		if(idx== 0){
			head = head.getNext();
			return;
			}
		node current= head;
		for(int i= 0; i< idx-1; i++){
			current= current.getNext();
			}
		current.setNext(current.getNext().getNext());
		}
	public void addAfter(int idx, int data){
		node current= head;
		for(int i= 0; i< idx-1; i++){
			if(current != null && current.getData()!=idx)
			current= current.getNext();
			}
		if(current != null) {
			node n= new node(data,current.getNext());
			current.setNext(n);
		}
	}
	public void removeTarget(int idx){
		if(head.getData()==idx) {
			removeFirst();
			return;
		}
		node current= head;
		for(int i= 0; i< idx-1; i++){
			if(current != null&&current.getData()!=idx)
				current= current.getNext();
			}
			if(current != null) 
				current.setNext(current.getNext().getNext());
		}
	
	public int indexOf(int idx ) {
		int n = 0;
		node current = head;
		while(current != null) {
			if(current.getData()==idx) {
				return n;
			}
			n++;
			current = current.getNext();
			
		}
		return -1;
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
