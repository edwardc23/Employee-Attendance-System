public class Main {
    public static void main(String[] args) {
        Login login = new Login();
        login.printLoginScreen();
        Employee em = new Employee(false,false);
        em.getVacationTime();
        em.setDaysRequestedOff(5);
    }
}
