/**
 * Deletes the middle node in a given linked list.
 * Created on 20/02/2017.
 */

class LinkedList{
    LinkedList next;
    int val;
    LinkedList(int val) {
        this.val = val;
    }
    static void printList(LinkedList head){
        LinkedList tmp = head;
        while(tmp!=null){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }

    static void deleteMiddleNode(LinkedList head){
        if (head == null || head.next == null)
            System.out.println("This list is inappropriate for this operation.");
        LinkedList tortoise = head;
        LinkedList rabbit = head;
        LinkedList tmp = head;
        while(rabbit != null){
            if (rabbit.next == null || rabbit.next.next == null){ // For odd and even number of list nodes
                tmp.next = tmp.next.next;
                tortoise.next = null;
                //May call System.gc() here to request a garbage collection
                break;
            }
            tmp = tortoise;
            tortoise = tortoise.next;
            rabbit = rabbit.next.next;
        }
    }
}

public class DeleteMiddleNode {
    public static void main(String args[]){
        LinkedList node1 = new LinkedList(2);
        LinkedList node2 = new LinkedList(3);
        LinkedList node3 = new LinkedList(4);
        node1.next = node2;
        node2.next = node3;
        LinkedList.deleteMiddleNode(node1);
        System.out.println("The new list without the middle node is: ");
        LinkedList.printList(node1); //Outputs 2 4
    }
}


