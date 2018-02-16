//The stack like a bag. First in last out. This implement run like array you follow a integer value for finding top element.
public class Stack {
    private  int top;
    private Object[] elements; // You can define capacity of stack.

    public Stack(int capacity)
    {

        elements = new Object[capacity];
        top=-1;
    }

    public void Push(Object data){ // Adds data.
        if(!isFull())
        {
            top++;
            elements[top]=data;
        }

    }

    public Object Pop() //Removes data.
    {
        if(!isEmpty())
        {
            Object returndata = elements[top];
            top--;
            return returndata;
        }
        else return null;


    }

    public boolean isEmpty()
    {
        return (top==-1);

    }

    public boolean isFull()

    {
        return (top+1==elements.length);
    }

    int size()
    {
        return top+1;
    }

    public Object Peek() //Shows top element.
    {
        if(!isEmpty())
        {
            return elements[top];
        }

        return null;

    }
}
