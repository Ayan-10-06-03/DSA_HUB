//this was you
// class Solution 
// {
//     private void dec(int[] happiness, int i)
//     {
//         while (i >= 0)
//         {
//             if (happiness[i] != 0) happiness[i]--;
//             i--;
//         }
//     }

//     public long maximumHappinessSum(int[] happiness, int k) 
//     {
//         long sum = 0;
//         Arrays.sort(happiness);
//         ArrayList<Integer> list = new ArrayList<>();

//         for (int i=happiness.length-1; k > 0; i--)
//         {
//             list.add(happiness[i]);
//             dec(happiness, i-1);
//             k--;
//         }

//         for (int num : list)
//         {
//             sum = sum + num;
//         }

//         return sum;
//     }
// }

class Solution 
{
    public long maximumHappinessSum(int[] happiness, int k) 
    {
        long sum = 0;
        Arrays.sort(happiness);
        int dec = 0;

        for (int i=happiness.length-1; k>0 && i>=0;  k--,i--)
        {
            happiness[i] = happiness[i] - dec;
            if (happiness[i] > 0)
            {
                sum = sum + happiness[i];
            }
            dec++;
        }

        return sum;
    }
}