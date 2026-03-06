/**
 * DateTime demo
 * This has two classes, the Time class defines a class with hours minutes and seconds
 * The DateTime extends Time to add on Year, Month, Day by utilising the original Time class it has hour, minute, second as well
 * the toSTring() method (overridden from Object class) is further overridden
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DateTime now = new DateTime();
        now.setTime(2026,3,4,9,25,0);
        DateTime holiday = new DateTime(2026,8, 27,12,30,0);
        DateTime notLeap = new DateTime(2029,2,28,23,59,59);
        DateTime leap = new DateTime(2028,2,28,23,59,59);
        notLeap.addSeconds(1);
        leap.addSeconds(1);
        System.out.println(notLeap); //automatically calls object's (DateTime) toString() method
        System.out.println(leap);

    }
}