package charbuilder.web;

import charbuilder.character.CharacterClass;
import charbuilder.character.CharacterInfo;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"character"})
public class CreationController {

  @ModelAttribute("character")
  public CharacterInfo getCharacter() {
    return new CharacterInfo("initalName");
  }

  @GetMapping("/")
  public String index() {
    return "start";
  }

  @GetMapping("/create/1")
  public String createNameForm() {
    return "name";
  }

  @PostMapping("/create/1")
  public String createStep1(String charactername, @ModelAttribute("character") CharacterInfo character) {
    character.setName(charactername);
    if (charactername == null || charactername.isBlank()) return "redirect:/create/1";
    return "redirect:/create/2";
  }

  @GetMapping("/create/2")
  public String createClassForm(@ModelAttribute("character") CharacterInfo character, Model m) {
    m.addAttribute("character", character);
    return "class";
  }

  @PostMapping("/create/2")
  public String createStep3(CharacterClass characterclass) {
    CharacterInfo character = new CharacterInfo("Laime Jannister");
    character.setCharacterClass(CharacterClass.WARRIOR);

    return
        "redirect:/create/3";
  }

  @GetMapping("/create/3")
  public String createAttributeForm(Model m) {
    CharacterInfo character = new CharacterInfo("Laime Jannister");
    character.setCharacterClass(CharacterClass.WARRIOR);
    m.addAttribute("character", character);
    return "attributes";
  }

  @PostMapping("/create/3")
  public String createStep3(Model m,
                            @RequestParam("Strength") int str,
                            @RequestParam("Dexterity") int dex,
                            @RequestParam("Constitution") int con,
                            @RequestParam("Intelligence") int intl,
                            @RequestParam("Wisdom") int wis,
                            @RequestParam("Charisma") int cha) {

    // Character fertigstellen und validieren

    // Fehler: Formular wieder anzeigen, Werte müssen erhalten bleiben

    // Erfolg: Ausgabe der Spielerinformationen auf der Konsole und zurück zur Startseite

    return "redirect:/";
  }


}
