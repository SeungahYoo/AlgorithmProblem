import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_4408_자기방으로돌아가기 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine().trim());
		
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(bf.readLine().trim());
			ArrayList<pair> list =new ArrayList<Solution_4408_자기방으로돌아가기.pair>();
			
			for(int i=0;i<N;i++) {
				StringTokenizer str = new StringTokenizer(bf.readLine()," ");
				int to = Integer.parseInt(str.nextToken());
				int from = Integer.parseInt(str.nextToken());
				list.add(new pair(to,from));
			}
			
			Collections.sort(list);
			
			int ans = 0;
			while(!list.isEmpty()) {
				int idx = 0 ;
				int now= -1;
				while(!list.isEmpty()) {
					pair p = list.get(0);
					if(p.to!=-1) {
						now = p.to;
						p.setFrom(-1);
						p.setTo(-1);
						break;
					}
					list.remove(0);
				}
				
				if(list.isEmpty()) break;
				
				for(int i=0;i<list.size();i++) {
					pair p2 = list.get(i);
					int next = p2.from; //출발 방
					if( next == -1 || next<=now ) continue;
					//list.remove(i);
					now = p2.to;
					p2.setFrom(-1);
					p2.setTo(-1);
				}
				ans++;
			}
			
			
			
			System.out.println("#"+tc + " "+ans);
		} //end of tc
	}
	
	public static class pair implements Comparable<pair>{
		int to;
		int from;
		public pair(int to, int from)  {
			
			//짝수면 1씩 뺀다.
			if(to%2 == 0) to-=1;
			if(from%2 == 0) from-=1;
			
			//출발 방번호가 더 크면 도착 방번호와 swap 한다.
			if(to < from) {
				int tmp = from;
				from = to;
				to = tmp;
			}
			
			this.to = to;
			this.from = from;
		}
		@Override
		public int compareTo(pair o) {
			if(this.to == o.to) {
				return this.from-o.from;
			} else {
				return this.to-o.to;
			}
		}
		public int getTo() {
			return to;
		}
		public void setTo(int to) {
			this.to = to;
		}
		public int getFrom() {
			return from;
		}
		public void setFrom(int from) {
			this.from = from;
		}
		
		
		
	}
}
