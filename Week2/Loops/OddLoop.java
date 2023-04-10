public class OddLoop {
    public static void main(String[] args) {
        int i=1;
        int sum=0;
        //  forLoop Implementation
        for (;i<=100;i+=2){
            sum+=i;
        }

        System.out.println("sum with for loop = " + sum);
        //  While Loop Implementation
        sum=0;
        i=1;
        while (i<=100){
            sum+=i;
            i+=2;
        }
        System.out.println("sum with while loop= " + sum);
        //  Do-While Loop Implementation

        sum=0;
        i=1;
        do {

            sum += i;
            i += 2;
        }while (i <= 99);

        System.out.println("sum with Do While loop = " + sum);
    }
}
