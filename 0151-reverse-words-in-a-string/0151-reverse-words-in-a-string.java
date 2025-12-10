class Solution 
{
    public String reverseWords(String s) 
    {
        String temp = "";
        StringBuilder sb = new StringBuilder();

        for (int i=s.length()-1; i>=0; i--)
        {
            char ch = s.charAt(i);
            if (ch != ' ')
            {
                temp = ch+temp;
            }
            else
            {
                if (!temp.isEmpty())
                {
                    sb.append(temp+" ");
                    temp = "";
                }
            }
        }

        sb.append(temp);   //last string
        return sb.toString().trim();
    }
}