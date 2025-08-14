package com.dsa;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BinaryNodeService {

    @Autowired
    private TreeStructureRepository treeStructureRepository;

    private Gson gson = new Gson();

    public BinaryNode buildTree(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return null;
        }

        BinarySearchTree bst = new BinarySearchTree();
        
        for (Integer number : numbers) {
            bst.insert(number);
        }

        BinaryNode root = bst.getRoot();
        
        saveTreeStructure(numbers, root);
        
        return root;
    }

    private void saveTreeStructure(List<Integer> numbers, BinaryNode root) {
        try {
            String treeJson = gson.toJson(root);
            
            String userInputs = numbers.toString();
            
            TreeStructure treeStructure = new TreeStructure(treeJson, userInputs);
            treeStructureRepository.save(treeStructure);
            
        } catch (Exception e) {
            System.err.println("Error saving tree structure: " + e.getMessage());
        }
    }

    public List<TreeStructure> getPreviousTreeJson() {
        return treeStructureRepository.findAll();
    }

    public TreeStructure getTreeById(Long id) {
        return treeStructureRepository.findById(id).orElse(null);
    }

    public void deleteTree(Long id) {
        treeStructureRepository.deleteById(id);
    }

    public void clearAllTrees() {
        treeStructureRepository.deleteAll();
    }
}
