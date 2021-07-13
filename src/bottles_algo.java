public class bottles_algo {
    public static void bottle_neighbor(int bottle_1 , int bottle_2) {
        int size = (bottle_1 + 1) * (bottle_2 + 1);
        boolean[][] mat = new boolean[size][size];
        for (int i = 0; i <= bottle_1; i++) {
            for (int j = 0; j <= bottle_2; j++) {
                int k = (bottle_2 + 1) * i + j;
                mat[k][j] = true;
                mat[k][(bottle_2 + 1) * i] = true;
                mat[k][(bottle_2 + 1) * i + bottle_1] = true;
                mat[k][(bottle_2 + 1) * bottle_2 + j] = true;
                if ((i + j) <= bottle_1)
                    mat[k][(bottle_2 + 1) * (i + j)] = true;
                else
                    mat[k][(bottle_2 + 1) * (bottle_2) + (j + i) - bottle_1] = true;
                if ((i + j) <= bottle_2)
                    mat[k][i + j] = true;
                else
                    mat[k][(bottle_2 + 1) * ((i + j) - bottle_2) + bottle_1] = true;
            }
        }
    }
}
