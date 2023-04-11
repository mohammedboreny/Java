
public class DividableByN {
     static int sum=0;
     static int sumHolder=0;
    public static void main(String[] args) {
      int x=  sumOfDivideByN(100,7);
        int y=  sumOfDivideByN(100,7);
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }

    public static int sumOfDivideByN(int number,int divider) {

        if (number > 0) {
          sum+=number%divider==0?number:0;
        }else {
            sumHolder=sum;
            sum=0;
            return sumHolder;
        }
        return sumOfDivideByN(--number, divider);
    }}

