package com.mycompany.subjectlist;

public class SubjectList {
    private SubjectNode head;

    public SubjectList() {
        this.head = null;
    }

    // Add Subject
    public void addSubject(String data) {
        SubjectNode newNode = new SubjectNode(data);
        if (head == null) {
            head = newNode;
        } else {
            SubjectNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Remove Subject
    public boolean removeSubject(String data) {
        if (head == null) {
            return false; // List is empty
        }

        if (head.data.equals(data)) {
            head = head.next; // Remove head
            return true;
        }

        SubjectNode current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next == null) {
            return false; // Data not found
        }

        current.next = current.next.next;
        return true;
    }

    // Display Subjects
    public void displaySubjects() {
        SubjectNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // Find Subject
    public boolean findSubject(String data) {
        SubjectNode current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Bubble Sort Subjects
    public void sortSubjects() {
        if (head == null || head.next == null) {
            return; // No need to sort
        }

        boolean swapped;
        do {
            swapped = false;
            SubjectNode current = head;
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

    static class SubjectNode {
        String data;
        SubjectNode next;

        SubjectNode(String data) {
            this.data = data;
            this.next = null;
        }
    }
}
