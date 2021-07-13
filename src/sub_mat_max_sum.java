import java.util.Arrays;

public class sub_mat_max_sum {
    public static int sub_mat_max_super_best(int[][] mat) {
        int[] temp_max = new int[3];
        int max = Integer.MIN_VALUE;
        int[] arr_temp = new int[mat[0].length];
        for (int i = 0; i < mat[0].length; i++) {
            Arrays.fill(arr_temp, 0);
            for (int j = i; j < mat[0].length; j++) {
                for (int k = 0; k < mat.length; k++) {
                    arr_temp[k] += mat[k][j];
                }
                temp_max = regular_best(arr_temp, 0, mat[0].length);
                if (temp_max[2] > max) {
                    max = temp_max[2];
                }
            }

        }

        return max;
    }


    public static int[] sub_mat_max_sum_full_search(int[][] mat) {
        int[] indexes = new int[4];
        int max_sum = Integer.MIN_VALUE, temp_sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                for (int k = i; k < mat.length; k++) {
                    for (int l = j; l < mat[0].length; l++) {
                        temp_sum = 0;
                        for (int m = i; m <= k; m++) {
                            for (int n = j; n <= l; n++) {
                                temp_sum += mat[m][n];
                            }
                        }
                        if (temp_sum > max_sum) {
                            max_sum = temp_sum;
                            indexes[0] = i;
                            indexes[1] = j;
                            indexes[2] = k;
                            indexes[3] = l;
                        }
                    }
                }
            }
        }
        return indexes;
    }

    public static int[] regular_best(int[] arr, int start, int end) {
        int[] range = new int[3];
        range[2] = Integer.MIN_VALUE;
        int end_temp = 0, start_temp = 0, k = 0;
        int[] arr_t = new int[end - start + 1];
        arr_t[0] = arr[start];
        start++;
        for (int i = 1; start <= end; i++, start++) {
            if (arr_t[i - 1] <= 0) {
                arr_t[i] = arr[start];
                start_temp = i;
                end_temp = i;
            } else {
                arr_t[i] = arr_t[i - 1] + arr[start];
                if (arr_t[i] <= 0) {
                    arr_t[i] = arr[i];
                }
                end_temp++;
            }
            if (arr_t[i] > range[2]) {
                range[2] = arr_t[i - 1];
                range[0] = start_temp;
                range[1] = end_temp;
            }
        }
        return range;
    }

    public static int sub_mat_max_sum_best(int[][] mat) {
        int[] temp_max = new int[3];
        int max = Integer.MIN_VALUE;
        int[] arr_temp = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                Arrays.fill(arr_temp, 0);
                for (int k = i; k < mat.length; k++) {
                    for (int l = j; l < mat[0].length; l++) {
                        arr_temp[k] += mat[k][l];
                    }
                }
                temp_max = regular_best(arr_temp, i, mat.length - 1);
                if (temp_max[2] > max) {
                    max = temp_max[2];
                }
            }
        }
        return max;
    }

    public static int sub_mat_max_temp_mat(int[][] mat) {
        int temp_sum, sum = Integer.MIN_VALUE, row = mat.length, col = mat[0].length;
        int[][] mat_sum = create_sum_mat(mat);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = i; k < row; k++) {
                    for (int l = j; l < col; l++) {
                        if (i == 0 && j == 0) {
                            temp_sum = mat_sum[k][l];
                        } else if (i == 0) {
                            temp_sum = mat_sum[k][l] - mat_sum[k][j - 1];
                        } else if (j == 0) {
                            temp_sum = mat_sum[k][l] - mat_sum[i - 1][l];
                        } else {
                            temp_sum = mat_sum[k][l] - mat_sum[k][j - 1] - mat_sum[i - 1][l] + mat_sum[i - 1][j - 1];
                        }
                        if (temp_sum > sum) {
                            sum = temp_sum;
                        }
                    }
                }
            }
        }
        return sum;
    }

    public static int[][] create_sum_mat(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] sum_mat = new int[row][col];
        sum_mat[0][0] = mat[0][0];
        for (int i = 1; i < row; i++) {
            sum_mat[i][0] = sum_mat[i - 1][0] + mat[i][0];
        }
        for (int i = 1; i < col; i++) {
            sum_mat[0][i] = sum_mat[0][i - 1] + mat[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                sum_mat[i][j] = sum_mat[i - 1][j] + sum_mat[i][j - 1] - sum_mat[i - 1][j - 1];
            }
        }
        return sum_mat;
    }
}
