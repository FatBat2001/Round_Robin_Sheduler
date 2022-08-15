class Node  {
    int burst_time;
    int process_id;
    public Node(int burst_time, int process_id) {
        this.burst_time = burst_time;
        this.process_id = process_id;
    }

    public int getBurst_time() {
        return burst_time;
    }

    public void setBurst_time(int burst_time) {
        this.burst_time = burst_time;
    }

    public int getProcess_id() {
        return process_id;
    }

    public void setProcess_id(int process_id) {
        this.process_id = process_id;
    }

    public String displayNode() {
        return "Process ID : " + getProcess_id() + ", remaining Burst Time : " + getBurst_time() + "\n";
    }
}