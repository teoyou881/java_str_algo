package dataStrucrues.stack;
public class Main {

  public static void main(String[] args) {

    Stack myStack = new Stack(2);

    System.out.println("Before push():");
    System.out.println("--------------");
    myStack.getTop();
    myStack.getHeight();

    System.out.println("\nStack:");
    myStack.printStack();

    myStack.push(1);

    System.out.println("\n\nAfter push():");
    System.out.println("-------------");
    myStack.getTop();
    myStack.getHeight();

    System.out.println("\nStack:");
    myStack.printStack();

        /*
            EXPECTED OUTPUT:

			Before push():
			--------------
			Top: 2
			Height: 1

			Stack:
			2


			After push():
			-------------
			Top: 1
			Height: 2

			Stack:
			1
			2

        */

    System.out.println("-----------------------------\n\n\n\n");

    Stack newStack = new Stack(2);
    newStack.push(1);

    // (2) Items - Returns 1 Node
    System.out.println(newStack.pop().value);
    // (1) Item - Returns 2 Node
    System.out.println(newStack.pop().value);
    // (0) Items - Returns null
    System.out.println(newStack.pop());


        /*
            EXPECTED OUTPUT:
            ----------------
            1
            2
            null

        */



  }
}
