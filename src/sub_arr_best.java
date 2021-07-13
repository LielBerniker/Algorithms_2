public class sub_arr_best {
    public static int[] regular_best(int []arr)
    {
        int max = Integer.MIN_VALUE,start=0,end=0,start_temp =0,end_temp = 0,k=0;
        int [] arr_t = new int[arr.length];
            arr_t[0] = arr[0];
            for (int i = 1; i <arr_t.length; i++) {
                if(arr_t[i-1] <=0) {
                    arr_t[i] = arr[i];
                    start_temp = i;
                    end_temp = i;
                }
                else
                {
                    arr_t[i] = arr_t[i-1] + arr[i];
                    if(arr_t[i] <=0 )
                    {
                        arr_t[i]= arr[i];
                    }
                    end_temp++;
                }
                if(arr_t[i]>max)
                {
                    max = arr_t[i-1];
                    start = start_temp;
                    end = end_temp;
                }
            }
        int [] arr_n = new int[end-start+1];
        for (int i = start; i <=end ; i++) {
            arr_n[k] = arr[i];
            k++;
        }
        return arr_n;
    }
    public static void main (String []args)
    {
        int [] arr = {7,-7,3,9,-15,2};
        int [] arr_temp = regular_best(arr);
        print_arr(arr_temp);

    }
    public static void print_arr(int[] arr)
    {
        for (int i = 0; i <arr.length ; i++) {
                System.out.print(arr[i] + ",");
        }
        System.out.println();
    }
}
