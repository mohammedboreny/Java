import java.util.Scanner;
import java.util.Stack;
import java.util.function.Predicate;

public class ParenthesesCheck {

        public static void main(String[] args) {
//            Scanner s=new Scanner(System.in);
//            String string=s.nextLine();
            boolean check=isValid("(())");
            System.out.println(check?"\tIs Valid String":"\tIs not valid String");
        }

     /***
         *
         * @param data of type String
         * @return boolean value
         * @isValid() is a method to check the String if all '(' has a cumulative parent ')'
         * Strings tested:
         * (()) -> True
         * ))(( -> False
         * (((((( -> False
         * )() -> False
         */


    public static boolean isValid(String data){
        data=data.trim();
        char[] dataToChar= data.toCharArray();
        Predicate<String> checkString= string->string.length()%2==0&&string.length()>0&&dataToChar[0]!=')';
        if (!checkString.test(data))
            return false;

        Stack<Character> x=new Stack<>();

        for (int i = 0; i <data.length() ; i++) {
            x.push(dataToChar[i]);
            if (x.peek()==')'&x.size()>1) {
                x.pop();
                x.pop();
            }
            else if (x.peek()==')'&x.size()==1) {
                return false;
            }

            System.out.println(x);
        }
        return x.size()==0;
    }
}