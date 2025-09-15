class Solution 
{
    public int canBeTypedWords(String text, String brokenLetters) 
    {
        ArrayList<Character> bl = new ArrayList<>();
        for (int i=0; i<brokenLetters.length(); i++)
        {
            bl.add(brokenLetters.charAt(i));
        }

        int flag = 0;
        int count = 0;
        text = text+' ';
        for (int i=0 ;i<text.length(); i++)
        {
            char c = text.charAt(i);
            if (bl.contains(c) && c != ' ')
            {
                flag = 1;
            }
            else if (c == ' ')
            {
                if (flag != 1)
                {
                    count++;
                }
                else
                {
                    flag = 0;
                }
            }
        }

        return count;
    }
}