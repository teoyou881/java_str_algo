package dataStrucrues.linkedList;

public class Main {

  public static void main(String[] args) {
    LinkedList ll = new LinkedList(4);
    ll.append(6);
    ll.append(9);
    ll.append(10);
    ll.append(2);
    ll.append(1);

    ll.printList(); // Output: 4 6 9 10 2 1


    ll.partitionList(5);

    ll.printList(); // Output: 4 2 1 6 9 10

  }
}