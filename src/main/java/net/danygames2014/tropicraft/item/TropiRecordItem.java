package net.danygames2014.tropicraft.item;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.client.item.CustomTooltipProvider;
import net.modificationstation.stationapi.api.template.item.TemplateMusicDiscItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class TropiRecordItem extends TemplateMusicDiscItem implements CustomTooltipProvider {
    public String jukeboxMessage;

    public TropiRecordItem(Identifier identifier, String sound, String jukeboxMessage) {
        super(identifier, sound);
        this.jukeboxMessage = jukeboxMessage;
    }

    @Override
    public String[] getTooltip(ItemStack itemStack, String originalTooltip) {
        if (Tropicraft.OTHER_CONFIG.enableModernMusicDiscTooltips) {
            return new String[]{"§b" + I18n.getTranslation("item.record.name"), "§7" + jukeboxMessage};
        } else {
            return new String[]{originalTooltip};
        }
    }
}
