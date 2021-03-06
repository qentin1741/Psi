/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Psi Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Psi
 *
 * Psi is Open Source and distributed under the
 * Psi License: http://psi.vazkii.us/license.php
 *
 * File Created @ [11/01/2016, 21:58:25 (GMT)]
 */
package vazkii.psi.common.network;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import vazkii.psi.common.lib.LibMisc;
import vazkii.psi.common.network.message.MessageChangeControllerSlot;
import vazkii.psi.common.network.message.MessageChangeSocketableSlot;
import vazkii.psi.common.network.message.MessageDataSync;
import vazkii.psi.common.network.message.MessageDeductPsi;
import vazkii.psi.common.network.message.MessageLearnGroup;
import vazkii.psi.common.network.message.MessageLevelUp;
import vazkii.psi.common.network.message.MessageSkipToLevel;
import vazkii.psi.common.network.message.MessageSpellModified;
import vazkii.psi.common.network.message.TestMessage;

public class NetworkHandler {

	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(LibMisc.MOD_ID);

	private static int i = 0;

	public static void init() {
		register(TestMessage.class, Side.CLIENT);

		register(MessageDataSync.class, Side.CLIENT);
		register(MessageDeductPsi.class, Side.CLIENT);
		register(MessageChangeSocketableSlot.class, Side.SERVER);
		register(MessageSpellModified.class, Side.SERVER);
		register(MessageLearnGroup.class, Side.SERVER);
		register(MessageSkipToLevel.class, Side.SERVER);
		register(MessageLevelUp.class, Side.CLIENT);
		register(MessageChangeControllerSlot.class, Side.SERVER);
	}

	private static void register(Class clazz, Side handlerSide) {
		INSTANCE.registerMessage(clazz, clazz, i++, handlerSide);
	}

}
