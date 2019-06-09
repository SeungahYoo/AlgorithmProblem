import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14719_빗물 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] map = new int[W];
		st = new StringTokenizer(br.readLine(), " ");
		
		int[] left = new int[W];
		int[] right = new int[W];
		int l=0, r=0;
		
		for(int i=0;i<W;i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		
		
		
		for(int i=0;i<W;i++) {
			//왼쪽벽에 대하여
			l = Math.max(l, map[i]);
			left[i] = l;
			
			//오른쪽 
			r = Math.max(r, map[W-1-i]);
			right[W-1-i] = r;
		}
		
		int[] min = new int[W];
		int water=0;
		for(int i=0;i<W;i++) {
			min[i] = Math.min(left[i], right[i]);
			if(min[i]-map[i]>0) water+=(min[i]-map[i]);
		}
		System.out.println(water);
	}
}
