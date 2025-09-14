//This code is correct but will give TLE for last few Test cases
// class Solution 
// {
//     int ci = 0;
//     int vei = 0;

//     private boolean matches(String s, String[] wordlist)
//     {
//         for (int i=0; i<wordlist.length; i++)
//         {
//             if (s.equals(wordlist[i]))
//             {
//                 return true;
//             }
//         }
//         return false;
//     }

//     private boolean capitalizeMatch(String s, String[] wordlist)
//     {
//         for (int i=0; i<wordlist.length; i++)
//         {
//             if (s.toLowerCase().equals(wordlist[i].toLowerCase()))
//             {
//                 ci = i;
//                 return true;
//             }
//         }
//         return false;
//     }

//     private boolean vowelerrormatch(String s, String[] wordlist)
//     {
//         String ts = s.toLowerCase();
//         char[] chs = ts.toCharArray();
//         for (int i=0; i<chs.length; i++)
//         {
//             if (chs[i] == 'a' || chs[i]=='e' || chs[i]=='i' || chs[i]=='o' || chs[i]=='u')
//             {
//                 chs[i] = '*';
//             }
//         }
//         s = new String(chs);

//         for (int i=0; i<wordlist.length; i++)
//         {
//             StringBuilder br = new StringBuilder();
//             String w = wordlist[i].toLowerCase();
//             if (w.length() != s.length())
//             {
//                 continue;
//             }
            
//             for (int j=0; j<w.length(); j++)
//             {
//                 if (w.charAt(j) == 'a' || w.charAt(j) == 'e' || w.charAt(j) == 'i' || w.charAt(j) == 'o' || w.charAt(j) == 'u')
//                 {
//                     br.append('*');
//                 }
//                 else
//                 {
//                     br.append(w.charAt(j));
//                 }
//             }
//             if (br.toString().equals(s))
//             {
//                 vei = i;
//                 return true;
//             }
//         }

//         return false;
//     }

//     public String[] spellchecker(String[] wordlist, String[] queries) 
//     {
//         String[] ans = new String[queries.length];
//         for (int i=0; i<queries.length; i++)
//         {
//             if (matches(queries[i], wordlist))
//             {
//                 ans[i] = queries[i];
//             }
//             else if (capitalizeMatch(queries[i], wordlist))
//             {
//                 ans[i] = wordlist[ci];
//             }
//             else if (vowelerrormatch(queries[i], wordlist))
//             {
//                 ans[i] = wordlist[vei];
//             }
//             else
//             {
//                 ans[i] = "";
//             }
//         }

//         return ans;
//     }
// }

class Solution 
{
    private String devowel(String word) 
    {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) 
        {
            if ("aeiou".indexOf(Character.toLowerCase(c)) >= 0) 
            {
                sb.append('*');
            } 
            else 
            {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }

    public String[] spellchecker(String[] wordlist, String[] queries) 
    {
        Set<String> exactWords = new HashSet<>();
        Map<String, String> caseMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        // Preprocessing wordlist
        for (String word : wordlist) 
        {
            exactWords.add(word);

            String lower = word.toLowerCase();
            caseMap.putIfAbsent(lower, word);  // only keep first occurrence

            String dev = devowel(lower);
            vowelMap.putIfAbsent(dev, word);   // only keep first occurrence
        }

        // Answer queries
        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) 
        {
            String q = queries[i];

            if (exactWords.contains(q)) 
            {
                ans[i] = q;  // exact match
            } 
            else 
            {
                String lower = q.toLowerCase();
                if (caseMap.containsKey(lower)) 
                {
                    ans[i] = caseMap.get(lower);  // capitalization match
                } 
                else 
                {
                    String dev = devowel(lower);
                    if (vowelMap.containsKey(dev)) 
                    {
                        ans[i] = vowelMap.get(dev);  // vowel error match
                    } 
                    else 
                    {
                        ans[i] = "";  // no match
                    }
                }
            }
        }
        return ans;
    }
}
