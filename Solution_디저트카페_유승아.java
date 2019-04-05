
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* ���� ��ǥ(r,c)�� ���ϰ�, �簢���� ��(w), ����(h)�� ���� ��
* �簢 ������ �� �������� ������ ����� �ʴ��� ��ȿ�� �˻縦 �ϰ�,
* �簢�� ������ ���鼭 �۾�
*         ����Ʈ ī�� ��ȣ�� ī�����ϸ鼭 ��ġ�� ��ȣ�� �ִ��� üũ
*         ��ġ�� ��ȣ�� ������ ����Ʈī�� ���� : (w + h) * 2
* �ִ� �湮�� �� �ִ� ����Ʈ ī���� ������ ���
*/
public class Solution_����Ʈī��_���¾� {
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
            int res = -1; // �簢�� �Ұ��� ��� -1 ���
            // ��� ������ ����, ��� �簢�� ũ�⸦ ������.
            for(int r = 0; r < N; ++r) { // row
                for(int c = 0; c < N; ++c) { // column
                    for(int w = 1; w < N; ++w) { // width
                        for(int h = 1; h < N; ++h) { // height
                            if(r + h + w >= N || c - h < 0) // ������ ����� ���
                                continue;
                            int cnt = go(r, c, w, h); // �簢�� ��翡�� �湮�� �� �ִ� ī�� ������ ��ȯ
                            res = Math.max(res, cnt); // res ����
                        }
                    }
                }
            }
            
            // data output
            System.out.println("#" + tc + " " + res);
        } // end of test case
    } // end of main

    private static int go(int r, int c, int w, int h) {
        boolean[] visited = new boolean[101]; // �ߺ��Ǵ� ī�� üũ �迭
        
        for(int i = 0; i <= w; ++i) { // ���� ������Ű�鼭 �˻�
            if(visited[m[r + i][c + i]]) // �̹� �湮�� ī���� ���
                return -1;
            visited[m[r + i][c + i]] = true; // �湮 üũ
            
            if(visited[m[r + i + h][c - h + i]]) // �̹� �湮�� ī���� ���
                return -1;
            visited[m[r + i + h][c - h + i]] = true; // �湮 üũ
        }
        
        for(int i = 1; i < h; ++i) { // �簢���� �������� üũ�� ������
            if(visited[m[r + i][c - i]])
                return -1;
            visited[m[r + i][c - i]] = true;
            
            if(visited[m[r + i + w][c - i + w]])
                return -1;
            visited[m[r + i + w][c - i + w]] = true;
        }
        
        return (w + h) * 2; // �簢�� �˻縦 ����Ͽ��� ��� �簢���� �ѷ� ��ȯ
    } // end of go
    
} // end of class