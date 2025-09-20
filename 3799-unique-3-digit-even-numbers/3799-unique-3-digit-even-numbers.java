class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int n = digits.length;

        for (int i = 0; i < n; i++) {              // first digit
            for (int j = 0; j < n; j++) {          // second digit
                for (int k = 0; k < n; k++) {      // third digit
                    if (i != j && j != k && i != k) {
                        int d1 = digits[i], d2 = digits[j], d3 = digits[k];
                        if (d1 != 0 && d3 % 2 == 0) {   // check leading zero + last even
                            int num = d1 * 100 + d2 * 10 + d3;
                            set.add(num);
                        }
                    }
                }
            }
        }
        return set.size();
    }
}
