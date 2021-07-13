public class sub_arr_max_sum {
    public static int[] max_arr_sum_with_mat(int []arr)
    {
        int max = Integer.MIN_VALUE,start=0,end=0,k=0;
        int [][]mat = new int[arr.length][arr.length];
        for (int i = 0; i <arr.length ; i++) {
            for (int j = i; j <arr.length; j++) {
                if(i==j)
                    mat[i][j] = arr[i];
                else
                    mat[i][j]= mat[i][j-1] + arr[j];
                if(mat[i][j]>max)
                {  max = mat[i][j];
                start = i;
                end = j;}
            }
        }
        int [] arr_n = new int[end-start+1];
        for (int i = start; i <=end ; i++) {
            arr_n[k] = arr[i];
            k++;
        }
   return arr_n;
    }
    public static int[] max_arr_sum_with_arr_1(int []arr)
    {
        int temp_i=0,temp_j=0,temp_sum = arr[0],max=Integer.MIN_VALUE,max_i=Integer.MIN_VALUE,max_j=Integer.MIN_VALUE;
        for (int i =1; i < arr.length; i++) {
            if(temp_sum+arr[i]<0)
            {
                if(temp_sum>max) {
                    max = temp_sum;
                    max_i = temp_i;
                    max_j = temp_j;
                }
                temp_i = i+1;
                temp_j = i+1;
                temp_sum = 0;
            }
            else
            {
                temp_sum += arr[i];
                temp_j = i;
            }
        }
        int [] arr_n = new int[max_j-max_i + 1];
        int k=0;
        for (int i = max_i; i <=max_j ; i++) {
            arr_n[k] = arr[i];
            k++;
        }
        return arr_n;
    }
    public static int[] max_arr_sum_with_arr_2(int []arr)
    {
        int temp_i=0,temp_j=0,temp_sum = arr[0],max=Integer.MIN_VALUE,max_i=Integer.MIN_VALUE,max_j=Integer.MIN_VALUE;
        int [] arr_temp = new int[arr.length];
        arr_temp[0] = arr[0];
        for (int i =1; i < arr.length; i++) {
            if(arr_temp[i-1] == Integer.MAX_VALUE)
            {
                arr_temp[i] = arr[i];
            }
            else {
                if (arr_temp[i - 1] + arr[i] < 0) {
                    arr_temp[i] = Integer.MAX_VALUE;
                    temp_j= i+1;
                    temp_j = i+1;
                } else {
                    arr_temp[i] = arr_temp[i] + arr[i];
                    temp_j++;
                }
            }
            if(arr_temp[i]>max)
            {
              max = arr_temp[i];
              max_i = temp_i;
              max_j = temp_j;
            }
        }
        int [] arr_n = new int[max_j-max_i + 1];
        int k=0;
        for (int i = max_i; i <=max_j ; i++) {
            arr_n[k] = arr[i];
            k++;
        }
        return arr_n;
    }
}
