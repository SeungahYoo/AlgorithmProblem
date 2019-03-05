import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int a;
	int b;
	int w;
	public Edge(int a, int b, int w) {
		super();
		this.a = a;
		this.b = b;
		this.w = w;
	}
	@Override
	public int compareTo(Edge o) {
		return this.w-o.w;
	}
	
	
}
public class Solution3124 {
	static int[]p;
	static int[]rank;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine()," ");
			int V = Integer.parseInt(st.nextToken());//����
			int E = Integer.parseInt(st.nextToken()); //����
			
			p = new int[V+1];
			rank = new int[V+1];
			
			Edge[] ed = new Edge[E];
			
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(bf.readLine()," ");
				ed[i]=new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(ed);
			
			for(int i=0;i<p.length;i++) {
				makeSet(i);
			}
			
			long ans = 0;
			//����ġ ���� �������� �����ϱ�
			for(int i=0;i<ed.length;i++) {
				Edge e = ed[i];
				if(findSet(e.a)!=findSet(e.b)) {
					union(e.a,e.b);
					ans += e.w;
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}//end of tc
	}
	
	//���ο� ���� ����
	public static void makeSet(int x) {
		p[x]=x;
	}
	
	//x�� ���Ե� �׷��� ��ǥ�� ����
	public static int findSet(int x) {
		if(x==p[x]) return x;
		
		else {
			p[x]=findSet(p[x]);
			
			return p[x];
		}
	}
	
	public static void union(int x, int y) {
		int px=findSet(x);
		int py=findSet(y);
		
		//���� �ٸ� ������ ��츸 ��ģ��.
		if(px!=py) {
			link(px,py);
		}
	}
	
	//px, py�� ��ǥ�� �ִ� ������ ��ġ�� rank ���߱�
	public static void link(int px, int py) {
		if(rank[px]>rank[py]) {
			p[py] = px;
		} else {
			p[px] = py;
			
			if(rank[px]==rank[py]) {
				rank[py]++;
			}
		}
	}
}
