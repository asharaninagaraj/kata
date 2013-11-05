package boikoro.marsrovers;

import static boikoro.marsrovers.Direction.EAST;
import static boikoro.marsrovers.Direction.NORTH;
import static boikoro.marsrovers.Direction.SOUTH;
import static boikoro.marsrovers.Direction.WEST;
import static boikoro.marsrovers.Direction.turnDirection;
import static boikoro.marsrovers.Step.FORWARD;
import static java.lang.String.format;

import java.awt.Dimension;

public class Position {
	private final int xPosition;
	private final int yPosition;
	private final Direction direction;

	public Position(int xPosition, int yPosition, Direction direction) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.direction = direction;
	}

	@Override
	public boolean equals(Object other) {
		Position otherPosition = (Position) other;
		return (this.xPosition == otherPosition.xPosition)
				&& (this.yPosition == otherPosition.yPosition)
				&& this.direction.equals(otherPosition.direction);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = prime + direction.hashCode();
		result = prime * result + xPosition;
		result = prime * result + yPosition;
		return result;
	}

	public Position nextPosition(Step step, Dimension plateauDimension) {
		return validate(calculateNextPosition(step), plateauDimension);
	}

	private Position calculateNextPosition(Step step) {
		if (step.equals(FORWARD)) {
			if (direction.equals(SOUTH)) {
				return new Position(xPosition, yPosition - 1, direction);
			} else if (direction.equals(WEST)) {
				return new Position(xPosition - 1, yPosition, direction);
			} else if (direction.equals(NORTH)) {
				return new Position(xPosition, yPosition + 1, direction);
			} else if (direction.equals(EAST)) {
				return new Position(xPosition + 1, yPosition, direction);
			}
		}

		return new Position(xPosition, yPosition, turnDirection(direction, step));
	}

	private Position validate(Position position, Dimension plateauDimension) {
		if(position.xPosition < 0 
			|| position.yPosition < 0
			|| position.xPosition > plateauDimension.width
			|| position.yPosition > plateauDimension.height) {
			throw new IllegalStateException(format("Position out of plateau border: %s", position.toString()));
		} else {
			return position;
		}
	}

	@Override
	public String toString() {
		return format("%d %d %s", xPosition, yPosition, direction);
	}
	
	

}
