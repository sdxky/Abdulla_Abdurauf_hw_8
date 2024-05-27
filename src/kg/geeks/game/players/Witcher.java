package kg.geeks.game.players;

public class Witcher extends Hero {
    private boolean hasRevived = false;

    public Witcher(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.HEAL);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (!hasRevived) {
            for (Hero hero : heroes) {
                if (hero != null && hero.getHealth() <= 0) {
                    hero.setHealth(hero.getHealth() + this.getHealth());
                    this.setHealth(0);
                    hasRevived = true;
                    System.out.println(this.getName() + " sacrificed himself to revive " + hero.getName());
                    break;
                }
            }
        }
    }
}
