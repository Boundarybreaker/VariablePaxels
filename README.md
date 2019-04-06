# VariablePaxels [![](https://jitpack.io/v/Cynosphere/VariablePaxels.svg)](https://jitpack.io/#Cynosphere/VariablePaxels)
The classic multitool now on Fabric

**This mod was a feature originally part of [Variability](https://gitlab.com/Cynosphere/variability-fabric).**

## For developers

### Gradle Dependencies

Add repository

```
repositories {
  maven { url 'https://jitpack.io' }
}
```

Then add to dependencies

```
dependencies {
  modCompile 'com.github.Cynosphere:VariablePaxels:<game version>-<mod version>'
}
```

### Creating a Paxel
```java
package com.whatever.mypaxelmod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import pm.c7.paxels.Paxels;
import pm.c7.paxels.item.PaxelItem;

public class MyPaxelMod extends ModInitializer {
    //...

    //use whatever ToolMaterial and optionally whatever item group.
    //if you're just adding basic paxels and don't want to make an item group feel free to just throw it into the mod's
    public static final PaxelItem MY_PAXEL = PaxelItem(ToolMaterials.DIAMOND, new Item.Settings().stackSize(1).itemGroup(Paxels.ITEM_GROUP));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("mypaxelmod","my_paxel"), MY_PAXEL);
    }
}
```
### Textures
I have provided a template both in [paint.net](/paxel_template.pdn) and [GIMP](/paxel_template.xcf) formats.
