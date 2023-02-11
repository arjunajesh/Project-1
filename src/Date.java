import java.util.Calendar;
public class Date implements Comparable<Date>{
    private int year;
    private int month;
    private int day;

    public Date (){
        this.month = Calendar.getInstance().MONTH;
        this.year = Calendar.getInstance().YEAR;
        this.day = Calendar.getInstance().DAY_OF_MONTH;
    }
    public Date(String date){
        String d[] = date.split("/");
        this.month = Integer.parseInt(d[0]);
        this.day = Integer.parseInt(d[1]);
        this.year = Integer.parseInt(d[2]);
    }

    public boolean isValid(){
        try{
            Calendar c = Calendar.getInstance();
            c.setLenient(false);
            c.set(year, month - 1, day);
            c.get(Calendar.DATE);
            System.out.println("Birth date is a valid date");

            return isOver16(c);
        }catch(IllegalArgumentException e){
            return false;
        }
    }
    public boolean isOver16(Calendar dob){

        Calendar today = Calendar.getInstance();
        long diffMillis = today.getTimeInMillis() - dob.getTimeInMillis();
        long numYears = diffMillis / (365l * 24 * 60 * 60 * 1000);
        System.out.println("age is " + numYears);
        return numYears >= 16; // checks that the student is 16 or older, also makes sure the date is not in the future or today's date as per requirements of project
    }

    @Override
    public int compareTo(Date o) {
        return 0;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Date)){
            return false;
        }
        Date other = (Date) o;
        System.out.println("got to the date class");
        if(this.year == other.year && this.month == other.month && this.day == other.day){
            System.out.println("this prolly wont run");
            return true;
        }
        else{
            return false;
        }
    }
}
