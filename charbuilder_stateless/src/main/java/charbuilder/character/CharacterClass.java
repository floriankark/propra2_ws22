package charbuilder.character;

import java.util.HashMap;
import java.util.Map;

public enum CharacterClass {
  WARRIOR("Warrior", 2, -1, 2, -1, -1, -1),
  WIZARD("Wizard", -2, -1, -2, 2, 2, 1),
  ASSASSIN("Assassin", -1, 2, -1, 0, 0, 0);

  private Map<String, Integer> attributes = new HashMap<>();

  private final String text;

  CharacterClass(String text, int strength, int dexterity, int constitution,
                 int intelligence, int wisdom,
                 int charisma) {
    this.text = text;
    setAttribute("Strength", strength);
    setAttribute("Dexterity", dexterity);
    setAttribute("Constitution", constitution);
    setAttribute("Intelligence", intelligence);
    setAttribute("Wisdom", wisdom);
    setAttribute("Charisma", charisma);
  }



  private void setAttribute(String name, Integer value) {
    attributes.put(name, value);
  }

  public Integer getBonus(String name) {
    return attributes.getOrDefault(name, 0);
  }

  public String getText() {
    return text;
  }
}
