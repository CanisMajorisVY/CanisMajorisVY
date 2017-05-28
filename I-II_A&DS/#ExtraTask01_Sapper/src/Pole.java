import java.util.Random;
/**
 * Created by Mihail on 02.02.2017.
 */

public class Pole {
    Random rand = new Random();
    private int n;
    private int m;
    private int r;
    private int hardness;
    private char[][] map;
    private boolean[][] bmap;
    private boolean[][] b1map;
    boolean q = false;
    boolean w = true;
    boolean e = false;
    boolean t = false;

    public Pole(int n, int m) {
        this.m = m;
        this.n = n;
        map = new char[n][m];
        bmap = new boolean[n][m];
        b1map = new boolean[n][m];
    }   

    public boolean weWin() {
        return t;
    }   

    public void setHardness(int hardness) {
        this.hardness = hardness;
    }

    public boolean gameIsOver() {
        return q;
    }    

    public boolean checkForWin() {
        t = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((b1map[i][j] == false && map[i][j] == '*') || (bmap[i][j] == false && map[i][j] !=  '*')) {
                    t = false;
                }
            }
        }
        if (t) {
            return true;
        }
        return false;
    }  

    public void setTrueIf0(int x, int y) {
        if (map[x][y] == '0' && !bmap[x][y]) {
            bmap[x][y] = true;
            if (x > 0 && y > 0 && x < n - 1 && y < m - 1) {
                setTrueIf0( x - 1     ,y - 1);
                setTrueIf0( x - 1     ,y     );
                setTrueIf0( x - 1     ,y + 1);
                setTrueIf0( x     ,y + 1     );
                setTrueIf0( x + 1     ,y + 1   );
                setTrueIf0( x + 1     ,y     );
                setTrueIf0( x + 1     ,y - 1  );
                setTrueIf0( x     ,y - 1     );
            } else {
                if (x < 1 &&   y > 0 &&   y < m - 1) {
                    setTrueIf0( x     ,y + 1     );
                    setTrueIf0( x + 1     ,y + 1  );
                    setTrueIf0( x + 1     ,y     );
                    setTrueIf0( x + 1     ,y - 1  );
                    setTrueIf0( x     ,y - 1);

                } else {
                    if (x > 0 && x < n - 1 &&   y > m - 2) {
                        setTrueIf0( x - 1     ,y - 1     );
                        setTrueIf0( x - 1     ,y     );
                        setTrueIf0( x + 1     ,y     );
                        setTrueIf0( x + 1     ,y - 1    );
                        setTrueIf0( x     ,y - 1     );

                    } else {
                        if (x > n - 2 &&   y > 0 &&   y < m - 1) {
                            setTrueIf0( x - 1     ,y - 1     );
                            setTrueIf0( x - 1     ,y     );
                            setTrueIf0( x - 1     ,y + 1    );
                            setTrueIf0( x     ,y + 1     );
                            setTrueIf0( x     ,y - 1    );

                        } else {
                            if (x > 0 &&   y < 1 && x < n - 1) {
                                setTrueIf0( x - 1     ,y     );
                                setTrueIf0( x - 1     ,y + 1     );
                                setTrueIf0( x     ,y + 1    );
                                setTrueIf0( x + 1     ,y + 1     );
                                setTrueIf0( x + 1     ,y     );

                            } else {
                                if (x == 0 &&   y == 0) {
                                    setTrueIf0( x     ,y + 1 );
                                    setTrueIf0( x + 1     ,y + 1     );
                                    setTrueIf0( x + 1     ,y     );
                                }

                                if (x == 0 &&   y == m - 1) {
                                    setTrueIf0( x     ,y - 1    );
                                    setTrueIf0( x + 1     ,y    );
                                    setTrueIf0( x + 1     ,y - 1     );
                                }

                                if (x == n - 1 &&   y == m - 1) {
                                    setTrueIf0( x     ,y - 1    );
                                    setTrueIf0( x - 1     ,y     );
                                    setTrueIf0( x - 1     ,y - 1     );
                                }

                                if (x == n - 1 &&   y == 0) {
                                    setTrueIf0( x     ,y + 1    );
                                    setTrueIf0( x - 1     ,y     );
                                    setTrueIf0( x - 1     ,y + 1  );
                                }
                            }
                        }
                    }
                }
            }
        }
        else {
            bmap[x][y] = true;
        }
    }  

    public void createMap(int x, int y) {
        bmap[x][y] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                r = rand.nextInt(1000);
                if ((i != x || j != y) && r < 80 + hardness * 35 ) {
                    map[i][j] = '*';
                }
                else {
                    map[i][j] = ' ';
                }
            }
        }

        int num;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                num = 0;
                if(i > 0 && j > 0 && i < n - 1 && j < m - 1 && map[i][j] != '*') {
                    if (map[i-1][j-1] == '*') num++;
                    if (map[i-1][j] == '*') num++;
                    if (map[i-1][j+1] == '*') num++;
                    if (map[i][j+1] == '*') num++;
                    if (map[i+1][j+1] == '*') num++;
                    if (map[i+1][j] == '*') num++;
                    if (map[i+1][j-1] == '*') num++;
                    if (map[i][j-1] == '*') num++;
                    map[i][j] = (char)(num + 48);
                } else {
                    if (map[i][j] != '*' && i < 1 && j > 0 && j < m - 1) {
                        if (map[i][j+1] == '*') num++;
                        if (map[i+1][j+1] == '*') num++;
                        if (map[i+1][j] == '*') num++;
                        if (map[i+1][j-1] == '*') num++;
                        if (map[i][j-1] == '*') num++;
                        map[i][j] = (char)(num + 48);
                    } else {
                        if (map[i][j] != '*' && i > 0 && i < n - 1 && j > m - 2) {
                            if (map[i-1][j-1] == '*') num++;
                            if (map[i-1][j] == '*') num++;
                            if (map[i+1][j] == '*') num++;
                            if (map[i+1][j-1] == '*') num++;
                            if (map[i][j-1] == '*') num++;
                            map[i][j] = (char)(num + 48);
                        } else {
                            if (map[i][j] != '*' && i > n - 2 && j > 0 && j < m - 1 ) {
                                if (map[i-1][j-1] == '*') num++;
                                if (map[i-1][j] == '*') num++;
                                if (map[i-1][j+1] == '*') num++;
                                if (map[i][j+1] == '*') num++;
                                if (map[i][j-1] == '*') num++;
                                map[i][j] = (char)(num + 48);
                            } else {
                                if ( map[i][j] != '*' && i > 0  && j < 1 && i < n - 1 ) {
                                    if (map[i-1][j] == '*') num++;
                                    if (map[i-1][j+1] == '*') num++;
                                    if (map[i][j+1] == '*') num++;
                                    if (map[i+1][j+1] == '*') num++;
                                    if (map[i+1][j] == '*') num++;
                                    map[i][j] = (char)(num + 48);
                                } else {
                                    if(map[i][j] != '*') {
                                        if (i == 0 && j == 0) {
                                            if (map[i][j+1] == '*') num++;
                                            if (map[i+1][j+1] == '*') num++;
                                            if (map[i+1][j] == '*') num++;
                                            map[i][j] = (char)(num + 48);
                                        }

                                        if (i == 0 && j == m - 1) {
                                            if (map[i][j-1] == '*') num++;
                                            if (map[i+1][j] == '*') num++;
                                            if (map[i+1][j-1] == '*') num++;
                                            map[i][j] = (char)(num + 48);
                                        }

                                        if (i == n - 1 && j == m - 1) {
                                            if (map[i][j-1] == '*') num++;
                                            if (map[i-1][j] == '*') num++;
                                            if (map[i-1][j-1] == '*') num++;
                                            map[i][j] = (char)(num + 48);
                                        }

                                        if (i == n - 1 && j == 0) {
                                            if (map[i][j+1] == '*') num++;
                                            if (map[i-1][j] == '*') num++;
                                            if (map[i-1][j+1] == '*') num++;
                                            map[i][j] = (char)(num + 48);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void checkplace(int x, int y, char b) {
        if (b == 'b') {
            b1map[x][y] = true;
        } else if (b == 'n') {
            b1map[x][y] = false;
        } else {
            bmap[x][y] = true;
        }
        boolean q = false;
        if(map[x][y] == '0') {
            bmap[x][y] = false;
            q = true;
        }
        updateBMap(q, x, y);
    }  

    public void updateBMap(boolean a, int x, int y) {
        if(a) {
            setTrueIf0(x, y);
        }
        q = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (bmap[i][j] == true && map[i][j] == '*') {
                    q = true;
                }
            }
        }
        checkForWin();
        if (q  || t) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    bmap[i][j] = true;
                }
            }
        }
    }  

    public void showMap () {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if(i == 0) {
                    System.out.print(j + "'" +  "\t");
                } else {
                    if (j == 0) {
                        System.out.print(i + "'" + "\t");
                    } else {

                        if (b1map[i-1][j-1] == true) {
                            System.out.print("b" + "\t");
                        } else {
                            if (bmap[i - 1][j - 1] == true) {
                                if (map[i - 1][j - 1] != '0') {
                                    System.out.print(map[i - 1][j - 1] + "\t");
                                } else {
                                    System.out.print("\t");
                                }
                            } else {
                                System.out.print("." + "\t");
                            }
                        }
                    }
                }
            }
            System.out.println("\t");
        }
    }  

}