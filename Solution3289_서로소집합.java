import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//SWEA :: 3289 서로소집합
//2019-04-04
public class Solution3289_서로소집합 {
	private static int[] p;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken()); //1~n
			int m = Integer.parseInt(st.nextToken());
			p = new int[n+1];
			for(int i=0;i<p.length;i++) p[i] = i;
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(op==0) { // 합집합
					union(a,b);
				}
				else if (op==1) {
					if(findSet(a)==findSet(b)) sb.append(1);
					else sb.append(0);
				}
			}
			sb.append("\n");
		}//end of tc
		System.out.print(sb);
	}//end of main
	
	public static int findSet(int x) {
		if(p[x]==x) return x;
		else {
			p[x] = findSet(p[x]);
			return p[x];
		}
	}
	public static void union(int a, int b) {
		int pa = findSet(a);
		int pb = findSet(b);
		
		if(pa!=pb) {
			p[pa]=pb;
		}
		return;
	}
}//end of class