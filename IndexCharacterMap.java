import java.util.Map;
import java.util.HashMap;

public class IndexCharacterMap {
    private HashMap<Integer, Character> indexToCharacter;
    private HashMap<Character, Integer> characterToIndex;

    public IndexCharacterMap() {
        indexToCharacter = new HashMap<>();
        characterToIndex = new HashMap<>();
        for (int ascii = 65; ascii <= 90; ascii++) {
            indexToCharacter.put(ascii - 65, (char) ascii);
        }
        for (int ascii = 48; ascii <= 57; ascii++) {
            indexToCharacter.put(ascii - 48 + 26, (char) ascii);
        }
        for (int ascii = 40; ascii <= 47; ascii++) {
            indexToCharacter.put(ascii - 40 + 36, (char) ascii);
        }
        for (Map.Entry<Integer, Character> entry : indexToCharacter.entrySet()) {
            characterToIndex.put(entry.getValue(), entry.getKey());
        }
    }

    public boolean containsKey(char key) {
        return characterToIndex.containsKey(key);
    }

    public Integer getIndex(char character) {
        return characterToIndex.get(character);
    }

    public Character getCharacter(int index) {
        return indexToCharacter.get(index);
    }
}