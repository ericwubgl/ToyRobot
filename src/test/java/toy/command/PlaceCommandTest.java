package toy.command;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import toy.Bound;
import toy.Robot;

public class PlaceCommandTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        Bound.newBound(4, 4);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void testNullPositionOrFacing() {
        PlaceCommand command = new PlaceCommand();
        command.execute(new Robot());

        assertEquals("Please place me on the table with a valid facing!\n", outContent.toString());
    }

}
