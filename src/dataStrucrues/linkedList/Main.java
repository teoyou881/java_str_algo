package dataStrucrues.linkedList;
public class Main {

  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList(10);
    linkedList.append(5);
    linkedList.append(16);
    linkedList.delete(5);
    linkedList.printList();
  }
}
