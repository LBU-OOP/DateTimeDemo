/**
 * Time Class define a Time of hour, minute, seconds
 * note I have put extends Object because if you don't have an extends this is what it is doing
 * IntelliJ will give a yellow code sniff on it, saying it isn't necessary
 * I've put it to show you what is happening (and it's when toString() comes from
 */
public class Time extends Object
{
    private int hour, minute, second;

    public Time()
    {
        hour = 12;
        minute = 0;
        second = 0;
    }
    public Time(int hour, int minute, int second)
    {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void setTime(int hour, int minute, int second)
    {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }
    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hour < 0 || hour > 23) return;
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute > 59) return;
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        if (second < 0 || second > 59) return ;
        this.second = second;
    }

    public void addSeconds(int secondsToAdd) {
        // 1. Calculate the new raw total
        int totalSeconds = this.second + secondsToAdd;

        // 2. Set current seconds to the remainder (0-59)
        this.second = totalSeconds % 60;

        // 3. Calculate how many whole minutes are in the total
        int minuteCarry = totalSeconds / 60;

        // 4. If there's a carry, add it to minutes
        if (minuteCarry > 0) {
            addMinutes(minuteCarry);
        }
    }

    public void addMinutes(int minutesToAdd) {
        int totalMinutes = this.minute + minutesToAdd;

        this.minute = totalMinutes % 60;

        int hourCarry = totalMinutes / 60;

        if (hourCarry > 0) {
            addHours(hourCarry);
        }
    }

    public void addHours(int hoursToAdd) {
        // Hours wrap around 24 (Military/Universal time)
        this.hour = (this.hour + hoursToAdd) % 24;
    }
    @Override //this is a tag that isn't technically necessary but it tells the compiler and another engineer that this is not a new method, in this case it is overriding the method in the class Object
    public String toString()
    {
        return String.format("%02d:%02d:%02d", this.hour, this.minute, this.second);
    }
}
