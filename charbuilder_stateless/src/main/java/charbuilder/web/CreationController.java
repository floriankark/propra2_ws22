package charbuilder.web;

import charbuilder.character.CharacterClass;
import charbuilder.character.CharacterInfo;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CreationController {


  @GetMapping("/")
  public String index() {
    return "start";
  }

  @GetMapping("/create/1")
  public String createNameForm() {
    return "name";
  }

  @PostMapping("/create/1")
  public String createStep1(String charactername, RedirectAttributes attributes) {
    attributes.addAttribute("charactername", charactername);
    if (charactername == null || charactername.isBlank()) {
      return "redirect:/create/1";
    }
    //System.out.println(m.getAttribute("charactername"));
    return "redirect:/create/2";
  }

  @GetMapping("/create/2")
  public String createClassForm(@ModelAttribute("character") CharacterInfo character,
                                @RequestParam("charactername") String charactername) {
    character.setName(charactername);
    return "class";
  }

  @PostMapping("/create/2")
  public String createStep3(@ModelAttribute("character") CharacterInfo character,
                            @RequestParam("characterclass") CharacterClass characterclass,
                            RedirectAttributes attributes) {
    attributes.addAttribute("charactername", character.getName());

    character.setCharacterClass(characterclass);
    attributes.addAttribute("characterclass", character.getCharacterclass());
    return
        "redirect:/create/3";
  }

  @GetMapping("/create/3")
  public String createAttributeForm(@ModelAttribute("character") CharacterInfo character,
                                    @RequestParam("charactername") String charactername,
                                    @RequestParam("characterclass") CharacterClass characterclass) {
    character.setName(charactername);
    character.setCharacterClass(characterclass);
    return "attributes";
  }

  @PostMapping("/create/3")
  public String createStep3(@ModelAttribute("character") CharacterInfo character,
                            @RequestParam("Strength") int str,
                            @RequestParam("Dexterity") int dex,
                            @RequestParam("Constitution") int con,
                            @RequestParam("Intelligence") int intl,
                            @RequestParam("Wisdom") int wis,
                            @RequestParam("Charisma") int cha,
                            @RequestParam("charactername") String charactername,
                            @RequestParam("characterclass") CharacterClass characterclass,
                            @RequestParam("points") int points){

    // Character fertigstellen und validieren
    character.setCharacterClass(characterclass);

    character.setAttribute("Strength", str);
    character.setAttribute("Dexterity", dex);
    character.setAttribute("Constitution", con);
    character.setAttribute("Intelligence", intl);
    character.setAttribute("Wisdom", wis);
    character.setAttribute("Charisma", cha);

    character.setName(charactername);
    character.setPoints(points);
    // Fehler: Formular wieder anzeigen, Werte müssen erhalten bleiben
    if (!character.isValid()){
      return "attributes";
    }

    // Erfolg: Ausgabe der Spielerinformationen auf der Konsole und zurück zur Startseite
    System.out.println(character.toString());
    return "redirect:/";
  }


}
