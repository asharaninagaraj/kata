package boikoro.marsrovers;

import static boikoro.marsrovers.Direction.EAST;
import static boikoro.marsrovers.Direction.NORTH;
import static boikoro.marsrovers.Direction.SOUTH;
import static boikoro.marsrovers.Direction.WEST;
import static boikoro.marsrovers.Step.FORWARD;
import static boikoro.marsrovers.Step.RIGHT;
import static boikoro.marsrovers.Step.LEFT;
import static org.junit.Assert.assertEquals;

import java.awt.Dimension;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PositionChangingTest {

	private static final Dimension PLATEAU_DIMENSION = new Dimension(4, 4);
	private Position initialPosition;
	private Step step;
	private Position expectedTargetPosition;

	public PositionChangingTest(Position initialPosition, Step step,
			Position expectedTargetPosition) {
		this.initialPosition = initialPosition;
		this.step = step;
		this.expectedTargetPosition = expectedTargetPosition;
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{position(2, 2, NORTH), FORWARD, position(2, 3, NORTH)},
				{position(2, 2, EAST), FORWARD, position(3, 2, EAST)},
				{position(2, 2, WEST), FORWARD, position(1, 2, WEST)},
				{position(2, 2, SOUTH), FORWARD, position(2, 1, SOUTH)},

				{position(2, 2, NORTH), RIGHT, position(2, 2, EAST)},
				{position(2, 2, NORTH), LEFT, position(2, 2, WEST)},

				{position(2, 2, EAST), RIGHT, position(2, 2, SOUTH)},
				{position(2, 2, EAST), LEFT, position(2, 2, NORTH)},

				{position(2, 2, SOUTH), RIGHT, position(2, 2, WEST)},
				{position(2, 2, SOUTH), LEFT, position(2, 2, EAST)},

				{position(2, 2, WEST), RIGHT, position(2, 2, NORTH)},
				{position(2, 2, WEST), LEFT, position(2, 2, SOUTH)}
		});
	}

	@Test
	public void shouldMoveFromInitialPositionToTargetOneAfterGivenStep() {
		assertEquals(expectedTargetPosition, initialPosition.nextPosition(step, PLATEAU_DIMENSION));
	}
	
	private static Position position(int xPosition, int yPosition, Direction direction) {
		return new Position(xPosition, yPosition, direction);
	}

}
