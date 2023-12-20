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
    if (head == null && tail == null) {
      this.head = newNode;
      this.tail = newNode;
    }
    Node temp = this.head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = newNode;
    newNode.prev = temp;
    newNode.next=null;
  }

}
