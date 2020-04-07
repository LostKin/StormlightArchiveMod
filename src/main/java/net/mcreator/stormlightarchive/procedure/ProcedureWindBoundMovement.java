package net.mcreator.stormlightarchive.procedure;

import net.minecraft.entity.Entity;

import net.mcreator.stormlightarchive.ElementsStormlightarchive;

@ElementsStormlightarchive.ModElement.Tag
public class ProcedureWindBoundMovement extends ElementsStormlightarchive.ModElement {
	public ProcedureWindBoundMovement(ElementsStormlightarchive instance) {
		super(instance, 3);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WindBoundMovement!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.motionX = ((entity.motionX) + (entity.getEntityData().getDouble("bindX")));
		entity.motionY = ((entity.motionY) + (entity.getEntityData().getDouble("bindY")));
		entity.motionZ = ((entity.motionZ) + (entity.getEntityData().getDouble("bindZ")));
		entity.fallDistance = (float) (0);
	}
}
