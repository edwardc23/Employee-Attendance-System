import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.io.IOException;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    static RecordRW rw=new RecordRW();
    static Logger l = new Logger();
    static List<Employee> employeeList = rw.read();
   static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {


        boolean keepLooping = true;



        while(keepLooping){
            keepLooping = start();
        }
            System.out.println("END");
    }


    static boolean start()
    {

        System.out.println("Select a number corresponding to the options below");
        System.out.println("1. Employee\n" +
                "2. Rolls\n" +
                "3. Records\n" +
                "4. Exit Program\n");

        int input = 0;

        do {
            try
            {
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextInt();
                if(input < 1 || input > 4)
                {
                    System.out.println("please enter a valid number");
                }
            }catch(InputMismatchException e)
            {
                System.out.println("please enter a valid integer");
            }
        }while(input < 1 || input > 4);

        return menu(input);
    }

    static boolean menu(int i)
    {
        switch (i){
            case 1:
                menuEmployee();
                break;
            case 2:
                menuRolls();
                break;
            case 3:
                menuRecords();
                break;
            default:
                return false;
        }
        return true;
    }

    static void menuEmployee()
    {
        System.out.println(
                "1. Add New Employee\n" +
                "2. Modify Existing Employee\n" +
                "3. Remove Employee\n");

        int input = 0;

        do {
            try
            {
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextInt();
                if(input < 1 || input > 3)
                {
                    System.out.println("please enter a valid number");
                }
            }catch(InputMismatchException e)
            {
                System.out.println("please enter a valid integer");
            }
        }while(input < 1 || input > 3);

        switch(input)
        {
            case 1:
                createEmployee();
                break;
            case 2:
                modifyEmployeeInfo();
                break;
            case 3:
                removeEmployee();
                break;
        }
    }

    static void menuRolls()
    {
        System.out.println(
                        "1. Employee Attendance\n" +
                        "2. Late Roll\n");

        int input = 0;

        do {
            try
            {
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextInt();
                if(input < 1 || input > 2)
                {
                    System.out.println("please enter a valid number");
                }
            }catch(InputMismatchException e)
            {
                System.out.println("please enter a valid integer");
            }
        }while(input < 1 || input > 2);

        switch(input)
        {
            case 1:
                callRoll();
                break;
            case 2:
                lateAttendee();
                break;

        }

    }

    static void menuRecords()
    {
        System.out.println(
                "1. Create Daily Report");

        int input = 0;

        do {
            try
            {
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextInt();
                if(input < 1 || input > 1)
                {
                    System.out.println("please enter a valid number");
                }
            }catch(InputMismatchException e)
            {
                System.out.println("please enter a valid integer");
            }
        }while(input < 1 || input > 1);

        switch(input)
        {
            case 1:
                writeDailyReport();
                break;
        }
    }

    static void createEmployee()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("\nEnter Employee Last Name: ");
        String lastName = scanner.nextLine();

        Employee emp = new Employee(firstName, lastName);
        System.out.println("Enter employee's email address");
        String email = scanner.nextLine();
        System.out.println("Enter employee's phone number");
        String phone = scanner.nextLine();

        emp.setEmail(email);
        emp.setPhone(phone);
        employeeList.add(emp);
        try {
            rw.write("Employees",employeeList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void modifyEmployeeInfo()
    {
        System.out.println("Select the number corresponding to the employee you wish to modify");
        int index = 0;
        for(var i : employeeList)
        {
            System.out.println(++index + ". " + i.getLastName() + " " + i.getFirstName());

        }

        int input = 0;

        do {
            try
            {
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextInt();
                if(input < 1 || input > employeeList.size() +1)
                {
                    System.out.println("please enter a valid number");
                }
            }catch(InputMismatchException e)
            {
                System.out.println("please enter a valid integer");
            }
        }while(input < 1 || input > employeeList.size() +1);

        System.out.println("What information do you wish to change for " + employeeList.get(input-1).getFirstName() + " " + employeeList.get(input-1).getLastName());

        System.out.println(
                "1. First Name\n" +
                "2. Last Name\n" +
                "3. Email Address\n" +
                "4. Phone Number\n"
        );

        int input2 = 0;

        do {
            try
            {
                Scanner scanner = new Scanner(System.in);
                input2 = scanner.nextInt();
                if(input2 < 1 || input2 > 4)
                {
                    System.out.println("please enter a valid number");
                }
            }catch(InputMismatchException e)
            {
                System.out.println("please enter a valid integer");
            }
        }while(input2 < 1 || input2 > 4);

        Scanner scanner = new Scanner(System.in);

        switch(input2){
            case 1:
                System.out.println("input correct first name");
                employeeList.get(input-1).setFirstName(scanner.nextLine());
                System.out.println("changes completed");
                break;
            case 2:
                System.out.println("input correct last name");
                employeeList.get(input-1).setLastName(scanner.nextLine());
                System.out.println("changes completed");
                break;
            case 3:
                System.out.println("input correct email address");
                employeeList.get(input-1).setEmail(scanner.nextLine());
                System.out.println("changes completed");
                break;
            case 4:
                System.out.println("input correct phone number");
                employeeList.get(input-1).setPhone(scanner.nextLine());
                System.out.println("changes completed");
                break;

        }

        System.out.println(employeeList.get(input-1).getFirstName());
        System.out.println(employeeList.get(input-1).getLastName());
        System.out.println(employeeList.get(input-1).getEmail());
        System.out.println(employeeList.get(input-1).getPhone());
        rw.update(employeeList);
    }

    static void removeEmployee()
    {


        System.out.println("Select the number corresponding to the employee you wish to remove");
        int index = 0;
        for(var i : employeeList)
        {
            System.out.println(++index + ". " + i.getLastName() + " " + i.getFirstName());

        }

        int input = 0;

        do {
            try
            {
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextInt();
                if(input < 1 || input > employeeList.size() +1)
                {
                    System.out.println("please enter a valid number");
                }
            }catch(InputMismatchException e)
            {
                System.out.println("please enter a valid integer");
            }
        }while(input < 1 || input > employeeList.size() +1);

        employeeList.remove(input-1);
        System.out.println("employee been removed");

        for(var i : employeeList)
        {
            System.out.println(i.getFirstName());
        }
        rw.update(employeeList);
    }

    static  void callRoll()
    {
        ArrayList<String> roll= new ArrayList<>();
        for(Employee e: employeeList)
        {
            roll.add(e.firstName);
        }

        l.callAttendance(roll);


    }
    static void lateAttendee()
    {
        for(int x=0;x<employeeList.size();x++)
        {
            System.out.println((x+1)+". "+employeeList.get(x).firstName);
        }
        int index=-1;
        do
        {System.out.println("Choose index number of the student.");
             index=in.nextInt()-1;

        }while(!l.abc.get(index).here==false&&index!=-1);
        l.latePerson(index);


    }

    static void writeDailyReport()
    {
        System.out.println("askdjaksldj");
    }

}
