package dataStrucrues.binarySearchTree;
import org.w3c.dom.Node;

public class BinarySearchTree {
  Node root;

  class Node{
    int value;
    Node left;
    Node right;
    private Node(int value){
      this.value = value;
    }
  }
}
