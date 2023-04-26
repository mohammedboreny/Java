public class ArraysMethods {
    public static void main(String[] args) {

        System.out.println("arraySort(1,4,3,6) = " + arraySelectionSort(1, 4, 3, 2));
    }
    public static int minValue(int... array){
        int min=array[0];
        for (int value: array) {
          min=value<=min?value:min;
        }
        return min;
    };
    public static int maxValue(int... array){
        int max=array[0];
        for (int value: array) {
            max=value>=max?value:max;
        }
        return max;
    };
    public static int avgValue(int... array){
        int sum=0;
        int count=0;
        for (int value: array) {
            sum+=value;
            count++;
        }
        return sum/count;
    };
    public static int[] arraySelectionSort(int... array){
        int temp=0;
        int[] sorted=array.clone();
        for (int i = 1; i <sorted.length ; i++) {
            if (sorted[i-1]>sorted[i])
            {
                temp = sorted[i-1];
                sorted[i-1] = sorted[i];
                sorted[i] = temp;
            }
        }
        for (int value : sorted) {
            System.out.println("value = " + value);
        }
        return sorted;
    };
}
