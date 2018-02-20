
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
    
}