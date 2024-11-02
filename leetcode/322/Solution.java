import java.util.*;
public class Solution{

    public static int [][] createtable(int [] coins, int amount){
        int [][] table = new int[coins.length+1][amount+1];

        for(int i = 0 ; i < table.length;i++){

            for(int j = 0 ; j < table[i].length;j++){
                table[i][j] = piecewisefunction(i, j, table, coins);

            }
        }

        return table;
    }


    public static int piecewisefunction(int i , int j , int[][] table, int[] coins){

        if((i == 0 && j == 0) || (i > 0 && j == 0)){
            return 0;
        }

        if( i == 0 && j > 0){
            return -1;
        }

        if (j >= coins[i-1]){

            int case1 = table[i-1][j];
            int case2 = table[i][j-coins[i-1]];

            if (case1 != -1 && case2 != -1){
                return Math.min(case1,(1+case2));
            }

            if(case1 != -1 && case2 == -1){
                return case1;
            }

            if(case1 == -1 && case2 != -1){
                return 1+case2;
            }

            return -1;

        }

        int case1 = table[i-1][j];

        if( case1 != -1){
            return case1;
        }

        return -1;


    }

    public static boolean backtracing(int [][] table , int i , int j , int [] coins){

        if( j > 0 && i > 0 && table[i][j] == 0){

            return false;
        }

        if( i == 0){
            return true;
        }

        if( table[i-1][j] == table[i][j]){
            i-=1;
            return backtracing(table, i, j,coins);
        }else{
            j -= coins[i-1];
            return backtracing(table, i, j, coins);
        }


    }


    public static void printTable( int [][] x){
        for(int i = 0 ;i < x.length;i++){
            for(int j = 0 ;j < x[i].length;j++){
                System.out.print(x[i][j] +" ");
            }
            System.out.println();
        }
    }

    public static int coinChange(int[] coins,int amount) {


        int [][] table = createtable(coins, amount);



        return table[table.length-1][table[0].length-1];



    }



}
