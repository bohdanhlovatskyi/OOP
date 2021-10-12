/* Heroes game in text mode
 *
 * TODO:
 * - Propose a solution to separate characters and their kick strategies
 * to allow more easier creation of new characters in future.
 * -  How did you implement createCharacter?
 * Can we improve code and extract subclasses of Character on a flight? Use reflections.
 */
package characters;

import java.util.Random;

interface Kickable {
    void kick(Character c);
}

/*
 * - Class Hobbit:
 *      - power=0,
 *      - hp=3,
 *      - kick(toCry())
 */
class Hobbit extends Character {

    public Hobbit() { super(0, 3); }

    public void kick(Character c) {
        if (this.getClass().equals(c.getClass())) {
            return;
        }
        toCry();
    }

    private void toCry() { System.out.println("Hobbit cannot kill someone else..."); }
}


/*
 * - Class Elf:
 *      - power=10,
 *      - hp=10,
 *      - kick(kill everybody weaker than him, otherwise decrease the power of character by 1)
 */
class Elf extends Character {

    public Elf() {
        super(10, 10);
    }

    public void kick(Character c) {
        if (this.getClass().equals(c.getClass())) {
            return;
        }

        if (c.getPower() < this.getPower()) {
            c.die();
        } else {
            this.setPower(this.getPower() - 1);
        }
    }
}


/*
 * - Class King:
 *      - power=5-15,
 *      - hp=5-15,
 *      - kick(decrease number of hp of the enemy by random number which will be in the range of his power)
 */
class King extends Character {
    private static Random random = new Random();
    // max and min values for both hp and power of the character
    protected static int min = 5;
    protected static int max = 15;

    public King() {
        super(random.nextInt(max - min) + min, random.nextInt(max - min) + min);
    }

    public void kick(Character c) {
        if (this.getClass().equals(c.getClass())) {
            return;
        }

        c.setHp(c.getHp() - random.nextInt(this.getPower()));
    }
}

/*
 * - Class Knight:
 *      - power=2-12,
 *      - hp=2-12,
 *      - kick(like King)
 */
class Knight extends King {
    protected static int min = 2;
    protected static int max = 12;

    public Knight() {
        super();
    }
}