import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class burn_algorithm {
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
}
