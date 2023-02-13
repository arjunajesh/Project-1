import java.util.Calendar;
public class Date implements Comparable<Date>{
    private int year;
    private int month;
    private int day;

    public static void main(String[] args){
        final String PASSED = "PASSED";
        final String FAILED = "FAILED";

        Date d = new Date("2/29/2003"); // testing leap year
        System.out.println("Testing isValid: " + d.toString());
        System.out.println(d.isValid() == false ? PASSED:FAILED);

        d = new Date("4/31/2003"); // invalid day on month
        System.out.println("Testing isValid: " + d.toString());
        System.out.println(d.isValid() == false ? PASSED:FAILED);

        d = new Date("13/31/2003"); // invalid month
        System.out.println("Testing isValid: " + d.toString());
        System.out.println(d.isValid() == false ? PASSED:FAILED);

        d = new Date("-1/31/2003"); // invalid month (negative)
        System.out.println("Testing isValid: " + d.toString());
        System.out.println(d.isValid() == false ? PASSED:FAILED);

        d = new Date("3/32/2003"); // invalid day of month
        System.out.println("Testing isValid: " + d.toString());
        System.out.println(d.isValid() == false ? PASSED:FAILED);

        d = new Date("3/31/2003"); // valid date
        System.out.println("Testing isValid: " + d.toString());
        System.out.println(d.isValid() == true ? PASSED:FAILED);

        d = new Date("2/29/2004"); // valid leap year date
        System.out.println("Testing isValid: " + d.toString());
        System.out.println(d.isValid() == true ? PASSED:FAILED);
    }
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

            return isOver16(c);
        }catch(IllegalArgumentException e){
            System.out.println("DOB invalid: " + this.toString() + " not a valid calendar date!");
            return false;
        }
    }
    public boolean isOver16(Calendar dob){

        Calendar today = Calendar.getInstance();
        long diffMillis = today.getTimeInMillis() - dob.getTimeInMillis();
        long numYears = diffMillis / (365l * 24 * 60 * 60 * 1000);
        if(numYears >= 16){
            return true;
        }
        else{
            System.out.println("DOB invalid: " + this.toString() + " younger than 16 years old.");
            return false;
        }
         // checks that the student is 16 or older, also makes sure the date is not in the future or today's date as per requirements of project
    }

    @Override
    public int compareTo(Date o) {
        long diff = getMilliSeconds() - o.getMilliSeconds();
        if (diff > 0){
            return 1;
        }
        else if (diff < 0){
            return -1;
        }
        else{
            return 0;
        }

    }
    public long getMilliSeconds(){
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, day, 0, 0, 0);
        return c.getTimeInMillis();
    }


    @Override
    public boolean equals(Object o){
        if(!(o instanceof Date)){
            return false;
        }
        Date other = (Date) o;
        if(this.year == other.year && this.month == other.month && this.day == other.day){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public String toString(){
        return Integer.toString(month) + "/" + Integer.toString(day) + "/" + Integer.toString(year);
    }
}
