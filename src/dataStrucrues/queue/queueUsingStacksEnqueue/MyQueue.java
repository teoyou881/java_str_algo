package dataStrucrues.queue.queueUsingStacksEnqueue;
import java.util.Stack;

public class MyQueue {
  private Stack<Integer> stack1;
  private Stack<Integer> stack2;

  public MyQueue() {
    stack1 = new Stack<>();
    stack2 = new Stack<>();
  }

  public void enqueue(int value){
    if(isEmpty()){
      stack1.push(value);
    }else{
      while(!stack1.empty()){
        stack2.push(stack1.pop());
      }
      stack1.push(value);
      while(!stack2.empty()){
        stack1.push(stack2.pop());
      }
    }
  }

  public int peek() {
    return stack1.peek();
  }

  public boolean isEmpty() {
    return stack1.isEmpty();
  }
}
