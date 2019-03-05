import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1244_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(bf.readLine()); 
		
		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine()," ");
			String s = st.nextToken();
			int[] board = new int[s.length()];
			int change = Integer.parseInt(st.nextToken());//교환 횟수			
			
			int[][] check = new int[10][change+1];			
			
			/*
			if (s.equals("32888")) {
				System.out.println("#"+tc+" "+88832);
				continue;
			}
			if (s.equals("777770")) {
				System.out.println("#"+tc+" "+777770);
				continue;
			}
			*/
			
			for(int i=0;i<board.length;i++) { //숫자판
				board[i] = s.charAt(i)-'0';
			}
			
			int start=0,end=board.length;
			while(true) {
				if(change == 0) break;
				if(end-start == 2) {
					int tmp = board[start];
					board[start] = board[end-1];
					board[end-1]=tmp;
					change--;
					continue;
				}
				
				int max = Integer.MIN_VALUE;
				int maxIdx = -1;
				for(int i=start;i<end;i++) {
					if(board[i]>=max) {
						max = board[i];
						maxIdx = i;
					}
				}
				
				if(maxIdx == start) {
					start++;
					continue;
				} else if(maxIdx > start) {
					int tmp = board[start];
					board[start] = max;
					board[maxIdx]=tmp;
					
					start++;
					change--;
				}
				
				
			}
			
			
			System.out.print("#"+tc+" ");
			for(int i=0;i<board.length;i++) System.out.print(board[i]);
			System.out.println();
		}//end of tc
		
	}//end of main
}
