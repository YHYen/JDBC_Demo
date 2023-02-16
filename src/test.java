import java.text.SimpleDateFormat;
import java.util.Calendar;

public class test {
	public static void main(String[] args) {
//		String studentID = "410234567";
//		System.out.println("s" + studentID.substring(1, studentID.length()-1) + "@pu.edu.tw");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String date = dateFormat.format(Calendar.getInstance().getTime());
		System.out.println(date);
	}
}
