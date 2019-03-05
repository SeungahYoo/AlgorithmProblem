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
			change = Integer.parseInt(st.nextToken());//��ȯ Ƚ��			
				
			int[] check = new int[10];
			Arrays.fill(check, -1);
			ArrayList<Integer> al = new ArrayList<Integer>();
			for(int i=0;i<board.length;i++) { //������
				board[i] = s.charAt(i)-'0';
				if(check[board[i]] != -1) { //�ߺ��� ���ڰ� ���� ���
					//al����Ʈ�� �ߺ��� ���ڵ��� �ε����� �����س��.
					if(al.isEmpty())al.add(check[board[i]]);
					al.add(i);
				}
				else check[board[i]] = i;	
			}
			
			for(int i=0;i<board.length;i++) { //��������
				if(change==0) break;
				
				int maxIndex = i;
				for(int j=i;j<board.length;j++) {
					if(board[maxIndex]<=board[j]) {
						maxIndex = j;
					}
				}
				if(maxIndex != i) {
					int tmp = board[maxIndex]; //1.���� ū ������ġ�� ���� ���� ���� swap
					board[maxIndex]=board[i]; 
					board[i]=tmp;
					change --;					
				} 
			} //end of for ��������
			
			//��ȯȽ���� ���� ���
			
			//������ ���ڰ� �����ϸ�, ���� �������� ��ȯȸ���� ���ҽ�ų �� �ִ�.
			HashSet<Integer> hs = new HashSet<Integer>(Arrays.asList(board));
			
			if(hs.size() != board.length) { // ���� ���� ����
				/* ó���� �����س� �ߺ��� ���ڵ��� �ε����� �̿��� 
				 * �ߺ� ���ڵ�� ��ȯ�� ���ڵ��� ���� ��, tmpArr �迭�� �����Ѵ�.
				 * 
				 * �ش� ���ڵ��� sort �� �ٽ� �Է��Ѵ�.
				 * 
				 * ex ) 
				 * 3 2 1 8 8 8 , 3�� ��ȯ
				 * �˰��� ���ϸ�
				 * 8 8 8 1 2 3 
				 * �� ������, ���� ����
				 * 8 8 8 3 2 1 �̴�.
				 * ��, �ߺ� ���ڵ�� ��ȯ�� ���ڵ��� �ٽ� sort �� �����Ѵ�. 
				 */
				Integer[] tmpArr = new Integer[al.size()];
				
				for(int i=0;i<al.size();i++) {
					tmpArr[i] = board[al.get(i)];
				}
				
				Arrays.sort(tmpArr, new Comparator<Integer>() { //�������� ����
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
			
			
			
			//¦���� �������� ����, Ȧ�� ���̸� 1�� �ڸ��� 10���ڸ��� �ٲ��ش�.
			if(change%2 == 1 && hs.size() == board.length) {
				int len = board.length-1;
				int tmp = board[len]; //1.���� ū ������ġ�� ���� ���� ���� swap
				board[len]=board[len-1]; 
				board[len-1]=tmp;
			} 
		
			
			
			System.out.print("#"+tc+" ");
			for(int i=0;i<board.length;i++) System.out.print(board[i]);
			System.out.println();
		}//end of tc
		
	}//end of main
}
