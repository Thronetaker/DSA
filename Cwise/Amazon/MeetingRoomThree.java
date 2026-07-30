import java.util.*;

public class MeetingRoomThree{
    public static int n_room(int start[] ,int end[], int n ){
        int meetings[][] = new int [n][n];
        for(int i = 0 ; i < n ; i++){
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }

        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
        //(endT, roomNumber)
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>((a, b) -> 
            a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1])); //minHeap
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for(int i = 0 ; i< n ; i++) availableRooms.offer(i);
        int cnt[] = new int[n];

        for(int meeting[] : meetings){
            long sT= meeting[0], endT = meeting[1];

            while(!busyRooms.isEmpty() && sT <= busyRooms.peek()[0]){
                int room =(int) busyRooms.poll()[1];
                availableRooms.offer(room);

            }

            if(!availableRooms.isEmpty() ){
                int room =(int)availableRooms.poll();
                busyRooms.offer(new long[]{ endT, room});
                cnt[room]++;
            }else{
                long[] earliest = busyRooms.poll();
                long newEndT = earliest[0]+endT-sT;
                busyRooms.offer(new long[] {newEndT,earliest[1]});
                cnt[(int)earliest[1]]++;
            }

        }
        int maxR = 0;
        for(int i = 1; i< n ; i++){
            if(cnt[i]>cnt[maxR]) maxR = i;
        }

        return maxR;
    }


    public static void main(String args[]){

    }
}