import java.util.Scanner;

public class Spring {

	
	public static void main(String[] args) {

	
	  int[][] chessBoard = new int[10][10];
	  
      for ( int i = 0 ; i < chessBoard.length ; i ++ ) {
          for ( int j = 0 ; j < chessBoard[i].length ; j ++ ) {
        	  if ( i %2 == 0 ) { // EVEN ROW
                  if ( j %2 == 0 ) {
                	  chessBoard[i][j] = 1 ;
                  }
              }
              else {
                  if ( j %2 == 1 ) {
                	  chessBoard[i][j] = 1 ;
                  }
              }
          }
      }
      
      for ( int[] x : chessBoard ) {
          for ( int y : x ) {
              System.out.print(y + " ");
          }
          System.out.println() ; 
      } 
      
      Scanner scanner  = new Scanner(System.in);
      System.out.println("enter the source index");
      System.out.println("enter the Row No : ");
      int srcRow = scanner.nextInt();
      System.out.println("enter the Column No : ");
      int srcCol = scanner.nextInt();

      System.out.println("enter the Destination index");
      System.out.println("enter the Row No : ");
      int desRow = scanner.nextInt();
      System.out.println("enter the Column No : ");
      int desCol = scanner.nextInt();

      for ( int i = 0 ; i < chessBoard.length ; i ++ ) {
          for ( int j = 0 ; j < chessBoard[i].length ; j ++ ) {
       
//          System.out.print(checker[i][j]+" ");
          if(i == srcRow  ) {
        	  if(j == srcCol) {
        		  if(chessBoard[srcRow][srcCol] == 1) {
        			  chessBoard[srcRow][srcCol] = 0;
        			  chessBoard[desRow][desCol] = 1;
        		  }
        		  else if(chessBoard[srcRow][srcCol] == 0){
        			  chessBoard[srcRow][srcCol] = 1;
        			  chessBoard[desRow][desCol] = 0;
        	        	
        		  }
        	  }
        	  
          }
          }
      
   }
      for ( int[] x : chessBoard ) {
          for ( int y : x ) {
              System.out.print(y + " ");
          }
          System.out.println() ; 
      }
      

      scanner.close();
      
	}

	
}