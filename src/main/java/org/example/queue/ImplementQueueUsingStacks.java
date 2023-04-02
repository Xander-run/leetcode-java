package org.example.queue;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    public class MyQueue {

        private Stack<Integer> stackStack;

        private Stack<Integer> queueStack;

        public MyQueue() {
            stackStack = new Stack<>();
            queueStack = new Stack<>();
        }

        public void push(int x) {
            stackStack.push(x);
        }

        public int pop() {
            if (queueStack.isEmpty()) {
                while(!stackStack.isEmpty()) {
                    queueStack.push(stackStack.pop());
                }
            }
            return queueStack.pop();
        }

        public int peek() {
            if (!queueStack.isEmpty()) {
                return queueStack.peek();
            } else {
                int ret = pop();
                queueStack.push(ret);
                return ret;
            }
        }

        public boolean empty() {
            return queueStack.isEmpty() && stackStack.isEmpty();
        }
    }
}
