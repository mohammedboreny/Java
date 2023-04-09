public class DividableBy7 {

    public static void main(String[] args) {
        int i=7;
        int sum=0;
        //  forLoop Implementation
        for (;i<=100;i+=7){
            sum+=i;
        }

        System.out.println("sum with for loop = " + sum);
        //  While Loop Implementation
        sum=0;
        i=7;
        while (i<=100){
            sum+=i;
            i+=7;
        }
        System.out.println("sum with while loop= " + sum);
        //  Do-While Loop Implementation

        sum=0;
        i=7;
        do {

            sum += i;
            i += 7;
        }while (i <= 100);

        System.out.println("sum with Do While loop = " + sum);

    }
}
