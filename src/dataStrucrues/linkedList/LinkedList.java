package dataStrucrues.linkedList;
public class LinkedList {
  private Node head;
  private Node tail;
  private int length;

  class Node{
    int value;
    Node next;
    Node(int value){
      this.value = value;
    }
  }

  public LinkedList(int value) {
  Node newNode = new Node(value);
  this.head = newNode;
  this.tail = newNode;
  this.length = 1;
  }

  public void append(int value) {
    Node newNode = new Node(value);
    if(this.length == 0) {
      this.head = newNode;
    } else {
      this.tail.next = newNode;
    }
    this.tail = newNode;
  }

  public void delete(int value) {
    Node currentNode = this.head;
    Node previousNode = null;

    // find the node to delete from head
    while (currentNode != null && currentNode.value != value) {
      previousNode = currentNode;
      currentNode = currentNode.next;
    }

    // if there is a node to delete
    if (currentNode != null) {
      // if the node is head
      if (currentNode == this.head) {
        this.head = currentNode.next;
      } else {
        // if the node is not head
        previousNode.next = currentNode.next;
      }

      //
      currentNode = null;
      this.length--;
    }else{
      System.out.println("Node not found");
    }

  }

  public void printList() {
    Node currentNode = this.head;
    while (currentNode != null) {
      System.out.print(currentNode.value + " -> ");
      currentNode = currentNode.next;
    }
    System.out.println("null");
  }
}
