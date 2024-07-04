package br.com.danilooa.ocpjadee7.timerservice;

import jakarta.ejb.Schedule;
import jakarta.ejb.Schedules;
import jakarta.ejb.Singleton;

//@Singleton
public class AutomaticTimer {

    @Schedule(
            hour = "*",
            minute = "*",
            second = "*/2",
            persistent = false,
            info = "Any description"
    )
    public void scheduledOnce() {
        System.out.println("Scheduled only once");
    }

    @Schedules({
            @Schedule(hour = "*", minute = "*", second = "*/5", info = "Each 5 seconds"),
            @Schedule(hour = "*", minute = "*", second = "*/10", info = "Reach 10 seconds")
    })
    public void scheduledManyTimes() {
        System.out.println("Scheduled many times");
    }

}
