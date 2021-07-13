
public class graph_in_mat {

        public static int[] connected_component(double [][] mat)
        {
            Floyd_Warshall(mat);
            int [] all_compo = new int[mat.length];
            for (int i = 0; i <all_compo.length ; i++) {
                all_compo[i] = Integer.MAX_VALUE;
            }
            for (int i = 0; i < all_compo.length; i++) {
                if(all_compo[i] ==  Integer.MAX_VALUE) {
                    all_compo[i] = i;
                    for (int j = 0; j < all_compo.length; j++) {
                        if(mat[i][j] == 1)
                            all_compo[j] = i;
                    }
                }
            }
            return all_compo;
        }
        public static boolean connected_graph(double [][] mat)
        {
            Floyd_Warshall(mat);
            for (int i = 0; i < mat.length ; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if(mat[i][j] == 0)
                        return false;
                }
            }
            return true;
        }
        public static void Floyd_Warshall(double [][] mat)
        {
            for (int k = 0; k <mat.length ; k++) {
                for (int i = 0; i < mat.length; i++) {
                    for (int j = 0; j < mat.length ; j++) {
                       Math.min(mat[i][j],mat[k][j] + mat[i][k]);
                    }
                }
            }
        }
    public static double[][] graph_neighbor(weighted_graph g1) {
        double[][] mat = new double[g1.nodeSize()][g1.nodeSize()];

        for (int i = 0; i <g1.nodeSize(); i++) {
            for (int j = 0; j <g1.nodeSize(); j++) {
                if (i==j)
                    mat[i][j] =0;
                else if(g1.hasEdge(i,j))
                    mat[i][j] =g1.getEdge(i,j);
            }
        }
        return mat;
    }
    public static int getIndex(int i, int j, int n)
    {
        return (n+1)*i + j;
    }
    public static void print_mat(double[][] mat)
    {
        for (int i = 0; i <mat.length ; i++) {
            for (int j = 0; j <mat[0].length ; j++) {
                System.out.print(mat[i][j] + ",");
            }
            System.out.println();
        }
    }
}
