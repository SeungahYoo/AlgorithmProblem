import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution1251 {
	public static class pair{
		int x;
		int y;
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static class Edge implements Comparable<Edge>{
		int a;
		int b;
		double val;

		
		public Edge(int a, int b, double val) {
			super();
			this.a = a;
			this.b = b;
			this.val = val;
		}


		@Override
		public int compareTo(Edge o) {
			return (int) (this.val - o.val);
		}
		
		
	}
	
	static int[] p;
	
	static public double Dist(pair a, pair b) {
		int x = a.x-b.x;
		int y = a.y-b.y;
		return Math.sqrt(x*x+y*y);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(bf.readLine()); 
		
		for(int tc=1;tc<=TC;tc++) {
			int N = Integer.parseInt(bf.readLine()); //섬의 개수
			
			StringTokenizer xx = new StringTokenizer(bf.readLine()," ");
			StringTokenizer yy = new StringTokenizer(bf.readLine()," ");
			double E = Double.parseDouble(bf.readLine()); //세율
			
			pair isl[] = new pair[N];
			p = new int[N];
			for(int i=0;i<N;i++) {
				isl[i] = new pair(Integer.parseInt(xx.nextToken()),Integer.parseInt(yy.nextToken()));
				makeSet(i);
			}
			
			LinkedList<Edge> ed = new LinkedList<Solution1251.Edge>();
			int idx = 0;
			for(int i=0;i<N;i++) {
				pair p1 = isl[i];
				for(int j=i+1;j<N;j++) {
					pair p2 = isl[j];
					ed.add(new Edge(i,j,Dist(p1,p2)));
				}
			}
			
			Collections.sort(ed);
		
			
			double sum=0;
			for(int i=0;i<ed.size();i++) {
				Edge e = ed.get(i);
				if(findSet(e.a) != findSet(e.b)) {
					union(e.a,e.b);
					sum+=E*e.val*e.val;
				}
			}
			
			
			System.out.println(tc+" "+Math.round(sum));
			
		} // end of tc
	} //end of main
	
	public static void makeSet(int x) {
		p[x]=x;
	}
	
	public static int findSet(int x) {
		if(p[x]==x) {
			return x;
		} else {
			p[x]=findSet(p[x]);
			return p[x];
		}
	}
	
	public static void union(int x,int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if(px!=py) {
			p[px]=py;
		}
	}
	

}
