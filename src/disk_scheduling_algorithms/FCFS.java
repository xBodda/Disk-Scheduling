package disk_scheduling_algorithms;

import java.util.*;

/**
 *
 * @author Celiusty
 */

public class FCFS extends Scheduling{

    public FCFS(int Initial_State, ArrayList<Integer> Request_Queue, int Boundries, int Seek_Time) 
    {
        super(Initial_State, Request_Queue, Boundries,Seek_Time);
    }

    @Override
    public ArrayList<Integer> Schedule() 
    {
    //    int initial=head;//number of heads 2aly habda2 mn 3ando
    int distance;//total distance 2aly 27na 3ayzin natala3o
    int count=0;//2aly ba7sab fy kol rakaman plus 2aly ba3daha 
    int size= Request_Queue.size();//2aly requests numbers
    
    int Node;
    
    for(int Init_1=0;Init_1<size;Init_1++){
        
        Node = Request_Queue.get(Init_1);
        
        distance=Math.abs(Node - Initial_State); 
        count+=distance;
        Initial_State=Node;
           
    }
        System.out.println("Total Seek Time = " + Seek_Time * count + " Time Unit");
    
        System.out.println("\nTotal Distance = "+ count);
        System.out.println("");
//    for(int i=0;i<size;i++){   
//        System.out.println("requests sequence is"+Request_Queue.get(i) + " --> ");
//    }

     
           return Request_Queue;
    }

    
    
    
    
    
    
    
    
}