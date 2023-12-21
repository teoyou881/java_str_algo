package dataStrucrues.stack;
import org.w3c.dom.Node;

public class Stack {

  private Node top;
  private int height;

  class Node {

    int value;
    Node next;

    Node(int value) {
      this.value = value;
    }
  }

  public Stack(int value) {
    Node newNode = new Node(value);
    top = newNode;
    height = 1;
  }

  public void printStack() {
    Node temp = top;
    while (temp != null) {
      System.out.println(temp.value);
      temp = temp.next;
    }
  }

  public void getTop() {
    System.out.println("top.value = " + top.value);
  }

  public void getHeight() {
    System.out.println("height = " + height);
  }

  public void push(int value) {
    Node newNode = new Node(value);
    if (height == 0) {
      this.top = newNode;
    } else {
      newNode.next = this.top;
      this.top = newNode;
    }
    height++;
  }

  public Node pop(){
    if(height<1){
      return null;
    }
    Node temp = this.top;
    this.top = top.next;
    temp.next = null;
    height--;
    return temp;

  }
}
