
public class Node {
    private Node prev;
    private Node next;
    private String name;
    private int priority;
    private boolean startingpoint; // To define starting point of new queue.
    private boolean process; // If any queue process their all customer will be process so no customer get ahead of them.

    public Node(String name, int priority) {
        startingpoint = false;
        process = false;
        this.name = name;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public boolean isStartingpoint() {
        return startingpoint;
    }

    public void setStartingpoint(boolean startingpoint) {
        this.startingpoint = startingpoint;
    }

    public boolean isProcess() {
        return process;
    }

    public void setProcess(boolean process) {
        this.process = process;
    }

    //  public void setName(String name) {this.name = name;}
    // public void setPriority(int priority) {this.priority = priority; }

}
