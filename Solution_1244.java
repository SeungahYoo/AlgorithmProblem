import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_1244 {

		
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(bf.readLine()); 
		int change;
		int ans;
		
		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine()," ");
			String s = st.nextToken();
			Integer[] board = new Integer[s.length()];
			change = Integer.parseInt(st.nextToken());//교환 횟수			
				
			int[] check = new int[10];
			Arrays.fill(check, -1);
			ArrayList<Integer> al = new ArrayList<Integer>();
			for(int i=0;i<board.length;i++) { //숫자판
				board[i] = s.charAt(i)-'0';
				if(check[board[i]] != -1) { //중복된 숫자가 들어온 경우
					//al리스트에 중복된 숫자들의 인덱스를 저장해논다.
					if(al.isEmpty())al.add(check[board[i]]);
					al.add(i);
				}
				else check[board[i]] = i;	
			}
			
			for(int i=0;i<board.length;i++) { //선택정렬
				if(change==0) break;
				
				int maxIndex = i;
				for(int j=i;j<board.length;j++) {
					if(board[maxIndex]<=board[j]) {
						maxIndex = j;
					}
				}
				if(maxIndex != i) {
					int tmp = board[maxIndex]; //1.가장 큰 숫자위치와 가장 왼쪽 원소 swap
					board[maxIndex]=board[i]; 
					board[i]=tmp;
					change --;					
				} 
			} //end of for 선택정렬
			
			//교환횟수가 남은 경우
			
			//동일한 숫자가 존재하면, 값의 변동없이 교환회수를 감소시킬 수 있다.
			HashSet<Integer> hs = new HashSet<Integer>(Arrays.asList(board));
			
			if(hs.size() != board.length) { // 같은 숫자 존재
				/* 처음에 저장해논 중복된 숫자들의 인덱스를 이용해 
				 * 중복 숫자들과 교환된 숫자들을 추출 후, tmpArr 배열에 저장한다.
				 * 
				 * 해당 숫자들을 sort 후 다시 입력한다.
				 * 
				 * ex ) 
				 * 3 2 1 8 8 8 , 3번 교환
				 * 알고리즘에 의하면
				 * 8 8 8 1 2 3 
				 * 이 되지만, 실제 답은
				 * 8 8 8 3 2 1 이다.
				 * 즉, 중복 숫자들과 교환된 숫자들은 다시 sort 후 대입한다. 
				 */
				Integer[] tmpArr = new Integer[al.size()];
				
				for(int i=0;i<al.size();i++) {
					tmpArr[i] = board[al.get(i)];
				}
				
				Arrays.sort(tmpArr, new Comparator<Integer>() { //내림차순 정렬
					@Override
					public int compare(Integer o1, Integer o2) {
						return o2-o1;
					}
				});
				
				int idx = 0;
				for(int i : al) {
					board[i] = tmpArr[idx++];
				}
			}
			
			
			
			//짝수번 남았으면 무시, 홀수 번이면 1의 자리와 10의자리를 바꿔준다.
			if(change%2 == 1 && hs.size() == board.length) {
				int len = board.length-1;
				int tmp = board[len]; //1.가장 큰 숫자위치와 가장 왼쪽 원소 swap
				board[len]=board[len-1]; 
				board[len-1]=tmp;
			} 
		
			
			
			System.out.print("#"+tc+" ");
			for(int i=0;i<board.length;i++) System.out.print(board[i]);
			System.out.println();
		}//end of tc
		
	}//end of main
}
