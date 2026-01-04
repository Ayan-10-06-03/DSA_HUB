class Solution 
{
    public String smallestSubsequence(String s) 
    {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i=0; i<s.length(); i++)
        {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i),0) + 1);
        }

        Stack<Character> st = new Stack<>();
        HashSet<Character> used = new HashSet<>();
        for (int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            freq.put(c, freq.get(c)-1);

            if (used.contains(c))
            {
                continue;
            }

            while (!st.isEmpty() && st.peek()>c && freq.get(st.peek())>0)
            {
                used.remove(st.pop());
            }

            st.push(c);
            used.add(c);
        }

        //final result
        StringBuilder br = new StringBuilder();
        for (char c : st)
        {
            br.append(c);
        }

        return br.toString();
    }
}