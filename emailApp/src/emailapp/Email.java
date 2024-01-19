package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private int defaultPasswordLength = 10;
    private String companySuffix = "company.com";

    // Constructor to receive the last and first name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
//        System.out.println("Email created " + this.firstName + " " +this.lastName);

        //Call a method asking fora the department and return the department
        this.department = setDepartment();
//        System.out.println("Department: " + this.department);

        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        //Combine elements to generate email
        email = firstName.toLowerCase() + "."+ lastName.toLowerCase() + "@" + department + "." + companySuffix;
//        System.out.println("Your full email address is: " + this.email);
    }
    // Ask for the department -method
    private String setDepartment(){;
        System.out.println("New worker: " + firstName + " The department codes: \n1 for sales \n2 for Developmet \n3 for Accounting \n0 for none \nEnter the department code:");
        Scanner in = new Scanner (System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "Dev";
        } else if (depChoice == 3) {
            return "Accounting";
        } else {
            return "";

        }
    }
    // Generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char [length];
        for (int i=0; i<length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    // Set the mailbox capacity through encapsulation
    public void setMailboxCapacity (int capacity) {
        this.mailboxCapacity = capacity;
    }
    // Set the alternate email
    public void setAlternateEmail (String altEmail){
        this.alternateEmail = altEmail;
    }
    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    // Access the encapsulated methods like this.

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }
    public String getAlternateEmail() {
        return alternateEmail;
    }
    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "DISPLAY NAME: " +firstName + " " + lastName +"\n" +
                "COMPANY NAME: " + email + "\n" +
                "MAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
