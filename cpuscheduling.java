/* 
ROHAN PANDEY
1710110419
*/

package osgla1;
import javafx.util.Pair;
import javax.print.attribute.standard.NumberUp;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/* Here the numbers in Chosen array represnts the type of scheduling algorithm
0-FCFS
1-RR
2-Preemptive SJF
3-Non-Preemptive SJF
4-Preemptive Priority
5-Non-Preemptive Priority
*/

public class cpuscheduling extends JFrame implements ActionListener
{
    int NumProc; //Number of processes
    int TQ; // Time quantum
    int [] chosen={0,0,0,0,0,0}; // To check if that particular scheduling algorithm is chosen
    ArrayList<Integer> pList=new ArrayList<Integer>();  //Process List
    ArrayList<Integer> atList=new ArrayList<Integer>(); //Arrival Time List
    ArrayList<Integer> btList=new ArrayList<Integer>(); //Burst Time List
    
    //Function for updating the Priority list
    public void update_priorities_list(String s)
    {
        pList.clear();
        s.trim();
        String inside="";
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!=',' && s.charAt(i)!='.')
                inside+=s.charAt(i);
            else if(s.charAt(i)!='.')
            {
                pList.add(Integer.parseInt(inside));
                inside="";
            }
            else
            {
                pList.add(Integer.parseInt(inside));
                inside="";
            }
        }
    }
    
    //Function for updaing the Arrival Time List  
    public void update_arrival_time_list(String s)
    {
        atList.clear();
        s.trim();
        String inside="";
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!=',' && s.charAt(i)!='.')
                inside+=s.charAt(i);
            else if(s.charAt(i)!='.')
            {
                atList.add(Integer.parseInt(inside));
                inside="";
            }
            else
            {
                atList.add(Integer.parseInt(inside));
                inside="";
            }
        }
    }
    
    //Function for updating the Burst Time List 
    public void update_btList(String s)
    {
        btList.clear();
        s.trim();
        String inside="";
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!=',' && s.charAt(i)!='.')
                inside+=s.charAt(i);
            else if(s.charAt(i)!='.')
            {
                btList.add(Integer.parseInt(inside));
                inside="";
            }
            else
            {
                btList.add(Integer.parseInt(inside));
                inside="";
            }
        }  
    }
    
    //Constructor for the class CPUSCHEDULING to create the frame
    public cpuscheduling()
    {
        JFrame MainFrame=new JFrame();  //Creating the frame
        GridLayout gl=new GridLayout(7,1);
        MainFrame.setLayout(gl);
        MainFrame.setSize(1920,1080);
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();
        JPanel panel4=new JPanel();
        JPanel panel5=new JPanel();
        JPanel panel6=new JPanel(new GridLayout(3,2));
        JPanel panel7=new JPanel();

        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel5.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel numberOfProcess=new JLabel("No. Of Proccesses");
        Vector options_for_processor = new Vector();
        for(int i=1;i<=6;i++)
            options_for_processor.add(i);

        JComboBox<Integer> options_for_processor_JC=new JComboBox<Integer>(options_for_processor);
        
        JTextField priorities_tf=new JTextField(20);
        JTextField burst_time_tf=new JTextField(20);
        JTextField TimeQuantumText=new JTextField(20);
        JTextField ArrivalTimeText=new JTextField(20);

        JCheckBox FCFS=new JCheckBox("FCFS");
        JCheckBox PSJF=new JCheckBox("Premptive SJF");
        JCheckBox RR=new JCheckBox("Round Robin");
        JCheckBox PP=new JCheckBox("Premptive Priority");
        JCheckBox NPSJF=new JCheckBox("Non-Premptive SJF");
        JCheckBox NPP=new JCheckBox("Non-Premptive Priority");
        
        JButton calculate=new JButton("COMPUTE");
        JLabel BurstT=new JLabel("Burst Time:     ");
        JLabel ArrivalT=new JLabel("Arrival Time:   ");
        JLabel TimeQuantumLabel=new JLabel("Time Quantum:");
        JLabel priorities=new JLabel("Priorities:         ");
        
        panel1.add(numberOfProcess);
        panel1.add(options_for_processor_JC);
        
        panel2.add(BurstT);
        panel2.add(burst_time_tf);

        panel3.add(ArrivalT);        
        panel3.add(ArrivalTimeText);

        panel4.add(priorities);
        panel4.add(priorities_tf);

        panel5.add(TimeQuantumLabel);        
        panel5.add(TimeQuantumText);

        panel6.add(FCFS);
        panel6.add(RR);
        panel6.add(PSJF);
        panel6.add(NPSJF);
        panel6.add(PP);
        panel6.add(NPP);
        
        panel7.add(calculate);
        
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                NumProc = (int) options_for_processor_JC.getSelectedItem();
                String btTime=burst_time_tf.getText();
                if(btTime!=null)
                {
                    btTime.trim();
                    update_btList(btTime);
                }
                btTime=ArrivalTimeText.getText();
                if(btTime!=null)
                {
                    btTime.trim();
                    update_arrival_time_list(btTime);
                }
                btTime=priorities_tf.getText();
                if(btTime!=null)
                {
                    btTime.trim();
                    update_priorities_list(btTime);
                }
                btTime=TimeQuantumText.getText();
                if(btTime!=null)
                {
                    btTime = btTime.trim();
                    TQ = Integer.parseInt(btTime);
                }
                if(FCFS.isSelected())
                    chosen[0]=1;
                else
                    chosen[0]=0;
                if(RR.isSelected())
                    chosen[1]=1;
                else
                    chosen[1]=0;
                if(PSJF.isSelected())
                    chosen[2]=1;
                else
                    chosen[2]=0;
                if(NPSJF.isSelected())
                    chosen[3]=1;
                else
                    chosen[3]=0;
                if(PP.isSelected())
                    chosen[4]=1;
                else
                    chosen[4]=0;
                if(NPP.isSelected())
                    chosen[5]=1;
                else
                    chosen[5]=0;
                get_output go=new get_output(NumProc,btList,atList,pList,TQ,chosen);
                go.output();
            }
        });
        MainFrame.add(panel1);
        MainFrame.add(panel2);
        MainFrame.add(panel3);
        MainFrame.add(panel4);
        MainFrame.add(panel5);
        MainFrame.add(panel6);
        MainFrame.add(panel7);
        MainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        MainFrame.setVisible(true);
    }
    
    //The main function for creating the instance of the constructor
    public static void main(String arg[])
    {
        Scanner in=new Scanner(System.in);
        cpuscheduling Output=new cpuscheduling();
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
    }
}

