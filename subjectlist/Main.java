package com.mycompany.subjectlist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SubjectList subjectList = new SubjectList();
        TaskStack taskStack = new TaskStack();
        StudySessionQueue studySessionQueue = new StudySessionQueue();

        int choice;
        do {
            System.out.println("Main Menu:");
            System.out.println("1. Subject List Menu");
            System.out.println("2. Task Stack Menu");
            System.out.println("3. Study Session Queue Menu");
            System.out.println("4. Exit");
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
                    studySessionMenu(scanner, studySessionQueue);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

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
            System.out.println("5. Sort Subjects");
            System.out.println("6. Back to Main Menu");
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
                    list.sortSubjects();
                    System.out.println("Subjects sorted.");
                    break;
                case 6:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    public static void taskMenu(Scanner scanner, TaskStack stack) {
        int choice;
        do {
            System.out.println("Task Stack Menu:");
            System.out.println("1. Push Task");
            System.out.println("2. Pop Task");
            System.out.println("3. Peek Task");
            System.out.println("4. Display Tasks");
            System.out.println("5. Sort Tasks");
            System.out.println("6. Back to Main Menu");
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
                    stack.sortTasks();
                    System.out.println("Tasks sorted.");
                    break;
                case 6:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    public static void studySessionMenu(Scanner scanner, StudySessionQueue queue) {
        int choice;
        do {
            System.out.println("Study Session Queue Menu:");
            System.out.println("1. Add Study Session");
            System.out.println("2. Delete Study Session");
            System.out.println("3. Next Study Session");
            System.out.println("4. Display Study Sessions");
            System.out.println("5. Sort Sessions");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter the topic of the study session:");
                    String topic = scanner.nextLine().trim();
                    queue.enqueue(topic);
                    System.out.println("Added: " + topic);
                    break;
                case 2:
                    System.out.println(queue.dequeue());
                    break;
                case 3:
                    System.out.println(queue.peek());
                    break;
                case 4:
                    System.out.println("All study sessions in the queue:");
                    queue.display();
                    break;
                case 5:
                    queue.sortSessions();
                    System.out.println("Sessions sorted.");
                    break;
                case 6:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }
}
