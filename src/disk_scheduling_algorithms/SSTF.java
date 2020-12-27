package disk_scheduling_algorithms;

import java.util.ArrayList;

/**
 *
 * @author xBodda
 */
public class SSTF extends Scheduling
{
    public SSTF(int Initial_State, ArrayList<Integer> Request_Queue, int Boundries, int Seek_Time) 
    {
        super(Initial_State, Request_Queue, Boundries, Seek_Time);
    }

    @Override
    public ArrayList<Integer> Schedule() 
    {
        Track.clear();
        Track.add(Initial_State);
        int Node = Initial_State;
        int Next_Node = 0;
        int Least_Distance = 99999;
        int Current_Node = 0;
        
        while(!Request_Queue.isEmpty())
        {
            for (int i = 0; i < Request_Queue.size(); i++) 
            {  
                if (Math.abs(Request_Queue.get(i) - Node) < Least_Distance)
                {
                    Least_Distance = Math.abs(Request_Queue.get(i) - Node);
                    Next_Node = Request_Queue.get(i);
                    Current_Node = i;
                }
            }
            Total_Distance += Math.abs(Node - Next_Node);
            Node = Next_Node;
            Track.add(Node);
            Request_Queue.remove(Current_Node);
            Least_Distance = 99999;
        }
        System.out.println("Total Seek Time = " + Seek_Time * Total_Distance + " Time Unit");
        System.out.println("Total Distance = " + Total_Distance + " Distance Unit \n" );
        
        return Track;
    }
    
}