class get_output
{
    int NumProc;    //NumberOfProocess
    ArrayList<Integer> pList=new ArrayList<Integer>();  //Priority List
    ArrayList<Integer> atList=new ArrayList<Integer>(); //Arrival Time List
    ArrayList<Integer> btList=new ArrayList<Integer>(); //Burst Time List
    int TQ; //Time Quantum
    int [] chosen={0,0,0,0,0,0}; //The process chosen out of the options
    ArrayList<Integer>TotalBurstTime=new ArrayList<Integer>();  //ArrayList for Total Burst Time
    
    //Overloaded Constructor to get inputs for the private variables
    get_output(int NumP,ArrayList<Integer> BTime,ArrayList<Integer> ATime,ArrayList<Integer> Priority,int timequantum,int []choice)
    {
        pList=Priority;
        NumProc=NumP;
        TQ=timequantum;
        btList=BTime;
        chosen=choice;
        atList=ATime;   
    
        //Function for sorting the values of the arrival times
        for (int i = 0; i < NumProc-1; i++)
        for (int j = 0; j < NumProc-i-1; j++)
        if (atList.get(j) > atList.get(j+1))
        {
            int temp1 = atList.get(j);
            atList.set(j,atList.get(j+1));
            atList.set(j+1,temp1);
            int temp2=btList.get(j);
            int temp3=pList.get(j);
            btList.set(j,btList.get(j+1));
            btList.set(j+1,temp2);
            pList.set(j,atList.get(j+1));
            pList.set(j+1,temp3);
        }
    }
    
