public class LinkedStackOfStrings {
    
    private Node first = null; //reference to the first node of the linked list

    private class Node{ //inner class for Node

        private String item; //reference to a string object
        private Node next; //reference to a Node object

    }

    public boolean isEmpty() { //returns true if empty

        return first == null; //if first is null then there is a empty stack

    }

    public void push (String item){ //inserting a new node with an item in the beginning of the linked list

        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        //running time is O(1)
        //1 array access per push

    }

    public String pop(){ //removes the first node of the linked list

        String item = first.item; //saving the reference to a string item
        first = first.next; //removes the first node of the linked list
        return item;
        //running time is O(1)

    }

    public static void main (String[] args){

        //testing the client
        LinkedStackOfStrings stack = new LinkedStackOfStrings();
        stack.push("I");
        stack.push("have");
        stack.push("a");
        stack.push("dream");
        stack.push("!");

        while (!stack.isEmpty()){
            String value = stack.pop();
            System.out.println(value);
        }
    }
}
