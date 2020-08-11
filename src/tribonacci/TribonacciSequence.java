/*
        * Tribonacci Sequence 
       ---------------------------------------------
       1, 1, 2, 5, 8, 4, -11, -17, 35, 152, 161, -254, -968, -575, 2813, 7049, 1394, -24047, -45260, 15472
 */
package tribonacci;

import java.util.ArrayList;
import java.util.Arrays;


public class TribonacciSequence {
    
    /* This trib method calculates the the n-th term of the sequence above by
       taking [n,x,y,z] as its arguments. The first 3 valuse are known to be 
       1-1-2. The rest of the values must be calculated by using 3 recursive 
       trib methods, each focusing on one of 3 immediately consecutive terms.
       This method is called from inside multiple for-loops (located in main)
       which iterate through multiple values of [x,y,z], until 3 values are
       found which together render the equations for the terms (4/5/6) true.
    */
    public static int trib(int n, int x, int y, int z) {
        
        if (n==1 || n==2)
            return 1;
       
        if (n==3)
            return 2;
        
        return (x*trib(n-1, x, y, z) + y*trib(n-2, x, y, z) + z*trib(n-3, x, y, z));
    }
    
    public static void main(String[] args) {
        
        /* Declaring ArrayList for later use in storing the correct sequence values */
        ArrayList<Integer> seq = new ArrayList<>();
        
        /* These 3 variables [X,Y,Z] will store the correctly calculated co-efficients */
        int X = 0;
        int Y = 0;
        int Z = 0;        
        
        // term4 = 5
        // term5 = 8
        // term6 = 4
        
       
        /* These 3 for-loops will iterate through [x,y,z] values from -10 to +10
           in order to use these values as inputs for testing whether they render 
           our 3 equations true in the if-statement below
        */
        for(int x= -10; x<=10; x++) {
            for(int y= -10; y<=10; y++) {
                for(int z= -10; z<=10; z++) {
                    
                    /*      
                            -Equations Used-
                            ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
                            z  + y + 2x = 5   -> (term 4)
                            z  + 2y + 5x = 8  -> (term 5)
                            2z + 5y + 8x = 4  -> (term 6)
                    */
                    
                    /* This if-statement only executes IF the particular [x,y,z] values that are being ran through
                       the for-loops cause all 3 equations to equal the value of their corresponding term.*/
                    if((z + y + 2*x) == 5 && (z + 2*y + 5*x) == 8 && (2*z + 5*y + 8*x) == 4) {
                        
                        
                        /* This for-loop is used to iterate and store the first 20 values of
                           the sequence using the trib method which calculates these values
                           using the particular [x,y,z] values that were previousy filtered.
                           The return values are then stored in the sequence ArrayList
                        */
                        for(int n=0; n<20; n++) {
                            
                            seq.add(trib(n+1, x, y, z));
                        }
                        
                        /* Stores the correct coefficients [x,y,z] that were used into [X,Y,Z] */
                        
                        X = x;
                        Y = y;
                        Z = z;
                    }
                }
            }
        }
        System.out.println();
        System.out.println("Tribonacci Sequence");
        
        /*Print out the sequence */
        System.out.println();
        System.out.println(Arrays.toString(seq.toArray()));
        System.out.println("________________________________________________________________________________________________________");
        
        /* Print out correct co-efficients */
        System.out.println();
        System.out.println("Equation:");
        System.out.println("¯¯¯¯¯¯¯¯¯¯");
        System.out.println(Z + "x + " + Y + "y + " + X + "z = n");
        System.out.println("___________________________________________________________________________________");
        System.out.println();
        System.out.println("— If x is the 1st term, y is the 2nd term, and z is the 3rd term of the \n"
                          +  "sequence, then n is the 4th term of that sequence. And the same applies \n"
                          +  "as one continues to shift higher on the sequence.");
    }
    
}
