package unibo.core;

import unibo.basicomm23.http.HTTPCommApache;
import unibo.basicomm23.utils.CommUtils;
import unibo.common.IAppl1Core;
import unibo.common.IVrobotMoves;
import unibo.supports.VrobotHLMovesHTTPApache;

import java.util.Observable;

public class Appl1Core extends Observable implements IAppl1Core {
    protected boolean started    = false;
    protected boolean stopped    = false;
    protected IVrobotMoves vr ;
    @Override
    public void start() throws Exception {
        if( ! started ){
            started = true;
            walkAtBoundary();
        }else CommUtils.outred("Application already started");

    }
    private void walkAtBoundary() throws Exception {
        robotMustBeAtHome("robot-athomebegin");
        for( int i=1; i<=4;i++) {
            walkBySteppingWithStop(i);
            vr.turnLeft();
            updateObservers("robot-turnLeft");
        }
        robotMustBeAtHome("robot-athomeend");
        started = false;
    }
    private void walkBySteppingWithStop(int n) throws Exception {
        CommUtils.outyellow("walkBySteppingWithStop n="+ n );
        boolean stepOk = true;
        while( stepOk  ) {
            if( stopped ) {
                CommUtils.beep();
                updateObservers("robot-stopped");
                waitResume();
            }
            updateObservers("robot-moving");
            stepOk =  vr.step(350);
            if( ! stepOk ) updateObservers("robot-collision");
            else updateObservers("robot-stepdone");
            CommUtils.delay(300); //to show the steps better
        }
    }

    public synchronized void waitResume(){
        while( stopped ){
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        updateObservers("robot-resumed");
    }


    @Override
    public synchronized void stop() {
        stopped = true;
        try {
            vr.halt();
        } catch (Exception e) {;
        }

    }

    @Override
    public synchronized void resume() {
        stopped = false;
        notifyAll();  //riattiva waitResume
    }
    public Appl1Core(String address){
        stopped = false;
        configure(address);
    }
    protected void configure(String address){
        String URL = address+":8090/api/move";
        //URL potrebbe essere letto da un file di configurazione
        HTTPCommApache httpSupport = new HTTPCommApache(  URL );
        vr = new VrobotHLMovesHTTPApache( httpSupport );
    }
    private void updateObservers(String msg){
        setChanged();
        notifyObservers(msg);
    }
    private void robotMustBeAtHome(String msg) throws Exception{
        if( checkRobotAtHome() ) updateObservers(msg);
        else throw new Exception("START: Robot must be at HOME");
    }

    private boolean checkRobotAtHome() {
        try {
            vr.turnRight();
            boolean res = vr.step(200); //a little step ...
            if (res) return false;
            vr.turnRight();
            res = vr.step(200);
            if (res) return false;
            vr.turnLeft();
            vr.turnLeft();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
