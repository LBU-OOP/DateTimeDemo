public class DateTime extends Time{
    private int year, month, day;
    public DateTime(){
        super();
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
}
