package airbnb;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    private static char[][] getTriangle(int n) {

        char[][] result = {
                {' ', '/', '\\', ' '},
                {'/', '_', '_', '\\'}};
        for(int i = 1; i < n; i++) {
            int h = result.length;
            int w = result[0].length;
            char[][] curr = new char[h*2][w*2];
            for(char[] r : curr) {
                Arrays.fill(r, ' ');
            }
            // fill bottom
            for(int r = h; r < curr.length; r++) {
                for(int c = 0; c < curr[0].length; c++) {
                    curr[r][c] = result[r-h][c%w];
                }
            }
            // fill top
            for(int r = 0; r < h; r++) {
                for(int c = 0; c < curr[0].length; c++) {
                    if(c >= w/2 && c < w + w/2) {
                        curr[r][c] = result[r][c - w / 2];
                    }
                }
            }
            result = curr;
        }

        return result;
    }

    public static void main(String[] args) {
        char[][] triangle = getTriangle(3);
        for(int i = 0; i < triangle.length; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                System.out.print(triangle[i][j]);
            }
            System.out.println();
        }
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        list.remove(1);
    }
}
