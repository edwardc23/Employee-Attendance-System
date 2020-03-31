import javafx.util.Pair;

import java.io.Serializable;
import java.util.*;

public class Logger {
    static Scanner scan = new Scanner(System.in);
   static HashMap<String , Pair<String, Boolean>> ctt = new HashMap<>();


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
        Pair<String, Boolean> put;
        for (String name : names) {
            System.out.println("Is " + name + " here?");
            String ans = "";
            while (!ans.equals("yes") && (!ans.equals("no"))) {
                ans = scan.next();


                if (ans.equals("yes")) {
                    isHere = true;

                     ctt.put(name, Pair. < "Here", isHere >);
                } else if (ans.equals("no")) {
                    isHere = false;
                    ctt.put(name,isHere);

                } else {
                    System.out.println("Invalid answer, enter yes or no.");
                        ans = scan.next();

                }
            }
        }
        
        for(var k: ctt.entrySet()){
            String name = k.getKey();
            if(k.getValue()){
                System.out.println(name + " is here.");
            }else{
                System.out.println(name + " is not here.");
            }
        }

//

    }

    public static void callAttendance(boolean isLate) {

    }

}


