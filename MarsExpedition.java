package boikoro.marsrovers;

public class MarsExpedition {
	public LandingResultReport lendRoversAndCreateLendingReport(LandingPlan landingPlan) {
		LandingResultReport landingResultReport = new LandingResultReport();
		while(landingPlan.hasMoreRoutes()) {
			RoutePlan routePlan = landingPlan.nextRoutePlan();
			Rover rover = new Rover(routePlan.getInitialPosition());
			rover.move(routePlan.getRoute(), landingPlan.getPlateauDimension());
			landingResultReport.reportThatRoverIsOnTargetPosition(rover);
		}
		return landingResultReport;
	}
}
