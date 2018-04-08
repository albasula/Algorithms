/**
 * Reverses a given linked list with
 * the help of two references.
 * Created on 20/01/2017.
 */
class LinkedList{
    LinkedList next;
    int val;
    LinkedList(int v){
        val = v;
        next = null;
    }
    static LinkedList reverseList(LinkedList head){
        LinkedList newHead = head;
        LinkedList prevHead = head;
        while (head.next.next != null){
            newHead = head.next;
            head.next = head.next.next;
            newHead.next= prevHead;
            prevHead = newHead;
        }
        head.next.next = newHead;
        newHead = head.next;
        head.next = null;
        return newHead; // return the head of the new reversed list
    }
    static void addLast(LinkedList head, LinkedList newList){
        LinkedList temp = head;
        while(temp.next!=null)
            temp = temp.next;
        temp.next = newList;
    }
    static void printList(LinkedList head){
        LinkedList temp = head;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
public class ReverseList {
    public static void main(String args[]){
        LinkedList head = new LinkedList(1);
        LinkedList node1 = new LinkedList(4);
        LinkedList node2 = new LinkedList(5);
        LinkedList.addLast(head, node1);
        LinkedList.addLast(head, node2);

        LinkedList.printList(head);
        System.out.println(); // newline
        LinkedList.printList(LinkedList.reverseList(head));
    }
}
