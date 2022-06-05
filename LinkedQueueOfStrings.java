public class LinkedQueueOfStrings {
    
    private Node first; //refers to the first node in the linked list
    private Node last; //refers to the last node in the linked list

    private class Node{ //inner class of Node
        private String item; //reference to a string object
        private Node next; //reference to a node object
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void enqueue(String item){
        Node oldLast = last; //sets oldLast to equal the value at last
        last = new Node(); //creates a new node for last to reference
        last.item = item; //sets last to reference the item
        last.next = null; //sets the value after last to be null
        if(isEmpty()){
            first = last; //has first and last both referencing the same item
        }else{
            oldLast.next = last; //sets oldLast to point to last next
        }
    }

    public String dequeue(){
        String item = first.item; //item takes the value of whatever first is referencing
        first = first.next; //first is now pointing to the next node 
        if(isEmpty()){
            last = null;
        }
        return item; //returns the item that was taken out of the node sequence
    }
}
