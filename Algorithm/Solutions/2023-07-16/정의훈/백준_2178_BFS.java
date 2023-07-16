import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2178
public class 백준_2178_BFS {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n,m;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            String input = br.readLine();
            for(int j=0; j<m; j++) {
                graph[i][j] = input.charAt(j)-'0';
            }
        }
        bfs(0, 0);
        System.out.println(graph[n-1][m-1]);
    }

    public static void bfs(int x, int y) {

        Queue<Location> q = new LinkedList<>();

        q.add(new Location(x, y));

        int[] moveX = {1,0,-1,0};
        int[] moveY = {0,1,0,-1};

        while(!q.isEmpty()) {

            Location loc = q.poll();

            int xx = loc.x;
            int yy = loc.y;

            visited[xx][yy] = true;

            for(int i=0; i<4; i++) {
                int xxx = xx+moveX[i];
                int yyy = yy+moveY[i];

                if(xxx<0 || xxx>=n || yyy<0 || yyy>=m) continue;
                if(graph[xxx][yyy]==0 || visited[xxx][yyy]) continue;

                q.add(new Location(xxx, yyy));

                graph[xxx][yyy] = graph[xx][yy] +1;
            }
        }
    }
}

class Location{
    int x;
    int y;

    Location(int x, int y){
        this.x = x;
        this.y = y;
    }
}
