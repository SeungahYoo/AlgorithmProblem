import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SWEA :: 2117 Ȩ�������
public class Solution2117_Ȩ������� {
	private static int M;
	private static int N;
	private static int[][] map;
	private static int budget;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // ������ ũ��
			M = Integer.parseInt(st.nextToken()); // �ϳ��� ���� ������ �� �ִ� ���
			map = new int[N][N];
			
			int home = 0;
			for(int i=0;i<N;i++) {
				st  = new StringTokenizer(br.readLine(), " ");
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1) home++;
				} //////////// input
			}
			
			//�ִ� �� 
			budget = home*M;
			
			//1. �ִ� K(���񽺿��� ũ��) �����ϱ�
			
			
			System.out.println("#"+tc+" ");
		} // end of tc
	} // end of main
	
	public static void solve() {
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
			}
		}
	}
	
	public static void makeSafeZone(int y, int x, int k) {
		for(int i=0;i<N;i++) {
		}
	}
}
