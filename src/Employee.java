public class Employee {

    int vacationTime;
    int daysRequestedOff;
    boolean isHoliday;
    boolean isHere;

    public Employee(boolean isHere, boolean isHoliday) {
        this.vacationTime = 20;
        this.isHoliday = isHoliday;
        this.isHere = isHere;
        this.daysRequestedOff = daysRequestedOff;
    }

    public void setDaysRequestedOff(int daysRequestedOff) {
        this.daysRequestedOff = daysRequestedOff;
        int daysRequestedOff2 = vacationTime - daysRequestedOff;
        System.out.println("Employee has requested off " + daysRequestedOff + " days. Employee has" +daysRequestedOff2+ " Vacation Days Left.");
    }

    public void  getVacationTime() {
        if(!(isHere) && (!isHoliday)){
            vacationTime = vacationTime -1;
            System.out.println("Employee has " + vacationTime + " Vacation days left. He/She is absent and today is not considered a Holiday.");
        } else {
                System.out.println("Employee has " + vacationTime + " Vacation days");

        }
    }


    public static void main(String[] args) {
        Employee em = new Employee(false,false);
        em.getVacationTime();
        em.setDaysRequestedOff(5);
    }
}
