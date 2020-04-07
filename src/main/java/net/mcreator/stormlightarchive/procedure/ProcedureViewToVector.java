package net.mcreator.stormlightarchive.procedure;

import net.minecraft.entity.Entity;

import net.mcreator.stormlightarchive.ElementsStormlightarchive;

@ElementsStormlightarchive.ModElement.Tag
public class ProcedureViewToVector extends ElementsStormlightarchive.ModElement {
	public ProcedureViewToVector(ElementsStormlightarchive instance) {
		super(instance, 4);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ViewToVector!");
			return;
		}
		if (dependencies.get("pitch") == null) {
			System.err.println("Failed to load dependency pitch for procedure ViewToVector!");
			return;
		}
		if (dependencies.get("yaw") == null) {
			System.err.println("Failed to load dependency yaw for procedure ViewToVector!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int pitch = (int) dependencies.get("pitch");
		int yaw = (int) dependencies.get("yaw");
		double alpha = 0;
		double beta = 0;
		alpha = (double) (yaw);
		beta = (double) (pitch);
		entity.rotationYaw = 0;
		entity.rotationPitch = 0;
	}
}
