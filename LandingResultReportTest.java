package boikoro.marsrovers;

import static boikoro.marsrovers.Direction.NORTH;
import static boikoro.marsrovers.Direction.SOUTH;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LandingResultReportTest {

	@Test
	public void shouldReturnEmptyReportIfNoRoversLanded() {
		LandingResultReport report = new LandingResultReport();
		assertEquals("", report.toString());
	}

	@Test
	public void shouldAddPositionOfRoverToReport() {
		LandingResultReport report = new LandingResultReport();
		report.reportThatRoverIsOnTargetPosition(new Rover(new Position(1, 2, NORTH)));
		assertEquals("1 2 N", report.toString());
	}

	@Test
	public void shouldSeparateMultipleRoversPositionsByLineEnding() {
		LandingResultReport report = new LandingResultReport();
		report.reportThatRoverIsOnTargetPosition(new Rover(new Position(1, 2, NORTH)));
		report.reportThatRoverIsOnTargetPosition(new Rover(new Position(2, 3, SOUTH)));
		assertEquals("1 2 N\n2 3 S", report.toString());
	}

}
