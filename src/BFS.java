import java.util.*;

public class BFS {
    public static  HashMap<Integer,Integer> bfs_regular(HashMap<Integer,ArrayList<Integer>> graph, int node)
    {
        Queue<Integer> prior = new ArrayDeque<>();
        HashMap<Integer,String> colors = new HashMap<>();
        HashMap<Integer,Integer> distance = new HashMap<>();
        for (int temp_node: graph.keySet()) {
              colors.put(temp_node,"white");
              distance.put(temp_node,Integer.MAX_VALUE);
        }
        colors.put(node,"");
        distance.put(node,0);
        prior.add(node);
        while (!prior.isEmpty())
        {
            int temp_node = prior.poll();
            for (int neighbor :graph.get(temp_node)) {
                if(colors.get(neighbor) =="white")
                {
                    colors.put(neighbor,"grey");
                    distance.put(neighbor,distance.get(temp_node)+1);
                    prior.add(neighbor);
                }
            }
            colors.put(temp_node,"black");
        }
        return distance;
    }
    public static boolean is_connected(HashMap<Integer,ArrayList<Integer>> graph)
    {
        int key = (int) graph.keySet().toArray()[0];
        HashMap<Integer,Integer> distance = bfs_regular(graph,key);
        for (int temp_node:graph.keySet()) {
            if(distance.get(temp_node) == Integer.MAX_VALUE)
            {
                return false;
            }
        }
        return true;
    }
    public static int connection_parts(HashMap<Integer,ArrayList<Integer>> graph)
    {
        int count = 0;
        HashMap<Integer,Integer> hold_con = new LinkedHashMap<>();
        HashMap<Integer,Integer> distance;
        for (int cur_node: graph.keySet()) {
            if(hold_con.get(cur_node) == null) {
                count++;
                distance = bfs_regular(graph, cur_node);
                hold_con.put(cur_node,cur_node);
                for (int temp_node:distance.keySet()) {
                    if(distance.get(temp_node)!=Integer.MAX_VALUE)
                    {
                        hold_con.put(temp_node,cur_node);
                    }
                }
            }
        }
        return count;
    }
}
