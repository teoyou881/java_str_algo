package dataStrucrues.linkedList;

public class LinkedList {

  private Node head;
  private Node tail;
  private int length;

  class Node {

    int value;
    Node next;

    Node(int value) {
      this.value = value;
    }
  }

  public void makeEmpty() {
    this.head = null;
    this.tail = null;
    this.length = 0;
  }

  public Node removeFirst() {
    if (this.length == 0) {
      return null;
    }
    Node temp = this.head;
    if (this.length == 1) {
      this.tail = null;
      this.head = null;
    } else {
      this.head = temp.next;
    }
    length--;

    return temp;
  }

  public Node get(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }
    Node temp = this.head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    return temp;
  }

  public void set(int index, int value) {
    if (index < 0 || index >= this.length) {
      return;
    }

    Node temp = this.head;

    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    temp.value = value;
  }

  public void insert(int index, int value) {
    if (index < 0 || index > this.length) {
      return;
    }
    if (index == 0) {
      this.prepend(value);
      return;
    }
    if (index == this.length) {
      this.append(value);
      return;
    }
    Node newNode = new Node(value);
    Node temp = this.head;
    Node pre = null;
    for (int i = 0; i < index; i++) {
      pre = temp;
      temp = temp.next;
    }
    pre.next = newNode;
    newNode.next = temp;
    this.length++;
  }

  public void reverse() {
    Node temp = this.head;
    this.head = this.tail;
    this.tail = temp;
    Node next = null;
    Node prev = null;
    for (int i = 0; i < this.length; i++) {
      next = temp.next;
      temp.next = prev;
      prev = temp;
      temp = next;
    }
  }

  public Node findMiddleNode() {
    if (this.head == null || this.tail == null) {
      return null;
    }

    Node slow = this.head;
    Node fast = this.head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    if (fast.next != null) {
      return slow.next;
    }
    return slow;
  }

  public LinkedList(int value) {
    Node newNode = new Node(value);
    this.head = newNode;
    this.tail = newNode;
    this.length = 1;
  }

  public void append(int value) {
    Node newNode = new Node(value);
    if (this.length == 0) {
      this.head = newNode;
    } else {
      this.tail.next = newNode;
    }
    this.tail = newNode;
    this.length++;
  }

  public void prepend(int value) {
    Node newNode = new Node(value);
    if (this.length == 0) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      newNode.next = this.head;
      this.head = newNode;
    }
    this.length++;
  }

  public Node removeLast() {
    if (this.length == 0) {
      return null;
    }
    Node cur = this.head;
    Node temp = head;
    while (cur.next != null) {
      temp = cur;
      cur = cur.next;
    }
    this.tail = temp;
    this.tail.next = null;
    length--;
    if (this.length == 0) {
      this.head = null;
      this.tail = null;
    }
    return cur;
  }

  public Node remove(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }

    if (index == 0) {
      return this.removeFirst();
    }
    if (index == this.length - 1) {
      return this.removeLast();
    }
    Node temp = this.head;
    Node pre = null;
    for (int i = 0; i < index; i++) {
      pre = temp;
      temp = temp.next;
    }
    pre.next = temp.next;
    length--;
    return temp;
  }

  public void printList() {
    Node currentNode = this.head;
    while (currentNode != null) {
      System.out.println(currentNode.value);
      currentNode = currentNode.next;
    }
  }

  public Node findKthFromEnd(int k) {
    if (k <= 0) {
      return null;
    }
    Node slow = head;
    Node fast = head;

    for (int i = 0; i < k; i++) {
      if (fast == null) {
        System.out.println("null");
        return null;
      }
      fast = fast.next;
    }

    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }
    assert slow != null;
    System.out.println(slow.value);
    return slow;
  }

  // wrong;;
//  public void partitionList(int x) {
//    if (this.head == null) {
//      return;
//    }
//    Node temp = this.head;
//    Node beforeStart = null;
//    Node beforeMove = null;
//    Node moveStart = null;
//    Node moveEnd = null;
//    Node stand = null;
//    boolean checkMoveStart = false;
//    boolean findStand = false;
//    while (temp.next != null) {
//      if (temp.value < x && !findStand) {
//        beforeStart = temp;
//      }
//      if(temp.value==x){
//        stand=temp;
//        findStand=true;
//      }
//      if(temp.value>x){
//        beforeMove=temp;
//      }
//      if( findStand&&temp.value <x && !checkMoveStart){
//        moveStart = temp;
//        checkMoveStart = true;
//      }
//      temp = temp.next;
//      if(temp.next!=null){
//        moveEnd=temp.next;
//      }
//    }
//    System.out.println("moveStart = " + moveStart.value);
//    System.out.println("moveEnd = " + moveEnd.value);
//    System.out.println("beforeStart = " + beforeStart.value);
//    beforeStart.next = moveStart;
//    moveEnd.next = stand;
//    beforeMove.next=null;
//  }

  public void partitionList(int x) {
    if (head == null || head.next==null) return;

    Node n1 = new Node(0);
    Node n2 = new Node(0);
    Node pre1 = n1;
    Node pre2 = n2;
    Node cur = this.head;
    while(cur!=null){
      if(cur.value<x){
        pre1.next=cur;
        pre1 = cur;
      }else{
        pre2.next=cur;
        pre2 = cur;
      }
      cur = cur.next;
    }

    pre2.next=null;
    pre1.next = n2.next;
    this.head = n1.next;

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

}
