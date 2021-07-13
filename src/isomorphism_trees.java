import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class isomorphism_trees {
    String get_tree_string(HashMap<Integer, LinkedList<Integer>> tree, int node) {
        String cur_str = "0";
        for (int cur_node : tree.get(node)) {
            cur_str = cur_str + get_tree_string(tree, cur_node);
        }
        cur_str = cur_str + "1";
        return cur_str;
    }

    LinkedList<Integer> get_center(HashMap<Integer, LinkedList<Integer>> tree) {
        Queue<Integer> leaves = new ArrayDeque<>();
        LinkedList<Integer> centers = new LinkedList<>();
        int ver_size = tree.size(), leaf_counter = ver_size, neighbors, temp_leaf;
        int[] degree = new int[ver_size];
        for (int key : tree.keySet()) {
            neighbors = tree.get(key).size();
            degree[key] = neighbors;
            if (neighbors == 1) {
                leaves.add(key);
            }

        }
        while (leaf_counter > 2) {
            Queue<Integer> leaves_temp = new ArrayDeque<>();
            while (!leaves.isEmpty()) {
                temp_leaf = leaves.poll();
                for (int neighbor : tree.get(temp_leaf)) {
                    if (degree[neighbor] > 0) {
                        degree[temp_leaf] = 0;
                        degree[neighbor] -= 1;
                        if (degree[neighbor] == 1) {
                            leaves_temp.add(neighbor);
                        }
                        leaf_counter--;
                    }
                }
            }
            leaves = leaves_temp;
        }
       while(!leaves.isEmpty())
       {
           centers.add(leaves.poll());
       }
       return centers;
    }



        boolean isomorphism_in_trees(HashMap<Integer, LinkedList<Integer>>tree1,HashMap<Integer, LinkedList<Integer>>tree2)
        {
            LinkedList<Integer> get_center1 = get_center(tree1);
            LinkedList<Integer> get_center2 = get_center(tree2);
            String str1,str2;
            for (int center:get_center1) {
                str1 = get_tree_string(tree1,center);
                for (int center2: get_center2) {
                    str2 = get_tree_string(tree2,center2);
                    if(str1.equals(str2))
                        return true;
                }
            }
            return false;
        }
        }
