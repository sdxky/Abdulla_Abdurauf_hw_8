package kg.geeks.game.players;

public class Magic extends Hero {
    private int boostAmount;

    public Magic(int health, int damage, String name, int boostAmount) {
        super(health, damage, name, SuperAbility.BOOST);
        this.boostAmount = boostAmount;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero != null && hero.getHealth() > 0) {
                hero.setDamage(hero.getDamage() + boostAmount);
                System.out.println(this.getName() + " boosted " + hero.getName() + "'s attack by " + boostAmount);
            }
        }
    }
}
