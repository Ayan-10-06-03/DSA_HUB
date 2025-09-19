class Solution 
{
    long mod = 1000000007;
    private long pow(long x, long n)
    {
        if (n == 0)
        {
            return 1;
        }

        if (n % 2 == 1) return (x % mod * pow(x, n-1) % mod) % mod;

        return pow(x % mod * x % mod, n/2);
    }

    public int countGoodNumbers(long n) 
    {
        long oddplaces = n/2;
        long evenplaces = n - oddplaces;

        long part1 = pow(4, oddplaces);
        long part2 = pow(5, evenplaces);

        return (int)((part1 * part2) % mod); 
    }
}