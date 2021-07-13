public class diameter_check {

        public static void main(String[] args) {
            boolean[][] matrixTest1 = {
                    {false, true, false, false, false, false},
                    {true, false, true, true, false, false},
                    {false, true, false, false, false, false},
                    {false, true, false, false, true, true},
                    {false, false, false, true, false, false},
                    {false, false, false, true, false, false}
            };
            Diameter l = new Diameter(matrixTest1);
            System.out.println("Test 1: " + ((l.get_diam() == 3) ? "Pass." : "Fail."));
            boolean t = true, f = false;
            boolean[][] matrixTest2 = {
                    {f, f, f, t, f, f, t, f, f, f, f, f},
                    {f, f, f, f, f, f, f, f, f, t, f, f},
                    {f, f, f, f, f, f, f, f, t, f, f, t},
                    {t, f, f, f, f, f, f, f, f, f, f, f},
                    {f, f, f, f, f, t, f, f, t, t, f, f},
                    {f, f, f, f, t, f, t, t, f, f, f, f},
                    {t, f, f, f, f, t, f, f, f, f, f, f},
                    {f, f, f, f, f, t, f, f, f, f, f, f},
                    {f, f, t, f, t, f, f, f, f, f, t, f},
                    {f, t, f, f, t, f, f, f, f, f, f, f},
                    {f, f, f, f, f, f, f, f, t, f, f, f},
                    {f, f, t, f, f, f, f, f, f, f, f, f}};
            Diameter d = new Diameter(matrixTest2);
            System.out.println("Test 2: " + ((d.get_diam() == 7) ? "Pass." : "Fail."));
            boolean[][] matrixTest3 = {{f, t, f, f, f, f, t, f, f, f, f, f, f, f, f, f, f},
                    {t, f, f, f, f, t, f, f, f, f, f, t, f, f, f, f, f},
                    {f, f, f, f, t, f, f, f, f, t, f, f, f, f, f, f, f},
                    {f, f, f, f, t, f, f, t, f, f, f, f, f, f, f, f, f},
                    {f, f, t, t, f, t, f, f, f, f, f, f, f, f, f, f, f},
                    {f, t, f, f, t, f, f, f, f, f, f, f, f, f, f, f, f},
                    {t, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, f},
                    {f, f, f, t, f, f, f, f, f, f, f, f, t, t, f, f, f},
                    {f, f, f, f, f, f, f, f, f, f, f, t, f, f, f, f, f},
                    {f, f, t, f, f, f, f, f, f, f, f, f, f, f, f, f, f},
                    {f, f, f, f, f, f, f, f, f, f, f, t, f, f, f, f, f},
                    {f, t, f, f, f, f, f, f, t, f, t, f, f, f, f, f, f},
                    {f, f, f, f, f, f, f, t, f, f, f, f, f, f, f, f, f},
                    {f, f, f, f, f, f, f, t, f, f, f, f, f, f, t, f, f},
                    {f, f, f, f, f, f, f, f, f, f, f, f, f, t, f, t, f},
                    {f, f, f, f, f, f, f, f, f, f, f, f, f, f, t, f, t},
                    {f, f, f, f, f, f, f, f, f, f, f, f, f, f, f, t, f}};
            Diameter p = new Diameter(matrixTest3);
            System.out.println("Test 3: " + ((p.get_diam() == 10) ? "Pass." : "Fail."));
        }
    }
