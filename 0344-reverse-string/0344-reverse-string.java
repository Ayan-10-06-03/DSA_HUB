class Solution 
{
    public void reverseString(char[] s) 
    {
        StringBuilder br = new StringBuilder();
        for (int i=0; i<s.length; i++)
        {
            br.append(s[i]);
        }

        br.reverse();
        for (int i=0; i<br.length(); i++)
        {
            s[i] = br.charAt(i);
        }
    }
}