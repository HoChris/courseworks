package MoneyTime;


public class Time implements Calculable<Time>,Comparable<Time>{
    private int hours;
    private int minutes;
    private int seconds;
    private int totalTime;
    private boolean militaryTime;

    public Time() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
        this.totalTime = 0;
        this.militaryTime = false;
    }
    public Time(int inHrs, int inMins, int inSecs) {
        this.hours = inHrs;
        this.minutes = inMins;
        this.seconds = inSecs;

        if (inHrs >=13 && inHrs<24){
            setMilitaryTime(true);
            int totHrsMins = (inHrs-12)*60;
            int totMinsSecs = (totHrsMins + inMins) * 60;
            this.totalTime = totMinsSecs + inSecs;

        }
         else {
            int totHrsMins = inHrs * 60;
            int totMinsSecs = (totHrsMins + inMins) * 60;
            this.totalTime= totMinsSecs + inSecs;
        }
    }

    //copy constructor
    public Time(Time old) {
        this.hours = old.hours;
        this.minutes = old.minutes;
        this.seconds = old.seconds;
        this.totalTime = old.totalTime;
    }


    @Override
    public Time add(Time o) {
        Time addTime = new Time();
        int i = getTotalTime() + o.getTotalTime();
        addTime.setTotalTime(i);
        addTime.convertTime();
        return  addTime;
    }

    @Override
    public Time subtract(Time o) {
        Time subTime = new Time();

            int i= getTotalTime() - o.getTotalTime();
            subTime.setTotalTime(i);
            subTime.convertTime();
            return subTime;

    }

    @Override
    public int compareTo(Time o) {
        if (getTotalTime() > o.getTotalTime())
            return 1;
        else if(getTotalTime() < o.getTotalTime())
            return -1;
        else
        return 0;
    }
    //re-write method to format HH:MM:SS
    public String toMilitary() {
        return String.format("%02d:%02d:%02d", hours,minutes,seconds) ;
    }
    @Override
    public String toString() {
        if (isMilitaryTime() == true){return toMilitary();}
        else
        return String.format("%d:%02d:%02d %s",
                (hours==0||hours==12 ? 12:hours%12), minutes, seconds,(hours < 12 ? "Am":"Pm"));
    }
//    method that changes total seconds back to hrs, mins, secs
    public void convertTime(){

        if (isMilitaryTime()==true){
            int backHrs = this.totalTime/3600;
            int backMin = (this.totalTime-(backHrs*3600))/60;
            int backSec = this.totalTime%60;
            setHours(backHrs+12);
            setMinutes(backMin);
            setSeconds(backSec);
;
        }
        else{
            int backHrs = this.totalTime/3600;
            int backMin = (this.totalTime-(backHrs * 3600))/60;
            int backSec = this.totalTime%60;
            setHours(backHrs);
            setMinutes(backMin);
            setSeconds(backSec);
        }
    }
    //method that applies restrictions to hours minutes and seconds to 59

    public boolean isMilitaryTime() {
        return militaryTime;
    }
    public void setMilitaryTime(boolean militaryTime) {
        this.militaryTime = militaryTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }
    public int getTotalTime() {
        return totalTime;
    }

    public int getHours() {
        return hours;
    }
    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}//end time
