


import java.util.*;

public class Logger {
    Scanner scan = new Scanner(System.in);
    RecordRW rw=new RecordRW();
    ArrayList<Stu> abc= new ArrayList<>();
    ArrayList<Stu> absent=new ArrayList<>();
    ArrayList<Employee>emp = rw.read();

     class Stu {
        String name1;
        String choice;
        int id;
        Boolean here;
        Boolean late ;

        public Stu(String c,String m,int id, Boolean a, Boolean b) {
            this.name1 = c;
            this.choice = m;
            this.id=id;
            this.here = a;
            this.late = b;
        }
    }

    public void callAttendance(ArrayList<String> names) {


        boolean isHere;
        boolean isLate;
int x=0;
        for (String name : names) {
            System.out.println("Is " + name + " here?");
            // may have to add another string variable to coincide with first input
            String ans = "";
            while (!ans.toLowerCase().equals("yes") && (!ans.toLowerCase().equals("no"))) {
                ans = scan.next();

                if (ans.toLowerCase().equals("yes")) {
                    isHere = true;
                    isLate = false;


                    abc.add(new Stu (name," is Here",emp.get(x).id, isHere,isLate));

                } else if (ans.toLowerCase().equals("no")) {
                    isHere = false;
                    isLate = false;
                    absent.add(new Stu(name,"is Absent",emp.get(x).id,isHere,isLate));
                    abc.add(new Stu(name," is Absent", emp.get(x).id,isHere, isLate));
                } else {
                    System.out.println("Invalid answer, enter yes or no.");
                    ans = scan.next();
                }
            }
x++;

        }

    }
    public  void latePerson(int index){
        abc.set(absent.get(index).id, new Stu(absent.get(index).name1,"is late",absent.get(index).id, true,true));
        System.out.println(absent.get(index).name1 + " is marked late");
        absent.remove(index);




    }
}


