import java.util.Arrays;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int bcal = (brown + 4) / 2;
        boolean check = false;
        for (int x = 1; x < bcal; ++x) {
            int y = bcal - x;
            if ((x - 2) * (y - 2) == yellow) {
                answer[0] = Math.max(x, y);
                answer[1] = Math.min(x, y);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Carpet carpet = new Carpet();
        int brown = 24;
        int yellow = 24;
        int[] result = carpet.solution(brown, yellow);
        System.out.println("가로: " + result[0] + ", 세로: " + result[1]);
    }
}