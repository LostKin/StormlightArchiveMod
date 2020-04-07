package net.mcreator.stormlightarchive.procedure;

import net.mcreator.stormlightarchive.ElementsStormlightarchive;

@ElementsStormlightarchive.ModElement.Tag
public class ProcedureViewToY extends ElementsStormlightarchive.ModElement {
	public ProcedureViewToY(ElementsStormlightarchive instance) {
		super(instance, 5);
	}

	public static double executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("pitch") == null) {
			System.err.println("Failed to load dependency pitch for procedure ViewToX!");
			return -2;
		}
		if (dependencies.get("yaw") == null) {
			System.err.println("Failed to load dependency yaw for procedure ViewToX!");
			return -2;
		}
		double pitch = (float)dependencies.get("pitch");
		double yaw = (float) dependencies.get("yaw");
		double alpha = 0;
		double beta = 0;
		alpha = (double) (yaw);
		beta = (double) (pitch);
		return Math.sin(-beta);

	}
}
