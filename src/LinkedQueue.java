
public class LinkedQueue
{
    class QNode
    {
        Node process;
        QNode next;
        public QNode(Node process) {
            this.process = process;
        }
    }
    final static int MAX = 1000;
    QNode front;
    QNode rear;
    int num_of_elements;
    int total_burst_time;
    int[] ids;
    int id_counter;
    public LinkedQueue() {
        this.front = null;
        this.rear = null;
        this.total_burst_time = 0;
        this.num_of_elements = 0;
        this.ids = new int[MAX];
        id_counter = 0;
    }


    public boolean is_empty()
    {
        return front == null;
    }

    public void destroy()
    {
        front = rear = null;
    }

    public boolean is_entered_before(int id) {
        for (int i = 0; i < id_counter; i ++) {
            if (id == this.ids[i])
                return true;
        }
        return false;
    }

    // You should check for IDs that's been entered Already before Enqueuing
    public void enqueue(Node process) {
        QNode temp = new QNode(process);
        if (this.rear  == null) {
            this.rear = this.front = temp;
        } else {
            this.rear.next = temp;
            this.rear = this.rear.next;
        }
        this.num_of_elements ++;
        if (!is_entered_before(process.getProcess_id())) {
            total_burst_time += process.getBurst_time();
            ids[id_counter ++] = process.process_id;
        }
    }


    public Node dequeue() {
        if (this.front == null)
            return null;

            QNode temp = this.front;
            this.front = this.front.next;
            if (this.front == null)
                this.rear = null;

            this.num_of_elements --;
            return temp.process;
    }


    public int get_num_of_elements(){ // to display the number of waiting processes
        return this.num_of_elements;
    }

    public int get_total_burst_time () {
        return this.total_burst_time;
    }

    public String display_waiting_processes() {
        QNode p = front;
        String result = "";
        while (p != null) {
            result += p.process.displayNode();
            p = p.next;
        }
        return  result;
    }








                            //*** Testing ***\\\
    //-------------------------------------------------------------------------------------\\

    public static void main(String[] args) {



    }
}
