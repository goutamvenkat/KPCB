public class BoundedQueue {
	private BoundedLinkedList<Integer> queue;
	public BoundedQueue(int max_size) {
		queue = new BoundedLinkedList<Integer>(max_size);
	}
	public void enqueue(int num) {
		queue.enqueue(num);
	}
	public String dequeue() {
		try {
			return Integer.toString(queue.dequeue());
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	public boolean isEmpty() {
		return queue.size() == 0;
	}
	public int size() {
		return queue.size();
	}
	private class BoundedLinkedList<E> {
		private int size;
		private int max_size;
		private Node<E> head;
		private Node<E> tail;
		private class Node<E> {
			private E data;
			private Node<E> next;
			private Node(E data) {
				this.data = data;
			}
		}
		private BoundedLinkedList(int max_size) {
			this.max_size = max_size;
		}
		private void enqueue(E num) {
			if (this.size < this.max_size) {
				Node<E> newNode = new Node<E>(num);
				if (head == null) {
					head = newNode;
					tail = head;
				} else if (size == 1) {
					head.next = newNode;
					tail = newNode;
				} else {
					tail.next = newNode;
					tail = newNode;
				}
				this.size++;
			}
		}
		private E dequeue() throws Exception {
			if (size > 0) {
				E data = head.data;
				head = head.next;
				this.size--;
				return data;
			}
			throw new Exception("Queue is empty!");
		}
		private int size() {
			return this.size;
		}
	}
}