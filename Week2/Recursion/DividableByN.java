package Week2.Recursion;

public class DividableByN {
    static int count=0;
    static int sum=0;
    public static void main(String[] args) {
      int x=  sumOfDivideByN(100,7);
        System.out.println("x = " + x);
    }

    public static int sumOfDivideByN(int number,int divider) {
        if (number > 0) {
            if (number % divider == 0) {
                sum += number;
            }

        }else {
            return sum;
        }
        return sumOfDivideByN(--number, divider);
    }}

