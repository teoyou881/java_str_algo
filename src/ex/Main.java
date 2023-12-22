package ex;
public class Main {

  static String reverseString(String s){
    Stack stack = new Stack();
    for (int i=0;i<s.length();i++ ){
      char tmp = s.charAt(i);
      stack.push(tmp);
    }
    Stack returnStack = new Stack();
    StringBuilder sb= new StringBuilder();
    while(stack.size()!=0){
      sb.append(stack.pop());
    }
    return String.valueOf(sb);
  }



  public static void main(String[] args) {

    String myString = "hello";
    String reversedString = reverseString(myString);
    System.out.println(reversedString);

        /*
            EXPECTED OUTPUT:
            ----------------
            olleh
        */

  }

}
