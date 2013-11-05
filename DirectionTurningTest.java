package boikoro.marsrovers;

import static boikoro.marsrovers.Direction.EAST;
import static boikoro.marsrovers.Direction.NORTH;
import static boikoro.marsrovers.Direction.SOUTH;
import static boikoro.marsrovers.Direction.WEST;
import static boikoro.marsrovers.Direction.turnDirection;
import static boikoro.marsrovers.Step.LEFT;
import static boikoro.marsrovers.Step.RIGHT;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DirectionTurningTest {

	private Direction initialDirection;
	private Step step;
	private Direction expectedDirection;

	public DirectionTurningTest(Direction initialDirection, Step step, Direction expectedDirection) {
		this.initialDirection = initialDirection;
		this.step = step;
		this.expectedDirection = expectedDirection;
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{NORTH, RIGHT, EAST},
				{NORTH, LEFT, WEST},

				{EAST, RIGHT, SOUTH},
				{EAST, LEFT, NORTH},

				{SOUTH, RIGHT, WEST},
				{SOUTH, LEFT, EAST},

				{WEST, RIGHT, NORTH},
				{WEST, LEFT, SOUTH}
		});
	}

	@Test
	public void shouldTurnFromInitialDirectionToTargetOne() {
		assertEquals(expectedDirection, turnDirection(initialDirection, step));
	}
}
