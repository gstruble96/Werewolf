public class MyLinkedList<E> extends MyAbstractList<E>{
  
  private Node<E> head;
  private Node<E> tail;
  
  /** Create a default list */
  public MyLinkedList() {
  }
  
  /** Create a list from an array of objects */
  public MyLinkedList(E[] objects) {
    super(objects);
  }
  
  /** Clear the list */
  public void clear() {
    head = tail = null;
    size = 0;       // this is missing from the 8th edition of the book!
  }
  
  /** Return the head element in the list */
  public E getFirst() {
    if (size == 0) {
      return null;
    }
    else {
      return head.element;
    }
  }
  
  /** Return the last element in the list */
  public E getLast() {
    if (size == 0) {
      return null;
    }
    else {
      return tail.element;
    }
  }
  
  /**contains method */
  public boolean contains(E e) { 
    Node<E> current = head;
    while(current != null) {
      if(e.equals(current.element)) {
        return true;
      }
      current = head.next;
    }
    return false;
  }
  
  /** gets the element from an index*/
  public E get(int index) {
    Node<E> current = head;
    int count = 0;
    while(current != null) {
      if(index == count) {
        return current.element;
      }
      count++;
      current = current.next;
    }
    return null;
  }
  /** gets the index of an element*/
  public int indexOf(E e) {
    Node<E> current = head;
    int index = 0;
    while(current != null) {
      if(current.equals(e)) {
        return index;
      }
      index++;
      current = current.next;
    }
    return -1;
  }
  /**gets the last index of an element */
  public int lastIndexOf(E e) {
    Node<E> current = head;
    int index = 0;
    int lastIndex = -1;
    while(current != null) {
      if(current.equals(e)) {
        lastIndex = index;
      }
      index++;
      current = current.next;
    }
    return lastIndex;
  }
  /**creates a sublist LinkedList from the original*/
  public MyLinkedList<E> extractSublist(int start, int end) {
    Node<E> current = head;
    if(start > end)
      return null;
    if(end > this.size)
      return null;
    MyLinkedList<E> newList = new MyLinkedList<E>();
    int count = 0;
    while(count != start) {
      current = current.next;
      count++;
    }
    int remcount = count;
    while(count <= end) {
      newList.addLast(current.element);
      current = current.next;
      this.remove(remcount);
      count++;
    }
    return newList;
  }
  /**puts a sublist to the beginning of the linked list*/
    public void prepend(MyLinkedList<E> prefix) {
    int x = prefix.size;
    Node<E> current = prefix.head;
    for(int i = 0; i < x; i++) {
      this.add(i,current.element);
      current = current.next;
  }
  }
    
    /** Override toString() to return elements in the list */
  public String toString() {
    StringBuilder result = new StringBuilder("[");

    Node<E> current = head;
    for (int i = 0; i < size; i++) {
      result.append(current.element);
      current = current.next;
      if (current != null) {
        result.append(", "); // Separate two elements with a comma
      }
      else {
        result.append("]"); // Insert the closing ] in the string
      }
    }

    return result.toString();
  }
    
  /** Add an element to the beginning of the list */
  public void addFirst(E e) {
    Node<E> newNode = new Node<E>(e); // Create a new node
    newNode.next = head; // link the new node with the head
    head = newNode; // head points to the new node
    size++; // Increase list size
    
    if (tail == null) // the new node is the only node in list
      tail = head;
  }
  
  /** Add an element to the end of the list */
  public void addLast(E e) {
    Node<E> newNode = new Node<E>(e); // Create a new for element e
    
    if (tail == null) {
      head = tail = newNode; // The new node is the only node in list
    }
    else {
      tail.next = newNode; // Link the new with the last node
      tail = tail.next; // tail now points to the last node
    }
    
    size++; // Increase size
  }
  public void add(int index, E e) {
    if (index == 0) {
      addFirst(e);
    }
    else if (index >= size) {
      addLast(e);
    }
    else {
      Node<E> current = head;
      for (int i = 1; i < index; i++) {
        current = current.next;
      }
      Node<E> temp = current.next;
      current.next = new Node<E>(e);
      (current.next).next = temp;
      size++;
    }
  }
  
  /** Remove the head node and
    *  return the object that is contained in the removed node. */
  public E removeFirst() {
    if (size == 0) {
      return null;
    }
    else {
      Node<E> temp = head;
      head = head.next;
      size--;
      if (head == null) {
        tail = null;
      }
      return temp.element;
    }
  }
  
  /** Remove the last node and
    * return the object that is contained in the removed node. */
  public E removeLast() {
    if (size == 0) {
      return null;
    }
    else if (size == 1) {
      Node<E> temp = head;
      head = tail = null;
      size = 0;
      return temp.element;
    }
    else {
      Node<E> current = head;
      
      for (int i = 0; i < size - 2; i++) {
        current = current.next;
      }
      
      Node<E> temp = tail;
      tail = current;
      tail.next = null;
      size--;
      return temp.element;
    }
  }
  
  public E remove(int index) {
    if (index < 0 || index >= size) {
      return null;
    }
    else if (index == 0) {
      return removeFirst();
    }
    else if (index == size - 1) {
      return removeLast();
    }
    else {
      Node<E> previous = head;
      
      for (int i = 1; i < index; i++) {
        previous = previous.next;
      }
      
      Node<E> current = previous.next;
      previous.next = current.next;
      size--;
      return current.element;
    }
  }
  
  /** Replace the element at the specified position in this list
    *  with the specified element. */
  public E set(int index, E e) {
    E e2 = this.remove(index);
    this.add(index, e);
    return e2;
  }
  
  private static class Node<E> {
    E element;
    Node<E> next;
    
    public Node(E element) {
      this.element = element;
    }
  }
}