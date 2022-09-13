package testmodu;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class genel_ayarlar implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("testmodu");



	public static boolean AutoFishingEnabled = false;
	public static boolean boatflyEnabled = false;

	public static final Block SINIRSIZ_SU_BLOCKU = new SinirsizSuBlocku(null);

	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, new Identifier("testmodu", "sinirsiz_su_blocku"), SINIRSIZ_SU_BLOCKU);
		Registry.register(Registry.ITEM, new Identifier("testmodu", "sinirsiz_su_blocku"), 
				new BlockItem(SINIRSIZ_SU_BLOCKU, new FabricItemSettings().group(ItemGroup.MISC)));



	}
}
