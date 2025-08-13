package com.dsa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BinaryNodeController {

    @Autowired
    BinaryNodeService binaryNodeService;

    @GetMapping("/enter-numbers")
    public String showEnterNumbersPage() {
        return "enter-numbers"; 
    }

    @PostMapping("/process-numbers")
    public String processNumbers(@RequestParam("numbers") String numbersInput, Model model) {
        List<Integer> numbers = parseNumbers(numbersInput);
        
        BinaryNode root = binaryNodeService.buildTree(numbers);
        
        model.addAttribute("numbers", numbers);
        model.addAttribute("tree", root);
        model.addAttribute("treeJson", new com.google.gson.Gson().toJson(root));
        
        return "result"; 
    }

    @GetMapping("/previous-trees")
    public String showPreviousTrees(Model model) {
        List<TreeStructure> previousTrees = binaryNodeService.getPreviousTreeJson();
        model.addAttribute("trees", previousTrees);
        return "previous-trees"; 
    }

    private List<Integer> parseNumbers(String input) {
        return java.util.Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(java.util.stream.Collectors.toList());
    }
}
