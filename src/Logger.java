


import java.util.*;

public class Logger {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Stu> abc= new ArrayList<>();
    public static void main(String[] args) {
        ArrayList<String> rollCall = new ArrayList<>();
        rollCall.add("Johnny");
        rollCall.add("Sarah");
        rollCall.add("Katie");

       callAttendance(rollCall);
        latePerson(0);

    }

    static class Stu {   //
        String name1;
        String choice;
        Boolean here;
        Boolean late ;


        public Stu(String c,String m, Boolean a, Boolean b) {
            this.name1 = c;
            this.choice = m;
            this.here = a;
            this.late = b;
        }
    }

    public static void callAttendance(ArrayList<String> names) {

        boolean isHere;
        boolean isLate = false;

        for (String name : names) {
            System.out.println("Is " + name + " here?");
            // may have to add another string variable to coincide with first input
            String ans = "";
            while (!ans.equals("yes") && (!ans.equals("no"))) {
                ans = scan.next();

                if (ans.equals("yes")) {
                    isHere = true;
                    isLate = false;


                    abc.add(new Stu (name," is Here", isHere,isLate));

                } else if (ans.equals("no")) {
                    isHere = false;
                    isLate = false;

                    abc.add(new Stu(name," is Absent", isHere, isLate));
                } else {
                    System.out.println("Invalid answer, enter yes or no.");
                    ans = scan.next();
                }
            }

        }

        for(Stu s : abc){

            System.out.println(s.name1 + " " + s.choice + ". ");
        }

    }
    public static void latePerson(int index){
        abc.set(index,new Stu(abc.get(index).name1,"late", true,true));
        System.out.println(abc.get(index).name1 + " is marked late");

    }
}


