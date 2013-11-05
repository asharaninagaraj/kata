package boikoro.marsrovers;

import static boikoro.marsrovers.Direction.NORTH;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class MarsExpeditionTest {
	@Test
	public void shouldNotAddItemsToReportIfLandingPlanHasNoRoutes() {
		LandingPlan landingPlan = mock(LandingPlan.class);
		when(landingPlan.hasMoreRoutes()).thenReturn(false);
		LandingResultReport report = new MarsExpedition().lendRoversAndCreateLendingReport(landingPlan);
		assertEquals(0, report.toString().length());
		verify(landingPlan).hasMoreRoutes();
		verify(landingPlan, never()).nextRoutePlan();
	}

	@Test
	public void shouldAddItemToReportIfLandingPlanHasRoutes() {
		LandingPlan landingPlan = Mockito.mock(LandingPlan.class);
		when(landingPlan.hasMoreRoutes()).thenReturn(true).thenReturn(false);
		when(landingPlan.nextRoutePlan()).thenReturn(new RoutePlan(new Position(1, 2, NORTH)));
		LandingResultReport report = new MarsExpedition().lendRoversAndCreateLendingReport(landingPlan);
		assertTrue(report.toString().length() > 0);
		verify(landingPlan, times(1)).nextRoutePlan();
		verify(landingPlan, times(2)).hasMoreRoutes();
	}

}
