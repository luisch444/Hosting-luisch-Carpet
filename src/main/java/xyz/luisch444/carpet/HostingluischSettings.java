package xyz.luisch444.carpet;

import carpet.settings.ParsedRule;
import carpet.settings.Rule;
import carpet.settings.RuleCategory;
import carpet.settings.Validator;
import net.minecraft.server.command.ServerCommandSource;

import java.util.Arrays;

import static carpet.settings.RuleCategory.*;

public class HostingluischSettings {
    public static final String HOST = "Hosting-luisch";
    public static final String EpsilonCarpetSettingsCategory = "epsilon-carpet";

    @Rule(desc = "DeepSlate have the same hardness that stone", category = { HOST, SURVIVAL, FEATURE})
    public static boolean deepSlateInstaminable = false;

    @Rule(desc = "EndStone have the same hardness that stone", category = { HOST, SURVIVAL, FEATURE})
    public static boolean endStonelessHardness = false;

    @Rule(desc = "Endermans not tries to pick any block", category = { HOST, SURVIVAL, CREATIVE, OPTIMIZATION})
    public static boolean endermanNoGrief = false;

    @Rule(desc = "Disable generation of iron golems by villagers", category = { HOST, SURVIVAL, CREATIVE})
    public static boolean villagersNoGenerateGolems = false;

    @Rule(desc = "Totems can be stackeable", category = { HOST, SURVIVAL, FEATURE})
    public static boolean stackeableTotems = false;
    @Rule(desc = "Limit the amount of stacking in the rule stackeableTotems",
            options = {"16", "64", "8"},
            strict = false,
            category = { HOST, SURVIVAL, FEATURE})
    public static int stackeableTotemsSize = 16;

    /*
    * ----------------------------------------------------------------------------
    * part of epsilon carpet https://github.com/EpsilonSMP/Epsilon-Carpet
    *
    * */
    private static final String[] carefulBreakOptions = new String[] { "never", "always", "sneaking", "no-sneaking" };
    @Rule(
            desc = "Places the mined block in the player inventory when sneaking.",
            category = { EpsilonCarpetSettingsCategory, SURVIVAL, FEATURE, EXPERIMENTAL, HOST },
            options = { "never", "always", "sneaking", "no-sneaking" },
            validate = { carefulBreakValidator.class }
    )
    public static String carefulBreak = "never";

    private static class carefulBreakValidator extends Validator<String> {

        @Override
        public String validate(ServerCommandSource serverCommandSource, ParsedRule<String> parsedRule, String s, String s2) {
            if ((serverCommandSource == null || parsedRule.get().equals(s)) && Arrays.asList(carefulBreakOptions).contains(s))
                carefulBreak = s;
            return s;
        }
    }
    /*
    *
    * finish of epsilon carpet https://github.com/EpsilonSMP/Epsilon-Carpet
    * ----------------------------------------------------------------------------
    * */


}
