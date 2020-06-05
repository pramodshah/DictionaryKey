import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.*;

public class HelloWorld{
   
   public static float finddiff(String dateBeforeString,String dateAfterString){
	 SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
	 
    float daysBetween=0;
	 try {
	       Date dateBefore = myFormat.parse(dateBeforeString);
	       Date dateAfter = myFormat.parse(dateAfterString);
	       long difference = dateAfter.getTime() - dateBefore.getTime();
	       daysBetween = (difference / (1000*60*60*24));
               
	       System.out.println("Number of Days between dates: "+daysBetween);
	 } catch (Exception e) {
	       e.printStackTrace();
	 }
	 return daysBetween;
   }
   
  public static String getNextDate(String  curDate) {
  String nextdate="";
  try{
  final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
  final Date date = format.parse(curDate);
  final Calendar calendar = Calendar.getInstance();
  calendar.setTime(date);
  calendar.add(Calendar.DAY_OF_YEAR, 1);
  nextdate=format.format(calendar.getTime());       
     }
    catch(Exception e){}
  
  
  return nextdate;
}
   
  static HashMap<String,Integer> filldict(HashMap<String,Integer> input){
         HashMap<String,Integer> output = new HashMap<>();
        Set entrySet = input.entrySet();
        Iterator it = entrySet.iterator();
        Map.Entry me = (Map.Entry)it.next();
        String date1=(String)me.getKey();
        System.out.println(date1);
        int val1=(int)me.getValue();
        output.put(date1,val1);
        String date2="";
        int val2=0;
        while(it.hasNext()){
            Map.Entry mapElement = (Map.Entry)it.next();
            date2=(String)mapElement.getKey();
            val2=(int)mapElement.getValue();
            float diff=finddiff(date1,date2);
            if(diff==1){
                date1=date2;
                output.put(date2,val2);
                continue;
            }
            int valdiff=val2-val1;
            int avg=(int)(valdiff/diff);
            String newdate=date1;
            int nextval=val1;
            while(diff>1){
                newdate=getNextDate(newdate);
                nextval=nextval+avg;
                output.put(newdate,nextval);
                diff--;
                
            }
            date1=date2;
                output.put(date2,val2);
            
        }
        return output;
  }
   


     public static void main(String []args){
        //System.out.println("Hello World");
        //System.out.println(getNextDate("1998-01-10"));
        
        HashMap<String,Integer> input= new HashMap<>();
        input.put("1998-01-10",10);
        input.put("1998-01-12",20);
        
        
        System.out.println(filldict(input));
     }
}