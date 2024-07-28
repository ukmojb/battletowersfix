package atomicstryker.battletowers.common;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.event.entity.living.LivingDestroyBlockEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Iterator;


public class EventHandler
{
    private long time;
    
    public EventHandler()
    {
        time = System.currentTimeMillis();
    }


    @SubscribeEvent
    public void onTick(TickEvent.WorldTickEvent tick)
    {
        if (System.currentTimeMillis() > time + 1000L) // its a one second timer OMFG
        {
            time = System.currentTimeMillis();
            Iterator<AS_TowerDestroyer> iter =  AS_BattleTowersCore.getTowerDestroyers().iterator();
            while(iter.hasNext())
            {
                AS_TowerDestroyer td = iter.next();
                if (td.isFinished())
                {
                    iter.remove();
                }
                else
                {
                    td.update();
                }
            }
        }
    }

}
