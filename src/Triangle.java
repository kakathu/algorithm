
public class Triangle {
    private static char[][] getTree(int n) {
        if(n <= 0) {
            return null;
        }
        char[][] triangle = new char[][]{{' ', '/', '\\', ' '}, {'/', '_', '_', '\\'}};
        for(int index = 1; index <= n; index++) {
            int height = triangle.length;
            int width = triangle[0].length;
            char[][] curr = new char[height * 2][width * 2];
            for(int i = 0; i < curr.length; i++) {
                for (int j = 0; j < curr[0].length; j++)
                    curr[i][j] = ' ';
            }

            for(int i = height; i < curr.length; i++) {
                for(int j = 0; j < curr[0].length; j++) {
                    curr[i][j] = triangle[i - height][j%width];
                }
            }
            for(int i = 0; i < height; i++) {
                for(int j = 0; j < curr[0].length; j++) {
                    if(j >= width/2 && j < width + width/2) {
                        curr[i][j] = triangle[i][j - width/2];
                    }
                }
            }
            triangle = curr;
        }
        return triangle;
    }

    private static void print(char[][] triangle) {
        for(int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[0].length; j++)
                System.out.print(triangle[i][j]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        print(getTree(2));
    }
}
