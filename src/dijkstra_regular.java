import java.util.*;

public class dijkstra_regular {
    public static void dijkstra_regular_all_nodes(weighted_graph graph, int node)
    {
        node_info node_t;
        PriorityQueue<node_info> prior = new PriorityQueue<>();
        for (node_info node_temp: graph.getV()) {
            node_temp.setTag(Double.MAX_EXPONENT);
        }
        graph.getNode(node).setTag(0);
        graph.getNode(node).setInfo(" ");
        prior.add(graph.getNode(node));
        while (!prior.isEmpty())
        {
            node_t = prior.poll();
            int node_key = node_t.getKey();
            for (node_info node_neighbor:graph.getV(node_key)) {
                int neighbor_key = node_neighbor.getKey();
                double distance = node_t.getTag() + graph.getEdge(node_key,neighbor_key);
                if((node_neighbor.getTag())>(distance))
                {
                    node_neighbor.setTag(distance);
                    node_neighbor.setInfo(Integer.toString(node_key));
                    prior.add(node_neighbor);
                }
            }
        }

    }
    public static void dijkstra_regular_specific_node(weighted_graph graph, int node_s,int node_e)
    {
        node_info node_t;
        PriorityQueue<node_info> prior = new PriorityQueue<>();
        for (node_info node_temp: graph.getV()) {
            node_temp.setTag(Double.MAX_EXPONENT);
            node_temp.setInfo("non");
        }
        graph.getNode(node_s).setTag(0);
        graph.getNode(node_s).setInfo(" ");
        prior.add(graph.getNode(node_s));
        while (!prior.isEmpty())
        {
            node_t = prior.poll();
            int node_key = node_t.getKey();
            for (node_info node_neighbor:graph.getV(node_key)) {
                int neighbor_key = node_neighbor.getKey();
                double distance = node_t.getTag() + graph.getEdge(node_key,neighbor_key);
                if((node_neighbor.getTag())>(distance))
                {
                    node_neighbor.setTag(distance);
                    node_neighbor.setInfo(Integer.toString(node_key));
                    prior.add(node_neighbor);
                }
                if(neighbor_key == node_e)
                {
                    return;
                }
            }
        }

    }
    public static List<String> dijkstra_specific_node_way(weighted_graph graph, int node_s, int node_e)
    {
        String prev;
        List<String> way = new LinkedList<>();
        if(node_e==node_s)
        {
            way.add(Integer.toString(node_e));
            return way;
        }
      dijkstra_regular_specific_node(graph,node_s,node_e);
      if(graph.getNode(node_e).getInfo().equals("non"))
      {
          return way;
      }

      way.add(Integer.toString(node_e));
         prev = graph.getNode(node_e).getInfo();
        while (!prev.equals(" ")) {
            way.add(prev);
            int temp_key= Integer.parseInt(prev);
            prev = graph.getNode(temp_key).getInfo();
        }
        Collections.reverse(way);
        return way;


    }

}
