package me.numilani.statbarnumbers;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.entities.player.hud.CustomUIHud;
import com.hypixel.hytale.server.core.ui.builder.UICommandBuilder;
import com.hypixel.hytale.server.core.universe.PlayerRef;

public class HpNumbersHud extends CustomUIHud{

  int Hp;
  int MaxHp;
  int Stamina;
  int MaxStamina;

  public HpNumbersHud(PlayerRef playerRef, int hp, int maxHp, int stamina, int maxStamina) {
    super(playerRef);
    Hp = hp;
    MaxHp = maxHp;
    Stamina = stamina;
    MaxStamina = maxStamina;
  }


  @Override
  protected void build(UICommandBuilder uiCmdBuilder) {
    uiCmdBuilder.append("Hud/hpNumbers.ui");
    uiCmdBuilder.set("#HpStatCurrent.TextSpans", Message.raw(Integer.toString(Hp)));
    uiCmdBuilder.set("#HpStatMax.TextSpans", Message.raw(Integer.toString(MaxHp)));
    uiCmdBuilder.set("#StaminaStatCurrent.TextSpans", Message.raw(Integer.toString(Stamina)));
    uiCmdBuilder.set("#StaminaStatMax.TextSpans", Message.raw(Integer.toString(MaxStamina)));
  }

}
