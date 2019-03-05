import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1863_Á¾±³_À¯½Â¾Æ {
	public static int[] p;
	public static int cnt;
	public static void main(String[] args) throws Exception {
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
	
		
		StringTokenizer st= new StringTokenizer(bf.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		cnt = n;
		p=new int[n+1];
		
		for(int i=1;i<n+1;i++) {
			p[i] = i;
		}
		

		for(int i=0;i<m;i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a,b);
		}
		
		System.out.println(cnt);
		
	}
	
	public static void union(int x,int y){
		int px = findSet(x);
		int py = findSet(y);
		
		if(px!=py) {
			p[py]=px;
			cnt--;
		}
	}
	
	public static int findSet(int x){
		if(x==p[x]) return x;
		else {
			p[x] = findSet(p[x]);
			return p[x];
		}
	}
}
