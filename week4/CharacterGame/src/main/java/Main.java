import characters.Character;
import characters.CharacterFactory;
import characters.GameManager;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

    // contains all the characters of the current game
    public static ArrayList<Character> characters = new ArrayList<>();

    // determines the size of current game
    private static int numberOfCharacters = 3;
    public void setNumberOfCharacters(int numberOfCharacters) { this.numberOfCharacters = numberOfCharacters; }

    // randomizer to choose an appropriate character
    private static Random random = new Random();

    // game manager creation
    private static GameManager gm = new GameManager();

    public static void InitGameField() {
        for (int i = 0; i < numberOfCharacters; i++) {
            Character newChar;
            try {
                newChar = CharacterFactory.createCharacter();
            } catch (Exception ex) {
                System.out.println(String.format(
                        "Could not initialise the game: %s",
                        ex.toString()));
                return;
            }
            characters.add(newChar);
        }
    }

    public static boolean SomeCharactersAlive() {
        int numOfAlive = 0;
        for (Character ch : characters) {
            numOfAlive += ch.isAlive() ? 1 : 0;
        }

        if (numOfAlive < 2) {
            return false;
        }

        return true;
    }

    public static void SomeCharactersFight () {
        int firstIdx = random.nextInt(characters.size());
        int secondIdx = firstIdx;
        while (secondIdx == firstIdx) {
            secondIdx = random.nextInt(characters.size());
        }

        Character fc = characters.get(firstIdx);
        Character sc = characters.get(secondIdx);
        // this will print out all the information on the game
        gm.fight(fc, sc);

        if (!fc.isAlive()) {
            System.out.println("Sadly, but the first character has died...\n");
            characters.remove(firstIdx);
        }

        if (!sc.isAlive()) {
            System.out.println("Sadly, but the second character has died...\n");
            characters.remove(secondIdx);
        }
    }

    public static void main(String[] args) {
        InitGameField();
        System.out.println("GAME HAS STARTED");
        System.out.println(characters.toString());
        System.out.println("------------------------\n");

        while (SomeCharactersAlive()) {
            SomeCharactersFight();
        }

        System.out.println("Game has come to an end...\n Too few heroes are left alive. "
                            + "They will create the future of this world");
        System.out.println(characters.toString());
    }
}
