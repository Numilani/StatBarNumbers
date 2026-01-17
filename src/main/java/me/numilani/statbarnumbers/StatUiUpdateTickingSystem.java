package me.numilani.statbarnumbers;

import com.hypixel.hytale.component.ArchetypeChunk;
import com.hypixel.hytale.component.CommandBuffer;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.component.query.Query;
import com.hypixel.hytale.component.system.tick.EntityTickingSystem;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.modules.entitystats.EntityStatMap;
import com.hypixel.hytale.server.core.modules.entitystats.asset.DefaultEntityStatTypes;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

public class StatUiUpdateTickingSystem extends EntityTickingSystem<EntityStore> {

  @Override
  public Query<EntityStore> getQuery() {
    return Query.and(Player.getComponentType());
  }

  @Override
  public void tick(float dt, int index, ArchetypeChunk<EntityStore> archetypeChunk, Store<EntityStore> store,
      CommandBuffer<EntityStore> commandBuffer) {

    var player_entity_ref = archetypeChunk.getReferenceTo(index);

    Player player = store.getComponent(player_entity_ref, Player.getComponentType());
    PlayerRef playerRef = store.getComponent(player_entity_ref, PlayerRef.getComponentType());
    EntityStatMap stats = store.getComponent(player_entity_ref, EntityStatMap.getComponentType());
    if (player == null || playerRef == null)
      return;

    player.getHudManager().setCustomHud(playerRef, new HpNumbersHud(
        playerRef,
        (int) stats.get(DefaultEntityStatTypes.getHealth()).get(),
        (int) stats.get(DefaultEntityStatTypes.getHealth()).getMax(),
        (int) stats.get(DefaultEntityStatTypes.getStamina()).get(),
        (int) stats.get(DefaultEntityStatTypes.getStamina()).getMax()));
  }

}
