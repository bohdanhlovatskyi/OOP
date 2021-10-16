package characters;

// import org.reflections.Reflections;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;

/*
 * - Class CharacterFactory
 *      - Character createCharacter() -- returns random instance of any existing character
 */
public class CharacterFactory {
    public static Character createCharacter() throws InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        // Reflections reflections = new Reflections("characters");
        // Set<Class<? extends Character>> characters = reflections.getSubTypesOf(Character.class);
        // List<Class<? extends Character>> charactersClasses = new ArrayList<>(characters);
        List<Class> charactersClasses;
        try {
            charactersClasses = loadAllSubClasses(Character.class);
        } catch (Exception ex) {
            System.out.println(ex);
            throw ex;
        }

        return (Character) charactersClasses.get(new Random().nextInt(charactersClasses.size())).newInstance();
    }

    // https://stackoverflow.com/questions/492184/how-do-you-find-all-subclasses-of-a-given-class-in-java
    public static List<Class> loadAllSubClasses(Class pClazz) throws IOException, ClassNotFoundException, IOException {
        ClassLoader classLoader = pClazz.getClassLoader();
        assert classLoader != null;
        String packageName = pClazz.getPackage().getName();
        String dirPath = packageName.replace(".", "/");
        Enumeration<URL> srcList = classLoader.getResources(dirPath);

        List<Class> subClassList = new ArrayList<>();
        while (srcList.hasMoreElements()) {
            File dirFile = new File(srcList.nextElement().getFile());
            File[] files = dirFile.listFiles();
            if (files != null) {
                for (File file : files) {
                    String subClassName = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                    if (! subClassName.equals(pClazz.getName())) {
                        subClassList.add(Class.forName(subClassName));
                    }
                }
            }
        }

        return subClassList;
    }
}
