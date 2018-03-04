
import java.util.Random;
public class QuickSort
{
    public static void main(String args[])
    {
        int[] A = {10, 80, 30, 90, 40, 50, 70};
        //quicksort(A, 0, 6);
        qs(A, 0, 6);
        for(int i:A)
        {
            System.out.println(i);
        }
        int[] numbers = {5, 5, 1, 5, 2, 3, 2, 2, 2, 5, 4,5, 5, 5,  2};
        int result = getMajority(numbers);
        System.out.println("majority is " + result);
    }

    static int partition(int[] numbers, int low, int high)
    {
        Random random = new Random();
        int pi = random.nextInt(high - low + 1) + low;
        swap(numbers, pi, high);

        int j = low-1;
        for(int i = 0; i <=  high; ++i)
        {
            if (numbers[i] < numbers[high])
            {
                ++j;
                if (i != j)
                    swap(numbers, j, i);
            }

        }
        ++j;
        if(j != high)
        {
            swap(numbers, j, high);

        }
        return j;
    }


    static private void qs(int[] numbers, int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                swap(numbers, i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            qs(numbers, low, j);
        if (i < high)
            qs(numbers, i, high);
    }

    static int getMajority(int[] numbers)
    {
        int result = numbers[0];
        int times = 1;
        for(int i = 0; i < numbers.length; ++i)
        {
            if (times == 0)
            {
                result = numbers[i];
                times = 1;
            }
            else if (numbers[i] == result)
            {
                times++;
            }
            else{
                times--;
            }
        }

        if (checkMajorityExists(numbers, result)==false)
        {
            throw new IllegalArgumentException("No majority exists");
        }
        return result;
    }

    static boolean checkMajorityExists(int[] numbers, int number)
    {
        int times = 0;
        for(int i = 0; i < numbers.length; ++i)
        {
            if (numbers[i]  == number)
            {
                times++;
            }
        }
        return times>=(numbers.length/2)?true:false;
    }


    static void quicksort(int numbers[], int low, int high)
    {
        if (low >= high)
        return;

        int index = partition(numbers, low, high);
        quicksort(numbers, low, index);
        quicksort(numbers, index+1, high);
    }


    static void swap(int numbers[], int one, int two)
    {
        int temp = numbers[one];
        numbers[one] = numbers[two];
        numbers[two] = temp;
    }
}