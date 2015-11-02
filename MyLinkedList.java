/**
 * The following code delivers methods for operations on a linked list.
 * operations include: linked list creation,returning the head, tail,
 * element at an index, the index for an element, true/false if element found,
 * last index for an element found. Other methods include add to linked list,
 * add to head or tail, replace element at an index. Remove head or tail and
 * at index.
 * @author Bill Blunk - C202 IUS
 * @param <E>
 */
public class MyLinkedList<E> extends MyAbstractList<E> {

    private Node<E> head, tail;

    /** Create a default list */
    public MyLinkedList() {
    }

    /** Create a list from an array of objects */
    public MyLinkedList(E[] objects) {
        super(objects);
    }

    /** Return the head element in the list */
    public E getFirst() {
       if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }

    /** Return the last element in the list */
    public E getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }

    /** Add an element to the beginning of the list */
    public void addFirst(E e) {
        Node<E> newNode = new Node<E>(e); // Create a new node
        newNode.next = head; // link the new node with the head
        head = newNode; // head points to the new node
        size++; // Increase list size

        if (tail == null) // the new node is the only node in list
        {
            tail = head;
        }

    }

    /** Add an element to the end of the list */
    public void addLast(E e) {
        Node<E> newNode = new Node<E>(e); // Create a new for element e
        if (tail == null) {
            head = tail = newNode; // The new node is the only node in list
        } else {
            tail.next = newNode; // Link the new with the last node
            tail = tail.next; // tail now points to the last node
        }
        size++; // Increase size
    }

    /** Add a new element at the specified index in this list
     * The index of the head element is 0 */
    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
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
        } else {
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
        } else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        } else {
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

    /** Remove the element at the specified position in this list.
     *  Return the element that was removed from the list. */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
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

    /** Override toString() to return elements in the list */
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            } else {
                result.append("]"); // Insert the closing ] in the string
            }
        }
        return result.toString();
    }

    /** Clear the list */
    public void clear() {
        head = tail = null;
    }
    
    /**
     methods for lab 8 should be implemented here
     */
    /** Returns true if this liked list contains the element e, otherwise return false
     * @requires an element to search for
     * @param e
     * @return  true or false if element is found or not found in list**/
     public boolean contains (E e)
    {
            Node<E> current = head;
            for (int i = 0; i < size; i++)
            {
                if (current.element == e)
                {
                    return true;
                }                    
                current = current.next;
            } 
            return false;
    }
    
     public boolean contains(E e, int [] count){
         Node <E> current = head;
         for (int i =0; i < size; i++){
             if (current.element.equals(e)){
                 count[0] = i + 1;
                 return true;
             }
             current = current.next;
         }
         count[0]=size;
         return false;
     }
     
     /** Returns element at the specified index of the list, returns null if index is invalid
     * @requires an index to to specify where the element is
     * @param index*
     * @return  the element at the supplied index*/ 
    public E get(int index)
    {
      if (index < 0 || index >= size)
       {
            return null;
       }
       else
       {
            Node<E> current = head;
            for (int i = 0; i == index; i++)
            {
                current = current.next;
            }
            return current.element;
       }
    }
    
    /** returns the index of the first matching element in the linked list,
     return -1 if not match
     * @requires an element to search for
     * @param e
     * @return matching element or -1 */
    public int indexOf(E e)
    {
        Node <E> current = head;
        for (int i = 0; i < size; i++)
        {
            if (current.element.equals(e))
            {
                return i;
            }
            current = current.next;
        }
        return -1;
    }
    
    /** returns the index of the last matching element in the linked list,
     return -1 if not match
     * @requires an element to search for
     * @param e
     * @return  matching element or -1 */
    public int lastIndexOf (E e)
    {
        Node <E> current = head;
        int index = -1;
        for (int i = 0; i< size; i++)
        {
            if (current.element.equals(e))
            {
                index = i;
            }
            current = current.next;
        }
        return index;
    }
    
    /** replaces the element at specified index in the linked list with the specified element.
     Returns the old element at specified index. otherwise returns null if index is invalid
     * @requires nd index and the new element
     * @param index
     * @param e
     * @return e - which is not in the output print line */
    public E set(int index, E e){
        if (index < 0 || index >= size)
        {
            return null;
        }
        else
        {
        Node <E> current = head;
        for (int i = 0; i != index; i++)
        {
            current = current.next;
        }
        E word = current.element;
        current.element = e;
        return word;
        }
        
    }
    /**
     * Create Node Class
     * @param <E> 
     */    
    private static class Node<E>
    {
        E element;
        Node<E> next;
        public Node(E element)
        {
            this.element = element;
        }
    }
}
    

