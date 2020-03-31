

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

        callAttendance(rollCall);


    }

    public static void callAttendance(ArrayList<String> names) {
        boolean isHere;

        for (String name : names) {
            System.out.println("Is " + name + " here?");
            String ans = "";
            while (!ans.equals("yes") && (!ans.equals("no"))) {
                ans = scan.next();
                HashMap<String,Boolean> pair= new HashMap<>();

                if (ans.equals("yes")) {
                    isHere = true;

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

//

    }

    public static void callAttendance(boolean isLate) {

    }

}


