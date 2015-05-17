package toy.position;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import toy.Bound;

public class PositionTest {

    @Before
    public void setUpStreams() {
        Bound.newBound(4, 4);
    }

    @Test
    public void testOutOfBound() {
        Position position = new Position(0, 0);
        assertFalse(position.outOfBound());

        position.setX(-1);
        assertTrue(position.outOfBound());

        position = new Position(0, 0);
        position.setY(-1);
        assertTrue(position.outOfBound());

        position = new Position(0, 0);
        position.setX(5);
        assertTrue(position.outOfBound());

        position = new Position(0, 0);
        position.setY(5);
        assertTrue(position.outOfBound());
    }

    @Test
    public void testDisplace() {
        Position position = new Position(1, 1);
        Displacement displacement = new Displacement(-2, 3);
        position.displace(displacement, 2);
        assertEquals(-3, position.getX());
        assertEquals(7, position.getY());
    }

}
