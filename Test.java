import java.util.Scanner;

public class TestQueue {
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Queue fruitQueue = new Queue(100);
		Queue tempQueue1= new Queue(100); // Temp queues for keeping 5 fruit to  first and secon queue.
		Queue tempQueue2 = new Queue(100);
		Queue Queue1 = new Queue(500);
		Queue Queue2 = new Queue(500);
		int firstQueueRandom; // Queue randoms numbers to assign random fruit Queue1 and Queue2.
		int secondQueueRandom;
		int firstchoice; // To keep choices.
		int secondchoice;
		int score=0;
		int step=1;
		fruitQueue.Enqueue("Apple");
		fruitQueue.Enqueue("Banana");
		fruitQueue.Enqueue("Bear");
		fruitQueue.Enqueue("Orange");
		fruitQueue.Enqueue("Mellon");
		fruitQueue.Enqueue("Watermellon");
		fruitQueue.Enqueue("Pineapple");
		fruitQueue.Enqueue("Strawberry");
		fruitQueue.Enqueue("Cherry");
		fruitQueue.Enqueue("Grape");

			System.out.print("Fruit Queue: ");
			displayQueue(fruitQueue);
			System.out.println("\n \n");
			
		// To define the fruit to be placed.
	for (int k = 0; k < 5; k++) 
	{
		
		int randomnumber = (int) (Math.random() * fruitQueue.size() + 0); 
		
			for (int i =0 ; i < randomnumber; i++) 
			{
				fruitQueue.Enqueue(fruitQueue.Dequeue());
			}
			tempQueue1.Enqueue(fruitQueue.peek());   // For Queue1
			tempQueue2.Enqueue(fruitQueue.Dequeue());   // For Queue2
			
			for (int i = randomnumber; i < fruitQueue.size(); i++) 
			{
				fruitQueue.Enqueue(fruitQueue.Dequeue());
			}
			
			
			
	}
		for(int k=0;k<5;k++) // To place choiced fruits to Queue1 and Queue2
		{
			firstQueueRandom = (int) (Math.random() * tempQueue1.size() + 0);
			secondQueueRandom = (int) (Math.random()* tempQueue2.size()+ 0);
			
			for (int i = 0; i < firstQueueRandom; i++) {
				tempQueue1.Enqueue(tempQueue1.Dequeue());
				
			}
			Queue1.Enqueue(tempQueue1.Dequeue());
			for (int i = firstQueueRandom; i <tempQueue1.size(); i++) {
				tempQueue1.Enqueue(tempQueue1.Dequeue());
			}
			
			for (int i = 0; i < secondQueueRandom; i++) {
				tempQueue2.Enqueue(tempQueue2.Dequeue());
			}
			Queue2.Enqueue(tempQueue2.Dequeue());
			for (int i = secondQueueRandom; i < tempQueue2.size(); i++) {
				tempQueue2.Enqueue(tempQueue2.Dequeue());
			}
		
		}
		
		
		System.out.print("Queue1: ");
		displayQueue(Queue1);
		System.out.println();
		System.out.print("Queue2: ");
		displayQueue(Queue2);
		System.out.println("\n");
			while(true)
			{
			firstchoice=(int)(Math.random()*Queue1.size()+0);
			secondchoice=(int)(Math.random()*Queue2.size()+0);
			System.out.print("Random generated numbers: "+(firstchoice+1)+" "+(secondchoice+1));
			
			System.out.println("                         "+"Step = "+step);
		
			for (int i = 0; i < firstchoice; i++) 
			{
				Queue1.Enqueue(Queue1.Dequeue());
			}
			for (int i = 0; i < secondchoice; i++) 
			{
				Queue2.Enqueue(Queue2.Dequeue());
			}
			if(Queue1.peek().equals(Queue2.peek()))
			{
				Queue1.Dequeue();
				Queue2.Dequeue();
				score+=20;
			}
			else
			{
				score-=1;
			}
			for (int i = firstchoice; i < Queue1.size(); i++)
			{
				Queue1.Enqueue(Queue1.Dequeue());
			}
			for (int i = secondchoice; i < Queue2.size(); i++) 
			{
				Queue2.Enqueue(Queue2.Dequeue());
				
			}
			
			
			System.out.println("                                                      Score= "+score);
			System.out.print("Queue1: ");
			displayQueue(Queue1);
			System.out.println();
			System.out.print("Queue2: ");
			displayQueue(Queue2);
			System.out.println("\n \n \n");
			
			step++;
			
			if(Queue1.size()==0&&Queue2.size()==0)
			{
				break;
			}
			
			}

	System.out.println("Game is over.");
		

	
	}
	
 // To write queues.
	public static void displayQueue(Queue Queue)
	{
		for (int i = 0; i < Queue.size(); i++) {
			if(Queue.peek()!=null){
			System.out.print(Queue.peek()+" ");
			}
			Queue.Enqueue(Queue.Dequeue());
		}
		
	}
	

}
