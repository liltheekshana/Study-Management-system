package com.mycompany.subjectlist;

public class TaskStack {
    private TaskNode top;

    public TaskStack() {
        this.top = null;
    }

    // Push Task
    public void push(String data) {
        TaskNode newNode = new TaskNode(data);
        newNode.next = top;
        top = newNode;
    }

    // Pop Task
    public String pop() {
        if (top == null) {
            return null; // Stack is empty
        }
        String data = top.data;
        top = top.next;
        return data;
    }

    // Peek Task
    public String peek() {
        if (top == null) {
            return null; // Stack is empty
        }
        return top.data;
    }

    // Display Tasks
    public void displayTasks() {
        TaskNode current = top;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // Bubble Sort Tasks
    public void sortTasks() {
        if (top == null || top.next == null) {
            return; // No need to sort
        }

        boolean swapped;
        do {
            swapped = false;
            TaskNode current = top;
            while (current.next != null) {
                if (current.data.compareTo(current.next.data) > 0) {
                    // Swap data
                    String temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    static class TaskNode {
        String data;
        TaskNode next;

        TaskNode(String data) {
            this.data = data;
            this.next = null;
        }
    }
}
