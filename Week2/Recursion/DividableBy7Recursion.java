package Week2.Recursion;

public class DividableBy7Recursion {

    public static void main(String[] args) {
        int test=sumOf7s(0,100,0);
        System.out.println("test = " + test);
    }
    public static int sumOf7s(int start,int end,int sum){
        int sumTemp=start%7==0?sum+start:sum+0;
         return start>end? sum:sumOf7s(++start, end,sumTemp);
    }
}
