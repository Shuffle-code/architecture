package org.example;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RequestMapping("/tour")
@Controller
public class GreetingController {

    private final ModelMvc modelMvc;
    @GetMapping
    public String greeting(org.springframework.ui.Model model) {
        CountGame countGame = new CountGame();
        model.addAttribute("countGame", countGame);
        return "tour-form";
    }

    @PostMapping("/count")
    public String saveCount(CountGame countGame, @RequestBody String body) {
        modelMvc.save(countGame);
        System.out.println("! : " + body);
        return "redirect:/tour";
    }
}