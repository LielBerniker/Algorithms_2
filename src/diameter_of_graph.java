import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;




// ID : 315708370
public class diameter_of_graph {
    HashMap<Integer, LinkedList<Integer>> graph;
    final int MAX = Integer.MAX_VALUE;
    final int MIN = Integer.MIN_VALUE;
    int ver_size;
    int diam;
    public diameter_of_graph(boolean[][] adj_matrix) {
        graph = new HashMap<>();
        ver_size = adj_matrix.length;
        diam = MIN;
        for (int i = 0; i <ver_size ; i++) {
            LinkedList<Integer> temp_list = new LinkedList<>();
            for (int j = 0; j <ver_size ; j++) {
                if(adj_matrix[i][j])
                {temp_list.add(j);}
            }
            graph.put(i,temp_list);
        }
    }

    public int get_diam() {
        int big_len=MIN,temp_len =0;
        if(diam == MIN) {
            for (int i = 0; i < ver_size; i++) {
                temp_len = get_max_len(i);
                if (temp_len > big_len) {
                    big_len = temp_len;
                }
            }
            diam = big_len;
        }
        return diam;
    }
    public int get_max_len(int node) {
        HashMap<Integer,Integer> distances = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        distances.put(node,0);

        int v,v_dis,max_val = MIN;
        while (q.isEmpty() == false)
        {
            v = q.poll();
            for (Integer cur_nigh: graph.get(v))
            {
                v_dis = distances.get(v);
                if (distances.get(cur_nigh) == null)
                {
                    distances.put(cur_nigh,v_dis+1);
                    q.add(cur_nigh);
                }
                else
                {
                    if(distances.get(cur_nigh)>1+v_dis)
                    {
                        distances.put(cur_nigh,1+v_dis);
                    }
                }
            }
        }
        distances.put(node,MAX);
        for (Integer val: distances.values()) {
            if(val>max_val)
            {
                max_val = val;
            }
        }
        return max_val;
    }


}

