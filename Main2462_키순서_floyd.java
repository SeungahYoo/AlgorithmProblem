

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2462_키순서_floyd {
	private static int[][] a;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 학생들 수 , 2<= N <= 500
		int M = Integer.parseInt(st.nextToken()); // 키비교수 , 2 < = M <= N *(N-1)/2
		a = new int[N + 1][N + 1]; // 1~N 정접만 활용, 인접행렬
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int small = Integer.parseInt(st.nextToken()); // 작은
			int tall = Integer.parseInt(st.nextToken()); // 큰
			a[small][tall] = 1;
		}
		// 인접행렬에서 사용하지 않는 0번칸을 플래그 변수로 활용하겠음
		for (int i = 0; i < a.length; i++) {
			a[i][0] = -1; // 초기화
		}
		//순회하기전
		/*System.out.println("순회하기전");
		for (int i = 0; i < a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}*/
		
		
		
		int totalN = 0; // 순서를 정확히 알게되는 학생 인원수
		System.out.println(totalN);
		for (int i = 0; i < a.length; i++) {
			up(i); // dfs로 순회
		}
		
	/*	System.out.println("순회한 후");
		for (int i = 0; i < a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}*/
		//나보다 키가 작은 애들, 큰아이들의 합을 구해서  N-1이면 순서를 정확하게 알수있는 사람임
		
		for (int i = 1; i < a.length; i++) {
			for (int k = 0; k < a.length; k++) {
				a[0][i] += a[k][i]; //정점 i로 진입하는 정점들의 개수를 저장
			}
			
		}
		
		for (int i = 0; i < a.length; i++) {
			if(a[0][i] + a[i][0] == N-1) {
				totalN++;
			}
		}
		
		System.out.println(totalN);
	}// end of main

	public static void up(int v) {
		if(a[v][0] != -1) {//저장이 되어있는 상태이면 저장되어있는 값으로 가지고 가라(메모이제이션) //정점 v에 대해서 부모를 체크해 둔 상태라면			
			return;
		}
		//현재 v정점의 부모가 누구인지를 인접행렬에 저장
		for (int i = 1; i < a.length; i++) {
			if(a[v][i] ==1) {
				up(i);
				for (int j = 1; j < a.length; j++) {
					a[v][j] = a[v][j] | a[i][j];
				}
			}
		}
		
		// 인접행렬의 0번째 칸은 v정접의 부모의 개수 몇개인지 저장해두자
		int sum = 0;
		for (int j = 1; j < a.length; j++) {
			sum += a[v][j]; //인접한 부모는 1, 인접안했으면 0 이니깐, 싹 더하면  부모의 개수가 됨..
		}
		
		a[v][0] = sum;;
		
	}

}