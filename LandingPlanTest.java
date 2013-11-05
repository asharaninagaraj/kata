package boikoro.marsrovers;

import static boikoro.marsrovers.Direction.NORTH;
import static boikoro.marsrovers.Step.FORWARD;
import static org.junit.Assert.*;

import java.awt.Dimension;
import java.util.Arrays;

import org.junit.Test;

public class LandingPlanTest {

	@Test
	public void shouldParsePlateauDimension() {
		LandingPlan landingPlan= new LandingPlan("2 3");
		assertEquals(new Dimension(2, 3), landingPlan.getPlateauDimension());
	}
	
	@Test
	public void shouldNotHaveRoutesIfPlateauDimensionIsSpecifiedOnly() {
		LandingPlan landingPlan= new LandingPlan("2 3");
		assertFalse(landingPlan.hasMoreRoutes());
	}

	@Test
	public void shouldHaveMoreRoutesIfAtLeastOneMoreRouteGiven() {
		LandingPlan landingPlan= new LandingPlan("2 3\n2 3 N\nMM");
		assertTrue(landingPlan.hasMoreRoutes());
	}
	
	@Test
	public void shouldReturnNextRoutePlan() {
		LandingPlan landingPlan= new LandingPlan("2 3\n2 3 N\nMM");
		RoutePlan routePlan = landingPlan.nextRoutePlan();
		assertEquals(new Position(2, 3, NORTH), routePlan.getInitialPosition());
		assertEquals(Arrays.asList(FORWARD, FORWARD), routePlan.getRoute());
	}

	@Test
	public void shouldNotHaveMoreRoutePlansIfTheOnlyOneGivenWasRetrieved() {
		LandingPlan landingPlan= new LandingPlan("2 3\n2 3 N\nMM");
		landingPlan.nextRoutePlan();
		assertFalse(landingPlan.hasMoreRoutes());
	}

	@Test
	public void shouldReturnMultipleRoutePlans() {
		LandingPlan landingPlan= new LandingPlan("2 3\n2 3 N\nMMM\n2 3 N\nMMM\n2 3 N\nMMM");
		assertNotNull(landingPlan.nextRoutePlan());
		assertNotNull(landingPlan.nextRoutePlan());
		assertNotNull(landingPlan.nextRoutePlan());
		assertFalse(landingPlan.hasMoreRoutes());
	}

	@Test(expected = IllegalStateException.class)
	public void shouldThrowExceptionIfNoMoreRoutesButNextOneRequested() {
		LandingPlan landingPlan= new LandingPlan("2 3");
		landingPlan.nextRoutePlan();
	}
}
