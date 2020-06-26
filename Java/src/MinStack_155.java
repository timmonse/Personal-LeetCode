class MinStack_155 {
    StackNode head;


    class StackNode {
        StackNode next;
        int val;
        int min;

        StackNode () {
        }

        StackNode (int val, StackNode next, int min) {
            this.val = val;
            this.next = next;
            this.min = min;
        }
    }

    /** initialize your data structure here. */
    public MinStack_155() {
        head = new StackNode();
    }

    public void push(int x) {
        StackNode newNode;
        // If x is first item in stack or new min, x its own min
        if (x < head.min || head.next == null) {
            newNode = new StackNode(x, head, x);
        } else {
            newNode = new StackNode(x, head, head.min);
        }
        head = newNode;
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
