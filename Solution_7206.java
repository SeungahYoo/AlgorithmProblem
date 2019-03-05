import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//2019-03-05
//SWEA 7206 숫자게임

public class Solution_7206 {

	public static int turn;
	public static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			max = Integer.MIN_VALUE;
			String num = bf.readLine();
			int size = num.length();
			if (size == 1) {
				System.out.println("#" + tc + " 0");
				continue;
			}

			// 쪼개는 곳 선택하기.
			// 길이가 size 인 문자열은 1~size-1번까지 쪼갤 수 있다.
			turn = 0;
			select(num);

			System.out.println("#" + tc + " " + turn);
		} // end of tc
	}// end of main

	public static void select(String num) {
		int size = num.length();
		
		if(size == 1) {
			max = max < turn? turn:max;
			turn--;
			return;
		}
		for (int i = 1; i < size; i++) {

			


			comb(new int[i], num, size, 0, i, 0);// (size-1)Ci
			


		}
	}

	public static void comb(int[] set, String num, int size, int len, int r, int k) {// (size-1)Cr

		if (len == r) {
			System.out.println(Arrays.toString(set));
			String s = split(set, num);
			if(s.length() != 1) select(s);
			else {
				max = max < turn? turn:max;
				turn --;
				return;
			}

		}

		for (int i = k; i < size - 1; i++) {
			set[len] = i;
			comb(set, num, size, len + 1, r, i + 1);

		}

	} // end of comb method

	public static String split(int[] set, String num) {
		turn++;
		int p = Integer.parseInt(num.substring(0, set[0] + 1));
		for (int i = 1; i < set.length; i++) {
			p *= Integer.parseInt(num.substring(set[i - 1] + 1, set[i] + 1));

		}
		p *= Integer.parseInt(num.substring(set[set.length - 1] + 1, num.length()));

		return "" + p;
	} // end of split method
}
