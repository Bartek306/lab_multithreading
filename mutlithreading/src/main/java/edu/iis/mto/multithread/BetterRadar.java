package edu.iis.mto.multithread;

import edu.iis.mto.multithread.Scud;

import java.util.concurrent.ExecutorService;

public class BetterRadar{
    private int count;
    private PatriotBattery pariotBattery;
    private ExecutorService excutorService;

    public BetterRadar(int count, PatriotBattery pariotBattery, ExecutorService executorService){
        this.count = count;
        this.pariotBattery = pariotBattery;
        this.excutorService = executorService;
    }

    public void notice(Scud enemyMissile){
        excutorService.execute(() -> {
            for(int i=0; i< count; i++){
                this.pariotBattery.launchPatriot(enemyMissile);
            }
        });

    }
}