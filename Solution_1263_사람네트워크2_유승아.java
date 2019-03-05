import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1263_사람네트워크2_유승아 {
	public static void main(String[] args) throws Exception {
BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int INF = 987654321;
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc = 1 ; tc<=T ; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine()," ");
			int n =  Integer.parseInt(st.nextToken());
			
			int[][] map = new int[n][n];
			int[][] dist = new int[n][n];

			
			for(int i=0;i<n;i++) {
				
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1) {
						dist[i][j]=1;
					} else {
						dist[i][j] = INF;
					}
					if(i==j) dist[i][j]=0;
				}
			} //입력 받기.
			
			
			for(int k=0;k<n;k++) {
				for(int i=0;i<n;i++) {
					if(i==k) continue;
					for(int j=0;j<n;j++) {
						if(j==i) continue;
						
						if(dist[i][k]+dist[k][j] < dist[i][j])
							dist[i][j]=dist[i][k]+dist[k][j];
					}
				}
			}
			
			int ans = Integer.MAX_VALUE;
			for(int i=0;i<n;i++) {
				int sum=0;
				for(int j=0;j<n;j++) {
					sum+=dist[i][j];
				}
				ans = ans>sum? sum:ans;
			}
			System.out.println("#"+tc + " " + ans);
		} //end of tc
	}
}
