/**
 * Detects if a given linked list contains a cycle
 * through the Tortoise and Hare (Floyd's cycle-finding) algorithm.
 * Created on 30/01/2017
 */
class LinkedList {
    LinkedList next;
    int val;

    LinkedList(int v) {
        val = v;
        next = null;
    }
    static boolean detectCycle(LinkedList head) {
        if (head == null) // for an empty list
            return false;
        if (head.next == null) // for a list with a single node
            return false;
        LinkedList tortoise = head;
        LinkedList rabbit = head.next;

        while (rabbit != null && rabbit.next != null) { // for respectively odd and even number of nodes in the list
            if (rabbit.next == tortoise)
                return true;
            tortoise = tortoise.next;
            rabbit = rabbit.next.next;
        }
        return false;
    }
    static void addLast(LinkedList head, LinkedList newList) {
        LinkedList temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newList;
    }
    static LinkedList addFirst(LinkedList head, LinkedList node) {
        node.next = head;
        return node;
    }
}
public class DetectCycle {
    public static void main(String args[]) {
        LinkedList head = new LinkedList(1);
        LinkedList node1 = new LinkedList(4);
        LinkedList node2 = new LinkedList(5);
        LinkedList.addLast(head, node1);
        LinkedList.addLast(head, node2);
        LinkedList.addLast(node2, head);

        System.out.println(LinkedList.detectCycle(head));
    }
}

