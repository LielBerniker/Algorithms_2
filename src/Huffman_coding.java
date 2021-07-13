import java.util.HashMap;

public class Huffman_coding {
    public class letter
    {
        char c;
        double percent;
        public letter(char c2,double per2)
        {
            this.c = c2;
            this.percent = per2;
        }
    }
    public class node
    {
        char c1;
        double per;
        int prv;
        int left;
        int right;
        boolean flag;
        String code;
        public node(char c2,double per2)
        {
            this.c1 = c2;
            this.per = per2;
            left = -1;
            right = -1;
            prv = -1;
            flag = false;
            code = "";
        }

    }
    public  HashMap<Integer,node> hoffman_code_hash(letter[] arrl)
    {
      HashMap<Integer,node> tree_per = new HashMap<>();
      boolean flag = true;
      int i = 0,j=0;
        for (letter let:arrl) {
            node n = new node(let.c,let.percent);
            tree_per.put(i++,n);
        }
        while (j!=1)
        {
            double min1=110, min2=110;
            int index_1 = -1,index_2 = -1;
            for (int index_temp:tree_per.keySet()) {
                if(tree_per.get(index_temp).per<min2)
                {
                    if(tree_per.get(index_temp).per<min1)
                    {
                        min2 = min1;
                        index_2 = index_1;
                        min1 = tree_per.get(index_temp).per;
                        index_1 = index_temp;
                    }
                    min2 = tree_per.get(index_temp).per;
                    index_2 = index_temp;

                }
            }
            tree_per.get(index_1).flag = true;
            tree_per.get(index_2).flag = true;
            tree_per.get(index_1).per=i;
            tree_per.get(index_1).per=i;
            j--;
            node n = new node('@',tree_per.get(index_1).per+tree_per.get(index_2).per);
            n.left = index_1;
            n.right = index_2;
            tree_per.put(i++,n);
        }
        int left_in = tree_per.get(i-1).left;
        int right_in = tree_per.get(i-1).right;
      code(tree_per,left_in,"1");
        code(tree_per,right_in,"0");
        return tree_per;
    }
    public void code(HashMap<Integer,node> tree_per,int index,String coding)
    {

        tree_per.get(index).code = coding;
        if(tree_per.get(index).left!=-1)
        {
            code(tree_per,tree_per.get(index).left,coding+"1");
        }
        if(tree_per.get(index).right!=-1)
        {
            code(tree_per,tree_per.get(index).right,coding+"0");
        }
    }
}
