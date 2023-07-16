import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1303
public class 백준_1303_DFS {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,M;
    static char[][] arr;
    static boolean[][] visited;
    static int count = 0;
    static int wCount = 0;
    static int bCount = 0;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String input = br.readLine();
            for(int j=0; j<M; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!visited[i][j]) {  			//이 라인 틀렸었음 V(체크)
                    char color = arr[i][j];
                    count = 0;
                    dfs(i, j, color);
                    if(color == 'W') {
                        wCount += count * count;
                    }else {
                        bCount += count * count;
                    }
                }
            }
        }
        System.out.println(wCount + " " + bCount);
    }

    public static void dfs(int x, int y, char color) {

        visited[x][y] = true;
        int[] xArr = {1, 0, -1, 0};
        int[] yArr = {0, 1, 0, -1};
        count = count + 1;

        for(int i=0; i<4; i++) {
            int xx = x+xArr[i];
            int yy = y+yArr[i];

            if(xx<0 || xx>=N || yy<0 || yy>=M) continue;
            if(arr[xx][yy]!=color || visited[xx][yy]) continue;

            dfs(xx, yy, color);
        }
    }
}
