package boikoro.marsrovers;

import static boikoro.marsrovers.Direction.EAST;
import static boikoro.marsrovers.Direction.NORTH;
import static boikoro.marsrovers.Direction.SOUTH;
import static boikoro.marsrovers.Direction.WEST;
import static boikoro.marsrovers.Step.FORWARD;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DirectionTest {

	@Test
	public void shouldGenerateDirectionFromShortcut() {
		assertEquals(EAST, Direction.fromString("E"));
		assertEquals(SOUTH, Direction.fromString("S"));
		assertEquals(WEST, Direction.fromString("W"));
		assertEquals(NORTH, Direction.fromString("N"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionOnInvalidDirectionShortcut() {
		Direction.fromString("ILLEGAL_DIRECTION");
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionOnInvalidTurnInput() {
		Direction.turnDirection(NORTH, FORWARD);
	}

	@Test
	public void shouldProvideShortcutAsResultOfToStringMethod() {
		assertEquals("E", EAST.toString());
		assertEquals("S", SOUTH.toString());
		assertEquals("W", WEST.toString());
		assertEquals("N", NORTH.toString());
	}
}
