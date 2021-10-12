package characters;

import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/*
 * - Class CharacterFactory
 *      - Character createCharacter() -- returns random instance of any exisisting character
 */
public class CharacterFactory {
    public static Character createCharacter() throws InstantiationException, IllegalAccessException {
        Reflections reflections = new Reflections("characters");
        Set<Class<? extends Character>> characters = reflections.getSubTypesOf(Character.class);
        List<Class<? extends Character>> charactersClasses = new ArrayList<>(characters);
        return charactersClasses.get(new Random().nextInt(characters.size())).newInstance();
    }
}
