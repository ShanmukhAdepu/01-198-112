public class StackArray {
    
    public class FixedCapacityStackOfStrings{
        private String[] s;
        private int n = 0;
    }

    public FixedCapacityStackOfStrings (int capacity){
        s = new String[capacity];
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public void push(String item){
        s[n++] = item;
        //sets item to n, then increments n
    }

    public String pop(){
        return s[--n];
        //decrements n
    }
}
