
class My
{
    public static void main(String args[])
    {
        int[] numbers = {2, 1, 6, 3, 4, 0, 6};
        int dup = duplicate(numbers);
        System.out.println("duplicate is " + dup);

        int number = 1234221;
        boolean b = isPalindrom(number);

        System.out.println(number + " is palindrom is " + b);

        String string =new String("We are happy.");
        char[] str = string.toCharArray();
        ReplaceBlanks(str);
        int[] array1 = {2, 5, 6, 8, 10, 15, 23};
        int[] array2 = {3, 5, 8, 10, 12, 34, 36, 39};
        int[] array3 = mergeSortedArray(array1, array2);
    }

    static int duplicate1(int numbers[])
    {
        int length = numbers.length;
        int sum1 = 0, sum2 = 0;
        sum1 = (length-1)*(length-2) >> 1;
        for(int i = 0; i < length; i++)
        {
            sum2 += numbers[i];
        }
        int dup = sum2 - sum1;
        return dup;
    }

    static int duplicate(int numbers[])
    {
        int length = numbers.length;

        for(int i = 0; i < length; i++)
        {
            while(numbers[i] != i)
            {
                if (numbers[i] == numbers[numbers[i]])
                {
                    return numbers[i];
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }

        throw new IllegalArgumentException("No duplications.");
    }

    static boolean isPalindrom(int number)
    {
        boolean ret = false;
        int reversed = 0;
        int copy = number;
        while(number != 0)
        {
            reversed = reversed*10 + number%10;
            number /= 10;
        }
        ret = (copy == reversed)?true:false;
        return ret;
    }


    static void ReplaceBlanks(char[] string)
    {
        int originalIndex = 0 ; int newIndex = 0; int length = 0; int numberOfBlanks = 0;
        length = string.length;
        for(int i = 0; i < length; ++i)
        {
            if (string[i] == ' ')
            {
                ++numberOfBlanks;
            }

        }
        newIndex = length + numberOfBlanks*2-1;
        int longLength = newIndex + 1;
        originalIndex = length-1;
        char[] newString = new char[longLength];

        while(originalIndex >= 0)
        {
            if (string[originalIndex] == ' ')
            {
                newString[newIndex--] = '0';
                newString[newIndex--] = '2';
                newString[newIndex--] = '%';    
            }
            else{
                newString[newIndex--] = string[originalIndex];
            }
            originalIndex--;
        }
        String str = new String(newString, 0, longLength);
        System.out.println(str);
    }


    static private int[] mergeSortedArray(int[] array1, int[] array2)
    {
        int len1 = array1.length;
        int len2 = array2.length;
        int[] large = new int[len1 + len2];
        for(int i = 0; i < len1; ++i)
        {
            large[i] = array1[i];
        }
        int index1 = len1 - 1;
        int index2 = len2 -1;
        int index3 = len1 + len2 -1;
        while(index1 >= 0 && index2 >= 0)
        {
            if (array1[index1] >= array2[index2])
            {
                large[index3--] = array1[index1--];
            }
            else{
                large[index3--] = array2[index2--];
            }
        }

        while (index2 >= 0)
        {
            large[index3--] = array2[index2--];
        }

        return large;
    }
    
}