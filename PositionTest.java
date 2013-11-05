package boikoro.marsrovers;

import static boikoro.marsrovers.Direction.EAST;
import static boikoro.marsrovers.Direction.NORTH;
import static boikoro.marsrovers.Direction.SOUTH;
import static boikoro.marsrovers.Direction.WEST;
import static boikoro.marsrovers.Step.FORWARD;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.awt.Dimension;

import org.junit.Test;

public class PositionTest {

	@Test
	public void shouldProvideToStringMethodWhichWillShowStateOfPosition() {
		Position position = new Position(1, 2, NORTH);
		assertEquals("1 2 N", position.toString());
	}

	@Test(expected = IllegalStateException.class)
	public void shouldThrowExceptionIfNextPositionIsOutOfPlateauBorderInSouth() {
		new Position(0, 0, SOUTH).nextPosition(FORWARD, new Dimension(1, 1));
	}

	@Test(expected = IllegalStateException.class)
	public void shouldThrowExceptionIfNextPositionIsOutOfPlateauBorderInNorth() {
		new Position(1, 1, NORTH).nextPosition(FORWARD, new Dimension(1, 1));
	}

	@Test(expected = IllegalStateException.class)
	public void shouldThrowExceptionIfNextPositionIsOutOfPlateauBorderInWest() {
		new Position(0, 1, WEST).nextPosition(FORWARD, new Dimension(1, 1));
	}

	@Test(expected = IllegalStateException.class)
	public void shouldThrowExceptionIfNextPositionIsOutOfPlateauBorderInEast() {
		new Position(1, 0, EAST).nextPosition(FORWARD, new Dimension(1, 1));
	}

	@Test
	public void shouldEqualToPositionWithSameCoordinatesAndDirection() {
		Position position1 = new Position(1, 2, NORTH);
		Position position2 = new Position(1, 2, NORTH);
		assertThat(position1, is(equalTo(position2)));
	}
	
	@Test
	public void shouldNotEqualToPositionWithDifferentCoordinates() {
		Position position1 = new Position(1, 2, NORTH);
		Position position2 = new Position(1, 3, NORTH);
		assertThat(position1, is(not(equalTo(position2))));
	}
	
	@Test
	public void shouldNotEqualToPositionWithSameCoordinatesButDifferentDirection() {
		Position position1 = new Position(1, 2, NORTH);
		Position position2 = new Position(1, 2, SOUTH);
		assertThat(position1, is(not(equalTo(position2))));
	}
	
	@Test
	public void shouldEqualToItself() {
		Position position = new Position(1, 2, NORTH);
		assertThat(position, is(equalTo(position)));
	}
}
