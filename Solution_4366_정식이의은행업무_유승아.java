import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//SWEA :: 4366. 정식이의 은행업무
//2019-04-03
public class Solution_4366_정식이의은행업무_유승아 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc =1; tc<=T;tc++) {
			String two = br.readLine();
			String three = br.readLine();
			ArrayList<Integer> twoList = new ArrayList<>();
			ArrayList<Integer> threeList = new ArrayList<>();
			for(int i=0;i<two.length();i++) {
				if(two.charAt(i)=='0') {
					String tmp = two.substring(0, i)+"1"+two.substring(i+1, two.length());
					twoList.add(Integer.valueOf(tmp, 2));
				}
				else if(two.charAt(i)=='1') {
					String tmp = two.substring(0, i)+"0"+two.substring(i+1, two.length());
					twoList.add(Integer.valueOf(tmp, 2));
				}
			}
			
			for(int i=0;i<three.length();i++) {
				if(three.charAt(i)=='0') {
					String tmp = three.substring(0, i)+"1"+three.substring(i+1, three.length());
					threeList.add(Integer.valueOf(tmp, 3));
					tmp = three.substring(0, i)+"2"+three.substring(i+1, three.length());
					threeList.add(Integer.valueOf(tmp, 3));
				}
				else if(three.charAt(i)=='1') {
					String tmp = three.substring(0, i)+"0"+three.substring(i+1, three.length());
					threeList.add(Integer.valueOf(tmp, 3));
					tmp = three.substring(0, i)+"2"+three.substring(i+1, three.length());
					threeList.add(Integer.valueOf(tmp, 3));
				}
				else if(three.charAt(i)=='2') {
					String tmp = three.substring(0, i)+"1"+three.substring(i+1, three.length());
					threeList.add(Integer.valueOf(tmp, 3));
					tmp = three.substring(0, i)+"0"+three.substring(i+1, three.length());
					threeList.add(Integer.valueOf(tmp, 3));
				}
			}
			
			Collections.sort(twoList);
			Collections.sort(threeList);
			
			int tmp2, tmp3;
			int ans = -1;
			for(int i=0,j=0;i<twoList.size();i++) {
				tmp2 = twoList.get(i);
				
				for(;j<threeList.size();j++) {
					tmp3 = threeList.get(j);
					if(tmp2<tmp3) break;
					else if(tmp2>tmp3) continue;
					if(tmp2==tmp3) {
						ans = tmp2;
						break;
					}
				}
				if(ans!=-1) break;
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
