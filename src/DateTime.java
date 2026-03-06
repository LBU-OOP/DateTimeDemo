public class DateTime extends Time{
    private int year, month, day;
    public DateTime(){
        super();  //not ethis isn't necessary as Java automatically calls the super() for the no parameter constructor
        year = 2026;
        month = 1;
        day = 1;
    }
    public DateTime(int year, int month, int day, int hour, int minute, int second) {
        super(hour, minute, second);
        this.year = year;
        this.month = month;
        this.day = day;

    }

    public void setTime(int year, int month, int day, int hour, int minute, int second) {
        super.setTime(hour, minute, second);
        setYear(year);
        setMonth(month);
        setDay(day);
    }
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 1 || year > 9999) return;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) return;
        this.month = month;
    }

    public int getDay() {

        return day;
    }

    public void setDay(int day) {
        //you can see we could do with more logic here
        if (day < 1 || day > 31) return;
        this.day = day;
    }

    /**
     * Overridden toSTring() calls original toSTring in parent class to print the time part , then adds the date part
     * @return String  (date) (time)
     */
    @Override //this is a tag that isn't technically necessary but it tells the compiler and another engineer that this is not a new method
    public String toString()
    {
        String time = super.toString();
        String date =  String.format("%02d-%02d-%02d", this.year, this.month, this.day);
        return date+" "+time;
    }

    // Override the parent addHours to handle day carry-over
    @Override
    public void addHours(int hoursToAdd) {
        int totalHours = getHour() + hoursToAdd;
        setHour(totalHours % 24); // Use parent setters/getters

        int dayCarry = totalHours / 24;
        if (dayCarry > 0) {
            addDays(dayCarry);
        }
    }

    public void addDays(int daysToAdd) {
        this.day += daysToAdd;
        // While the current day exceeds the max days in the current month
        while (this.day > daysInMonth(this.month, this.year)) {
            this.day -= daysInMonth(this.month, this.year);
            addMonths(1);
        }
    }

    public void addMonths(int monthsToAdd) {
        int totalMonths = (this.month - 1) + monthsToAdd; // 0-indexed for math
        this.month = (totalMonths % 12) + 1;             // Back to 1-indexed
        addYears(totalMonths / 12);
    }

    public void addYears(int yearsToAdd) {
        this.year += yearsToAdd;
    }

    // Helper to handle varying month lengths and leap years
    private int daysInMonth(int m, int y) {
        return switch (m) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> (isLeapYear(y) ? 29 : 28);
            default -> 31;
        };
    }

    private boolean isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }
}
