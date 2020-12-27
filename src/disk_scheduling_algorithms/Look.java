package disk_scheduling_algorithms;

import java.util.*;

/**
 *
 * @author xCeliusty
 */
public class Look extends Scheduling
{
    public Look(int Initial_State,int Boundries,ArrayList<Integer> Request_Queue, int Direction, int Seek_Time) 
    {
        super(Initial_State, Request_Queue, Boundries, Direction, Seek_Time);
    }
    
    @Override
    public ArrayList<Integer> Schedule() 
    {
        Track.clear();
        Track.add(Initial_State);
        int Node = Initial_State;

        switch (Direction) 
        {
            case 0:
                while (Node < Boundries) 
                {
                    if (Request_Queue.contains(Node))
                    {
                        Total_Distance += Math.abs(Track.get(Track.size() - 1) - Node);
                        Track.add(Node);
                        Request_Queue.remove(new Integer(Node));
                    }
                    Node++;
                }
                while (Node > 0) 
                {
                    if (Request_Queue.contains(Node))
                    {
                        Total_Distance += Math.abs(Track.get(Track.size() - 1) - Node);
                        Track.add(Node);
                        Request_Queue.remove(new Integer(Node));
                    }
                    Node--;
                }   break;
                
            case 1:
                while (Node > 0) 
                {
                    if (Request_Queue.contains(Node))
                    {
                        Total_Distance += Math.abs(Track.get(Track.size() - 1) - Node);
                        Track.add(Node);
                        Request_Queue.remove(new Integer(Node));
                    }
                    Node--;
                }   
                while (Node < Boundries) 
                {
                    if (Request_Queue.contains(Node))
                    {
                        Total_Distance += Math.abs(Track.get(Track.size() - 1) - Node);
                        Track.add(Node);
                        Request_Queue.remove(new Integer(Node));
                    }
                    Node++;
                }   break;
                
            default:
                System.out.println("Error In Direction");
                break;
        }
        System.out.println("Total Seek Time = " + Seek_Time * Total_Distance + " Time Unit");
        System.out.println("Total Distance = " + Total_Distance + " Distance Unit \n" );
        System.out.println("");

        return Track;
    }
}
