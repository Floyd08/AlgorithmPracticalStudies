package PS4;

import java.util.Arrays;

class CoinChange{
    int coins[], sum;
    int dpTable[][];
 
    CoinChange(int coins[], int sum){
        this.coins = coins;
        this.sum = sum;
        this.dpTable = new int[coins.length+1][sum+1];
 
        initDpTable();
    }
 
    //Function to initialize 1st column of dpTable with 1
    private void initDpTable(){
        for(int i=1; i<coins.length; i++){
          dpTable[i][0] = 1;
        }
    }
    
    public int solve(){
 
      for(int coinIndex=1; coinIndex<coins.length+1; coinIndex++){
          for(int dpSum=1; dpSum< sum+1; dpSum++){
 
            //coin value should be less than or equal to sum value in order to consider it
            if(dpSum-coins[coinIndex-1] < 0)
                dpTable[coinIndex][dpSum] = dpTable[coinIndex-1][dpSum];
            else
                dpTable[coinIndex][dpSum]  = dpTable[coinIndex-1][dpSum]+dpTable[coinIndex][dpSum-coins[coinIndex-1]];
                    
          }
      }
      
      //return final row and column value
      
      System.out.printf(" \t ");
      for (int i = 0; i <= sum; ++i)
    	  System.out.printf("%d  ", i);
		
      System.out.printf("\n");
		
      for (int i = 0; i <= coins.length; ++i)
    	  System.out.printf("%d\t%s\n", i, Arrays.toString(dpTable[i]));
      
      
      return dpTable[coins.length][sum];
 
    }
    
    
    public static void main(String[] args){
    	    int coins[] = {1,2,3};
    		CoinChange coinchange = new CoinChange(coins,4);
    		System.out.println("Total solutions: "+coinchange.solve());
    }
    
}
 

