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
    }
    newNode.next = this.head;
    this.head.prev = newNode;
    this.head = newNode;
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

}
