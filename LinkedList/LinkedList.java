
public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public Node processing() { // Dequeue operation in linked.

        if (size == 0) {
            System.err.println("There is no customer in the queue");
            return null;
        } else {
            Node temp = head;
            signProcess(); // To sign customer to process.
            if (head.getNext() != null) {
                // If any customer is the head of queue their startingpoint variable is true.
                head.getNext().setStartingpoint(true);
                head = head.getNext();
                head.setPrev(null);
            } else {
                tail = head = null;
            }
            size--;
            return temp;
        }
    }

    public void signProcess() {

        Node temp = head.getNext();
        while (temp != null && !temp.isStartingpoint()) {
            temp.setProcess(true);
            temp = temp.getNext();
        }
    }

    public void add(String name, int priority) {

        Node newNode = new Node(name, priority);
        if (size == 0) {
            tail = head = newNode;
            newNode.setStartingpoint(true); // To find position of new queue.
            size++;
        } else {
            Node temp = tail;
            size++;
            while (!temp.isProcess() && temp.getPriority() > priority && temp.getPrev() != null) {
                temp = temp.getPrev();
            }
            if (priority == 3) { // For all customer that have 3 priority, will start new queue.
                newNode.setPrev(temp);
                temp.setNext(newNode);
                newNode.setStartingpoint(true);
                tail = newNode;
            } else {
                if (checkLocation(priority, temp)) { // else have to start new queue because of limitations.

                    if (temp.getPrev() == null && temp.getPriority() > priority) { // Add to head.
                        head.setStartingpoint(false);
                        temp.setPrev(newNode);
                        newNode.setNext(temp);
                        newNode.setStartingpoint(true);
                        head = newNode;

                    } else if (temp.getNext() == null) { // Add to the end.
                        newNode.setPrev(temp);
                        temp.setNext(newNode);
                        tail = newNode;
                    } else {  // Add between two node.
                        if (temp.getNext().isStartingpoint()) { //   /1* 2* 3* / 2  <--0 to change starting point.
                            temp.getNext().setStartingpoint(false);
                            newNode.setStartingpoint(true);
                        }
                        newNode.setPrev(temp);
                        newNode.setNext(temp.getNext());
                        temp.getNext().setPrev(newNode);
                        temp.setNext(newNode);

                    }

                } else { // To start new queue.

                    while (temp != null && !temp.isStartingpoint()) {
                        temp = temp.getNext();
                    }
                    if (temp == null) {
                        newNode.setStartingpoint(true);
                        newNode.setPrev(tail);
                        tail.setNext(newNode);
                        tail = newNode;
                    } else {
                        temp.setStartingpoint(false);
                        newNode.setNext(temp);
                        newNode.setPrev(temp.getPrev());
                        temp.getPrev().setNext(newNode);
                        temp.setPrev(newNode);
                        newNode.setStartingpoint(true);
                    }

                }
            }

        }
    }

    public boolean checkLocation(int priority, Node temp) {
        // Checks limitation rules and process options.

        int counter = 0;
        if (temp.getPrev() == null) {
            return true;
        } else {
            while (temp != null && !temp.isStartingpoint()) {
                if (temp.getPriority() == priority)
                    counter++;
                temp = temp.getPrev();
            }
            if (temp.isStartingpoint() && priority == temp.getPriority()) counter++;
            if (priority == 0)
                return counter < 5;
            else if (priority == 1)
                return counter < 3;
            else if (priority == 2)
                return counter < 2;
            else return false;

        }
    }

    public String printQueue() {

        /* This is changed version of defined output. If any customer is the
           startingpoint of queue it has "/" in front of their priority.
           In addition if a queue processed, their priority look like this
           "1*" so you can more easy understand what happened in this queue.*/

        String print = "";
        if (size == 0)
            return "Empty";
        else {
            Node temp = head;
            while (temp != null) {
                if (temp.isStartingpoint()) print = print + "/";
                print = print + " " + temp.getPriority();
                if (temp.isProcess())
                    print = print + "*";
                temp = temp.getNext();
            }
        }
        return print;

    }

}
