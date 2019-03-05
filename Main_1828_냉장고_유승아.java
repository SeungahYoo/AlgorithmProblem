import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1828_³ÃÀå°í_À¯½Â¾Æ{
	public static class pair implements Comparable<pair> {
		int a;
		int b;

		public pair(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(pair o) {
			return this.a-o.a;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		pair[] arr = new pair[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new pair(a, b);
		}
		Arrays.sort(arr);
		int ans =1;
		int before = arr[0].b;
		for(int i=1;i<n;i++) {
			int now = arr[i].a;
			if(before < now) {
				ans++;
				before = arr[i].b;
			}
			else {
				if(arr[i].b < before)
					before=arr[i].b;
			}
		}
		
		System.out.println(ans);
	}
}
