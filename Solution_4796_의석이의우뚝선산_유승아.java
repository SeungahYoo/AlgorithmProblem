import java.util.Scanner;

//SWEA :: 4796 의석이의 우뚝 선 산
//2019-04-03

public class Solution_4796_의석이의우뚝선산_유승아 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] height = new int[N];
			int before = -1;
			int ans = 0;
			int up=0, down=0;
			boolean downflag = false;
			for(int i=0;i<N;i++) {
				height[i] = sc.nextInt();
				if(height[i]>before) {
					if(downflag) {
						ans+=(up*down);
						up=0;
						down=0;
					}
					if(i>0) up++; //첫번째 높이에 대해서는 고려 X
					downflag = false;
					
				} else {
					down++;
					downflag = true;
				}
				before=height[i];
			}
			if(downflag) {
				ans+=(up*down);
			}
			System.out.println("#"+tc+" "+ans);
			
		}
	}
}
