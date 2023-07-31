package xyz.luisch444.carpet;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import carpet.utils.Translations;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;


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
    public Map<String, String> canHasTranslations(String lang)
    {
        return Translations.getTranslationFromResourcePath("assets/hostingluisch/lang/" + lang + ".json");
    }


}
