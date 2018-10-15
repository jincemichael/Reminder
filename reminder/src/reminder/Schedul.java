/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reminder;
//
//import org.quartz.CronScheduleBuilder;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

//import org.quartz.Job;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.quartz.Scheduler;
//import org.quartz.SchedulerException;
//
//import org.quartz.Trigger;
//import org.quartz.TriggerBuilder;
//import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author jince michael
 */
 public class Schedul {

    public Schedul() {
    }

    public Schedul(Calendar c) {
        this.c = c;
    }
    
    private Calendar c;
     private Timer timer = new Timer();
public void start(){
   
    TimerTask tt = new TimerTask(){
			public void run(){
				Calendar cal = Calendar.getInstance();
                                int hourNow=cal.get(Calendar.HOUR_OF_DAY);
                                int minNow=cal.get(Calendar.MINUTE);
                                int finHour=c.get(Calendar.HOUR_OF_DAY);
                                int finMin=c.get(Calendar.MINUTE);
				if(hourNow == finHour && minNow==finMin){
					System.out.println("Rememeber Remember");
                                        
				}
			}
    };
    timer.schedule(tt, 25, 1000);
}
public void stop(){
timer.cancel();
timer.purge();
}
} 
