import java.util.NoSuchElementException;

public class Stack <T> { //declaring that the class will have items of type T

    //T CANNOT BE A primitive data type

    private Node first = null; //reference to the first node of the linked list

    private class Node{ //inner class node
        private T item; //reference to an object of type T   
        private Node next; //reference to a node object
    }

    public boolean isEmpty(){
        return first == null; //if first is equal to null that means its an empty stack
    }

    //4 assignments -> O(1)
    public void push(T item){ //inserts the new Node into the beginning of the linked list
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;        
    }

    //4 assignments -> O(1)
    public T pop(){ //removes the first node of the linked list
        if( first == null){
            //throws an exception
            //The execution of the method ends right here
            //returns the message back to the user
            throw new NoSuchElementException("Stack is Empty");
        }
        T item = first.item; //saves the reference to the item that first is referring to
        first = first.next; //removes the first node of the linked list
        return item; //returns the removed item
    }

    public static void main (String args[]){
        Stack<Integer> st = new Stack<Integer>();
        st.push(8);
        st.push(7);
        st.push(6);

        Stack<Character> stC = new Stack<Character>();
        stC.push('I');
        stC.push('H');
        stC.push('A');

        while(!st.isEmpty()){
            System.out.println(st.pop());
        }

        while(!stC.isEmpty()){
            System.out.println(stC.pop());
        }

        Stack<String> stS = new Stack <String>();
        //try and catch block is a way to handle the exception
        try{
            //code in this block can throw an expection
            stS.pop();
        }catch(NoSuchElementException referenceToException){
            //handles the exception
            System.out.println("Oops, my bad");
        }
    }
}
