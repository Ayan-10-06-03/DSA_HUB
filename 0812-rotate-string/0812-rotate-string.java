class Solution 
{
    public boolean rotateString(String s, String goal) 
    {
        int len = s.length();
        while (len>0)
        {
            if (s.equals(goal))
            {
                return true;
            }
            char temp = s.charAt(0);
            String str = s.substring(1, s.length());
            str = str + temp;
            s = str;
            len=len-1;
        }

        return false;
    }
}