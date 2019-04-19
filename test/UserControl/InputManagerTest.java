package UserControl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InputManagerTest {

    @Before
    public void setUp(){
    }

    @Test
    public void directionW() {

        char actual = 'w';
        char expected = 's';
        assertEquals(expected, actual);
    }
}