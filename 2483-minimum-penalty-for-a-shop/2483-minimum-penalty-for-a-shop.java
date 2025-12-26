// class Solution 
// {
//     private int cal(char[] cus, int ct)
//     {
//         int p=0;
//         for (int i=0; i<cus.length; i++)
//         {
//             if (cus[i]=='N' && i<ct || cus[i]=='Y' && i>=ct) 
//             {
//                 p++;
//             }
//         }
//         return p;
//     }

//     public int bestClosingTime(String customers) 
//     {
//         int ap = Integer.MAX_VALUE;
//         int ct = 0;
//         char[] cus = customers.toCharArray();
//         for (int j=0; j<=cus.length; j++)
//         {
//             int tp = cal(cus,j);
//             if (tp < ap)
//             {
//                 ap = tp;
//                 ct = j;
//             }
//         }
//         return ct;
//     }
// }

class Solution {
    public int bestClosingTime(String customers) {
        int totalY = 0;
        for (char c : customers.toCharArray()) {
            if (c == 'Y') totalY++;
        }

        int currentPenalty = totalY;   // closing at 0
        int bestPenalty = currentPenalty;
        int bestClosingTime = 0;

        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                currentPenalty--;   // we open for this Y, so avoid penalty
            } else { // 'N'
                currentPenalty++;   // open for N, penalty
            }

            if (currentPenalty < bestPenalty) {
                bestPenalty = currentPenalty;
                bestClosingTime = i + 1;
            }
        }

        return bestClosingTime;
    }
}
