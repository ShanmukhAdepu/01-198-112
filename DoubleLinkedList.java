public class DoubleLinkedList <T> {
    
    private Node<T> first;
    private int size;

    //inner class
    private class Node<T>{
        T data; //the data we want to store
        Node<T> prev; //linked to the previous node on the list
        Node<T> next; //linked to the next node on the list

        public Node(T newData){
            this.data = newData;
            this.prev = null;
            this.next = null;
        }
    }

    public DoubleLinkedList(){
        first = null;
        size = 0;
    }

    public void addToFront(T newData){
        Node<T> n = new Node<T>(newData);
        n.next = first; //has n pointing to first
        if(first != null){
            //the list is not empty
            first.prev = n; //has whatever node first is referrencing, point back to n
        }
        first = n; //has n be known as the knew first 
        size += 1; //increases the size by 1
    }

    public void traverse(){ //prints out every variable in the double linked list
        Node<T> ptr = first; //has the pointer referencing the first node
        System.out.print("null <--> ");
        while(ptr != null){ //keeps going until pointer is referencing null
            System.out.print(ptr.data + " <--> "); //prints out the node data that pointer is referencing
            ptr = ptr.next; //sets pointer to reference the next node in the double linked list
        }
        System.out.print("null");
    }

    public static void main(String args[]){
        DoubleLinkedList<String> songs = new DoubleLinkedList<String>();
        songs.addToFront("BadGuy");
        songs.addToFront("CopyCat");
        songs.addToFront("Love Again");
        songs.traverse();

    }


}
