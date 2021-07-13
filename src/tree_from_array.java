import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class tree_from_array {
   public static HashMap<Integer, LinkedList<Integer>> arr_to_tree(int [] arr)
    {
        int size = arr.length;
        HashMap<Integer, LinkedList<Integer>> tree_arr = new HashMap<>();
        if(!check_conversion_to_tree(arr))
        {
            return tree_arr;
        }
        Arrays.sort(arr);
        for (int i = 0; i < size; i++) {
            LinkedList<Integer> temp_neighbor = new LinkedList<>();
            tree_arr.put(i,temp_neighbor);
        }
        for (int i = 0; i <size-2 ; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[j] != 1)
                {
                    tree_arr.get(i).add(j);
                    tree_arr.get(j).add(i);
                    arr[j]-=1;
                    arr[i] = 0;
                    break;
                }
            }
        }
        tree_arr.get(size-2).add(size-1);
        tree_arr.get(size-1).add(size-2);
  return tree_arr;
    }
    public static boolean check_conversion_to_tree(int [] arr)
    {
        double size = arr.length;
        double sum = 0;
        for (int i = 0; i <(double)size; i++) {
            sum+= (double) arr[i];
        }
        sum = sum/2 + 1;
        if(sum!=size)
            return false;
        return true;
    }
    public static void main(String [] args)
    {
        int [] arr = {1,1,1,1,2,2,3,3};
        HashMap<Integer,LinkedList<Integer>> tree = arr_to_tree(arr);
        for (int key:tree.keySet()) {
            System.out.print("the key is: " + key+ " neighbors :");
            for (int val:tree.get(key)) {
                System.out.print(" ," + val);
            }
            System.out.println();
        }
    }
}
