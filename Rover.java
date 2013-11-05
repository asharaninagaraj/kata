package boikoro.marsrovers;

import java.awt.Dimension;
import java.util.List;

public class Rover {

	private Position currentPosition;

	public Rover(Position initialPosition) {
		this.currentPosition = initialPosition;
	}

	public Position getCurrentPosition() {
		return currentPosition;
	}

	public void move(List<Step> route, Dimension plateauDimension) {
		for(Step step: route) {
			currentPosition = currentPosition.nextPosition(step, plateauDimension);
		}
	}
}
