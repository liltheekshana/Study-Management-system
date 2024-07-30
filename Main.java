package com.mycompany.subjectlist;

import java.util.Scanner;

class SubjectNode {
    String data;
    SubjectNode next;

    SubjectNode(String data) {
        this.data = data;
        this.next = null;
    }
}

class SubjectList {
    private SubjectNode head;

    public SubjectList() {
        this.head = null;
    }

    // Add Subject (4.2)
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

    // Remove Subject (4.3)
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

    // Display Subjects (4.4)
    public void displaySubjects() {
        SubjectNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // Find Subject (4.5)
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

    static class TaskStack {
        private TaskNode top;

        public TaskStack() {
            this.top = null;
        }

        // Push Task (4.7)
        public void push(String data) {
            TaskNode newNode = new TaskNode(data);
            newNode.next = top;
            top = newNode;
        }

        // Pop Task (4.8)
        public String pop() {
            if (top == null) {
                return null; // Stack is empty
            }
            String data = top.data;
            top = top.next;
            return data;
        }

        // Peek Task (4.9)
        public String peek() {
            if (top == null) {
                return null; // Stack is empty
            }
            return top.data;
        }

        // Display Tasks (4.10)
        public void displayTasks() {
            TaskNode current = top;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            TaskStack stack = new TaskStack();
            int choice;
            do {
                System.out.println("1. Create Task");
                System.out.println("2. Push Task");
                System.out.println("3. Pop Task");
                System.out.println("4. Peek Task");
                System.out.println("5. Display Tasks");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Consume the invalid input
                }
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter the task to create: ");
                        String newTask = scanner.nextLine();
                        stack.push(newTask);
                        System.out.println("Task created and added to stack.");
                        break;
                    case 2:
                        System.out.print("Enter the task to push: ");
                        String pushTask = scanner.nextLine();
                        stack.push(pushTask);
                        System.out.println("Task pushed to stack.");
                        break;
                    case 3:
                        String poppedTask = stack.pop();
                        if (poppedTask == null) {
                            System.out.println("Stack is empty.");
                        } else {
                            System.out.println("Popped task: " + poppedTask);
                        }
                        break;
                    case 4:
                        String peekedTask = stack.peek();
                        if (peekedTask == null) {
                            System.out.println("Stack is empty.");
                        } else {
                            System.out.println("Top task: " + peekedTask);
                        }
                        break;
                    case 5:
                        System.out.println("All tasks in the stack:");
                        stack.displayTasks();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 6);

            scanner.close();
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
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SubjectList subjectList = new SubjectList();
        SubjectList.TaskStack taskStack = new SubjectList.TaskStack();

        int choice;
        do {
            System.out.println("Main Menu:");
            System.out.println("1. Subject List Menu");
            System.out.println("2. Task Stack Menu");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    subjectMenu(scanner, subjectList);
                    break;
                case 2:
                    taskMenu(scanner, taskStack);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }

    public static void subjectMenu(Scanner scanner, SubjectList list) {
        int choice;
        do {
            System.out.println("Subject List Menu:");
            System.out.println("1. Add Subject");
            System.out.println("2. Remove Subject");
            System.out.println("3. Display Subjects");
            System.out.println("4. Find Subject");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter subject to add: ");
                    String newSubject = scanner.nextLine();
                    list.addSubject(newSubject);
                    System.out.println("Subject added.");
                    break;
                case 2:
                    System.out.print("Enter subject to remove: ");
                    String removeSubject = scanner.nextLine();
                    boolean removed = list.removeSubject(removeSubject);
                    if (removed) {
                        System.out.println("Subject removed.");
                    } else {
                        System.out.println("Subject not found.");
                    }
                    break;
                case 3:
                    System.out.println("All subjects:");
                    list.displaySubjects();
                    break;
                case 4:
                    System.out.print("Enter subject to find: ");
                    String findSubject = scanner.nextLine();
                    boolean found = list.findSubject(findSubject);
                    if (found) {
                        System.out.println("Subject found.");
                    } else {
                        System.out.println("Subject not found.");
                    }
                    break;
                case 5:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    public static void taskMenu(Scanner scanner, SubjectList.TaskStack stack) {
        int choice;
        do {
            System.out.println("Task Stack Menu:");
            System.out.println("1. Push Task");
            System.out.println("2. Pop Task");
            System.out.println("3. Peek Task");
            System.out.println("4. Display Tasks");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task to push: ");
                    String pushTask = scanner.nextLine();
                    stack.push(pushTask);
                    System.out.println("Task pushed to stack.");
                    break;
                case 2:
                    String poppedTask = stack.pop();
                    if (poppedTask == null) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Popped task: " + poppedTask);
                    }
                    break;
                case 3:
                    String peekedTask = stack.peek();
                    if (peekedTask == null) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Top task: " + peekedTask);
                    }
                    break;
                case 4:
                    System.out.println("All tasks in the stack:");
                    stack.displayTasks();
                    break;
                case 5:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}
