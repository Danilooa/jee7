package br.com.danilooa.ocpjadee7.timerservice;

import jakarta.annotation.Resource;
import jakarta.ejb.*;

import java.util.Collection;

@Singleton
public class TimerInfo {

    @Resource
    private SessionContext sessionContext;

    public void getTimersInformation() {
        TimerService timerService = sessionContext.getTimerService();
        Collection<Timer> timers = timerService.getTimers();

        for (Timer timer : timers) {
            System.out.println("Timer Info:");
            System.out.println("  Timer Next Timeout: " + timer.getNextTimeout());
            System.out.println("  Timer Schedule: " + timer.getSchedule());
            System.out.println("  Timer Info: " + timer.getInfo());
        }
    }
}