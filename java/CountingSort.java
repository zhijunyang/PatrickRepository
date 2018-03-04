public class CountingSort
{
    public static void main(String args[])
    {

        int[] A = {5, 2, 9, 5, 2, 3, 5};
        int[] result = CountSort(A, 9);
        for(int i: result)
        {
            System.out.println(i);
        }

    }

    static int[] CountSort(int[] A, int max)
    {
        int[] result = new int[A.length];
        int[] count = new int[max + 1];
        for(int i: A)
        {
            count[i]++;
        }

        int j = 0;
        for(int i = 0; i < count.length; i++)
        {
            int temp = count[i];

            while(temp-- > 0)
            {
                result[j++] = i;
            }

        }
        return result;
    }

}