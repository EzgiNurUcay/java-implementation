// The program don't need any else condition for push and pop. Because this condition is checked in main.
public class Stack {
private  int top;
private Object[] elements;
	
	public Stack(int capacity)
	{
		
		elements = new Object[capacity];
		top=-1;
	}
	
	public void Push(Object data){
		if(!isFull())
		{
			top++;
			elements[top]=data;
		}
		
	}
	
	public Object Pop()
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
	
	public Object Peek()
	{
		if(!isEmpty())
		{
			return elements[top];
		}
	
		return null;
		
			
	}
}
