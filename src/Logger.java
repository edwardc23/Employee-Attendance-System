

import java.io.Serializable;
import java.util.*;

public class Logger {
    static Scanner scan = new Scanner(System.in);
   static HashMap<String , HashMap<String,Boolean>> ctt = new HashMap<>();


    public static void main(String[] args) {

        ArrayList<String> rollCall = new ArrayList<>();
        rollCall.add("Johnny");
        rollCall.add("Sarah");
        rollCall.add("Katie");
        /*rollCall.add("Liam");
        rollCall.add("Sammy");
        rollCall.add("Jasmine");
*/

        // callAttendance(rollCall);
        isLateAttendance(rollCall);


    }

    public static void callAttendance(ArrayList<String> names) {
        boolean isHere;
        Pair<String, Boolean> put;
        for (String name : names) {
            System.out.println("Is " + name + " here?");
            String ans = "";
            while (!ans.equals("yes") && (!ans.equals("no"))) {
                ans = scan.next();
                HashMap<String,Boolean> pair= new HashMap<>();

                if (ans.equals("yes")) {
                    isHere = true;
                    ctt.put(name, isHere);
                    System.out.println("Was Employee on Time? ");
                    isLate = false;
                    ans = scan.next();
                    if (ans.equals("Yes")) {

                    pair.put("Here",isHere);
                     ctt.put(name,pair);
                }
                else if (ans.equals("no")) {
                    isHere = false;

                    pair.put("Absent",isHere);
                    ctt.put(name,pair);

                } else {
                    System.out.println("Invalid answer, enter yes or no.");
                    ans = scan.next();

                }
            }
        }
        
        for(Map.Entry<String,HashMap<String,Boolean>> k: ctt.entrySet()){
           for(Map.Entry<String,Boolean> l:k.getValue().entrySet()){
               System.out.println(k.getKey() + " is "+ l.getKey()+".");
           }
        }
    }

    public static void isLateAttendance(ArrayList<String> names) {

        boolean isLate;

        for (String name : names) {
            System.out.println("Was " + name + " late?");
            String ans = "";
            while (!ans.equals("yes") && (!ans.equals("no"))) {
                ans = scan.next();

                if (ans.equals("yes")) {
                    isLate = true;
                    ctt.put(name, isLate);
                } else if (ans.equals("no")) {
                    isLate = false;
                    ctt.put(name, isLate);

                } else {
                    System.out.println("Invalid answer, enter yes or no.");
                    ans = scan.next();

                }
            }
        }
        for (var k : ctt.entrySet()) {
            String name = k.getKey();
            if (k.getValue()) {
                System.out.println(name + " was late.");
            } else {
                System.out.println(name + " was on time.");
            }
        }

    }

}


