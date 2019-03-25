import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ :: 1805 �����ڸ���
//2019-03-22

public class Main2805 {
	static int N;
	static long[] arr;
	static long M,ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());//���� ��
		M = Long.parseLong(st.nextToken());//����̰� �ʿ��� ������ ����
		
		ans = Long.MIN_VALUE;
		arr = new long [N];
		st = new StringTokenizer(br.readLine(), " ");
		long maxh = Long.MIN_VALUE;
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			maxh = maxh<arr[i]? arr[i] : maxh;
		} 
		/////////////////input
		
		bsearch(0, maxh);
		System.out.println(ans);
		
		
	}
	static boolean flag = false;
	public static void bsearch(long start, long end) {
		//if(flag) return;
		if(start>end) {
			return ;
		}
		
		long mid = (start+end)/2; //���� ���ܱ� ����
		
		//��������
		long sum = 0;
		for(int i=0;i<N;i++) {
			long tmp = arr[i]-mid;
			sum += ((tmp>0)? tmp : 0);
		}
		//sum�� M���� ������ ���̸� �����.
		//sum�� M���� ũ�� ���̸� ���δ�.
		if(sum>=M) {
			ans = ans < mid? mid:ans;
			bsearch(mid+1, end);
		}
		else if(sum<M) {
			bsearch(start, mid-1);
		}
		return;
	}
}
