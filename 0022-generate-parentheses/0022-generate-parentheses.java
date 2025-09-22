class Solution 
{
    private void helper(int open, int close, String curr, List<String> result)
    {
        if (open == 0 && close == 0)
        {
            result.add(curr);
            return;
        }

        if (open != 0)
        {
            helper(open-1, close, curr+"(", result);
        }

        if (close > open)
        {
            helper(open, close-1, curr+")", result);
        }
    }

    public List<String> generateParenthesis(int n) 
    {
        List<String> result = new ArrayList<>();
        int open = n;
        int close = n;
        String curr = "";

        helper(open, close, curr, result);
        return result;
    }
}