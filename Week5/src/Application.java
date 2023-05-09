package Week5.src;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toList;

public class Application {

    public static void main(String[] args) {
         Student[] students = new Student[]{
                Student.of("Ahmad", 20, Gender.MALE, true, Course.MATH, Course.CHEMISTRY, Course.JAVA),
                Student.of("Mohammad", 25, Gender.MALE, true, Course.MATH, Course.JAVA),
                Student.of("ESA", 27, Gender.MALE, false, Course.MATH, Course.JAVA),
                Student.of("ESRA", 19, Gender.FEMALE, true, Course.MATH, Course.ENGLISH),
                Student.of("DANA", 40, Gender.FEMALE, true, Course.MATH, Course.ENGLISH, Course.PHYSICS),
                Student.of("RUBA", 22, Gender.FEMALE, true, Course.MATH, Course.PHYSICS)

        };


        System.out.println("studentsToList = " );
        List<Student> studentsToList = toList(students);
        System.out.println(studentsToList);
        System.out.println("//Students -> List<Integer> using streams");
        List<Student> studentsList = Stream.
                of(students).collect(Collectors.toList());
        studentsList.forEach(System.out::println);
        System.out.println('\n');
        System.out.println("// grouping student by age <20 using streams");
        Map<Integer, List<Student>> studentsAboveAge_20_Grouping = Arrays.stream(students).filter(student -> student.getAge() < 20)
                .collect(groupingBy(Student::getAge));
        System.out.println("studentsAboveAge_20_Grouping = " + studentsAboveAge_20_Grouping+'\n');
        System.out.println(" //grouping(keyExtractorFunction,valueExtractorFunction)->Map<Key,List<V>>");
        Map<String, Integer> groupingByNameAndAge = Arrays.stream(students)
                .collect(grouping(Student::getName, Student::getAge));
        System.out.println("groupingByNameAndAge = " + groupingByNameAndAge);
    }

    //toList->List implementation
    public static <T> ArrayList<T> toList(T...data){

        if (data==null ||data.length<1)
            throw new IllegalArgumentException("Array is empty or length is < 1 ");
        return reduceL(new ArrayList<T>(),
                acc -> e -> {
                    acc.add(e);
                    return acc;
                }, data);
    }


    //grouping(keyExtractorFunction,valueExtractorFunction)->Map<Key,List<V>>
    public static <T, K, U>
    Collector<T, ?, Map<K,U>> grouping(Function<? super T, ? extends K> keyExtractorFunction,
                                       Function<? super T, ? extends U> valueExtractorFunction){
        return Collectors.toMap(keyExtractorFunction, valueExtractorFunction);
    }



    public static <U,T> U reduceR(U seed,Function<T,Function<U,U>> accFunction,T... data){
        if(data==null || data.length==0){
            return seed;
        }
        U result = seed;
        for (int i = data.length - 1; i >= 0; i--) {
            result=accFunction.apply(data[i]).apply(result);
        }
        return result;
    }




public static <U,T> U reduceL(U seed, Function<U,Function<T,U>> accFunction, T... data){

        if(data == null || data.length==0){
            return seed;
        }
        U accResult = seed;

        for (int i = 0; i < data.length; i++) {
            accResult=accFunction.apply(accResult).apply(data[i]);
        }

        return accResult;
    }
}
