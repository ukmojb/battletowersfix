package atomicstryker.battletowers.common;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.Level;

public class CommandDeleteAllBattleTowers extends CommandBattleTowers
{

    @Override
    public String getName()
    {
        return "deleteallbattletowers";
    }

    @Override
    public String getUsage(ICommandSender icommandsender)
    {
        return "/deleteallbattletowers deletes all existing Battletowers, as logged in save file";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender icommandsender, String[] astring)
    {
        WorldGenHandler.deleteAllTowers(icommandsender.getEntityWorld(), false);
        AS_BattleTowersCore.LOGGER.log(Level.INFO, icommandsender.getName() + ": All Battletowers deleted");
    }

}
