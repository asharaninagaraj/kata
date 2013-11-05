package boikoro.marsrovers;

import static boikoro.marsrovers.Step.LEFT;
import static boikoro.marsrovers.Step.FORWARD;
import static boikoro.marsrovers.Step.RIGHT;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StepTest {

	@Test
	public void shouldGenerateStepFromShortcut() {
		assertEquals(FORWARD, Step.fromString("M"));
		assertEquals(LEFT, Step.fromString("L"));
		assertEquals(RIGHT, Step.fromString("R"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionOnInvalidStepShortcutGiven() {
		Direction.fromString("ILLEGAL_DIRECTION");
	}

	@Test
	public void shouldProvideShortcutAsResultOfToStringMethod() {
		assertEquals("M", FORWARD.toString());
		assertEquals("L", LEFT.toString());
		assertEquals("R", RIGHT.toString());
	}
}
