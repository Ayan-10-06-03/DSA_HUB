class Solution 
{
    private void helper(int n, String curr, List<String> result)
    {
        if (n == 0)
        {
            result.add(curr);
            return;
        }

        helper(n-1, curr+"1", result);
        if (curr.length() == 0 || curr.charAt(curr.length()-1) != '0')
        {
            helper(n-1, curr+"0", result);
        }
    }
    
    public List<String> validStrings(int n) 
    {
        List<String> result = new ArrayList<>();
        String curr = "";

        helper(n, curr, result);
        return result;
    }
}