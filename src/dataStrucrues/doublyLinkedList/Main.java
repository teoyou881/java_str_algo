package dataStrucrues.doublyLinkedList;
public class Main {

  public static void main(String[] args) {




    DoublyLinkedList myDLL = new DoublyLinkedList(0);
    myDLL.append(1);
    myDLL.append(2);
    myDLL.append(3);

    System.out.println("myDLL.get(1).value = " + myDLL.get(1).value);
    System.out.println("myDLL.get(2).value = " + myDLL.get(2).value);
    System.out.println("myDLL.get(3).value = " + myDLL.get(3).value);

    myDLL.printList();


        /*
            EXPECTED OUTPUT:
            ----------------
            3

        */

  }
}
