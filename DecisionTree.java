public class DecisionTree {
    
    public static int indexOf(int[] a, int key){
        int lo = 0;
        int hi = a.length - 1;
        int count = 0;
        int comp = 0;   

        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            count++;
            if(key == a[mid]){
                comp++;
                System.out.println("The current count is: " + count);
                System.out.println("The current array index is: " + mid);
                System.out.println("The current number of comparisons is: " + comp);
                System.out.println(" ");
                return mid;
            }
            if(key < a[mid]){
                hi = mid - 1;
                comp += 2;

            }else{
                comp += 2;
                lo = mid + 1;
            }
            System.out.println("The current count is: " + count);
            System.out.println("The current array index is: " + mid);
            System.out.println("The current number of comparisons is: " + comp);
            System.out.println(" ");
        }
        return -1; //indicates that the key is not present within this array
    }

    public static void main(String[] args){
        int[] a = {11,12,17,19,26,38,45,62,69,83};
        int key = 18;

        if(indexOf(a, key) == -1){
            System.out.println("The index of the key was not found");
        }else{
            System.out.println("The index of the key " + key + " is: " + indexOf(a, key));
        }
    }
}
