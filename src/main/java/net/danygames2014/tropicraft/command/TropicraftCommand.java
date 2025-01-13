package net.danygames2014.tropicraft.command;

import com.matthewperiut.retrocommands.api.Command;
import com.matthewperiut.retrocommands.util.SharedCommandSource;
import net.danygames2014.tropicraft.Tropicraft;
import net.danygames2014.tropicraft.world.dimension.TropicsTravelAgent;
import net.modificationstation.stationapi.api.world.dimension.DimensionHelper;

import java.util.ArrayList;

@SuppressWarnings("SwitchStatementWithTooFewBranches")
public class TropicraftCommand implements Command {

    @Override
    public void command(SharedCommandSource sharedCommandSource, String[] args) {
        if (args.length > 1) {
            if (args[1].equalsIgnoreCase("drift")) {
                DimensionHelper.switchDimension(
                        sharedCommandSource.getPlayer(),
                        Tropicraft.NAMESPACE.id("tropics"),
                        1,
                        new TropicsTravelAgent()
                );
            }
        }
    }

    @Override
    public String name() {
        return "tropicraft";
    }

    @Override
    public String[] suggestion(SharedCommandSource source, int parameterNum, String currentInput, String totalInput) {
        String[] possibleSuggestions;
        
        switch (parameterNum) {
            case 1 -> {
                possibleSuggestions = new String[] { "drift" };
            }

            default -> {
                possibleSuggestions = new String[0];
            }
        }

        ArrayList<String> suggestions = new ArrayList<>();
        for (String suggestion : possibleSuggestions) {
            if (suggestion.startsWith(currentInput)) {
                suggestions.add(suggestion.substring(currentInput.length()));
            }
        }

        return suggestions.toArray(new String[0]);
        
    }

    @Override
    public void manual(SharedCommandSource sharedCommandSource) {
        sharedCommandSource.sendFeedback("Usage: /tropicraft drift");
    }

    @Override
    public boolean needsPermissions() {
        return true;
    }
}
