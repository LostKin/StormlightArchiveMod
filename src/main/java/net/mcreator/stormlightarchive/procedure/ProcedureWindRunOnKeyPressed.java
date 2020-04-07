package net.mcreator.stormlightarchive.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.stormlightarchive.potion.PotionWindBound;
import net.mcreator.stormlightarchive.ElementsStormlightarchive;
import net.mcreator.stormlightarchive.procedure.ProcedureViewToX;
import net.mcreator.stormlightarchive.procedure.ProcedureViewToY;
import net.mcreator.stormlightarchive.procedure.ProcedureViewToZ;

import java.lang.Math;

@ElementsStormlightarchive.ModElement.Tag
public class ProcedureWindRunOnKeyPressed extends ElementsStormlightarchive.ModElement {
	public ProcedureWindRunOnKeyPressed(ElementsStormlightarchive instance) {
		super(instance, 1);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WindRunOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((!(entity.getEntityData().getBoolean("isWindRunning")))) {
			float yaw = entity.rotationYaw;
			float pitch = entity.rotationPitch;
			yaw = yaw * (float)Math.PI / 180;
			pitch = pitch * (float)Math.PI / 180;
			dependencies.put("pitch", pitch);
			dependencies.put("yaw", yaw);

			float mult = (float) 1.6;
			
			float x = (float)ProcedureViewToX.executeProcedure(dependencies) * mult;
			float y = (float)ProcedureViewToY.executeProcedure(dependencies) * mult;
			float z = (float)ProcedureViewToZ.executeProcedure(dependencies) * mult;

			float FreeFallAcceleration = (float) 1.6;
			float TicksPerSec = 20;

			y += FreeFallAcceleration;

			x = x / TicksPerSec;
			y = y / TicksPerSec;
			z = z / TicksPerSec;
			
			System.out.println("ANGLES");
			System.out.println(yaw);
			System.out.println(pitch);
			System.out.println("FLOAT");
			System.out.println(x);
			System.out.println(y);
			System.out.println(z);
			System.out.println("END OF OUTPUT");
			entity.getEntityData().setBoolean("isWindRunning", (true));
			entity.getEntityData().setDouble("bindX", x);
			entity.getEntityData().setDouble("bindY", y);
			entity.getEntityData().setDouble("bindZ", z);
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(PotionWindBound.potion, (int) 200, (int) 1));
			entity.getEntityData().setBoolean("isWindRunning", (false));
		} else {
			entity.getEntityData().setDouble("bindX", 0);
			entity.getEntityData().setDouble("bindY", 0);
			entity.getEntityData().setDouble("bindZ", 0);
		}
	}
}
