package boikoro.marsrovers;

public class LandingResultReport {

	private static final String LINE_SEPARATOR = "\n";

	private final StringBuffer output = new StringBuffer();

	public LandingResultReport reportThatRoverIsOnTargetPosition(Rover rover) {
		output.append(rover.getCurrentPosition().toString()).append(LINE_SEPARATOR);
		return this;
	}

	public String toString() {
		return output.toString().trim();
	}
}
