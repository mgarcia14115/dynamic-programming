import java.util.*;

public class Kattis{
	static int itemsChose = 0;
	static ArrayList<Integer> idx;
	public static int [][] table (int cap,int items ,int []values, int[] weights){
		idx = new ArrayList<>();

		int [][] dp = new int[items+1][cap+1];

		for(int i = 0 ;i < dp.length;i++){

			for(int j = 0 ;j < dp[i].length;j++){

				dp[i][j] = f(i,j,values,weights,dp);
			}
		}



		return dp; 

	}


	public static int f(int i , int j, int[] values,int[] weights,int[][]k){
		int a = 0;
		int b = 0;
		int c = 0;
		if( i == 0 || j ==0){
			return 0;
		} 

		a = k[i-1][j];
		b = k[i][j-1];
		if( j>=weights[i-1]){
			c = values[i-1] + k[i-1][j-weights[i-1]];
		}
		
		
		
		

		return Math.max(c,Math.max(a, b));
	}

	public static void print(int [][] x){

		for(int i = 0 ;i < x.length;i++){
			for(int j = 0 ; j< x[i].length;j++){
				System.out.print(x[i][j] + " ");
			}
			System.err.println();
		}
		
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		
		
		

		while(in.hasNext()){
			String [] info = in.nextLine().split(" ");
			int cap = Integer.parseInt(info[0]);
			int items = Integer.parseInt(info[1]);
			int [] values = new int[items];
			int [] weights = new int[items];
			for(int i = 0 ; i < items;i++){

				String [] temp = in.nextLine().split(" ");
				values[i] = Integer.parseInt(temp[0]);
				weights[i] = Integer.parseInt(temp[1]);
				
			}
			int [][] table = table(cap, items, values, weights);
			print(table);	

		}


	}
}