package xyz.luisch444.carpet;

import carpet.api.settings.CarpetRule;
import carpet.api.settings.Rule;
import carpet.api.settings.Validator;
import net.minecraft.server.command.ServerCommandSource;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

import static carpet.api.settings.RuleCategory.*;

public class HostingluischSettings {
    public static final String HOST = "Hostingluisch";

    public static final String COPRA = "CopraHacks";

    @Rule(categories = { HOST, SURVIVAL, FEATURE})
    public static boolean deepslateInstaminable = false;

    @Rule(categories = { HOST, SURVIVAL, FEATURE})
    public static boolean endstoneInstaminable = false;

    @Rule(categories = { HOST, SURVIVAL, CREATIVE, OPTIMIZATION})
    public static boolean endermanNoGrief = false;

//    @Rule(desc = "Allows always endermans picks the blocks in the list", category = { HOST, SURVIVAL, CREATIVE, OPTIMIZATION})
//    public static List<Block> allowEndermansPick = Arrays.asList(Blocks.PUMPKIN, Blocks.MELON);

    @Rule(categories = { HOST, SURVIVAL, CREATIVE})
    public static boolean villagersNoGenerateGolems = false;

    @Rule(categories = { HOST, SURVIVAL, FEATURE})
    public static boolean stackeableTotems = false;
    @Rule(options = {"16", "64", "8"},
            strict = false,
            categories = { HOST, SURVIVAL, FEATURE})
    public static int stackeableTotemsSize = 16;

    @Rule(categories = {HOST, CREATIVE, FEATURE, EXPERIMENTAL})
    public static boolean isHalloween = false;

    @Rule(categories = {HOST, CREATIVE, FEATURE})
    public static boolean enderPearlsNoCooldown = false;

    @Rule(categories = {HOST, CREATIVE, FEATURE, COPRA})
    public static boolean squidsNoSpawn = false;

    private static final String[] carefulBreakOptions = new String[] { "never", "always", "sneaking", "no-sneaking" };
    @Rule(categories = { SURVIVAL, FEATURE, EXPERIMENTAL, HOST },
            options = { "never", "always", "sneaking", "no-sneaking" },
            validators = carefulBreakValidator.class
    )
    public static String carefulBreak = "never";

    private static class carefulBreakValidator extends Validator<String> {

        @Override
        public String validate(@Nullable ServerCommandSource source, CarpetRule<String> changingRule, String newValue, String userInput) {
            if ((source == null || changingRule.name().equals(newValue)) && Arrays.asList(carefulBreakOptions).contains(newValue))
                carefulBreak = newValue;
            return newValue;
        }
    }

}
