import java.util.*;

public class Main {

        public static int newCurrentMemberIndex(Queue<String> taskqueue, String s, int currindold) {

            Queue<String> tempQueue = new LinkedList<>(taskqueue);

            // loop through the temporary queue to get the element at the specified index
            for (int i = 0; i < currindold; i++) {
                tempQueue.remove();
            }
            String oldmemb=tempQueue.peek();
            System.out.println("oldmemb is: "+oldmemb);


            // Remove inactive members from the queue
            Queue<String> newQueue = new LinkedList<>(); // create a new queue to store the elements after removing required one

            // loop through the original queue and add non-repeating elements to the new queue
            for (String element : taskqueue) {
                if (!element.equals(oldmemb)) {
                    newQueue.add(element);
                }
            }
            System.out.println(newQueue);

            //Calculating the index of new queue current member
            Iterator<String> iterator = taskqueue.iterator();
            int count=0;
            int index=0;
            while (iterator.hasNext() && index <= currindold) {
                String currentElement = iterator.next();
                if (currentElement == oldmemb) {
                    count++;
                    index++;

                    if (index > currindold)
                        break;

                }

        }return (currindold-count);
        }

        public static void main(String[] args) {
            Queue<String> taskqueue= new LinkedList<>() ;
            Scanner sc=new Scanner(System.in);

            System.out.println("Enter the size of queue: ");
            int n=sc.nextInt();

            System.out.println("Enter elements of queue: ");
            for(int i=0;i<n;i++){
                String ele=sc.next();
                taskqueue.add(ele);
            }
            System.out.println("queue is: "+ taskqueue);

            System.out.println("enter current index value: ");
            int currindold=sc.nextInt();

            System.out.println("enter the members name to be removed: ");
                String s=sc.next();

            System.out.println(newCurrentMemberIndex(taskqueue, s, currindold));
        }
}