// NOTE: make sure to put your code in the default package

import java.util.*; // NOTE: please ask privately on piazza if you think you need to import a package outside of the Java standard library

public class Problem2 {
    /*
        INSTRUCTIONS: For each for the following four functions, the input consists of a set A, and
        a relation R represented as a set of ordered pairs. R will always be a subset of A x A.
        Method "isPropertyX(A,R)" returns true if R has property X, and false otherwise.
        Note that here we use the Pair class (see Pair.java) to represent an ordered pair.
        Pair(c, d) represents cRd and Pair(d, c) represents dRc.
     */
    public static Set<Pair> crossA(Set<Integer> A){
        Set<Pair> ret = new HashSet<>();
        for(Integer x : A){
            for(Integer y : A){
                Pair e = new Pair(x, y);
                ret.add(e);
            }
        }
        return ret;
    }

    public static boolean isReflexive (Set<Integer> A, Set<Pair> R) {
        Set<Pair> domain = crossA(A);
        for(Pair target : domain){
            if(target.a == target.b && !R.contains(target)){
                return false;
            }
        }
        return true;
    }

    public static boolean isTransitive (Set<Integer> A, Set<Pair> R) {
        Set<Pair> domain = crossA(A);
        for(Pair ab : domain){
            if(R.contains(ab)){
                Integer first = ab.getB();
                for(Pair bc : domain){
                    Integer second = bc.getA();
                    if(first.equals(second) && !ab.equals(bc) && R.contains(bc)){
                        //if we're not looking at same coordinate pair & 2nd pair is in R
                        Pair ac = new Pair(ab.getA(), bc.getB());
                        if(!R.contains(ac)) return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isSymmetric (Set<Integer> A, Set<Pair> R) {
        for(Integer a : A){
            for(Integer b : A){
                if(!a.equals(b)){
                    Pair ab = new Pair(a, b);
                    Pair ba = new Pair(b, a);
                    if(R.contains(ab) && !R.contains(ba)) return false;
                }
            }
        }
        return true;
    }

    public static boolean isAsymmetric (Set<Integer> A, Set<Pair> R) {
        //note, asymmetric functions must not contain any pair (a,a)
        for(Integer a : A){
            for(Integer b : A){
                    Pair ab = new Pair(a, b);
                    Pair ba = new Pair(b, a);
                    if(R.contains(ab) && R.contains(ba)) return false;
            }
        }
        return true;
    }

    /**
     * This is an example for the relation <= on the set {0, 1, 2, 3, 4}
     *    Here A = {0, 1, 2, 3, 4} and
     *    R = {(0,0), (0,1), (0,2), (0,3), (0,4), (1,1), (1,2), (1,3), (1,4), (2,2), (2,3), (2,4), (3,3), (3,4), (4,4)}
     *    This relation is reflexive and transitive but is neither symmetric nor asymmetric.
     * NOTE: This is here to help you test your code. Nothing written in the main method will be run by the autograder
     */
    public static void main(String[] args) {
        Set<Integer> A = new HashSet<>();
        Set<Pair> R = new HashSet<>();

        for (int a = 0; a < 5; a++) A.add(a);
        for(int a: A){
            for(int b: A){
                if(a != b) R.add(new Pair(a, b));
            }
        }

        Set<Pair> test = crossA(A);
        //System.out.println(test);
        System.out.println("reflexive: " + isReflexive(A, R));      // expected: true
        System.out.println("transitive: " + isTransitive(A, R));    // expected: true
        System.out.println("symmetric: " + isSymmetric(A, R));      // expected: false
        System.out.println("asymmetric: " + isAsymmetric(A, R));    // expected: false
    }
}