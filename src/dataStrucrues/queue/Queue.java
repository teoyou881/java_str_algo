package dataStrucrues.queue;

public class Queue {

  private Node first;
  private Node last;
  private int length;

  class Node {

    int value;
    Node next;

    Node(int value) {
      this.value = value;
    }
  }

  public Queue(int value) {
    Node newNode = new Node(value);
    first = newNode;
    last = newNode;
    length = 1;
  }

  public void printQueue() {
    Node temp = first;
    while (temp != null) {
      System.out.println(temp.value);
      temp = temp.next;
    }
  }

  public void getFirst() {
    System.out.println("first = " + first.value);
  }

  public void getLast() {
    System.out.println("last =" + last.value);
  }

  public void getLength() {
    System.out.println("length = " + length);
  }

  public void enqueue(int value) {
    Node newNode = new Node(value);
    if (length == 0) {
      this.first = newNode;
      this.last = newNode;
    } else {
      Node temp = this.last;
      this.last = newNode;
      temp.next = newNode;
    }
    length++;
  }

  public Node dequeue() {
    if (length == 0) {
      return null;
    }
    Node temp = this.first;
    this.first = this.first.next;
    temp.next = null;

    length--;
    return temp;
  }
}
