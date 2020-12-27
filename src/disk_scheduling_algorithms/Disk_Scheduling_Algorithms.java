package disk_scheduling_algorithms;

import java.io.*;
import java.util.*;

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
    
    public static void main(String[] abc) throws FileNotFoundException 
    {
        System.out.println("*****   Disk Scheduling Simulator   *****\n");
        
        outer:while (Menu_Choice != 3)
        {
            System.out.println("Choose The Way You Want To Have Your Inputs ");
            System.out.println("1- Read From File");
            System.out.println("2- Read From User");
            System.out.println("3- Exit\n");
            Menu_Choice = Valid_Input("Invalid Menu Choice, Please Try Again\n");
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
        Initial_State = Valid_Input("Invalid Initial State, Please Try Again\n");
        System.out.println("");
        System.out.println("Enter The Maximum Bound : (eg:200 , 0->199)");
        Boundries = Valid_Input("Invalid Boundries Value, Please Try Again\n");
        System.out.print("\nEnter The Seek Time : ");
        Seek_Time = Valid_Input("Invalid Seek Time, Please Try Again\n");
        int Direction = Select_Direction();
        Scheduler = new SCAN(Initial_State,Boundries, Request_Queue,Direction,Seek_Time);
        Result = Scheduler.Schedule();
        System.out.println("SCAN");
        for (int Init_1 = 0; Init_1 <  Result.size(); Init_1++) 
        {
            System.out.print(Result.get(Init_1));
            if (Init_1 < Result.size()-1) 
            {
                System.out.print(" --> ");
            }
        }
        System.out.println();
    }
    
    public static void Start_CSCAN(ArrayList<Integer> Request_Queue)
    {
        System.out.print("Enter The Head Position : ");
        Initial_State = Valid_Input("Invalid Initial State, Please Try Again\n");
        System.out.println("");
        System.out.println("Enter The Maximum Bound : (eg:200 , 0->199)");
        Boundries = Valid_Input("Invalid Boundries Value, Please Try Again\n");
        System.out.print("\nEnter The Seek Time : ");
        Seek_Time = Valid_Input("Invalid Seek Time, Please Try Again\n");
        int Direction = Select_Direction();
        Scheduler = new CSCAN(Initial_State, Request_Queue, Boundries, Direction,Seek_Time);
        Result = Scheduler.Schedule();
        System.out.println("C-SCAN");
        for (int Init_1 = 0; Init_1 <  Result.size(); Init_1++) 
        {
            System.out.print(Result.get(Init_1));
            if (Init_1 < Result.size()-1) 
            {
                System.out.print(" --> ");
            }
        }
        System.out.println();
    }
    
    public static void Start_Clook(ArrayList<Integer> Request_Queue)
    {
        System.out.print("Enter The Head Position : ");
        Initial_State = Valid_Input("Invalid Initial State, Please Try Again\n");
        System.out.println("");
        System.out.println("Enter The Maximum Bound : (eg:200 , 0->199)");
        Boundries = Valid_Input("Invalid Boundries Value, Please Try Again\n");
        System.out.print("\nEnter The Seek Time : ");
        Seek_Time = Valid_Input("Invalid Seek Time, Please Try Again\n");
        int Direction = Select_Direction();
        Scheduler = new Clook(Initial_State, Request_Queue, Boundries, Direction,Seek_Time);
        Result = Scheduler.Schedule();
        System.out.println("C-Look");
        for (int Init_1 = 0; Init_1 <  Result.size(); Init_1++) 
        {
            System.out.print(Result.get(Init_1));
            if (Init_1 < Result.size()-1) 
            {
                System.out.print(" --> ");
            }
        }
        System.out.println();
    }
    
    public static void Start_Look(ArrayList<Integer> Request_Queue)
    {
        System.out.print("Enter The Head Position : ");
        Initial_State = Valid_Input("Invalid Initial State, Please Try Again\n");
        System.out.println("");
        System.out.println("Enter The Maximum Bound : (eg:200 , 0->199)");
        Boundries = Valid_Input("Invalid Boundries Value, Please Try Again\n");
        System.out.print("\nEnter The Seek Time : ");
        Seek_Time = Valid_Input("Invalid Seek Time, Please Try Again\n");
        int Direction = Select_Direction();
        Scheduler = new Look(Initial_State,  Boundries, Request_Queue, Direction,Seek_Time);
        Result = Scheduler.Schedule();
        System.out.println("Look");
        for (int Init_1 = 0; Init_1 <  Result.size(); Init_1++) 
        {
            System.out.print(Result.get(Init_1));
            if (Init_1 < Result.size()-1) 
            {
                System.out.print(" --> ");
            }
        }
        System.out.println();
    }
    
    public static void Start_SSTF(ArrayList<Integer> Request_Queue)
    {
        System.out.print("Enter The Head Position : ");
        Initial_State = Valid_Input("Invalid Initial State, Please Try Again\n");
        System.out.println("");
        System.out.println("Enter The Maximum Bound : (eg:200 , 0->199)");
        Boundries = Valid_Input("Invalid Boundries Value, Please Try Again\n");
        System.out.print("\nEnter The Seek Time : ");
        Seek_Time = Valid_Input("Invalid Seek Time, Please Try Again\n");
        Scheduler = new SSTF(Initial_State, Request_Queue,Boundries,Seek_Time);
        Result = Scheduler.Schedule();
        System.out.println("SSTF");
        for (int Init_1 = 0; Init_1 <  Result.size(); Init_1++) 
        {
            System.out.print(Result.get(Init_1));
            if (Init_1 < Result.size()-1) 
            {
                System.out.print(" --> ");
            }
        }
        System.out.println();
    }
    
    public static void Start_FCFS(ArrayList<Integer> Request_Queue)
    {
        System.out.print("Enter The Head Position : ");
        Initial_State = Valid_Input("Invalid Initial State, Please Try Again\n");
        System.out.println("");
        System.out.println("Enter The Maximum Bound : (eg:200 , 0->199)");
        Boundries = Valid_Input("Invalid Boundries Value, Please Try Again\n");
        System.out.print("\nEnter The Seek Time : ");
        Seek_Time = Valid_Input("Invalid Seek Time, Please Try Again\n");
        Scheduler = new FCFS(Initial_State,Request_Queue,Boundries,Seek_Time);
        Result = Scheduler.Schedule();
        System.out.println("FCFS");
        for (int Init_2 = 0; Init_2 <  Result.size(); Init_2++) 
        {
            System.out.print( Result.get(Init_2));
            if (Init_2 < Result.size()-1)
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
        System.out.println("To Stop Type (0) ");
        int Temp_Element = -1;
        while(Temp_Element != 0)
        {
            Temp_Element = Valid_Input("Invalid Request Value, Please Try Again");
            if(Temp_Element != 0)
            {
                Request_Queue.add(Temp_Element);
            }
        }
        return Request_Queue;
    }
    
    public static void Show_Algorithms()
    {
        while(Algorithm_Choice != 3)
        {
            System.out.println("\nChoose The Algorithm You Want");
            System.out.println("1- FCFS");
            System.out.println("2- SCAN");
            System.out.println("3- SSTF");
            System.out.println("4- CSCAN");
            System.out.println("5- CLOOK");
            System.out.println("6- Look");
            System.out.println("7- Go Back\n");
            Algorithm_Choice = Valid_Input("Invalid Algorithm Choice, Please Try Again\n");
            switch (Algorithm_Choice) 
            {
                case 1:
                    Start_FCFS(Request_Queue);
                    break;
                case 2:
                    Start_Scan(Request_Queue);
                    break;
                case 3:
                    Start_SSTF(Request_Queue);
                    break;
                case 4:
                    Start_CSCAN(Request_Queue);
                case 5:
                    Start_Clook(Request_Queue);
                case 6:
                    Start_Look(Request_Queue);
                case 7:
                    System.out.println("\n");
                    break;
                default:
                    System.out.println("Invalid Choice, Please Try Again");
                    break;
            }
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
            Choice = Valid_Input("Invalid Direction, Please Try Again\n");
            switch (Choice) 
            {
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
    
    public static int Valid_Input(String Message)
    {
        int x = -1;
        String Temp = "";
        
        while(!Temp.matches("[0-9]+"))
        {
            Temp = input.next();
            if (Temp.matches("[0-9]+")) 
            {
                x = Integer.parseInt(Temp);
            }
            else
            {
                System.out.println(Message);
            }
        }
        return x;
    }
}
