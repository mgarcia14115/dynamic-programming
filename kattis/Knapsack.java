import java.util.*;

public class Knapsack{
	static int itemsChose;
	static ArrayList<Integer> idx;
	public static int [][] table (int cap,int items ,int []values, int[] weights){
		idx = new ArrayList<>();

		int [][] dp = new int[items+1][cap+1];

		for(int i = 0 ;i < dp.length;i++){

			for(int j = 0 ;j < dp[i].length;j++){

				dp[i][j] = piecewise(i,j,values,weights,dp);
			}
		}



		return dp; 

	}


	public static int piecewise(int i , int j, int[] values,int[] weights,int[][]k){
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

	public static void backtracking(int [][] table , int [] weights){

		int i = table.length-1;
		int j = table[0].length-1;

		while( i != 0){
			if(table[i][j] == table[i-1][j]){
				i = i-1;
			}else{
				itemsChose++;
				idx.add(i-1);
				j = j - weights[i-1];
				i = i-1;
			}
		}

	}

	public static void print(int [][] x){

		for(int i = 0 ;i < x.length;i++){
			for(int j = 0 ; j< x[i].length;j++){
				System.out.print(x[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while(in.hasNextLine()){
			
			String line = in.nextLine();
			if ( line.isEmpty()){
				break;
			}
			itemsChose = 0;
			idx = new ArrayList<>();
			String [] info = line.split(" ");
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
			backtracking(table, weights);
			System.out.println(itemsChose);
			printList(idx);

		}

		in.close();


	}

	public static void printList(ArrayList<Integer> x){
		for(int i = 0 ;i < x.size();i++){
			System.out.print(x.get(i) + " ");
		}
		System.out.println();
	}
}