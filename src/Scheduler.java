import java.util.Scanner;

public class Scheduler {
    final static int MAX = 1000;


    LinkedQueue Q;
    int time_quantum;

    public Scheduler() {
        this.Q = new LinkedQueue();
    }

    public Scheduler(int time_quantum) {
        this.Q = new LinkedQueue();
        this.time_quantum = time_quantum;
    }

    public void add_process(int burst_time, int id) {
        Q.enqueue(new Node(burst_time, id));
    }

    public String serve_process() {
        String res;
        Node temp = Q.dequeue();
        if (temp == null)
            return "(No processes to be served) \n";

        if (temp.getBurst_time() > this.time_quantum) {
            temp.setBurst_time(temp.getBurst_time() - time_quantum);
            Q.enqueue(temp);
            res = temp.displayNode();
        } else {
            temp.setBurst_time(0);
            res = "Process with ID: (" + temp.getProcess_id() + ") is Finished\n";
        }
        return res;
    }

    public String no_of_waiting_processes() {
        return "Number of waiting processes is : " + this.Q.get_num_of_elements();
    }

    public String waiting_processes_info() {
        return Q.display_waiting_processes();
    }
    public String total_cpu_burst_time() {
        return this.Q.get_total_burst_time() + "";
    }

    public void setTime_quantum(int time_quantum) {
        this.time_quantum = time_quantum;
    }

    public int getTime_quantum() {
        return this.time_quantum;
    }




    //--------------------------Testing--------------------\\
    public static void main(String[] args) {
        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        System.out.println(str);
    }

}
