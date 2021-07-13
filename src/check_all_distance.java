public class check_all_distance {
    public static void main (String [] args)
    {
        int vertices_w[] = {1,3,15,2,8,8,5,6};
        int vertices_w2[] = {2,4,3,6};
         int inf = 1000000;
        int[][] edges_w = {

                {0,5,inf,inf,inf,inf,4,inf},

                {5,0,inf,inf,inf,6,8,inf},

                {inf,inf,0,6,inf,inf,2,5},

                {inf,inf,6,0,5,inf,18,inf},

                {inf,inf,inf,5,0,4,3,inf},

                {inf,6,inf,inf,4,0,inf,inf},

                {4,8,2,18,3,inf,0,7},

                {inf,inf,5,inf,inf,inf,7,0}

        };
        int[][] edges_w2 = {

                {0,18,5,inf},

                {18,0,2,3},

                {5,2,0,inf},

                {inf,3,inf,0}
        };
        AllDistances ad = new AllDistances(vertices_w,edges_w);
        AllDistances ad2 = new AllDistances(vertices_w2,edges_w2);

// result:
/*
[1, 9, 27, 28, 21, 23, 10, 23]
[9, 3, 33, 34, 27, 17, 16, 29]
[27, 33, 15, 23, 33, 45, 22, 26]
[28, 34, 23, 2, 15, 27, 23, 34]
[21, 27, 33, 15, 8, 20, 16, 29]
[23, 17, 45, 27, 20, 8, 28, 41]
[10, 16, 22, 23, 16, 28, 5, 18]
[23, 29, 26, 34, 29, 41, 18, 6]
*/String full_path = ad.path(1, 4);
        System.out.println(full_path); // 1-7-5-4
        System.out.println(ad.path(2, 5)); // 2-7-5
        System.out.println(ad.path(5, 4)); // 5-4
        System.out.println(ad.path(1, 5)); // 1-7-5
        System.out.println(ad.path(6, 2)); // 6-2
        System.out.println(ad.path(5, 8)); // 5-7-8
         System.out.println(ad.path(4, 8)); // 4-3-8
        System.out.println(ad.distance(1,8));// 23
        System.out.println(ad.distance(3,8));// 26
        int[][]all_edges_in = ad.distance_matrix();
        for (int i = 0; i < vertices_w.length; i++) {
            for (int j = 0; j <vertices_w.length ; j++) {
                System.out.print(all_edges_in[i][j] + "-");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(ad2.distance(1, 4)); // 25
        System.out.println(ad2.path(1, 4)); // 1-3-2-4

        int[][]all_edges_in2 = ad2.distance_matrix();
        for (int i = 0; i < vertices_w2.length; i++) {
            for (int j = 0; j <vertices_w2.length ; j++) {
                System.out.print(all_edges_in2[i][j] + "-");
            }
            System.out.println();
        }
    }
}
