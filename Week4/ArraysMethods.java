public class ArraysMethods {
    public static void main(String[] args) {
        int[] testArray = {7,1, 4, 3, 2};
        System.out.println("The min value in array is = " + minValue(testArray));
        System.out.println("The max value in array is = " + maxValue(testArray));
        System.out.println("The average Value in array is = " + avgValue(testArray));
        System.out.print("Sorting array using selection sort would be = {" );
        for (int i : arraySelectionSort(testArray)) {
            System.out.print(","+i);
        }
        System.out.print("}"+"\n");
        int findKeyIndex=binaraySearchArray(5, testArray);
        String searchResult= findKeyIndex<0?"Key value not found":"The key is on index\t"+findKeyIndex;
        System.out.println("Search result:" + searchResult);

    }

    public static int minValue(int... array) {
        int min = array[0];
        for (int value : array) {
            min = value <= min ? value : min;
        }
        return min;
    }

    public static int maxValue(int... array) {
        int max = array[0];
        for (int value : array) {
            max = value >= max ? value : max;
        }
        return max;
    }

    public static double avgValue(int... array) {
        double sum = 0;
        int count = 0;
        for (int value : array) {
            sum += value;
            count++;
        }
        return  (sum / count);
    }

    public static int[] arraySelectionSort(int... array) {
        int[] sorted = array.clone();
        for (int i = 0; i < sorted.length-1; i++) {
            //Find the minimum value in the sorted array
            int currentMin = sorted[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < sorted.length; j++) {
                if (currentMin > sorted[j]) {
                    currentMin = sorted[j];
                    currentMinIndex = j;
                }
            }
            // Swap sorted[i] with sorted[currentMinIndex]
            if (currentMinIndex != i) {
                sorted[currentMinIndex] = sorted[i];
                sorted[i] = currentMin;
            }

        }
        return sorted;
    }

    public static int binaraySearchArray(int key, int... array) {
        // To insure the array is sorted, using user defined function
        int[] sortedArray = arraySelectionSort(array);
        // Defining low and high base index, also working as pointers
        int low = 0;
        int high = sortedArray.length - 1;
        while (high >= low) {
            // in every step, relocate the mid index based on the low and high index
            int mid = (low + high) / 2;
            /* check the mid value respectively
             * -if mid value < key, make high index pointing to mid-1.
             * -if mid value == key, return the mid immediately.
             * -otherwise, make low index pointing to mid+1.
             *   */
            if (sortedArray[mid] > key)
                high = mid - 1;
            else if (sortedArray[mid] == key)
            {
                return mid;
            }
            else low = mid + 1;
        }

        // in case the key is not found in the given array, return -1
        return  -1;
    }
}
