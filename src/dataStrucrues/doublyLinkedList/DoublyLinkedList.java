package dataStrucrues.doublyLinkedList;

public class DoublyLinkedList {

  private Node head;
  private Node tail;
  private int length;

  class Node {

    int value;
    Node next;
    Node prev;

    Node(int value) {
      this.value = value;
    }
  }

  public DoublyLinkedList(int value) {
    Node newNode = new Node(value);
    head = newNode;
    tail = newNode;
    length = 1;
  }

  public void getHead() {
    System.out.println("head = " + head.value);
  }

  public void getTail() {
    System.out.println("tail = " + tail.value);
  }

  public void getLength() {
    System.out.println("length = " + length);
  }

  public void printList() {
    Node currentNode = this.head;
    while (currentNode != null) {
      System.out.println(currentNode.value);
      currentNode = currentNode.next;
    }
  }

  public void append(int value) {
    Node newNode = new Node(value);
    if (this.head == null || length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode;
    }
    length++;
  }

  // return Node which is removed
  public Node removeLast() {
    if (this.head == null || length == 0) {
      this.head = null;
      this.tail = null;
      return null;
    }
    Node temp = this.tail;
    if (this.head.next == null || this.tail.prev == null || length == 1) {
      this.head = null;
      this.tail = null;
    } else {
      this.tail = this.tail.prev;
      temp.prev = null;
      this.tail.next = null;
    }
    length--;
    return temp;
  }

  public void prepend(int value) {
    Node newNode = new Node(value);
    if (this.head == null || length == 0) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      newNode.next = this.head;
      this.head.prev = newNode;
      this.head = newNode;
    }
    length++;

  }

  public Node removeFirst() {

    if (this.head == null || length == 0) {
      return null;
    }
    Node temp = this.head;
    if (this.head.next == null || length == 1) {
      this.head = null;
      this.tail = null;
    } else {
      this.head = this.head.next;
      temp.next = null;
      this.head.prev = null;
    }
    length--;
    return temp;
  }

  public Node get(int index) {
    if (this.head == null || length == 0 || index >= length) {
      return null;
    }
    int num = length - index - 1;
    Node temp = null;
    if (num >= index) {
      temp = this.head;
      for (int i = 0; i < index; i++) {
        temp = temp.next;
      }
    } else {
      temp = this.tail;
      for (int i = 0; i < num; i++) {
        temp = temp.prev;
      }
    }
    return temp;
  }

  public boolean set(int index, int value) {
    if (this.head == null || length == 0 || get(index) == null) {
      return false;
    }
    Node node = get(index);
    node.value = value;
    return true;
  }

  public boolean insert(int index, int value) {
    if (this.head == null || length == 0) {
      return false;
    } else if (index == 0) {
      prepend(value);
      return true;
    } else if (get(index) == null || index == length) {
      append(value);
      return true;
    } else {
      Node newNode = new Node(value);
      Node findNode = get(index);
      Node pre = findNode.prev;
      pre.next = newNode;
      newNode.prev = pre;
      newNode.next = findNode;
      findNode.prev = newNode;
      length++;
      return true;

    }

  }

  public Node remove(int index) {
    if (this.head == null || length == 0 || index > length) {
      return null;
    }
    Node pre = null;
    Node next = null;
    Node findNode = get(index);
    if (index == 0) {
      removeFirst();
    } else if (length == index + 1) {
      removeLast();
    } else {
      pre = findNode.prev;
      next = findNode.next;
      pre.next = next;
      next.prev = pre;
      length--;
    }
    return findNode;
  }

//  public void swapFirstLast_Wrong() {
//    if (length < 2) {
//      return;
//    }
//    Node nextHead = this.head.next;
//    Node prevTail = this.tail.prev;
//    Node temp = null;
//    this.head.next = null;
//    this.tail.prev = null;
//    temp = this.head;
//    this.head = this.tail;
//    this.tail = temp;
//    if (length == 2) {
//      this.head.next = this.tail;
//      this.tail.prev = this.head;
//    } else {
//      this.head.next = nextHead;
//      nextHead.prev = this.head;
//      this.tail.prev = prevTail;
//      prevTail.next = this.tail;
//    }
//  }

  public void swapFirstLast() {
    if (length < 2) {
      return;
    }
    int temp = this.head.value;
    this.head.value = this.tail.value;
    this.tail.value = temp;
  }

  public void reverse() {
    if (length < 2) {
      return;
    }
    Node temp=this.head;
    while(temp!=null){
      Node next = temp.next;
      Node tmp = temp.next;
      temp.next = temp.prev;
      temp.prev = tmp;
      temp=next;
    }
    Node tmp = this.head;
    this.head = this.tail;
    this.tail = tmp;
  }
}
