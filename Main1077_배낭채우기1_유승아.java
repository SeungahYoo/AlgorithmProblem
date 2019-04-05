import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//JUNGOL :: 1077 �賶ä���
//2019-03-25

public class Main1077_�賶ä���1_���¾� {
	static class val{
		int w;
		int v;
		public val(int w, int v) {
			super();
			this.w = w;
			this.v = v;
		}
		
	}
	private static int W;
	private static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // ������ ���� ��
		W = Integer.parseInt(st.nextToken()); // �賶�� �뷮
		val[] arr = new val[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[i] = new val(w,v);
		}
		///////input
		
		
		
		///////dp
		int[] values = new int[W+1];
		
		//i�� ���� ����
		for(int i=0;i<N;i++) {
			//j�� ���� ����
			//�� ���Ժ��� ���� �賶�� ������ ���� ���� �����Ѵ�.
			for(int j=arr[i].w;j<=W;j++) { 
				values[j] = Math.max(values[j],values[j-arr[i].w]+arr[i].v);
			}
		}
		
		System.out.println(values[W]);
	}//end of main

}
