package xyz.luisch444.carpet;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.api.ModInitializer;
import net.minecraft.server.command.ServerCommandSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class HostingluischServer implements CarpetExtension, ModInitializer {

    public static Logger LOGGER = LogManager.getLogger("hosting-luisch");
    public static String compactName = "hosting-luisch";

    @Override
    public String version() {
        return compactName;
    }

    public static void loadExtension(){
        CarpetServer.manageExtension(new HostingluischServer());
    }

    @Override
    public void onInitialize() {
        HostingluischServer.loadExtension();
    }

    @Override
    public void onGameStarted(){
        CarpetServer.settingsManager.parseSettingsClass(HostingluischSettings.class);
    }

    @Override
    public void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher) {
        //commandclass.register(dispatcher);
    }

}
