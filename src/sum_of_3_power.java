public class sum_of_3_power {
    public static void main(String [] args)
    {
        int a  = 22;
        sum_of_3_pow(a);

    }
    public static boolean sum_of_3_pow(int num)
    {
        String sum = "";
        if(num == 1)
        {
            System.out.println("3 pow 0 = 1");
        }
        if(num == 0)
        {
            return false;
        }
        if(num%3 == 0 )
        {
            print_sum(num,sum);
        }
        else if((num-1)%3 == 0)
        {
            sum = sum + "3 pow 0 ";
            print_sum(num-1,sum);
        }

        return false;
    }
    public static void print_sum(int num,String sum)
    {
        int num_temp = num;
        double power=0;
        double temp_3;
        boolean go_on = true;
        int add = 1;
        if(sum.equals(""))
        {
           add = 0;
        }
        while(go_on)
        {
            temp_3 = 1;
            power = 0;
            while(temp_3<num_temp)
            {
                power++;
                temp_3 =  Math.pow(3,power);
            }
            if(temp_3 == num_temp)
            {
                sum = sum + " + 3 pow " + (int)(power);
                go_on = false;
            }
            else
            {
                power--;
                sum = sum + " + 3 pow " + (int)(power);
                num_temp -= Math.pow(3,power);
            }

        }
        sum = sum + " = " + (num+add);
        System.out.println(sum);
    }
}
