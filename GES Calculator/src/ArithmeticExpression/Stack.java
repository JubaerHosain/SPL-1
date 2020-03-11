package ArithmeticExpression;

import java.util.Objects;

public class Stack<T> {
    private T stack[];
    private  int top, MAX;

    public Stack(){
        MAX = 100;
        top = -1;
        stack = (T[]) new Object[MAX];
    }

    public void push(T data){
         if(top <= MAX-1){
             stack[++top] = data;
         }
         else {
             System.out.println("Stack Overflow!");
             return;
         }
    }

    public void pop(){
        if(!isEmpty()) {
           top--;
        }
        else {
            System.out.println("Stack Underflow");
        }
    }

    public T top(){
        if(top > -1 && top <= MAX-1){
            return stack[top];
        }
        else {
            return stack[0];
        }
    }

    public boolean isEmpty(){
        if(top <= -1){
            return true;
        }
        else {
            return false;
        }
    }
}
