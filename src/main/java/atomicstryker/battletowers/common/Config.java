package atomicstryker.battletowers.common;


import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

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
    public static String[] dimMinDistanceBetweenTowers = new String[]{
            "*:196"
    };

    public static boolean explosion = true;
    public static boolean hasloottable = true;

    public Config() {
    }

    public static void init(File configurationFile) {
        Configuration config = AS_BattleTowersCore.instance.configuration;
        String CATEGORY_Tower = "Tower";
        String CATEGORY_MORE_CONFIG = "more_config";

        try {
            config.load();
            config.addCustomCategoryComment("Tower", "TowerDimension\nThe composition of blocks when a tower is generated in a particular dimension\n[dimensionID,wallBlockID,lightBlockID,floorBlockID,floorBlockMetaData,stairBlockID,typeName]\nTowerBiome\nThe composition of blocks when a tower is generated in a particular Biome\n[biomeID,wallBlockID,lightBlockID,floorBlockID,floorBlockMetaData,stairBlockID,typeName]\ndimMinDistanceBetweenTowers\nThe minimum distance between two towers in different dimensions(* means any dimension)\nConfigurations with * should be at the bottom, for example:\n1:256\n*:128\n[dimensionID:minDistance]");
            config.addCustomCategoryComment("more_config", "explosion-Whether the resulting explosion damaged the terrain");
            TowerDimension = config.get(CATEGORY_Tower, "TowerDimension", TowerDimension, "").getStringList();
            TowerBiome = config.get(CATEGORY_Tower, "TowerBiome", TowerBiome, "").getStringList();
            dimMinDistanceBetweenTowers = config.get(CATEGORY_Tower, "dimMinDistanceBetweenTowers", dimMinDistanceBetweenTowers, "").getStringList();
            explosion = config.get(CATEGORY_MORE_CONFIG, "explosion", explosion, "").getBoolean();
            hasloottable = config.get(CATEGORY_MORE_CONFIG, "hasloottable", hasloottable, "").getBoolean();
        } catch (Exception var11) {
        } finally {
            config.save();
        }
    }


    public static int getDimDistance(int dimid) {
        Map<Integer, Integer> distanceMap = new HashMap<>();
        int dnum = 0;
        for (String s : dimMinDistanceBetweenTowers) {
            String[] strings = s.split(":");
            if (strings[0].contains("*")) {
                dnum = Integer.valueOf(strings[1]);
            } else {
                distanceMap.put(Integer.valueOf(strings[0]), Integer.valueOf(strings[1]));
            }
        }
        if (distanceMap.get(dimid) == null) {
            return dnum;
        } else {
            return distanceMap.get(dimid);
        }
    }

}
