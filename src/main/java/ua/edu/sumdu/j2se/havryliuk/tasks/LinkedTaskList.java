package ua.edu.sumdu.j2se.havryliuk.tasks;




public class LinkedTaskList {

    private Node head;
    private int size;


    private class Node {
        Task element;
        Node next;

        public Node(Task element, Node next) {
            this.element = element;
            this.next = next;
        }


    }


    private boolean isEmpty() {
        return head == null;
    }


    public void add(Task task) {
        if (task == null) {
            throw new NullPointerException("Task is empty");
        }

        Node newNode = new Node(task, null);
        if (!isEmpty()) {
            newNode.next = head;
        }
        head = newNode;
        size++;


    }


    public boolean remove(Task task) {

        if (task != null) {
            Node currentNode = head;
            Node previousNode = null;
            int helpSize = 0;

            while (currentNode != null && currentNode.element != task) {
                previousNode = currentNode;
                currentNode = currentNode.next;
                helpSize++;
                if (helpSize > size) {
                    return false;
                }
            }
            if (currentNode != null) {
                if (null == previousNode) {
                    head = head.next;
                } else {
                    previousNode.next = currentNode.next;
                }
                size--;
                return true;
            }
        }
        return false;
    }


    public int size() {
        return size;
    }

    public Task getTask(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Your index too much or too small. Check your index. ");
        }
        Node count = head;
        for (int i = 0; i < index; i++) {
            count = count.next;
        }
        return count.element;
    }


    public LinkedTaskList incoming(int from, int to) {

        LinkedTaskList inCom = new LinkedTaskList();
        Node currentNode = head;
        int helpSize = 0;

        while (size < helpSize) {
            currentNode = currentNode.next;
            helpSize++;
        }

        if ((currentNode.element.nextTimeAfter(from) < to
                && currentNode.element.nextTimeAfter(from) >= from)) {
            if (!isEmpty()) {
                inCom.head = currentNode;
            } else {
                head = currentNode;
            }
        } return inCom;
    }
}