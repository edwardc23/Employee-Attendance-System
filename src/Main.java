import org.w3c.dom.ls.LSOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    static List<Employee> employeeList = new ArrayList<>();
        start();
//    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {
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

    static void start()
    {
        System.out.println("Select a number corresponding to the options below");
        System.out.println("1. Employee\n" +
                "2. Rolls\n" +
                "3. Records");

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

        menu(input);
    }

    static void menu(int i)
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
        }
    }

    static void menuEmployee()
    {
        System.out.println(
                "1. Add New Employee\n" +
                "2. Modify Existing Employee\n");

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
                createEmployee();
            case 2:
                modifyEmployeeInfo();
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
    static void modifyEmployeeInfo(){};
}
