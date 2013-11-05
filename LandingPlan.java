package boikoro.marsrovers;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;

import java.awt.Dimension;
import java.util.LinkedList;
import java.util.List;

public class LandingPlan {

	private static final String INPUT_LINE_SEPARATOR = "\r?\n";
	private static final String INPUT_WORD_SEPARATOR = "\\s";

	private List<String> landingPlanLines;
	private Dimension plateauDimension;

	public LandingPlan(String input) {
		landingPlanLines = new LinkedList<String>(asList(input.split(INPUT_LINE_SEPARATOR)));
		plateauDimension = parseDimension(popLandingPlanLine());
	}

	public boolean hasMoreRoutes() {
		return !landingPlanLines.isEmpty();
	}

	public Dimension getPlateauDimension() {
		return new Dimension(plateauDimension);
	}

	public RoutePlan nextRoutePlan() {
		if(!hasMoreRoutes()) {
			throw new IllegalStateException("No more routes, there is method hasMoreRoutes() for verification");
		}
		String initialPositionCoordinatesLine = popLandingPlanLine();
		String routeStepsLine = popLandingPlanLine();
		Position initialPosition = parseInitialPosition(initialPositionCoordinatesLine);
		RoutePlan routePlan = new RoutePlan(initialPosition);
		for (char step : routeStepsLine.toCharArray()) {
			routePlan.addRouteStep(step);
		}
		return routePlan;
	}

	private String popLandingPlanLine() {
		return landingPlanLines.remove(0);
	}

	private Position parseInitialPosition(String initialPositionCoordinatesLine) {
		String[] initialPositionCoordinates = initialPositionCoordinatesLine.split(INPUT_WORD_SEPARATOR);
		int xPosition = parseInt(initialPositionCoordinates[0]);
		int yPosition = parseInt(initialPositionCoordinates[1]);
		String direction = initialPositionCoordinates[2].trim();
		return new Position(xPosition, yPosition, Direction.fromString(direction));
	}
	
	private Dimension parseDimension(String dimensionDefinitionLine) {
		String[] plateauDimensionCoordinates = dimensionDefinitionLine.split(INPUT_WORD_SEPARATOR);
		return new Dimension(parseInt(plateauDimensionCoordinates[0]), parseInt(plateauDimensionCoordinates[1]));
	}
	
}
