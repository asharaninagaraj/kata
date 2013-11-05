package boikoro.marsrovers;

import static java.lang.String.format;

public enum Step {
	FORWARD("M"), RIGHT("R"), LEFT("L");
	
	private String stepShortcut;

	private Step(String stepShortcut) {
		this.stepShortcut = stepShortcut; 
	}

	public String toString() {
		return stepShortcut;
	}

	public static Step fromString(String shortcut) {
		for(Step step: values()) {
			if(step.stepShortcut.equals(shortcut)) {
				return step;
			}
		}
		throw new IllegalArgumentException(format("Invalid step given: %s", shortcut));
	}
}
