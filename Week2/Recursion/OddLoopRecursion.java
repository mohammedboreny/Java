package Week2.Recursion;

public class OddLoopRecursion {
    public static void main(String[] args) {

        int test = sumOfOdd(0, 100, 0);
        System.out.println("test = " + test);
    }
        public static int sumOfOdd(int start,int end,int sum){
            int sumTemp=start%2!=0?sum+start:sum+0;
            return start>end? sum:sumOfOdd(++start, end,sumTemp);
        }

}
