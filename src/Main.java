import java.io.*;
import java.util.Scanner;

public class Main {
    //*** Testing ***\\\
    //-------------------------------------------------------------------------------------\\
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            BufferedWriter br = new BufferedWriter(new FileWriter("output.txt"));
            Scheduler S = new Scheduler();
            int quantum;
            int process_id;
            int process_burst_time;
            String menu_option;

            int []ids = new int[1000];
            int id_count = 0;

            String bufferQuery;


            System.out.print("\t\t**Welcome to Round Robin Scheduler**\n\n!Enter the time Quantum: ");

            quantum = sc.nextInt();
            S.setTime_quantum(quantum);

            System.out.println("Now Choose from the corresponding menu");


            while (true) {
                System.out.println("1- Add a process");
                System.out.println("2- Serve a process");
                System.out.println("3- Show the number of waiting processes");
                System.out.println("4- Display waiting processes");
                System.out.println("5- Display total CPU burst time");
                System.out.println("6- Exit");
                menu_option = sc.next();



                if (menu_option.equals("1")) {
                    boolean flag = false;
                    System.out.println("Enter the process's ID");
                    process_id = sc.nextInt();
                    for (int i = 0; i < id_count; i ++) {
                        if (ids[i] == process_id) {
                            System.out.println("This Process has been entered before\n");
                            flag = true;
                        }
                    }
                    if (!flag) {

                        ids[id_count ++] = process_id;
                        System.out.println("Enter the process's burst time");
                        process_burst_time = sc.nextInt();
                        S.add_process(process_burst_time, process_id);

                    }

                } else if (menu_option.equals("2")) {

                    bufferQuery = S.serve_process();
                    br.write(bufferQuery + "\n");
                    System.out.println(bufferQuery);

                } else if (menu_option.equals("3")) {

                    bufferQuery = S.no_of_waiting_processes();
                    br.write(bufferQuery + "\n");
                    System.out.println(bufferQuery);

                } else if (menu_option.equals("4")) {

                    bufferQuery = S.waiting_processes_info();
                    br.write(bufferQuery + "\n");
                    System.out.println(bufferQuery);

                } else if (menu_option.equals("5")) {

                    bufferQuery = S.total_cpu_burst_time();
                    br.write(bufferQuery + "\n");
                    System.out.println(bufferQuery);

                } else if (menu_option.equals("6")){
                    break;
                } else {
                    System.out.println("Enter a valid operation");
                }
            }



            br.close();
        } catch (Exception e) {
        }
    }
}
