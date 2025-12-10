class Solution 
{
    public int maxFrequencyElements(int[] nums) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
        {
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : map.values())
        {
            list.add(num);
        }

        Collections.sort(list);
        int fc = list.get(list.size()-1);
        int max = list.get(list.size()-1);

        for (int i=list.size()-2; i>=0; i--)
        {
            if (list.get(i) == max)
            {
                fc = fc + list.get(i);
            }
        }

        return fc;
    }
}