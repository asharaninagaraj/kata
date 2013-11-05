package boikoro.marsrovers;

import static boikoro.marsrovers.Direction.NORTH;
import static boikoro.marsrovers.Step.FORWARD;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.Dimension;

import org.junit.Test;

public class RoverTest {

	@Test
	public void shouldBeAbleToSetInitialPositionViaConstructor() {
		Position initialPosition = new Position(1, 2, NORTH);
		Rover rover = new Rover(initialPosition);
		Position currentPosition = rover.getCurrentPosition();
		assertThat(currentPosition, is(equalTo(initialPosition)));
	}

	@Test
	public void shouldMoveToPositionNextToCurrentAccordingToStepValue() {
		Position initialPosition = mock(Position.class);
		Dimension plateauDimension = new Dimension();
		Position targetPosition = new Position(1, 2, Direction.NORTH);
		when(initialPosition.nextPosition(FORWARD, plateauDimension)).thenReturn(targetPosition);
		Rover rover = new Rover(initialPosition);

		rover.move(asList(FORWARD), plateauDimension);

		verify(initialPosition).nextPosition(FORWARD, plateauDimension);
		assertThat(rover.getCurrentPosition(), is(equalTo(targetPosition)));
	}
}
