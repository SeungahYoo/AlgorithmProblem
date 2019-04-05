import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//SWEA :: 5674 올해의 조련사
//2019-04-02
public class Solution5672_올해의조련사_유승아 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			char[] arr = new char[N];
			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine().charAt(0);
			}
			
			ArrayList<Character> list = new ArrayList<>();
			
			sb.append("#").append(tc).append(" ");
			int fidx=0;
			int ridx=arr.length-1;
			while(fidx<=ridx) {
				char front = arr[fidx];
				char rear =arr[ridx];
				
				if(ridx==fidx) {
					sb.append(arr[ridx]);
					break;
				}
				if(front<rear) {
					sb.append(front);
					fidx++;
				} else if(front >rear) {
					sb.append(rear);
					ridx--;
				} else if(front==rear) {
					int l = fidx;
					int r = ridx;
					while(true) {
						
						if(l>=r) {
							sb.append(arr[l]);
							fidx++;
							break;
						}
						if(arr[l] != arr[r]) {
							if(arr[l]<arr[r]) {
								sb.append(arr[fidx]);
								fidx++;
							} else {
								sb.append(arr[ridx]);
								ridx--;
							}
							break;
						} 
						
						l++;
						r--;
					}
				}
		
			} // end of while
			
			sb.append("\n");
		} // end of tc
		
		System.out.print(sb);
	}// end of main
}// end of class
