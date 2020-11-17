package disk_scheduling_algorithms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author xBodda
 */
public class Disk_Scheduling_Algorithms 
{
    public static Scheduling Scheduler;
    public static ArrayList <Integer> Request_Queue = new ArrayList <Integer> ();
    public static ArrayList <Integer> Result = new ArrayList <Integer> ();
    public static Scanner input = new Scanner(System.in);
    
    public static int Menu_Choice = 0;
    public static int Algorithm_Choice = 0;
    public static int Initial_State = 0;
    public static int Boundries = 0;
    public static int Seek_Time = 0;
    
    public static void main(String[] args) throws FileNotFoundException 
    {
        System.out.println("*****   Disk Scheduling Simulator   *****\n");
        
        outer:while (Menu_Choice != 3)
        {
            System.out.println("Choose The Way You Want To Have Your Inputs ");
            System.out.println("1- Read From File");
            System.out.println("2- Read From User");
            System.out.println("3- Exit\n");
            Menu_Choice = input.nextInt();
            switch (Menu_Choice) 
            {
                case 1:
                    Read_From_File(Request_Queue,"numbers.txt");
                    while(Algorithm_Choice != 3)
                    {
                        Show_Algorithms();
                    }   
                    break;
                case 2:
                    Read_From_User(Request_Queue);
                    while(Algorithm_Choice != 3)
                    {
                        Show_Algorithms();
                    }   
                    break;
                case 3:
                    System.out.println("Program Exited");
                    break;
                default:
                    System.out.println("Invalid Choice, Please Try Again");
                    break;
            }
        }
    }
    
    public static void Start_Scan(ArrayList<Integer> Request_Queue)
    {
        System.out.print("Enter The Head Position : ");
        Initial_State = input.nextInt();
        System.out.println("");
        System.out.println("Enter The Maximum Bound : (eg:200 , 0->199)");
        Boundries = input.nextInt();
        System.out.print("\nEnter The Seek Time : ");
        Seek_Time = input.nextInt();
        int Direction = Select_Direction();
        Scheduler = new SCAN(Initial_State,Boundries, Request_Queue,Direction,Seek_Time);
        Result = Scheduler.Schedule();
        System.out.println("SCAN");
        for (int i = 0; i <  Result.size(); i++) 
        {
            System.out.print( Result.get(i));
            if (i < Result.size()-1) 
            {
                System.out.print(" --> ");
            }
        }
        System.out.println();
    }
    
    public static void Start_FCFS(ArrayList<Integer> Request_Queue)
    {
        System.out.print("Enter The Head Position : ");
        Initial_State = input.nextInt();
        System.out.println("");
        System.out.println("Enter The Maximum Bound : (eg:200 , 0->199)");
        Boundries = input.nextInt();
        System.out.print("\nEnter The Seek Time : ");
        Seek_Time = input.nextInt();
        Scheduler = new FCFS(Initial_State,Request_Queue,Boundries,Seek_Time);
        Result = Scheduler.Schedule();
        System.out.println("FCFS");
        for (int i = 0; i <  Result.size(); i++) 
        {
            System.out.print( Result.get(i));
            if (i < Result.size()-1)
            {
                System.out.print(" --> ");
            }
        }
        System.out.println();
    }
    
        
    public static ArrayList<Integer> Read_From_File(ArrayList<Integer> Request_Queue, String File_Name) throws FileNotFoundException
    {
        FileReader FileReader_Object = new FileReader(File_Name);
        Scanner Scanner_Object = new Scanner(FileReader_Object);

        while (Scanner_Object.hasNextInt())
        {
            Request_Queue.add(Scanner_Object.nextInt());
        }
        return Request_Queue;
    }
    
    public static ArrayList<Integer> Read_From_User(ArrayList<Integer> Request_Queue) throws FileNotFoundException
    {   
        System.out.println("Enter The Track Elements ");
        System.out.println("To Stop Type (-1) ");
        int Temp_Element = 0;
        while(Temp_Element != -1)
        {
            Temp_Element = input.nextInt();
            if(Temp_Element != -1)
            {
                Request_Queue.add(Temp_Element);
            }
        }
        return Request_Queue;
    }
    
    public static void Show_Algorithms()
    {
        System.out.println("\nChoose The Algorithm You Want");
        System.out.println("1- FCFS");
        System.out.println("2- SCAN");
        System.out.println("3- Go Back\n");
        Algorithm_Choice = input.nextInt();
        switch (Algorithm_Choice) 
        {
            case 1:
                Start_FCFS(Request_Queue);
                break;
            case 2:
                Start_Scan(Request_Queue);
                break;
            case 3:
                System.out.println("\n");
                break;
            default:
                System.out.println("Invalid Choice, Please Try Again");
                break;
        }
    }
    
    public static int Select_Direction()
    {
        int Direction = -1;
        int Choice = -1;

        outer:while (Choice != 3)
        {
            System.out.println("Enter The Direction You Want ");
            System.out.println("1- Upper Direction");
            System.out.println("2- Lower Direction");
            System.out.println("3- Exit\n");
            Choice = input.nextInt();
            switch (Choice) {
                case 1:
                    Direction = 0;
                    break outer;
                case 2:
                    Direction = 1;
                    break outer;
                case 3:
                    System.out.println("Program Exited");
                    break outer;
                default:
                    System.out.println("Invalid Choice, Please Try Again");
                    break;
            }
        }
        return Direction;
    }
}
