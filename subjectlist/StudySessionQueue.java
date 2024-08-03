package com.mycompany.subjectlist;

public class StudySessionQueue {
    private StudySessionNode head; // Points to the first session (head of the queue)
    private StudySessionNode tail; // Points to the last session (tail of the queue)

    public StudySessionQueue() {
        this.head = null;
        this.tail = null;
    }

    // Enqueue: Add a new session at the end of the queue
    public void enqueue(String topic) {
        StudySessionNode newNode = new StudySessionNode(topic);
        if (tail == null) { // If the queue is empty
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Dequeue: Remove the session from the front of the queue
    public String dequeue() {
        if (head == null) {
            return "The queue is empty, no session to dequeue.";
        }
        String removedTopic = head.topic;
        head = head.next;
        if (head == null) { // If the queue becomes empty
            tail = null;
        }
        return "Dequeued: " + removedTopic;
    }

    // Peek: Get the topic of the session at the front of the queue without removing it
    public String peek() {
        if (head == null) {
            return "The queue is empty, no session to peek.";
        }
        return "Next session: " + head.topic;
    }

    // Display: Print all sessions in the queue
    public void display() {
        if (head == null) {
            System.out.println("The queue is empty.");
            return;
        }
        StudySessionNode current = head;
        while (current != null) {
            System.out.println(current.topic);
            current = current.next;
        }
    }

    // Bubble Sort Sessions
    public void sortSessions() {
        if (head == null || head.next == null) {
            return; // No need to sort
        }

        boolean swapped;
        do {
            swapped = false;
            StudySessionNode current = head;
            while (current.next != null) {
                if (compareDates(current.topic, current.next.topic) > 0) {
                    // Swap topics
                    String temp = current.topic;
                    current.topic = current.next.topic;
                    current.next.topic = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    private int compareDates(String date1, String date2) {
        // Assuming date format is "YYYY-MM-DD"
        return date1.compareTo(date2);
    }

    static class StudySessionNode {
        String topic;
        StudySessionNode next;

        public StudySessionNode(String topic) {
            this.topic = topic;
            this.next = null;
        }
    }
}
