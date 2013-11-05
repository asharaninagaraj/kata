package boikoro.marsrovers;

import static boikoro.marsrovers.Step.FORWARD;
import static boikoro.marsrovers.Step.LEFT;
import static boikoro.marsrovers.Step.RIGHT;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Test;

public class RoutePlanTest {

	private static final Position INITIAL_POSITION = new Position(1, 2, Direction.NORTH);

	@Test
	public void shouldSetInitialPosition() {
		RoutePlan routePlan = new RoutePlan(INITIAL_POSITION);
		assertEquals(INITIAL_POSITION, routePlan.getInitialPosition());
	}

	@Test
	public void shouldReturnEmptyRouteIfNoStepsAdded() {
		RoutePlan routePlan = new RoutePlan(INITIAL_POSITION);
		assertEquals(Collections.emptyList(), routePlan.getRoute());
	}

	@Test
	public void shouldReturnRouteContainingAddedSteps() {
		RoutePlan routePlan = new RoutePlan(INITIAL_POSITION);
		routePlan.addRouteStep('R').addRouteStep('M').addRouteStep('L');
		assertEquals(asList(RIGHT, FORWARD, LEFT), routePlan.getRoute());
	}
}
