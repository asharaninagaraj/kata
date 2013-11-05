package boikoro.marsrovers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RoutePlan {
	private final Position initialPosition;
	private final List<Step> route;

	public RoutePlan(Position initialPosition) {
		this.initialPosition = initialPosition;
		this.route = new LinkedList<Step>();
	}

	public RoutePlan addRouteStep(Character stepAction) {
		this.route.add(Step.fromString(stepAction.toString()));
		return this;
	}

	public Position getInitialPosition() {
		return initialPosition;
	}

	public List<Step> getRoute() {
		return new ArrayList<Step>(route);
	}
}