    //This is the output frame that we get after our choice selection
    public void output()
    {
        TotalBurstTime.add(atList.get(0));  //Adding the arrival time list in the Total Burst Time list
        for(int i=1;i<NumProc+1;i++)
        {
            if(false)
                TotalBurstTime.add(atList.get(0));
            else
            {
                TotalBurstTime.add(TotalBurstTime.get(i-1)+btList.get(i-1));
            }
        }
        int Total_Time=TotalBurstTime.get(NumProc-1);
        for(int i=0;i<NumProc;i++)
        {
            double a=(double)btList.get(i)/Total_Time;
        }
        JFrame MainFrame=new JFrame();  //Output frame
        MainFrame.setSize(1920,1080);   //Setting the size for the output frame as the size of the screen
        JPanel panel1=new JPanel();
       
        //FCFS
        if(chosen[0]==1)
        {
            ArrayList<Integer> EndingTime=new ArrayList<Integer>();  //List maintaining the Ending Times 
            ArrayList<Integer> WaitingTime=new ArrayList<Integer>(); //List maintaining the Waiting Times
            ArrayList<Integer> StartTime=new ArrayList<Integer>();   //List maintaining the Start Times
            
            //Initializing all the values initially as 0
            for(int i=0;i<NumProc;i++)
            {
                StartTime.add(0);       //StartTime initialization as 0
                EndingTime.add(0);      //EndingTime initialization as 0 
                WaitingTime.add(0);     //WaitingTime initialization as 0
            }
            
            int var=0;      //The X-coordinate for the processes
            for(int i=0;i<NumProc;i++)
            {
                JLabel label=new JLabel("FCFS");                                //FCFS Scheduling
                JLabel label1=new JLabel("P"+Integer.toString(i));              //Process Labels
                JLabel label2=new JLabel(String.valueOf(TotalBurstTime.get(i)));//Getting total burst time for all
                label.setBounds(0,30,50,50);                                    
                label1.setPreferredSize(new Dimension(btList.get(i),40));
                label2.setPreferredSize(new Dimension(btList.get(i), 40));
                StartTime.set(i,TotalBurstTime.get(i));                         //Setting the Start Times
                WaitingTime.set(i,StartTime.get(i)-atList.get(i));              //Setting the Wait Times
                panel1.setLayout(null);
                Border border = BorderFactory.createLineBorder(Color.BLACK,1);
                label1.setBorder(border);
                Dimension d=label1.getPreferredSize().getSize();
                label1.setBounds(var,70,btList.get(i),50);
                label2.setBounds(var,100, btList.get(i),50);
                var+=btList.get(i);                                             //Increasing the X-coordinate of label
                panel1.add(label);                                                  //Adding the label to the panel
                panel1.add(label1);                                                 //Adding the label to the panel
                panel1.add(label2);                                                 //Adding the label to the panel
            }
            String Wait="Waiting Time:";
            String TurnAroundTime="Turn Around Time:";
            double totalWaitTime=0;
            double totaltat=0;
            for(int i=0;i<WaitingTime.size();i++)
            {
                totalWaitTime+=WaitingTime.get(i);
                totaltat+=(WaitingTime.get(i)+btList.get(i));
                Wait+="P"+Integer.toString(i)+"="+WaitingTime.get(i)+" ";       //Label for the output frame
                TurnAroundTime+="P"+Integer.toString(i)+"="+(WaitingTime.get(i)+btList.get(i))+" ";//Label for the output frame
            }
            Wait+="Average Waiting Time="+(totalWaitTime/NumProc);
            TurnAroundTime+="Average Turn Around Time Time="+(totaltat/NumProc);
            JLabel tat=new JLabel(TurnAroundTime);
            JLabel waittime=new JLabel(Wait);
            waittime.setBounds(0,110,1920,50);
            tat.setBounds(0,120,1920,50);
            JLabel last=new JLabel(Integer.toString(TotalBurstTime.get(TotalBurstTime.size()-1)));
            last.setBounds(var,100,30,50);
            panel1.add(last);       //Adding the labels to the panel
            panel1.add(tat);        //Adding the labels to the panel
            panel1.add(waittime);   //Adding the labels to the panel
            MainFrame.add(panel1);
            MainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            MainFrame.setVisible(true);
        }
        
        //Round Robin
        if(chosen[1]==1)
        {
            JLabel name=new JLabel("ROUND  ROBIN"); //The Scheduling method is Round Robin
            name.setBounds(0,130,100,50);           
            panel1.add(name);
            ArrayList<Integer> EndingTime=new ArrayList<Integer>(); //Ending Time List
            ArrayList<Integer> WaitTime=new ArrayList<Integer>();   //Waiting Time List
            
            //Initializing the ending and waiting times as 0
            for(int i=0;i<NumProc;i++)
            {
                EndingTime.add(0);
                WaitTime.add(0);
            }
            int var=0;                                          //The X-coordinate of the processes
            int BTtrack=TotalBurstTime.get(0);                  //Current track of the Burst Time
            ArrayList<Integer> Arrive=new ArrayList<Integer>(); //List of the Arrived 
            int after=atList.get(0);                            //Next Process
            int before=-1;                                      //Previous process
            ArrayList<Integer> TempBT =new ArrayList<Integer>();//Temp List for the Burst Times
            for(int j=0;j<btList.size();j++)
                TempBT.add(btList.get(j));                      //Adding the burst Times to the temperory list
            for (int j = 0; j < NumProc; j++)
            {
                if (atList.get(j) > before && atList.get(j) <= after)
                {
                    Arrive.add(j);                              //Adding the processor to the arrived List
                }
            }
            for(int i=0;i<NumProc;i++)                      
            {
                while(true)
                {
                    if(Arrive.size()==0)                        //If the arrived list is empty then exit
                        break;
                    JLabel label1=new JLabel();                 
                    JLabel label2 = new JLabel();
                    if(TempBT.get(Arrive.get(0))>TQ)           
                    {
                        TempBT.set(Arrive.get(0),TempBT.get(Arrive.get(0))-TQ);
                        label1.setText("p"+Integer.toString(Arrive.get(0)));
                        label2.setText(Integer.toString(BTtrack));
                        label1.setPreferredSize(new Dimension(TQ, 40));
                        label2.setPreferredSize(new Dimension(TQ, 40));
                        label1.setBounds(var, 170, TQ, 50);
                        label2.setBounds(var, 200,TQ, 50);
                        var+=TQ;
                        BTtrack+=TQ;
                        before = after;
                        after = after + TQ;
                        for (int j = 0; j < NumProc; j++)
                        {
                            if (atList.get(j) > before && atList.get(j) <= after)
                            {
                                Arrive.add(j);
                            }
                        }
                        int temp=Arrive.get(0);
                        for(int j=0;j<Arrive.size()-1;j++)
                        {
                            Arrive.set(j,Arrive.get(j+1));
                        }
                        Arrive.set(Arrive.size()-1,temp);
                    }
                    else
                    {
                        label1.setText("p"+Integer.toString(Arrive.get(0)));
                        label2.setText(Integer.toString(BTtrack));
                        label1.setPreferredSize(new Dimension(TempBT.get(Arrive.get(0)), 40));
                        label2.setPreferredSize(new Dimension(TempBT.get(Arrive.get(0)), 40));
                        label1.setBounds(var, 170,TempBT.get(Arrive.get(0)) , 50);
                        label2.setBounds(var, 200,TempBT.get(Arrive.get(0)) , 50);
                        var+=TempBT.get(Arrive.get(0));
                        BTtrack+=TempBT.get(Arrive.get(0));
                        before = after;
                        after = after + TempBT.get(Arrive.get(0));
                        EndingTime.set(Arrive.get(0),BTtrack);
                        TempBT.remove(Arrive.get(0));
                        Arrive.remove(0);
                        for (int j = 0; j < NumProc; j++)
                        {
                            if (atList.get(j) > before && atList.get(j) <= after)
                            {
                                Arrive.add(j);
                            }
                        }
                    }
                    panel1.setLayout(null);
                    Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
                    label1.setBorder(border);
                    panel1.add(label1);
                    panel1.add(label2);
                }
                MainFrame.add(panel1);
                MainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                MainFrame.setVisible(true);
            }
            for(int i=0;i<NumProc;i++)
            {
                WaitTime.set(i,EndingTime.get(i)-atList.get(i)-btList.get(i));
            }
            String Wait="Waiting Time:";
            String TurnAroundTime="Turn Around Time:";
            double totalWaitTime=0;
            double totaltat=0;
            for(int i=0;i<WaitTime.size();i++)
            {
                totalWaitTime+=WaitTime.get(i);
                totaltat+=(WaitTime.get(i)+btList.get(i));
                Wait+="P"+Integer.toString(i)+"="+WaitTime.get(i)+" ";  //Label for the output frame
                TurnAroundTime+="P"+Integer.toString(i)+"="+(WaitTime.get(i)+btList.get(i))+" ";    //Label for the output frame
            }
            Wait+="Average Waiting Time="+(totalWaitTime/NumProc);
            TurnAroundTime+="Average Turn Around Time Time="+(totaltat/NumProc);
            JLabel tat=new JLabel(TurnAroundTime);
            JLabel waits=new JLabel(Wait);
            JLabel end=new JLabel(Integer.toString(TotalBurstTime.get(TotalBurstTime.size()-1)));
            end.setBounds(var,200,30,50);
            panel1.add(end);
            waits.setBounds(0,210,1920,50);
            tat.setBounds(0,220,1920,50);
            panel1.add(tat);
            panel1.add(waits);
        }
        
        //Preemptive SJF
        if(chosen[2]==1)
        {
            JLabel label=new JLabel("PREEMPTIVE SHORTEST JOB FIRST");
            label.setBounds(0,230,300,50);
            panel1.add(label);
            ArrayList<Integer> TempBT=new ArrayList<Integer>();
            int varTime=atList.get(0);
            for(int i=0;i<NumProc;i++)
            {
                TempBT.add(btList.get(i));
                varTime+=btList.get(i);
            }
            ArrayList<Pair<String,String>> Pairs=new ArrayList<Pair<String, String>>();
            ArrayList<Integer> Arrival1=new ArrayList<Integer>();
            ArrayList<Integer> Arrival2=new ArrayList<Integer>();
            int initial=atList.get(0);
            int finish=initial;
            int CurrentLength=0;
            int CurrentProcess=-1;
            for(int i=atList.get(0);i<=varTime;i++)
            {
                if(CurrentProcess!=-1)
                    TempBT.set(CurrentProcess,TempBT.get(CurrentProcess)-1);
                for(int j=0;j<NumProc;j++)
                {
                    if(atList.get(j)<=i && TempBT.get(j)>0)
                    {
                        Arrival1.add(j);
                    }
                }
                boolean indicate=false;
                if(Arrival2.size()!=Arrival1.size())
                    indicate=true;
                else
                {
                    for(int j=0;j<Arrival1.size();j++)
                    {
                        if(Arrival2.get(j)!=Arrival1.get(j))
                        {
                            indicate=false;
                            break;
                        }
                        else
                            indicate=true;
                    }
                }
                if(indicate)
                {
                    CurrentLength=Arrival1.size();
                    int MinimumValue = 10000, MinimumProcess = 0;
                    for (int j = 0; j < Arrival1.size(); j++)
                    {
                        if (TempBT.get(Arrival1.get(j)) < MinimumValue && TempBT.get(Arrival1.get(j))>0)
                        {
                            MinimumProcess = Arrival1.get(j);
                            MinimumValue=TempBT.get(Arrival1.get(j));
                        }
                    }
                    if(MinimumProcess!=CurrentProcess)
                    {
                        String s=Integer.toString(CurrentProcess)+Integer.toString(initial);
                        String e=Integer.toString(CurrentProcess)+Integer.toString(finish);
                        Pairs.add(new Pair<String, String>(s,e));
                        initial=i;
                        finish+=1;
                        CurrentProcess=MinimumProcess;
                    }
                    else
                    {
                        finish+=1;
                    }
                }
                else
                {
                    finish+=1;
                }
                int SizeOfArrival2=Arrival2.size();
                for(int j=0;j<SizeOfArrival2;j++)
                    Arrival2.remove(0);
                for(int j=0;j<Arrival1.size();j++)
                {
                    Arrival2.add(Arrival1.get(j));
                }
                for(int j=0;j<CurrentLength;j++)
                {
                    Arrival1.remove(0);
                }
            }
            Pairs.add(new Pair<>(Integer.toString(CurrentProcess)+Integer.toString(initial),Integer.toString(CurrentProcess)+Integer.toString(finish)));
            int var=0;
            panel1.setLayout(null);
            for(int i=0;i<Pairs.size();i++)
            {
                String StartTime1=Pairs.get(i).getKey();
                String EndTime1=Pairs.get(i).getValue();
                int Start_Time_Sub=Integer.parseInt(StartTime1.substring(1));
                int End_Time_Sub=Integer.parseInt(EndTime1.substring(1));
                char Process_ID=StartTime1.charAt(0);
                JLabel label1=new JLabel("P"+Process_ID);
                JLabel label2=new JLabel(StartTime1.substring(1));
                label1.setPreferredSize(new Dimension(End_Time_Sub-Start_Time_Sub, 40));
                label2.setPreferredSize(new Dimension(End_Time_Sub-Start_Time_Sub, 40));
                label1.setBounds(var, 270,End_Time_Sub-Start_Time_Sub, 50);
                label2.setBounds(var, 300,End_Time_Sub-Start_Time_Sub , 50);
                Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
                label1.setBorder(border);
                var+=End_Time_Sub-Start_Time_Sub;
                panel1.add(label1);
                panel1.add(label2);
            }
            ArrayList<Integer> EndingTime=new ArrayList<Integer>();
            for(int i=0;i<NumProc;i++)
            {
                EndingTime.add(0);
            }
            for(int i=0;i<Pairs.size();i++)
            {
                char Process_ID=Pairs.get(i).getKey().charAt(0);
                int p=Character.getNumericValue(Process_ID);
                if(p!=-1)
                if(EndingTime.get(p)<Integer.parseInt(Pairs.get(i).getValue().substring(1))&&((Integer.parseInt(Pairs.get(i).getValue().substring(1))<=varTime)))
                {
                    EndingTime.set(p,Integer.parseInt(Pairs.get(i).getValue().substring(1)));
                }
            }
            ArrayList<Integer> TurnAroundTime=new ArrayList<Integer>();
            ArrayList<Integer> WaitTime=new ArrayList<Integer>();
            for(int i=0;i<NumProc;i++)
            {
                TurnAroundTime.add(EndingTime.get(i)-atList.get(i));
                WaitTime.add(TurnAroundTime.get(i)-btList.get(i));
            }
            String Waiting="Waiting Time:";
            String Tat="Turn Around Time:";
            double totalWaitTime=0;
            double totaltat=0;
            for(int i=0;i<WaitTime.size();i++)
            {
                totalWaitTime+=WaitTime.get(i);
                totaltat+=TurnAroundTime.get(i);
                Waiting+="P"+Integer.toString(i)+"="+WaitTime.get(i)+" ";       //Label for the output frame
                Tat+="P"+Integer.toString(i)+"="+TurnAroundTime.get(i)+" ";     //Label for the output frame
            }
            Waiting+="Average Waiting Time="+(totalWaitTime/NumProc);
            Tat+="Average Turn Around Time Time="+(totaltat/NumProc);
            JLabel TAT=new JLabel(Tat);
            JLabel WT=new JLabel(Waiting);
            WT.setBounds(0,310,1920,50);
            TAT.setBounds(0,320,1920,50);
            panel1.add(TAT);
            panel1.add(WT);
            JLabel last=new JLabel(Integer.toString(TotalBurstTime.get(TotalBurstTime.size()-1)));
            last.setBounds(var,300,30,50);
            panel1.add(last);
            MainFrame.add(panel1);
            MainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            MainFrame.setVisible(true);
        }
        
        //Non-Preemptive SJF
        if(chosen[3]==1)
        {
            JLabel label=new JLabel("NON PREEMPTIVE SHORTEST JOB FIRST");   //The scheduling is Non-Preemptive SJF
            label.setBounds(0,330,400,50);                                  
            panel1.add(label);                                                  //Adding the label to the panel
            int var=0;                                                      //Track of the X-Coordinates of the processes
            ArrayList<Integer> StartTime=new ArrayList<Integer>();          //Setting the Start Times List
            ArrayList<Integer> Arrival1=new ArrayList<Integer>();           //Setting the Arrival TimeList
            ArrayList<Integer> WaitingTime=new ArrayList<Integer>();        //Setting the Waiting Times list
            
            //Initializing the starting and waiting times with 0
            for(int i=0;i<NumProc;i++)
            {
                StartTime.add(0);
                WaitingTime.add(0);
            }
            int after=atList.get(0);        //The next process
            int before=-1;                  //The previous process
            for(int i=0;i<NumProc;i++)
            {
                for (int j = 0; j < NumProc; j++)
                {
                    if (atList.get(j) > before && atList.get(j) <= after) {
                        Arrival1.add(j);                //Adding the process to the arrived list
                    }
                }
                int MinimumProcess = 10000;             //The minimum number of processes
                int ProcessNumber = -1;                 //The current process number
                int ProcessToRemove = -1;               //The process to remove
                for (int j = 0; j < Arrival1.size(); j++)
                {
                    if (btList.get(Arrival1.get(j)) < MinimumProcess)
                    {
                        MinimumProcess = btList.get(Arrival1.get(j));   
                        ProcessNumber = Arrival1.get(j);
                        ProcessToRemove = j;
                    }
                }
                JLabel label1 = new JLabel("p" + Integer.toString(ProcessNumber));
                label1.setPreferredSize(new Dimension(btList.get(ProcessNumber), 40));
                JLabel label2 = new JLabel(Integer.toString(after));
                StartTime.set(i,after);
                WaitingTime.set(i,StartTime.get(i)-atList.get(i));
                label2.setPreferredSize(new Dimension(btList.get(ProcessNumber), 40));
                panel1.setLayout(null);
                Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
                label1.setBorder(border);
                label1.setBounds(var, 370, btList.get(ProcessNumber), 50);
                label2.setBounds(var, 400, btList.get(ProcessNumber), 50);
                var += btList.get(ProcessNumber);
                panel1.add(label1);
                panel1.add(label2);
                Arrival1.remove(ProcessToRemove);
                before = after;
                after = after + btList.get(ProcessNumber);
                MainFrame.add(panel1);
                MainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                MainFrame.setVisible(true);
            }
            String WaitTime="Waiting Time:";
            String TAT="Turn Around Time:";
            double totalWaitTime=0;
            double totaltat=0;
            for(int i=0;i<WaitingTime.size();i++)
            {
                totalWaitTime+=WaitingTime.get(i);
                totaltat+=(WaitingTime.get(i)+btList.get(i));
                WaitTime+="P"+Integer.toString(i)+"="+WaitingTime.get(i)+" ";           //Label for the output frame
                TAT+="P"+Integer.toString(i)+"="+(WaitingTime.get(i)+btList.get(i))+" ";//Label for the output frame
            }
            WaitTime+="Average Waiting Time="+(totalWaitTime/NumProc);
            TAT+="Average Turn Around Time Time="+(totaltat/NumProc);
            JLabel tat=new JLabel(TAT);
            JLabel WT=new JLabel(WaitTime);
            WT.setBounds(0,410,1920,50);
            tat.setBounds(0,420,1920,50);
            JLabel last=new JLabel(Integer.toString(TotalBurstTime.get(TotalBurstTime.size()-1)));
            last.setBounds(var,400,30,50);
            panel1.add(last);
            panel1.add(WT);
            panel1.add(tat);
        }
        
        //Preemptive Priority
        if(chosen[4]==1)
        {
            JLabel label=new JLabel("PREEMPTIVE PRIORITY"); //The scheduling algorithm is Preemptive Priority
            label.setBounds(0,430,300,50);
            panel1.add(label);
            ArrayList<Integer> TempBT=new ArrayList<Integer>(); //The temporary storage of the burst times in this list
            int timeInstance=atList.get(0);                     //The time instance of arrival
            for(int i=0;i<NumProc;i++)
            {
                TempBT.add(btList.get(i));
                timeInstance+=btList.get(i);
            }
            ArrayList<Integer> Arrival1=new ArrayList<Integer>();       //The arrived list 1
            ArrayList<Integer> Arrival2=new ArrayList<Integer>();       //The arrived list 2
            ArrayList<Pair<String,String>> Pairs=new ArrayList<Pair<String, String>>(); //The pair storing the Starting Times and End times
            int initial=atList.get(0);
            int finish=initial;
            int CurrentLength=0;
            int CurrentProcess=-1;
            for(int i=atList.get(0);i<=timeInstance;i++)
            {
                if(CurrentProcess!=-1)
                    TempBT.set(CurrentProcess,TempBT.get(CurrentProcess)-1);    //Setting the temperory burst time list with the values
                for(int j=0;j<NumProc;j++)
                {
                    if(atList.get(j)<=i && TempBT.get(j)>0)
                    {
                        Arrival1.add(j);            //Adding the arrived number to the arrived list 1
                    }   
                }
                boolean indicate=false;             //This indicates if any update has taken place 
                if(Arrival2.size()!=Arrival1.size())
                    indicate=true;
                else
                {
                    for(int j=0;j<Arrival1.size();j++)
                    {
                        if(Arrival2.get(j)!=Arrival1.get(j))
                        {
                            indicate=false;
                            break;
                        }
                        else
                            indicate=true;
                    }
                }
                if(indicate)
                {
                    CurrentLength=Arrival1.size();      //The current Length of the arrived list1
                    int MinimumValue = 10000;
                    int MinimumProcess = 0;
                    for (int j = 0; j < Arrival1.size(); j++)
                    {
                        if (pList.get(Arrival1.get(j)) < MinimumValue && TempBT.get(Arrival1.get(j))>0)
                        {
                            MinimumProcess = Arrival1.get(j);
                            MinimumValue=pList.get(Arrival1.get(j));
                        }
                    }
                    if(MinimumProcess!=CurrentProcess)
                    {
                        String Start=Integer.toString(CurrentProcess)+Integer.toString(initial);
                        String End=Integer.toString(CurrentProcess)+Integer.toString(finish);
                        Pairs.add(new Pair<String, String>(Start,End));
                        initial=i;
                        finish+=1;
                        CurrentProcess=MinimumProcess;
                    }
                    else
                    {
                        finish+=1;
                    }
                }
                else
                {
                    finish+=1;
                }
                int SizeOfArrival2=Arrival2.size();
                for(int j=0;j<SizeOfArrival2;j++)
                    Arrival2.remove(0);
                for(int j=0;j<Arrival1.size();j++)
                {
                    Arrival2.add(Arrival1.get(j));
                }
                for(int j=0;j<CurrentLength;j++)
                {
                    Arrival1.remove(0);
                }
             }
            Pairs.add(new Pair<>(Integer.toString(CurrentProcess)+Integer.toString(initial),Integer.toString(CurrentProcess)+Integer.toString(finish)));
            int var=0;
            panel1.setLayout(null);
            for(int i=0;i<Pairs.size();i++)
            {
                String StartTime1=Pairs.get(i).getKey();
                String EndTime1=Pairs.get(i).getValue();
                int Start_Time_Sub=Integer.parseInt(StartTime1.substring(1));
                int End_Time_Sub=Integer.parseInt(EndTime1.substring(1));
                char Process_ID=StartTime1.charAt(0);
                JLabel label1=new JLabel("P"+Process_ID);
                JLabel label2=new JLabel(StartTime1.substring(1));
                label1.setPreferredSize(new Dimension(End_Time_Sub-Start_Time_Sub, 40));
                label2.setPreferredSize(new Dimension(End_Time_Sub-Start_Time_Sub, 40));
                label1.setBounds(var, 470,End_Time_Sub-Start_Time_Sub, 50);
                label2.setBounds(var, 500,End_Time_Sub-Start_Time_Sub , 50);
                Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
                label1.setBorder(border);
                var+=End_Time_Sub-Start_Time_Sub;
                panel1.add(label1);panel1.add(label2);
            }
            ArrayList<Integer> EndingTime=new ArrayList<Integer>();
            for(int i=0;i<NumProc;i++)
            {
                EndingTime.add(0);
            }
            for(int i=0;i<Pairs.size();i++)
            {
                char Process_ID=Pairs.get(i).getKey().charAt(0);
                int p=Character.getNumericValue(Process_ID);
                if(p!=-1)
                    if(EndingTime.get(p)<Integer.parseInt(Pairs.get(i).getValue().substring(1))&&((Integer.parseInt(Pairs.get(i).getValue().substring(1))<=timeInstance)))
                    {
                        EndingTime.set(p,Integer.parseInt(Pairs.get(i).getValue().substring(1)));
                    }
            }
            ArrayList<Integer> TAT=new ArrayList<Integer>();
            ArrayList<Integer> WaitTime=new ArrayList<Integer>();
            
            for(int i=0;i<NumProc;i++)
            {
                TAT.add(EndingTime.get(i)-atList.get(i));
                WaitTime.add(TAT.get(i)-btList.get(i));
            }
            
            String Wait="Waiting Time:";
            String Tat="Turn Around Time:";
            double totalWaitTime=0;
            double totaltat=0;
            for(int i=0;i<WaitTime.size();i++)
            {
                totalWaitTime+=WaitTime.get(i);
                totaltat+=TAT.get(i);
                Wait+="P"+Integer.toString(i)+"="+WaitTime.get(i)+" ";      //Label for the output frame
                Tat+="P"+Integer.toString(i)+"="+TAT.get(i)+" ";            //Label for the output frame
            }
            Wait+="Average Waiting Time="+(totalWaitTime/NumProc);
            Tat+="Average Turn Around Time Time="+(totaltat/NumProc);
            JLabel tat=new JLabel(Tat);
            JLabel WT=new JLabel(Wait);
            WT.setBounds(0,510,1920,50);
            tat.setBounds(0,520,1920,50);
            JLabel end=new JLabel(Integer.toString(TotalBurstTime.get(TotalBurstTime.size()-1)));
            end.setBounds(var,500,30,50);
            panel1.add(end);
            panel1.add(tat);
            panel1.add(WT);
            MainFrame.add(panel1);
            MainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            MainFrame.setVisible(true);
        }
        
        //Non_Preemptive Priority
        if(chosen[5]==1)
        {
            JLabel label=new JLabel("NON PREEMPTIVE PRIORITY"); //The scheduling algorithm in use is Non Preemptive Priority
            label.setBounds(0,530,300,50);
            panel1.add(label);                                      //Adding the label to the panel
            int var=0;                                          //Keeping track of the X-Coordinate of the processes
            ArrayList<Integer> STARTTIME=new ArrayList<Integer>();  //A list for maintaining the Start Times
            ArrayList<Integer> WAITTIME=new ArrayList<Integer>();   //A list for maintaining the Wait Times
            ArrayList<Integer> Arrival1=new ArrayList<Integer>();   //Setting the arrived list           
            //Inititalizing the start times initially as 0
            for(int i=0;i<NumProc;i++)
            {
                STARTTIME.add(0);
            }
            int after=atList.get(0);    //The next process
            int before=-1;              //The previous proess
            for(int i=0;i<NumProc;i++)
            {
                for(int j=0;j<NumProc;j++)
                {
                    if(atList.get(j)>before && atList.get(j)<=after)
                    {
                        Arrival1.add(j);    //Adding the arrived process into the list
                    }
                }
                int MinimumProcess=10000;   //The minimum number of processes
                int ProcessToRemove=-1;     //The process which is to be removed
                int ProcessNumber=-1;       //The process number
                for(int j=0;j<Arrival1.size();j++)
                {
                    if(pList.get(Arrival1.get(j))<MinimumProcess)
                    {
                        MinimumProcess=pList.get(Arrival1.get(j));
                        ProcessNumber=Arrival1.get(j);ProcessToRemove=j;
                    }
                }
                JLabel label1=new JLabel("p"+Integer.toString(ProcessNumber));
                label1.setPreferredSize(new Dimension(btList.get(ProcessNumber),40));
                JLabel label2=new JLabel(Integer.toString(after));
                STARTTIME.set(i,after);
                WAITTIME.add(i,STARTTIME.get(i)-atList.get(i));
                label2.setPreferredSize(new Dimension(btList.get(ProcessNumber), 40));
                panel1.setLayout(null);
                Border border = BorderFactory.createLineBorder(Color.BLACK,1);
                label1.setBorder(border);
                label1.setBounds(var,570,btList.get(ProcessNumber),50);
                label2.setBounds(var,600, btList.get(ProcessNumber),50);
                var+=btList.get(ProcessNumber);
                panel1.add(label1);
                panel1.add(label2);
                Arrival1.remove(ProcessToRemove);
                before=after;
                after=after+btList.get(ProcessNumber);
                MainFrame.add(panel1);
                MainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                MainFrame.setVisible(true);
            }
            String WaitTime="Waiting Time:";
            String TAT="Turn Around Time:";
            double totalWaitTime=0;
            double totaltat=0;
            for(int i=0;i<WAITTIME.size();i++)
            {
                totalWaitTime+=WAITTIME.get(i);
                totaltat+=(WAITTIME.get(i)+btList.get(i));
                WaitTime+="P"+Integer.toString(i)+"="+WAITTIME.get(i)+" ";              //Label for the output frame
                TAT+="P"+Integer.toString(i)+"="+(WAITTIME.get(i)+btList.get(i))+" ";   //Label for the output frame
            }
            WaitTime+="Average Waiting Time="+(totalWaitTime/NumProc);
            TAT+="Average Turn Around Time Time="+(totaltat/NumProc);
            JLabel tat=new JLabel(TAT); 
            JLabel wt=new JLabel(WaitTime);
            JLabel last=new JLabel(Integer.toString(TotalBurstTime.get(TotalBurstTime.size()-1)));
            last.setBounds(var,600,30,50);
            panel1.add(last);
            wt.setBounds(0,610,1920,50);
            tat.setBounds(0,620,1920,50);
            panel1.add(wt);
            panel1.add(tat);
        }
    }
}