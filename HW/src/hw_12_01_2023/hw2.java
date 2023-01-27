package hw_12_01_2023;

public class hw2 {
    public static void main(String[] args) {
        int[][] tab = new int[][]{  {1, 2, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                                    {1, 2, 7, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 2},
                                    {3, 2, 7, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 7},
                                    {1, 5, 2, 1, 1, 1, 4, 1, 1, 1, 1, 3, 1, 1, 2},
                                    {1, 5, 2, 3, 1, 6, 1, 1, 1, 1, 1, 1, 1, 1, 2},
                                    {1, 5, 2, 1, 1, 1, 1, 1, 6, 2, 1, 9, 2, 1, 2},
                                    {1, 5, 2, 1, 2, 7, 4, 4, 1, 3, 1, 1, 3, 1, 2},
                                    {1, 5, 2, 8, 1, 7, 1, 7, 1, 1, 1, 1, 1, 1, 2},
                                    {1, 5, 2, 1, 2, 1, 1, 1, 1, 9, 1, 1, 9, 1, 2},
                                    {1, 5, 2, 1, 3, 1, 1, 1, 2, 7, 4, 4, 8, 2, 2},
                                    {1, 5, 2, 1, 1, 1, 6, 1, 1, 1, 1, 1, 1, 3, 2},
                                    {1, 5, 2, 1, 9, 1, 1, 1, 1, 5, 6, 1, 1, 1, 2},
                                    {1, 5, 2, 1, 4, 1, 1, 4, 1, 2, 7, 4, 4, 9, 2},
                                    {1, 5, 2, 1, 5, 1, 8, 1, 1, 3, 1, 7, 2, 1, 2},
                                    {2, 4, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}};

        int[][] tab2 = new int[tab.length][tab.length];
        int[][] tab3 = new int[tab.length+1][tab.length+1];
        long start = System.currentTimeMillis();
        System.out.println(minPassRec(tab, tab2, 0, 0));
        long finish = System.currentTimeMillis();
        System.out.println("Time of oper: " + (finish - start));
        for (int i = 0; i < tab2.length; i++) {
            for (int j = 0; j < tab2[i].length; j++) {
                System.out.printf("%3d", tab2[i][j]);
            }
            System.out.println();
        }
        start = System.currentTimeMillis();
        System.out.println(minPass(tab, tab3, 0, 0));
        finish = System.currentTimeMillis();
        System.out.println("Time of oper: " + (finish - start));
        for (int i = 0; i < tab3.length-1; i++) {
            for (int j = 0; j < tab3[i].length-1; j++) {
                System.out.printf("%3d", tab3[i][j]);
            }
            System.out.println();
        }

    }

    private static int minPassRec(int[][] tab, int[][] tab2, int i, int j) {
        if (i >= tab.length || j >= tab[i].length) return 1000000;
        if (i == tab.length - 1 && j == tab[i].length - 1) return tab[i][j];
        int a = minPassRec(tab, tab2, i + 1, j);
        int b = minPassRec(tab, tab2, i, j + 1);
        tab2[i][j] = Math.min(a, b);
        int x = tab[i][j] + tab2[i][j];

        return x;
    }

    private static int minPass(int[][] tab, int[][] tab2, int i, int j) {
        if (i >= tab.length || j >= tab[i].length) return 1000000;
        if (i == tab.length - 1 && j == tab[i].length - 1) return tab[i][j];
        if (tab2[i][j] != 0) return tab2[i][j];

        int a = minPass(tab, tab2, i + 1, j);
        tab2[i+1][j] = a;
        int b = minPass(tab, tab2, i, j + 1);
        tab2[i][j+1] = b;
        int x = tab[i][j] + Math.min(a, b);
        tab2[i][j] = x;
        return x;

    }
}
