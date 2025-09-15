//This code is completely written by you and its correct also but just in last test case its giving TLE
// class Solution 
// {
//     private boolean contains(String str)
//     {
//         if (str.length() < 3)
//         {
//             return false;
//         }

//         int[] temp = new int[3];
//         for (int i=0; i<str.length(); i++)
//         {
//             if (str.charAt(i) == 'a')
//             {
//                 temp[0] = 1;
//             }
//             else if (str.charAt(i)=='b')
//             {
//                 temp[1] = 1;
//             }
//             else if (str.charAt(i)=='c')
//             {
//                 temp[2] = 1;
//             }
//         }

//         if (temp[0]+temp[1]+temp[2] == 3)
//         {
//             return true;
//         }
//         return false;
//     }

//     public int numberOfSubstrings(String s) 
//     {
//         int[] hash = new int[3];
//         int count = 0;
//         int left = 0;
//         int right = 2;

//         while (right < s.length())
//         {   
//             String str = s.substring(left,right+1);
//             if (contains(str))
//             {
//                 count += s.length()-right;
//                 left++;
//             }
//             else
//             {
//                 right++;
//             }
//         }
//         return count;
//     }
// }

class Solution 
{
    public int numberOfSubstrings(String s) 
    {
        int n = s.length();
        int[] count = new int[3]; // for 'a','b','c'
        int left = 0, ans = 0;

        for (int right = 0; right < n; right++) 
        {
            // add current char
            count[s.charAt(right) - 'a']++;

            // shrink window until all 3 present
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) 
            {
                ans += n - right; // all substrings starting at left and ending at >= right are valid
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return ans;
    }
}
