public class CustomLinkedList {

   
    static class SinglyNode {
        int data;
        SinglyNode next;

        SinglyNode(int data) {
            this.data = data;
        }
    }

    static class SinglyLinkedList {
        SinglyNode head;

        void insert(int data) {
            SinglyNode newNode = new SinglyNode(data);

            if (head == null) {
                head = newNode;
                return;
            }

            SinglyNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        void display() {
            SinglyNode temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }

        void delete(int value) {
            if (head == null) return;

            if (head.data == value) {
                head = head.next;
                return;
            }

            SinglyNode temp = head;
            while (temp.next != null && temp.next.data != value) {
                temp = temp.next;
            }

            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }
    }

    
    static class DoublyNode {
        int data;
        DoublyNode prev, next;

        DoublyNode(int data) {
            this.data = data;
        }
    }

    static class DoublyLinkedList {
        DoublyNode head;

        void insert(int data) {
            DoublyNode newNode = new DoublyNode(data);

            if (head == null) {
                head = newNode;
                return;
            }

            DoublyNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.prev = temp;
        }

        void display() {
            DoublyNode temp = head;
            while (temp != null) {
                System.out.print(temp.data + " <-> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    
    static class CircularNode {
        int data;
        CircularNode next;

        CircularNode(int data) {
            this.data = data;
        }
    }

    static class CircularLinkedList {
        CircularNode head;

        void insert(int data) {
            CircularNode newNode = new CircularNode(data);

            if (head == null) {
                head = newNode;
                head.next = head;
                return;
            }

            CircularNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.next = head;
        }

        void display() {
            if (head == null) return;

            CircularNode temp = head;
            do {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            } while (temp != head);

            System.out.println("(back to head)");
        }
    }

  
    public static void main(String[] args) {


        System.out.println("Singly Linked List:");
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insert(10);
        sll.insert(20);
        sll.insert(30);
        sll.display();
        sll.delete(20);
        sll.display();


        System.out.println("\nDoubly Linked List:");
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insert(100);
        dll.insert(200);
        dll.insert(300);
        dll.display();

  
        System.out.println("\nCircular Linked List:");
        CircularLinkedList cll = new CircularLinkedList();
        cll.insert(1);
        cll.insert(2);
        cll.insert(3);
        cll.display();
    }
}