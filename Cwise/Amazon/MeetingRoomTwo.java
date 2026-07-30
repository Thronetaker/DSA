import java.util.*;
public class MeetingRoomTwo{
    public static int n_roomt(int start[] ,int end[], int n ){
        int meetings[][] = new int [n][2];
        for(int i = 0 ; i < n ; i++){
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }

        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
        //(endT, roomNumber)
        PriorityQueue<Integer> busyRooms = new PriorityQueue<>(); //minHeap
       for(int meeting[] : meetings){
        int stT = meeting[0], endT = meeting[1];

         if(!busyRooms.isEmpty() && busyRooms.peek()<= stT){
            busyRooms.poll();
         }

         busyRooms.offer( endT);
       }
       return busyRooms.size();

    }
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
        int cnt =1;
       for(int meeting[] : meetings){
        int stT = meeting[0], endT = meeting[1];
         if(busyRooms.isEmpty()){
            busyRooms.offer(new long[]{endT,cnt});
         }else if(!busyRooms.isEmpty() && busyRooms.peek()[0]<= stT){
            busyRooms.offer( new long[] {endT, busyRooms.poll()[1]});
         }else if(!busyRooms.isEmpty() && busyRooms.peek()[0]> stT){
            busyRooms.offer(new long[]{endT, ++cnt});

         }
       }
       return cnt;

    }


    public static void main(String[] args) {
        int start[] = {4,4,4};
        int end[] = {9,9,9};
        System.out.println(n_roomt(start, end, start.length));
    }
}