package toy;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import toy.command.LeftCommand;
import toy.command.MoveCommand;
import toy.command.PlaceCommand;
import toy.command.ReportCommand;
import toy.command.RightCommand;
import toy.facing.East;
import toy.position.Position;

public class TestCase {

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
    public void test() {
        Robot robot = new Robot();

        PlaceCommand place = new PlaceCommand();
        place.setPosition(new Position(1, 3));
        place.setFacing(new East());
        place.execute(robot);
        assertEquals("EAST", robot.getFacing().toString());
        assertEquals(1, robot.getPosition().getX());
        assertEquals(3, robot.getPosition().getY());

        LeftCommand left = LeftCommand.getInstance();
        left.execute(robot);
        assertEquals("NORTH", robot.getFacing().toString());
        assertEquals(1, robot.getPosition().getX());
        assertEquals(3, robot.getPosition().getY());

        RightCommand right = RightCommand.getInstance();
        right.execute(robot);
        right.execute(robot);
        assertEquals("SOUTH", robot.getFacing().toString());
        assertEquals(1, robot.getPosition().getX());
        assertEquals(3, robot.getPosition().getY());

        MoveCommand move = new MoveCommand();
        move.execute(robot);
        assertEquals("SOUTH", robot.getFacing().toString());
        assertEquals(1, robot.getPosition().getX());
        assertEquals(2, robot.getPosition().getY());

        right.execute(robot);
        assertEquals("WEST", robot.getFacing().toString());
        assertEquals(1, robot.getPosition().getX());
        assertEquals(2, robot.getPosition().getY());

        move.execute(robot);
        assertEquals("WEST", robot.getFacing().toString());
        assertEquals(0, robot.getPosition().getX());
        assertEquals(2, robot.getPosition().getY());

        move.execute(robot);
        assertEquals("WEST", robot.getFacing().toString());
        assertEquals(0, robot.getPosition().getX());
        assertEquals(2, robot.getPosition().getY());

        left.execute(robot);
        assertEquals("SOUTH", robot.getFacing().toString());
        assertEquals(0, robot.getPosition().getX());
        assertEquals(2, robot.getPosition().getY());

        move.setUnit(2);
        move.execute(robot);
        assertEquals("SOUTH", robot.getFacing().toString());
        assertEquals(0, robot.getPosition().getX());
        assertEquals(0, robot.getPosition().getY());

        ReportCommand report = ReportCommand.getInstance();
        report.execute(robot);
        assertEquals("Output: 0, 0, SOUTH\n", outContent.toString());
    }

}
