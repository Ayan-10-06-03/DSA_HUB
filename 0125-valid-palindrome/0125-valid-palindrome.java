class Solution 
{
    public boolean isPalindrome(String s) 
    {
        if (s.length() == 1)
        {
            return true;
        }

        String t = s.toLowerCase();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<t.length(); i++)
        {
            if ((t.charAt(i) >= 'a' && t.charAt(i) <= 'z') || (t.charAt(i)>='0' && t.charAt(i)<='9'))
            {
                sb.append(t.charAt(i));
            }
        }

        String ori = sb.toString();
        String rev = sb.reverse().toString();
        return ori.equals(rev);
    }
}