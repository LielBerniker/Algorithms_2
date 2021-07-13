

public class bottles_problem_all_connections {
    public static int[] connected_component(int [][] mat)
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
    public static boolean connected_graph(int [][] mat)
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
    public static void Floyd_Warshall(int [][] mat)
    {
        for (int k = 0; k <mat.length ; k++) {
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length ; j++) {
                    if(mat[i][j] == 1 || (mat[k][j] ==1 && mat[i][k] == 1))
                        mat[i][j] = 1;
                }
            }
        }
    }
    public static int[][] bottle_neighbor(int bottle_1 , int bottle_2) {
        int size = (bottle_1 + 1) * (bottle_2 + 1);
      int[][] mat = new int[size][size];
        for (int i = 0; i <= bottle_1; i++) {
            for (int j = 0; j <= bottle_2; j++) {
                int k = (bottle_2 + 1) * i + j;// convert the row
                mat[k][getIndex(0,j,bottle_2)] = 1;// empty the first bottle
                mat[k][getIndex(i,0,bottle_2)] = 1;// empty the second bottle
                mat[k][getIndex(bottle_1,j,bottle_2)] = 1;// fill the first bottle full
                mat[k][getIndex(i,bottle_2,bottle_2)] = 1;// fill the second bottle full
                if((i+j)<bottle_1)
                { mat[k][getIndex(i+j,0,bottle_2)] = 1;}
                else
                { mat[k][getIndex(bottle_1,(j+i) - bottle_1,bottle_2)] = 1;}
                if((i+j)<bottle_2)
                { mat[k][getIndex(0,i+j,bottle_2)] = 1;}
                else
                { mat[k][getIndex((j+i) - bottle_2 ,bottle_2,bottle_2)] = 1;}
            }
        }
        return mat;
    }
    public static int getIndex(int i, int j, int n)
    {
        return (n+1)*i + j;
    }
    public static void main (String [] args)
    {
       int[][] mat = bottle_neighbor(1,2);
       Floyd_Warshall(mat);
       print_mat(mat);
    }
    public static void print_mat(int[][] mat)
    {
        for (int i = 0; i <mat.length ; i++) {
            for (int j = 0; j <mat[0].length ; j++) {
                System.out.print(mat[i][j] + ",");
            }
            System.out.println();
        }
    }

}
