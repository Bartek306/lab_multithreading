package edu.iis.mto.multithread;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.ExecutorService;

@ExtendWith(MockitoExtension.class)
class RadarTest {

    @Mock
    private PatriotBattery batteryMock;
    @Mock
    private ExecutorService executorService;

    @RepeatedTest(50)
    void launchOneRocket() {
        BetterRadar radar = new BetterRadar(1, batteryMock, executorService);
        Scud scud = new Scud();
        radar.notice(scud);
        verify(executorService).execute(any(Runnable.class));
    }
    @RepeatedTest(50)
    void launchZeroRocket(){
        BetterRadar radar = new BetterRadar(0, batteryMock, executorService);
        Scud scud = new Scud();
        radar.notice(scud);
        verify(batteryMock, Mockito.times(0)).launchPatriot(scud);
    }

    @RepeatedTest(50)
    void launchHundredRocket(){
        BetterRadar radar = new BetterRadar(100, batteryMock, executorService);
        Scud scud = new Scud();
        radar.notice(scud);
        verify(executorService).execute(any(Runnable.class));
    }