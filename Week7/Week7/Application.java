package Week7;


//import static Week7.MyLinkedList.unZip;

public class Application {
    public static void main(String[] args) {

        MyLinkedList<Integer> numbers = MyLinkedList.of(1, 2, 3, 4, 5);
        numbers.forEach(System.out::println);
        numbers.map(e->2*e).forEach(System.out::println);
        System.out.println("++++++++++++++++++");
        numbers.flatMap(integer -> MyLinkedList.of(integer-1,integer,integer+1)).forEach(System.out::println);
        Integer sum = numbers.reduceL(0, acc -> e -> acc + e);
        System.out.println("sum"+sum);


        MyLinkedList<Integer> ids = MyLinkedList.of(1000, 1001, 1002,1003);
        MyLinkedList<String> names = MyLinkedList.of("Mohammad", "Ahmad", "Mosa");
        MyLinkedList<Tuple<Integer, String>> nameWithIds = ids.zip(names);

        nameWithIds.forEach(System.out::println);
        Tuple<MyLinkedList<Integer>, MyLinkedList<String>> myLinkedListMyLinkedListTuple = MyLinkedList.unZip(nameWithIds);
        System.out.println(myLinkedListMyLinkedListTuple);

    }
}
