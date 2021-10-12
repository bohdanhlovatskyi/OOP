package characters;
/*
 * - Class GameManager:
 *      - void fight(Character c1, Character c2) to provide fight between to characters
 *      and explain via command line what happens during fight, till both of the characters are alive
 */
public class GameManager {

    public static void fight(Character c1, Character c2) {
        System.out.println(String.format(
                "Fight has started, the fighters are:\n%s\n%s",
                c1.toString(),
                c2.toString()
        ));
        if (c1.isAlive() && c2.isAlive()) {
            c1.kick(c2);
            System.out.println(getState("First", c1, c2)) ;
            if (c1.isAlive() && c2.isAlive()) {
                c2.kick(c1);
                System.out.println(getState("Second", c1, c2));
            }
        }

        System.out.println("Fight has ended...\n");
    }

    private static String getState(String kicked, Character c1, Character c2) {
        return String.format(
                "%s character has kicked, now the state is: \n-- %s\n-- %s",
                kicked,
                c1.toString(),
                c2.toString()
        );
    }
}