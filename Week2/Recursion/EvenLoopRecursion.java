package Week2.Recursion;

public class EvenLoopRecursion {
    public static void main(String[] args) {

            int test=sumOfEvens(0,100,0);
            System.out.println("test = " + test);
        }
    public static int sumOfEvens(int start,int end,int sum){
        int sumTemp=start%2==0?sum+start:sum+0;
        return start>end? sum:sumOfEvens(++start,end,sumTemp);
    }
}
