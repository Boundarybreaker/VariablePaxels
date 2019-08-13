package pm.c7.paxels;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pm.c7.paxels.item.PaxelItem;

public class Paxels implements ModInitializer {
    public static final String MOD_ID = "variablepaxels";

    private static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
        new Identifier(MOD_ID,"items"))
        .icon(() -> new ItemStack(Paxels.DIAMOND_PAXEL))
        .build();

    public static final PaxelItem WOODEN_PAXEL = new PaxelItem(ToolMaterials.WOOD, new Item.Settings().maxDamage(ToolMaterials.WOOD.getDurability()*3).group(Paxels.ITEM_GROUP));
    public static final PaxelItem STONE_PAXEL = new PaxelItem(ToolMaterials.STONE, new Item.Settings().maxDamage(ToolMaterials.STONE.getDurability()*3).group(Paxels.ITEM_GROUP));
    public static final PaxelItem IRON_PAXEL = new PaxelItem(ToolMaterials.IRON, new Item.Settings().maxDamage(ToolMaterials.IRON.getDurability()*3).group(Paxels.ITEM_GROUP));
    public static final PaxelItem GOLDEN_PAXEL = new PaxelItem(ToolMaterials.GOLD, new Item.Settings().maxDamage(ToolMaterials.GOLD.getDurability()*3).group(Paxels.ITEM_GROUP));
    public static final PaxelItem DIAMOND_PAXEL = new PaxelItem(ToolMaterials.DIAMOND, new Item.Settings().maxDamage(ToolMaterials.DIAMOND.getDurability()*3).group(Paxels.ITEM_GROUP));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"wooden_paxel"), WOODEN_PAXEL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"stone_paxel"), STONE_PAXEL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"iron_paxel"), IRON_PAXEL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"golden_paxel"), GOLDEN_PAXEL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"diamond_paxel"), DIAMOND_PAXEL);
    }
}