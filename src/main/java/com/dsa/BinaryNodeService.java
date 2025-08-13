package com.dsa;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BinaryNodeService {

    @Autowired
    private BinaryNodeRepository binaryNodeRepository;

    @Autowired
    private TreeStructureRepository treeStructureRepository;

    private Gson gson = new Gson();

    // Build a BST from a list of numbers
    public BinaryNode buildTree(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return null;
        }

        BinarySearchTree bst = new BinarySearchTree();
        
        // Insert each number into the BST
        for (Integer number : numbers) {
            bst.insert(number);
        }

        // Get the root node
        BinaryNode root = bst.getRoot();
        
        // Save the tree structure to database
        saveTreeStructure(numbers, root);
        
        return root;
    }

    // Save tree structure and input numbers to database
    private void saveTreeStructure(List<Integer> numbers, BinaryNode root) {
        try {
            // Convert tree to JSON string
            String treeJson = gson.toJson(root);
            
            // Convert numbers list to string
            String userInputs = numbers.toString();
            
            // Create and save TreeStructure
            TreeStructure treeStructure = new TreeStructure(treeJson, userInputs);
            treeStructureRepository.save(treeStructure);
            
        } catch (Exception e) {
            // Log error but don't fail the main operation
            System.err.println("Error saving tree structure: " + e.getMessage());
        }
    }

    // Get all previous trees from database
    public List<TreeStructure> getPreviousTreeJson() {
        return treeStructureRepository.findAll();
    }

    // Get a specific tree by ID
    public TreeStructure getTreeById(Long id) {
        return treeStructureRepository.findById(id).orElse(null);
    }

    // Delete a specific tree
    public void deleteTree(Long id) {
        treeStructureRepository.deleteById(id);
    }

    // Clear all trees
    public void clearAllTrees() {
        treeStructureRepository.deleteAll();
    }
}
