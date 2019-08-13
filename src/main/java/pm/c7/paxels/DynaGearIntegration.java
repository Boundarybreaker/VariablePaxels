package pm.c7.paxels;

import io.github.cottonmc.dynagear.DynaGear;
import io.github.cottonmc.dynagear.api.ConfiguredMaterial;
import io.github.cottonmc.dynagear.api.EquipmentCategory;
import io.github.cottonmc.dynagear.api.EquipmentType;
import io.github.cottonmc.dynagear.api.EquipmentTypeAdder;
import io.github.cottonmc.dynagear.impl.EquipmentManager;
import io.github.cottonmc.dynagear.impl.SimpleEquipmentType;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import pm.c7.paxels.item.DynaPaxelItem;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DynaGearIntegration implements EquipmentTypeAdder {
    @Override
    public void addEquipmentTypes(EquipmentManager equipmentManager) {
        equipmentManager.addEquipmentType(
                new PaxelEquipmentType(
                        "paxel",
                        new String[]{"123"," / "," / "},
                        new Identifier("variablepaxels:paxels"),
                        EquipmentCategory.TOOLS,
                        (material) -> new DynaPaxelItem(material,DynaGear.getSettings().maxDamage(material.asTool().getDurability()*3).group(Paxels.ITEM_GROUP))
                )
        );
    }

    private class PaxelEquipmentType implements EquipmentType {
        private String suffix;
        private String[] pattern;
        private Identifier tag;
        private EquipmentCategory category;
        private Function<ConfiguredMaterial, Item> constructor;

        public PaxelEquipmentType(String suffix, String[] pattern, Identifier tag, EquipmentCategory category, Function<ConfiguredMaterial, Item> constructor) {
            this.suffix = suffix;
            this.pattern = pattern;
            this.tag = tag;
            this.category = category;
            this.constructor = constructor;
        }

        public String getSuffix() {
            return this.suffix;
        }

        public String[] getCraftingPattern() {
            return this.pattern;
        }

        public Identifier getEquipmentTag() {
            return this.tag;
        }

        public EquipmentCategory getCategory() {
            return this.category;
        }

        public Item construct(ConfiguredMaterial material) {
            return (Item)this.constructor.apply(material);
        }

        public Map<Character, String> getAdditionalIngredients(String materialName) {
            HashMap<Character, String> map = new HashMap<>();
            map.put('1',"dynagear:"+materialName+"_axe");
            map.put('2',"dynagear:"+materialName+"_shovel");
            map.put('3',"dynagear:"+materialName+"_pickaxe");
            return map;
        }
    }
}
