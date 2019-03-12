import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BOJ :: 17070 ������ �ű��1
//2019-03-12

public class Solution17070 {
	static int N;
	static int[][] map;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0;
		dfs(0,1,1);
		
		System.out.println(cnt);
		
	} // end of main
	static int cnt;
	static int[] dy = {1,0, 1};
	static int[] dx = {0,1, 1}; //�Ʒ� ������ �밢��
	public static void dfs(int y,int x, int type){
		//type
		//0 : ����
		//1 : ����
		//2 : �밢��
		
		//visit[y][x]=true;
		System.out.println(y+","+x);
		if(y==N-1 && x==N-1) { //����
			System.out.println("����");
			cnt++;
			return;
		}
		
		int[] Dir = getDir(type);
		//System.out.println(Arrays.toString(Dir));
		
		for(int i=0;i<Dir.length;i++) {

			int ny = y+dy[Dir[i]];
			int nx = x+dx[Dir[i]];
			
			if(ny<0 || ny>N-1 || nx<0 || nx>N-1 || map[ny][nx]!=0) continue;
			//�밢������ �̵��� �ֺ� 4ĭ�� Ȯ���Ǿ� �־�� �Ѵ�.
			if(Dir[i]==2 && (map[y][x+1]!=0||map[y+1][x]!=0)) continue; 
			
			
			dfs(ny,nx,Dir[i]);
			
		}
		
	}
	
	public static int[] getDir(int type) {
		
		//type
		//0 : ����
		//1 : ����
		//2 : �밢��
		
		//�Ʒ� ������ �밢��
		if(type == 0) { //����
			int[] ret = {0,2};
			return ret;
		} 
		if(type == 1) { //����
			int[] ret = {1,2};
			return ret;
		}
		if(type ==2) {
			int[] ret = {0,1,2};
			return ret;
		}
		return null;
	}
	
}
