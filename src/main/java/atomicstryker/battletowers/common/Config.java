package atomicstryker.battletowers.common;


import net.minecraftforge.common.config.Configuration;

import java.io.File;
/**
 * Created by IntelliJ IDEA.
 *
 * @Author : wdcftgg
 * @create 2023/8/26 17:33
 */
public class Config  {

    public static String[] TowerDimension = new String[]{
        "1,minecraft:end_stone,minecraft:air,minecraft:end_bricks,1,minecraft:stone_slab,endstone"
    };

    public static String[] TowerBiome = new String[]{
            "0,minecraft:wool,minecraft:air,minecraft:end_bricks,1,minecraft:stone_slab,endstone"
    };

    public Config() {
    }

    public static void init(File configurationFile) {
        Configuration config = AS_BattleTowersCore.instance.configuration;
        String CATEGORY_Tower = "Tower";

        try {
            config.load();
            config.addCustomCategoryComment("Tower", "TowerDimension\nThe composition of blocks when a tower is generated in a particular dimension\n[dimensionID,wallBlockID,lightBlockID,floorBlockID,floorBlockMetaData,stairBlockID,typeName]\nTowerBiome\nThe composition of blocks when a tower is generated in a particular Biome\n[biomeID,wallBlockID,lightBlockID,floorBlockID,floorBlockMetaData,stairBlockID,typeName]");
            TowerDimension = config.get(CATEGORY_Tower, "TowerDimension", TowerDimension, "").getStringList();
            TowerBiome = config.get(CATEGORY_Tower, "TowerBiome", TowerBiome, "").getStringList();
        } catch (Exception var11) {
        } finally {
            config.save();
        }

    }
}
