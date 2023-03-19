import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import unibo.basicomm23.utils.ApplAbstractObserver;
import unibo.common.IAppl1Core;
import unibo.common.IVrobotMoves;
import unibo.core.Appl1Core;
import unibo.observer.Appl1ObserverForpath;

import java.util.Map;

import static org.junit.Assert.*;

public class TestBoundaryWalk {
    private Appl1Core appl1Core;
    private Appl1ObserverForpath observer;

   // @Before


    @Before
    public void init() {
      appl1Core=new Appl1Core();
        observer=new Appl1ObserverForpath();
    }

    @Test
   public void checkBoundaryWalk(){
        appl1Core.addObserver(observer);
        try {
            appl1Core.start();
            assertTrue(observer.evalBoundaryDone());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
