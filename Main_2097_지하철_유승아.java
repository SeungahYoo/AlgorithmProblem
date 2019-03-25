import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//JUNGOL 2097 ÁöÇÏÃ¶
public class Main_2097_ÁöÇÏÃ¶_À¯½Â¾Æ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+1][N+1];
		int[] dist = new int[N+1];
		int[] path = new int[N+1];
		int[] visit = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			dist[i] = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1;j<=N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // input
		

		dist[1] = 0;
		
		for(int i=1;i<=N;i++) {
			int minNode = -1, minVal=Integer.MAX_VALUE;
			for(int j=1;j<=N;j++) {
				if(visit[j]==0 && minVal>dist[j]) {
					minNode=j;
					minVal=dist[j];
				}
			}
			visit[minNode]=1;
			
			for(int j=1;j<=N;j++) {
				if(dist[j]>minVal+map[minNode][j]) {
					dist[j]=minVal+map[minNode][j];
					path[j]=minNode;
				}
			}
		}
		
		System.out.println(dist[M]);
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(M);
		
		int idx = M;
		while(true) {
			int tmp = path[idx];
			if(tmp==0) break;
			list.add(tmp);
			idx = tmp;
		}
		
		for(int i=list.size()-1; i>=0;i--) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		
	}
	

}
