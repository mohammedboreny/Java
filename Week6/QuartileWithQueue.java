import java.util.Comparator;
import java.util.PriorityQueue;

public class QuartileWithQueue {
    public static void main(String[] args) {
        int[] array = {3, 2, 4, 8,10,11,5};
        double result=median(array);
        System.out.println("Median is \t"+result);
    }

    /***
     *
     * @param array
     * @return the median of the passed array
     * This is a demonstration on PriorityQueue to solve a problem where a list of values is given
     * without being ordered.
     * The idea process:
     * 1-Create two PriorityQueue (higher and lower).
     * 2-let higher queue fill in descending order, higher.peek() would be the lower value in the queue
     * 3-let lower queue fill in ascending order(reversed), lower.peek() would be the higher value in the queue.
     * 4-loop over the given array then:
     *   -keep adding values to higher priority on every iteration.
     *   -if the higher.size-lower.size==1, poll from higher and add it to lower queue.
     */
    public static double median(int... array) {
        PriorityQueue<Integer> higher=
                new PriorityQueue<>(Integer::compareTo);
        PriorityQueue<Integer> lower=
                new PriorityQueue<>(Comparator.<Integer>comparingInt(a->a).reversed());

        for (int i : array) {
            higher.add(i);
           if (higher.size()-lower.size()==1){
                lower.add(higher.poll());
           }
        }
        System.out.println("Q1="+lower+"\nQ3= "+higher);
        return (double) (higher.peek() + lower.peek()) /2;
    }
}

