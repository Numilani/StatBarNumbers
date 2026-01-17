package me.numilani.statbarnumbers;

import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;

import javax.annotation.Nonnull;

public class Main extends JavaPlugin {

  public static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

  public Main(@Nonnull JavaPluginInit init) {
    super(init);
  }

  @Override
  protected void setup() {
    super.setup();
    this.getEntityStoreRegistry().registerSystem(new StatUiUpdateTickingSystem());
  }

}
