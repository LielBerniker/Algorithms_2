import java.util.*;

// ID : 315708370
public class AllDistances {
    private int[] vertices;
    private int[][] edges_all;
    private int[] per_u;
    private int[] per_v;
    final int inf = 1000000;
    private int min_index;

    public AllDistances(int[] vertices_weights, int[][] edges_weights) {
        this.vertices = vertices_weights;
        this.edges_all = edges_weights;
        int ver_len = vertices.length;
        per_u = new int[ver_len];
        per_v = new int[ver_len];
        min_index = -1;
    }

    public int[][] distance_matrix() {
        int ver_len = vertices.length;
        int[][] dis_mat = new int[ver_len][ver_len];
        for (int i = 0; i < ver_len; i++) {
            for (int j = 0; j < ver_len; j++) {
                if (i == j) {
                    dis_mat[i][j] = vertices[i];
                } else {
                    if (edges_all[i][j] == inf) {
                        dis_mat[i][j] = inf;
                    } else {
                        dis_mat[i][j] = vertices[i] + vertices[j] + edges_all[i][j];
                    }
                }
            }
        }
        for (int k = 0; k < ver_len; k++) {
            for (int i = 0; i < ver_len; i++) {
                for (int j = 0; j < ver_len; j++) {
                    if (i != j) {
                        if (dis_mat[i][j] > (dis_mat[i][k] + dis_mat[k][j]) - vertices[k]) {
                            dis_mat[i][j] = (dis_mat[i][k] + dis_mat[k][j] - vertices[k]);
                        } else {
                            dis_mat[i][j] = dis_mat[i][j];
                        }
                    }
                }
            }
        }
        return dis_mat;
    }

    public int distance(int u, int v) {
        if (u == v)
            return vertices[u];
        return two_way_Dijkstra(u, v);
    }

    private int two_way_Dijkstra(int u, int v) {
        u = u - 1;
        v = v - 1;
        int ver_len = vertices.length;
        boolean[] visited_u = new boolean[ver_len];
        boolean[] visited_v = new boolean[ver_len];
        int[] dist_u = new int[ver_len];
        int[] dist_v = new int[ver_len];
        int distance;
        for (int i = 0; i < ver_len; i++) {
            dist_u[i] = inf;
            per_v[i] = -1;
            dist_v[i] = inf;
            per_u[i] = -1;
            visited_u[i] = false;
            visited_v[i] = false;
        }
        dist_u[u] = vertices[u];
        dist_v[v] = vertices[v];
        per_u[u] = -1;
        per_v[v] = -1;

        int v_s, v_v;
        boolean inProcess = true;

        while (inProcess == true) {
            if (inProcess == true && ((v_s = ExtractMin(dist_u, visited_u)) != -1)) {
                for (int i = 0; i < ver_len; i++) {
                    if (edges_all[v_s][i] != inf) {
                        distance = dist_u[v_s] + edges_all[v_s][i] + vertices[i];
                        if (visited_u[i] == false && (dist_u[i] > distance)) {
                            dist_u[i] = distance;
                            per_u[i] = v_s;
                        }
                    }
                }
                visited_u[v_s] = true;
                if (visited_u[v_s] == true && visited_v[v_s] == true) {
                    inProcess = false;
                }
            }
            if (inProcess == true && ((v_v = ExtractMin(dist_v, visited_v)) != -1)) {
                for (int i = 0; i < ver_len; i++) {
                    if (edges_all[v_v][i] != inf) {
                        distance = dist_v[v_v] + edges_all[v_v][i] + vertices[i];
                        if (visited_v[i] == false && (dist_v[i] > distance)) {
                            dist_v[i] = distance;
                            per_v[i] = v_v;
                        }
                    }
                }
                visited_v[v_v] = true;
                if (visited_u[v_v] == true && visited_v[v_v] == true) {
                    inProcess = false;
                }
            }
        }

        int min = inf;
        for (int i = 0; i < ver_len; i++) {
            if ((visited_u[i] || visited_v[i]) && dist_u[i] != inf && dist_v[i] != inf) {
                if (min > dist_u[i] + dist_v[i] - vertices[i]) {
                    min = dist_u[i] + dist_v[i] - vertices[i];
                    min_index = i;
                }
            }
        }
        return min;
    }

    private int ExtractMin(int[] dist, boolean[] visited) {
        int minIndex = Integer.MAX_VALUE, MinValue = Integer.MAX_VALUE;
        int ver_len = vertices.length;
        for (int i = 0; i < ver_len; i++) {
            if (visited[i] == false && dist[i] < MinValue) {
                minIndex = i;
                MinValue = dist[i];
            }
        }
        return minIndex;
    }

    public String path(int u, int v) {
        int cur_per;
        String path = "";
        if (u == v)
            return "v";
        if (two_way_Dijkstra(u, v) == inf)
            return path;
        cur_per = min_index;
        while (per_u[cur_per] != -1) {
            path = "-" + (cur_per + 1) + path;
            cur_per = per_u[cur_per];
        }
        path = (cur_per + 1) + path;
        cur_per = min_index;
        while (cur_per != -1) {
            if (cur_per != min_index) {
                path = path + "-" + (cur_per + 1);
            }
            cur_per = per_v[cur_per];
        }
        return path;
    }
}
