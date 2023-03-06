package charbuilder.character;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class CharacterInfo {

  private String name;
  private CharacterClass characterclass;

  public static final Set<String> ATTRIBUTES =
      Set.of("Strength", "Dexterity", "Constitution",
          "Intelligence", "Wisdom", "Charisma");

  private Map<String, Integer> attributes = new HashMap<>();
  private int points = -1;

  public CharacterInfo(String name) {
    this.name = name;
  }

  public Integer getAttribute(String name) {
    return attributes.getOrDefault(name, 0);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CharacterClass getCharacterclass() {
    return characterclass;
  }

  public void setAttribute(String name, Integer value) {
    if (!ATTRIBUTES.contains(name)) {
      throw new IllegalArgumentException("Unknown Attribute: " + name);
    }
    attributes.put(name, value);
  }

  public void setCharacterClass(CharacterClass characterclass) {
    this.characterclass = characterclass;
    Random r = new Random();
    int points = r.nextInt(-4, 5);
    setPoints(30 + points);
    setAttribute("Strength", minPoints("Strength"));
    setAttribute("Dexterity", minPoints("Dexterity"));
    setAttribute("Constitution", minPoints("Constitution"));
    setAttribute("Intelligence", minPoints("Intelligence"));
    setAttribute("Wisdom", minPoints("Wisdom"));
    setAttribute("Charisma", minPoints("Charisma"));
  }

  public void setPoints(int points) {
    this.points = points;
  }

  public int getPoints() {
    return points;
  }

  public int minPoints(String attribute) {
    int bonus = characterclass.getBonus(attribute);
    if (bonus > 0) return 0;
    return 1 - bonus;
  }

  public boolean isValid() {
    int sum = ATTRIBUTES.stream().mapToInt(k -> attributes.get(k)).sum();
    if (sum != points) return false;
    long tolow = ATTRIBUTES.stream().mapToInt(k -> attributes.get(k) + characterclass.getBonus(k))
        .filter(p -> p < 1).count();
    if (tolow != 0) return false;
    return true;
  }

  @Override
  public String toString() {
    return "CharacterInfo{" +
        "name='" + name + '\'' +
        ", characterclass=" + characterclass +
        ", attributes=" + attributes +
        ", points=" + points +
        '}';
  }
}
