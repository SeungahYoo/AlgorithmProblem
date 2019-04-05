
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* 시작 좌표(r,c)를 정하고, 사각형의 폭(w), 높이(h)를 정한 뒤
* 사각 영역의 각 꼭지점이 지역을 벗어나지 않는지 유효성 검사를 하고,
* 사각형 영역을 돌면서 작업
*         디저트 카페 번호를 카운팅하면서 겹치는 번호가 있는지 체크
*         겹치는 번호가 없으면 디저트카페 개수 : (w + h) * 2
* 최대 방문할 수 있는 디저트 카페의 개수를 출력
*/
public class Solution_디저트카페_유승아 {
    private static int N;
    private static int[][] m;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        
        for(int tc = 1; tc <= T; ++tc) {
            // data input
            N = Integer.parseInt(br.readLine().trim());
            m = new int[N][N];
            for(int i = 0; i < N; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int j = 0; j < N; ++j)
                    m[i][j] = Integer.parseInt(st.nextToken());
            }
            
            // solve
            int res = -1; // 사각형 불가할 경우 -1 출력
            // 모든 정점에 대해, 모든 사각형 크기를 만들어본다.
            for(int r = 0; r < N; ++r) { // row
                for(int c = 0; c < N; ++c) { // column
                    for(int w = 1; w < N; ++w) { // width
                        for(int h = 1; h < N; ++h) { // height
                            if(r + h + w >= N || c - h < 0) // 지역을 벗어났을 경우
                                continue;
                            int cnt = go(r, c, w, h); // 사각형 모양에서 방문할 수 있는 카페 개수를 반환
                            res = Math.max(res, cnt); // res 갱신
                        }
                    }
                }
            }
            
            // data output
            System.out.println("#" + tc + " " + res);
        } // end of test case
    } // end of main

    private static int go(int r, int c, int w, int h) {
        boolean[] visited = new boolean[101]; // 중복되는 카페 체크 배열
        
        for(int i = 0; i <= w; ++i) { // 폭을 증가시키면서 검사
            if(visited[m[r + i][c + i]]) // 이미 방문한 카페일 경우
                return -1;
            visited[m[r + i][c + i]] = true; // 방문 체크
            
            if(visited[m[r + i + h][c - h + i]]) // 이미 방문한 카페일 경우
                return -1;
            visited[m[r + i + h][c - h + i]] = true; // 방문 체크
        }
        
        for(int i = 1; i < h; ++i) { // 사각형의 꼭지점은 체크를 진행함
            if(visited[m[r + i][c - i]])
                return -1;
            visited[m[r + i][c - i]] = true;
            
            if(visited[m[r + i + w][c - i + w]])
                return -1;
            visited[m[r + i + w][c - i + w]] = true;
        }
        
        return (w + h) * 2; // 사각형 검사를 통과하였을 경우 사각형의 둘레 반환
    } // end of go
    
} // end of class