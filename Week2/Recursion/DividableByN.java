
public class DividableByN {
    static int sum=0;
    public static void main(String[] args) {
      int x=  sumOfDivideByN(100,7);
        System.out.println("x = " + x);
    }

    public static int sumOfDivideByN(int number,int divider) {

        if (number > 0) {
          sum+=number%divider==0?number:0;
        }else {
            return sum;
        }
        return sumOfDivideByN(--number, divider);
    }}

