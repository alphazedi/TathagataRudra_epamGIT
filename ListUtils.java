import java.io.*;
// A linked list node
class Node
{
 int data;
 Node next;
 Node(int data, Node next) {
 this.data = data;
 this.next = next;
 }
};
class ListUtils
{
 // Function to detect Cycle in a linked list using
 // Floyd’s Cycle Detection Algorithm
 public static int detectCycle(Node head)
 {
 int count = 0;
 // take two references - tortoise and fast
 Node tortoise = head, hare = head;
 while (hare != null && hare.next != null)
 {
 // move tortoise by one
 tortoise = tortoise.next;
 // move hare by two
 hare = hare.next.next;
 // if they meet any any node, linked list contains a cycle
 if (tortoise == hare) {
 tortoise = head;
 while(tortoise != hare)
 {
 hare = hare.next;
tortoise = tortoise.next;
count++;
 }
 return count;
 }
 }
 // we reach here if tortoise & hare do not meet
 return 0;
 }
 // Detect Cycle in a linked list using Floyd’s Cycle Detection Algorithm
 public static void main(String[] args) throws IOException {
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 System.out.println("Enter the size of the list:");
 int n;
 n = Integer.parseInt(br.readLine());
 int keys[] = new int[n];
 // input keys
 System.out.println("Enter the elements of the list:");
 for(int i=0; i<n; i++)
 {
 keys[i]=Integer.parseInt(br.readLine());
 }
 Node head = null;
 for (int i = keys.length - 1; i >= 0; i--) {
 head = new Node(keys[i], head);
 }
 System.out.println("---------------------------------------------------");
 // insert cycle
 head.next.next.next.next.next.next = head.next.next.next;
 int found=detectCycle(head);
 if (found!=0) {

 System.out.println("Cycle Found at position "+found);
 } else {
 System.out.println("Hare Pointer won");
 System.out.println("No Cycle Found");
 }
 }
}
