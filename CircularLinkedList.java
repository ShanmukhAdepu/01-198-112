import java.util.NoSuchElementException;

public class CircularLinkedList<T> {
    
    Node<T> last; //a reference to the last node
    int size; //the number of items in the list

    private class Node<T>{

        //the instance variables of the Node
        T data; //this data is of type T
        Node<T> next; //reference to the next node in the list
    }

    public boolean isEmpty(){ //checks to see if the list is empty

        return last == null;

    }

    public void addToFront(T newData){

        //creates a new Node
        Node<T> n = new Node<T>();
        n.data = newData;

        if(isEmpty()){
            //list is empty
            n.next = n; //n points to itself
            last = n; //sets a one list item
        }else{
            n.next = last.next; //last.next represents the current first variable and this puts n in the front
            last.next = n; //last now points to the front variable n in this circular linked list
        }

        size += 1; //increases the size by 1

    }

    public void traverse(){

        if(isEmpty()){
            throw new NoSuchElementException(); //the execution of the traverse stops right here and goes back to the caller
        }
        Node<T> ptr = last.next; //starts at the first Node
        do{ //this block of code executes as long as the while loop statement at the bottome remains true
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }while(ptr != last.next);
        System.out.println("Points back to the first Node");

    }

    public T removeFront(){
        if (isEmpty()) {
            throw new NoSuchElementException("CLL is empty");        
        }
        T frontdata = last.next.data; //picks out the first Node of the circular linked list
        //removes the front Node
        last.next = last.next.next; //the first Node is now the second Node
        return frontdata; //returns the removed Node
    }
    public static void main (String[] args){

        CircularLinkedList<Integer> cll = new CircularLinkedList<Integer>(); //creates the circular linked list for integer types
        cll.addToFront(8);
        cll.addToFront(7);
        cll.addToFront(6);
        cll.addToFront(5);
        cll.traverse();
        cll.removeFront();
        cll.traverse();

        CircularLinkedList<Character> cllc = new CircularLinkedList<Character>();
        try{
            //methods that can throw an exception
            cllc.removeFront();
        }catch(NoSuchElementException exception){ //looks for this exception to appear and then performs the next code block
            System.out.println("Oh well that's life");
            exception.printStackTrace();

        }
    }
}
