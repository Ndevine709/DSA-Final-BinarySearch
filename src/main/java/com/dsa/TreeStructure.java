package com.dsa;

import jakarta.persistence.*;

@Entity
public class TreeStructure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 5000)
    private String treeJson;

    private String userInputs;

    // Default constructor required by JPA
    public TreeStructure() {
    }

    // Constructor with parameters
    public TreeStructure(String treeJson, String userInputs) {
        this.treeJson = treeJson;
        this.userInputs = userInputs;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTreeJson() {
        return treeJson;
    }

    public void setTreeJson(String treeJson) {
        this.treeJson = treeJson;
    }

    public String getUserInputs() {
        return userInputs;
    }

    public void setUserInputs(String userInputs) {
        this.userInputs = userInputs;
    }

    // Helper method to get formatted user inputs
    public String getFormattedUserInputs() {
        if (userInputs != null && userInputs.startsWith("[") && userInputs.endsWith("]")) {
            return userInputs.substring(1, userInputs.length() - 1);
        }
        return userInputs;
    }

    // Override toString for debugging
    @Override
    public String toString() {
        return "TreeStructure{" +
                "id=" + id +
                ", userInputs='" + userInputs + '\'' +
                ", treeJson='" + (treeJson != null ? treeJson.substring(0, Math.min(100, treeJson.length())) + "..." : "null") + '\'' +
                '}';
    }
}
