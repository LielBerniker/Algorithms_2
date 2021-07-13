public class gas_station_algorithm {
    public static int gas_station_algo(int [] gas_amount,int[] way_cost)
    {
        int [] arr_check  = new int[gas_amount.length];
        for (int i = 0; i <arr_check.length ; i++) {
            arr_check[i] = gas_amount[i] - way_cost[i];
        }
   return regular_best_round_double_arr(arr_check);
    }
    public static int regular_best_round_double_arr(int []arr)
    {
        int max = Integer.MIN_VALUE,temp_max=0,start = 0;
        int [] arr_2 =multiply_2(arr);
        for (int i = 0; i <arr.length ; i++) {
            int [] arr_temp = create_arr(i,i+arr.length-1,arr_2);
            temp_max = regular_best(arr_temp);
            if(temp_max>max)
            {
                max = temp_max;
                start = i;
            }
        }
        return start;
    }
    public static int regular_best_round_minus_arr(int []arr)
    {
        int max = Integer.MIN_VALUE,minus_max=0,sum = 0;
        int [] arr_minus = new int[arr.length];
        for (int i = 0; i <arr_minus.length ; i++) {
            arr_minus[i] = -1*arr[i];
            sum +=arr[i];
        }
        max = regular_best(arr);
        minus_max = regular_best(arr_minus);
        return  Math.max(sum-(-minus_max),max);

    }
    public static int [] multiply_2(int [] arr)
    {
        int [] arr_temp = new int[arr.length+arr.length];
        for (int i = 0; i <arr.length ; i++) {
            arr_temp[i] = arr[i];
            arr_temp[i+arr.length] = arr[i];
        }
        return  arr_temp;
    }
    public static void main (String []args)
    {
        int [] arr = {7,-7,3,9,-15,2};
        int max_1 = regular_best(arr);

    }
    public static int [] create_arr(int start, int end,int [] arr)
    {
        int [] arr_temp = new int[end-start+1];
        int k = 0;
        for (int i = start; i <= end; i++) {
            arr_temp[k] = arr[i];
        }
        return arr_temp;
    }

    public static int regular_best(int []arr)
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
        return max;
    }


}
