package disk_scheduling_algorithms;

import java.util.ArrayList;

/**
 *
 * @author xBodda
 */
public abstract class Scheduling 
{
    public int Initial_State;
    public ArrayList<Integer>Request_Queue;
    public ArrayList<Integer> Track = new ArrayList<>();
    public int Boundries;
    public int Total_Distance = 0;
    public int Direction = 999;
    public int Seek_Time = 0;
    
    public abstract ArrayList<Integer> Schedule();

    public Scheduling(int Initial_State, ArrayList<Integer> Request_Queue, int Boundries, int Seek_Time) 
    {
        this.Initial_State = Initial_State;
        this.Request_Queue = Request_Queue;
        this.Boundries = Boundries;
        this.Seek_Time = Seek_Time;
    }
    
    public Scheduling(int Initial_State, ArrayList<Integer> Request_Queue, int Boundries,  int Direction, int Seek_Time) 
    {
        this.Initial_State = Initial_State;
        this.Boundries = Boundries;
        this.Request_Queue = Request_Queue;
        this.Direction = Direction;
        this.Seek_Time = Seek_Time;
    }

    public int getInitial_State() 
    {
        return Initial_State;
    }

    public void setInitial_State(int Initial_State) 
    {
        this.Initial_State = Initial_State;
    }

    public ArrayList<Integer> getRequest_Queue() 
    {
        return Request_Queue;
    }

    public void setRequest_Queue(ArrayList<Integer> Request_Queue) 
    {
        this.Request_Queue = Request_Queue;
    }
}
