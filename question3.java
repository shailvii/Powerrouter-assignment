import java.util.*;
public class question3 {

        static class Node { 
            int data;
            Node next;
            Node(int data) {
                this.data = data;
                next = null;
            }
        }
        static Node head;

        public static int getMiddle() {
            if (head == null) {
                return -1; // Return -1 if the linked list is empty
            }

            Node slow = head;
            Node fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow.data;
        }

        public static void main(String[] args) {
            LinkedList list = new LinkedList();
            Scanner sc=new Scanner(System.in);

            System.out.print("Enter the number of elements in the linked list: ");
            int n = sc.nextInt();
            System.out.print("Enter the elements of the linked list: ");
            int data = sc.nextInt();
            head = new Node(data);
            Node current = head;

            for (int i = 1; i < n; i++) {
                data = sc.nextInt();
                Node newNode = new Node(data);
                current.next = newNode;
                current = newNode;
            }

            System.out.println("Middle element is: " + getMiddle());

        }
    }

