package characters;

/*
 * - Class Character:
 *      - int power
 *      - in hp,
 *
 *      - void kick(Character c),
 *      -  boolean isAlive()
 */
public abstract class Character implements Kickable {
    private int power;
    private int hp;

    public Character(int power, int hp) {
        this.power = power;
        this.hp = hp;
    }

    public boolean isAlive() { return hp > 0; }

    public void setHp(int hp) { this.hp = hp; }

    public int getHp() { return this.hp; }

    public int getPower() { return this.power; }

    protected void setPower(int power) {
        if (power < 0) {
            power = 0;
        }
        this.power = power;
    }

    public void die() { this.hp = 0; }

    @Override
    public String toString() {
        String className = this.getClass().getSimpleName();
        return String.format("%s(hp: %d, power: %d)",
                className, this.hp, this.power);
    }
}
