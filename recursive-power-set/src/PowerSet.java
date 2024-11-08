public class PowerSet {
    public static boolean totalNullCheck(String[] s)
    {
        for (int i = 0; i < s.length; i++)
        {
            if ( s[i] != null )
            {
                return false;
            }
        }
        return true;
    }
    public static int power(int a, int b)
    {
        int product = 1;
        for (int i = 0; i < b; i++)
        {
            product = product * a;
        }
        return product;
    }
    public String[] checkRepetition(String[] set)
    {
        int size = set.length;
        for (int i = 0; i < size; i++)
        {
            for (int j = i + 1; j < size; j++)
            {
                while ( (set[i].equals(set[j])) && (j < size) )
                {
                    for (int k = j; k < size - 1; k++)
                    {
                        set[k] = set[k + 1];
                    }
                    size--;
                }
            }
        }
        String[] updatedSet = new String[size];
        System.arraycopy(set, 0, updatedSet, 0, size);
        return updatedSet;
    }
    public static void powerSet(String[] inputSet, int index, String[] currentSubset) {
        if (index == inputSet.length) {
            printSubset(currentSubset);
            if (!(totalNullCheck(currentSubset)))
            {
                System.out.print(", ");
            }
            return;
        }

        currentSubset[index] = inputSet[index];
        powerSet(inputSet, index + 1, currentSubset);

        currentSubset[index] = null;
        powerSet(inputSet, index + 1, currentSubset);
    }

    private static void printSubset(String[] subset)
    {
        System.out.print("{");
        for (int i = 0; i < subset.length; i++) {
            if (subset[i] != null)
            {
                System.out.print(subset[i]);
            }
            if (i < subset.length - 1)
            {
                if ( (subset[i+1] != null) )
                {
                    System.out.print(",");
                }
            }
        }
        System.out.print("}");
    }
}