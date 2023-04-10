public class EvenLoop {
    public static void main(String[] args) {
        int i=0;
        int sum=0;
        //  forLoop Implementation
        for (;i<=100;i+=2){
            sum+=i;
        }

        System.out.println("sum with for loop = " + sum);
        //  While Loop Implementation
        sum=0;
        i=0;
        while (i<=100){
            sum+=i;
            i+=2;
        }
        System.out.println("sum with while loop= " + sum);
        //  Do-While Loop Implementation

        sum=0;
        i=0;
        do {
            i += 2;
            sum += i;
        }while (i < 100);

        System.out.println("sum with Do While loop = " + sum);
    }
}
