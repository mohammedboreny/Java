package Week5.src;


import java.util.Arrays;
import java.util.stream.Stream;

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
//         Stream.of(students).
        ExpandedArray<Student> studentExpandedArray = ExpandedArray.of(students).flatMap(s -> Stream.of(s.getCourse()));
        System.out.println(studentExpandedArray);
//        List<Student> studentsToList = toList(students);
//        System.out.println(studentsToList);
//        System.out.println("//Students -> List<Integer> using streams");
//        List<Student> studentsList = Stream.
//                of(students).collect(Collectors.toList());
//        studentsList.forEach(System.out::println);
//        System.out.println('\n');
//        System.out.println("// grouping student by age <20 using streams");
//        Map<Integer, List<Student>> studentsAboveAge_20_Grouping = Arrays.stream(students).filter(student -> student.getAge() < 20)
//                .collect(groupingBy(Student::getAge));
//        System.out.println("studentsAboveAge_20_Grouping = " + studentsAboveAge_20_Grouping+'\n');
//        System.out.println(" //grouping(keyExtractorFunction,valueExtractorFunction)->Map<Key,List<V>>");
//        Map<String, Integer> groupingByNameAndAge = Arrays.stream(students)
//                .collect(grouping(Student::getName, Student::getAge));
//        System.out.println("groupingByNameAndAge = " + groupingByNameAndAge);
    }

    //toList->List implementation
//    public static <T> ArrayList<T> toList(T...data){
//
//        if (data==null ||data.length<1)
//            throw new IllegalArgumentException("Array is empty or length is < 1 ");
//        return reduceL(new ArrayList<T>(),
//                acc -> e -> {
//                    acc.add(e);
//                    return acc;
//                }, data);
//    }


    //grouping(keyExtractorFunction,valueExtractorFunction)->Map<Key,List<V>>
//    public <U,V> Map<U, ArrayDeque<V>> grouping(Function<T,U> keyExtractor,Function<T,V> valueExtractor){
//        return reduceL(
//                new HashMap<>(),
//                acc->e->{
//                    U key = keyExtractor.apply(e);
//                    acc.compute(key, (k,l)->{
//                        if(l == null){
//                            l=new ArrayDeque<>();
//                        }
//                        l.addLast(valueExtractor.apply(e));
//                        return l;
//                    });
//                    return acc;
//                });
//    }
}
