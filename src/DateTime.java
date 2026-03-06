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
    public String toString()
    {
        String time = super.toString();
        String date =  String.format("%02d-%02d-%02d", this.year, this.month, this.day);
        return date+" "+time;
    }
}
