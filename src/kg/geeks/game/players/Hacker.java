package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;  // Добавляем импорт

public class Hacker extends Hero {
    private int stealAmount;

    public Hacker(int health, int damage, String name, int stealAmount) {
        super(health, damage, name, SuperAbility.STEAL_HEALTH);
        this.stealAmount = stealAmount;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (RPG_Game.roundNumber % 2 == 0) {
            int bossHealth = boss.getHealth() - stealAmount;
            if (bossHealth < 0) bossHealth = 0;
            boss.setHealth(bossHealth);

            Hero targetHero = heroes[(int) (Math.random() * heroes.length)];
            targetHero.setHealth(targetHero.getHealth() + stealAmount);

            System.out.println(this.getName() + " stole " + stealAmount + " health from the Boss and gave it to " + targetHero.getName());
        }
    }
}
