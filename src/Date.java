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
            return true;
        }catch(IllegalArgumentException e){
            return false;
        }
    }

    @Override
    public int compareTo(Date o) {
        return 0;
    }
}
