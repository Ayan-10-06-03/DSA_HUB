class Solution 
{
    public int mostBooked(int n, int[][] meetings) 
    {
        // sort meetings by start time
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
        
        // free rooms (min heap by room id)
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for(int i = 0; i < n; i++) freeRooms.add(i);

        // busy rooms -> {endTime, roomId}
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
            (a,b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );

        int[] count = new int[n];  // how many meetings each room handled

        for(int[] meet : meetings) 
        {
            long start = meet[0];
            long end = meet[1];
            long duration = end - start;

            // free up finished rooms
            while(!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) 
            {
                freeRooms.add((int)busyRooms.poll()[1]);
            }

            if(!freeRooms.isEmpty()) 
            {
                // assign directly
                int room = freeRooms.poll();
                count[room]++;
                busyRooms.add(new long[]{end, room});
            } 
            else 
            {
                // delay the meeting -> earliest room to be free
                long[] next = busyRooms.poll();
                long newStart = next[0];
                int room = (int) next[1];

                count[room]++;
                busyRooms.add(new long[]{newStart + duration, room});
            }
        }

        // find room with maximum frequency
        int maxRoom = 0;
        for(int i = 1; i < n; i++)
        {
            if(count[i] > count[maxRoom]) 
            {
                maxRoom = i;
            }
        }

        return maxRoom;
    }
}
