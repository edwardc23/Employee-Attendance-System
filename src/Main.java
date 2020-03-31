import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    static List<Employee> employeeList = new ArrayList<>();

//    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {

        boolean keepLooping = true;
        while(keepLooping)
        {
            keepLooping = start();
        }


        System.out.println("END");
        //System.out.println("after start loop");
//        RecordRW rw = new RecordRW();
////        User ed = new User("Edward","Cochran");
////        User c = new User("Carmen")
//        rw.writeDailyRecord("test");
//        rw.writeDailyRecord("test2");
//        Scanner fL = null;
//        if(rw.fileLookup.exists()){
//         fL= new Scanner(rw.fileLookup);
//        }
//        while(fL.hasNextLine())
//        {
//            System.out.println(fL.nextLine());
//        }
//        System.out.println("Pick a number");
//        rw.readSaveFile(in.nextInt());
//        Login login = new Login();
//        login.printLoginScreen();
//        Employee em = new Employee(false,false);
//        em.getVacationTime();
//        em.setDaysRequestedOff(5);


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
        System.out.println("rolls");
    }

    static void menuRecords()
    {
        System.out.println("records");
    }

    static void createEmployee()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("\n Enter Employee Last Name: ");
        String lastName = scanner.nextLine();

        Employee emp = new Employee(firstName, lastName);
        System.out.println("Enter employee's email address");
        String email = scanner.nextLine();
        System.out.println("Enter employee's phone number");
        String phone = scanner.nextLine();

        emp.setEmail(email);
        emp.setPhone(phone);
        employeeList.add(emp);
    }

    static void modifyEmployeeInfo()
    {
        employeeList.add(new Employee("firstname1", "lastname1"));
        employeeList.add(new Employee("firstname2", "lastname2"));
        employeeList.add(new Employee("firstname3", "lastname3"));

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

    }

    static void removeEmployee()
    {
        employeeList.add(new Employee("firstname1", "lastname1"));
        employeeList.add(new Employee("firstname2", "lastname2"));
        employeeList.add(new Employee("firstname3", "lastname3"));

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
    }


}
