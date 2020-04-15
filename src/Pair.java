/**
 * Stores a pair of ints (a, b)
 * Used in problem 2 to represent an ordered pair and in problem 3 to represent an edge
 * NOTE: You do not write any code for this class. You also do not need to include this file with your submission.
 */
class Pair {
    int a;
    int b;

    public Pair(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int getA() {return a;}
    public int getB() {return b;}

    /* you do not need to worry about any of the methods below this line */
    @Override
    public boolean equals (Object o){
        Pair op = (Pair) o;
        return op.a == a && op.b == b;
    }

    @Override
    public int hashCode (){return a + b;}

    @Override
    public String toString (){return "(" + a + ", " + b + ")";}
}