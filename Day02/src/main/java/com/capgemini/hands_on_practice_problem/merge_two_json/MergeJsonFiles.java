package com.capgemini.hands_on_practice_problem.merge_two_json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class MergeJsonFiles {

    // Method to merge two JSON files
    public static JsonNode mergeJsonFiles(String filePath1, String filePath2) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON files into JsonNode
            JsonNode jsonNode1 = objectMapper.readTree(new File(filePath1));
            JsonNode jsonNode2 = objectMapper.readTree(new File(filePath2));

            // Merge JSON objects
            JsonNode mergedNode = mergeJsonNodes(jsonNode1, jsonNode2);
            System.out.println("Merged JSON: \n" + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedNode));

            return mergedNode;

        } catch (IOException e) {
            throw new RuntimeException("Error merging JSON files: " + e.getMessage());
        }
    }

    // Helper method to merge two JsonNodes
    private static JsonNode mergeJsonNodes(JsonNode node1, JsonNode node2) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode mergedNode = node1.deepCopy();

        // Iterate over node2 and add its fields to node1
        node2.fields().forEachRemaining(entry -> ((com.fasterxml.jackson.databind.node.ObjectNode) mergedNode).set(entry.getKey(), entry.getValue()));

        return mergedNode;
    }
}
