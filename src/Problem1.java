// NOTE: make sure to put your code in the default package
// NOTE: please ask privately on piazza if you think you need to import a package outside of the Java standard library

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Problem1 {

    public static String[] makeParams(int n){
        String[] terms = new String[n];
        for(int i = 0; i < n; i++){
            terms[i] = "x" + i;
        }
        return terms;
    }

    public static String makeString(boolean[] t_list, String[] inst, int n){
        String ret = "(";
        for(int i = 0; i < n; i++){
            if(!t_list[i]){
                ret += "n" + inst[i];
            }
            if(t_list[i]){
                ret += inst[i];
            }
            if(i < n - 1){
                ret += " " + "^" + " ";
            }
        }
        return ret + ")";
    }


    public static String convertToDNF (int n, boolean[][] table) {
        String[] vars = makeParams(n);
        String ret = "";
        int i = 1;
        int trueCount = 0;
        for(boolean[] t_list : table){
            if(t_list[n]){
                ret += makeString(t_list, vars, n) + " " + "v" + " ";
                trueCount ++;
            }
            i ++;
        }
        if(trueCount > 0){
            ret = ret.substring(0, ret.length() - 2);
        }
        return ret;
    }

    /**
     * This is an example for the Boolean function xor of two variables (x0, x1) corresponding to the following truth table:
     *
     *          | x0 | x1 |x0 xor x1|
     *          ---------------------------
     *          | F  |  F |    F    |
     *          | F  |  T |    T    |
     *          | T  |  F |    T    |
     *          | T  |  T |    F    |
     * NOTE: This is here to help you test your code. Nothing written in the main method will be run by the autograder
     */
    public static void main(String[] args) {
        boolean[][] table = {
                {false, false, false},
                {false, true, true},
                {true, false, true},
                {true, true, false}
        };
        String[] test = makeParams(3);
        boolean[] test2 = {false, true, true};

        //System.out.println(makeString(test2, new String[]{"x0", "x1"}, 2));

        //for(String inst : test){
         //   System.out.println(inst);}
        System.out.println(convertToDNF(2, table)); //sample solution: (nx0 ^ x1) v (x0 ^ nx1)
    }
}