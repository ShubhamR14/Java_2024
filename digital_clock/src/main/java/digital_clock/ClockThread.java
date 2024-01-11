package digital_clock;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockThread extends Thread {
	
	DigitalClock dc;
	
	//1.create constructor of the class
	public ClockThread(DigitalClock dc) {
		this.dc=dc;
		start();
	}
	
	public void run() {
		//We have to run infinite loop
		while(true) {	
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
//			2.store in string value
			String formateDate = sdf.format(date);
			
			String[] dateArr = formateDate.split(":");
			dc.textField.setText(dateArr[0]);
			dc.textField_1.setText(dateArr[1]);
			dc.textField_2.setText(dateArr[2]);

			
		}
	}
	
}
