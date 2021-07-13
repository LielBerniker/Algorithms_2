import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// ID : 315708370
public class Diameter {
    HashMap<Integer, HashMap<Integer, Integer>> graph;
    int[] degree;
    Queue<Integer> leaves;
    final int MIN = Integer.MIN_VALUE;
    int ver_size;
    int diam;

    public Diameter(boolean[][] adj_matrix) {
        int neighbors;
        graph = new HashMap<>();
        leaves = new ArrayDeque<>();
        ver_size = adj_matrix.length;
        degree = new int[ver_size];
        diam = MIN;
        for (int i = 0; i < ver_size; i++) {
            neighbors = 0;
            HashMap<Integer, Integer> temp_neighbor = new HashMap<>();
            for (int j = 0; j < ver_size; j++) {
                if (adj_matrix[i][j]) {
                    temp_neighbor.put(j, j);
                    neighbors++;
                }
            }
            degree[i] = neighbors;
            if(neighbors==1)
            {
                leaves.add(i);
            }
            graph.put(i, temp_neighbor);
        }
    }

    public int get_diam() {
        if (diam == MIN) {
            int leaf_counter = ver_size,burn_count = 0,temp_leaf;
            while (leaf_counter>2)
            {
                burn_count++;
                Queue<Integer> leaves_temp = new ArrayDeque<>();
              while(!leaves.isEmpty())
              {
               temp_leaf = leaves.poll();
                  for (int neighbor:graph.get(temp_leaf).keySet()) {
                       degree[temp_leaf] = 0;
                       degree[neighbor] -=1;
                       graph.get(neighbor).remove(temp_leaf);
                       if(degree[neighbor] == 1)
                       {
                           leaves_temp.add(neighbor);
                       }
                       leaf_counter--;
                  }
              }
              leaves = leaves_temp;
            }
            if (leaf_counter==2){
                burn_count++;
                diam = burn_count*2 - 1;
            }
            else diam = burn_count*2;
        }
        return diam;
    }


}
