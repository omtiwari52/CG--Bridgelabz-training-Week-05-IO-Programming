package com.capgemini.hands_on_practice_problem.merge_two_json;

public class Main {
    public static void main(String[] args) {
        String file1 = "src/main/java/com/capgemini/hands_on_practice_problem/merge_two_json/file1.json";
        String file2 = "src/main/java/com/capgemini/hands_on_practice_problem/merge_two_json/file2.json";

        MergeJsonFiles.mergeJsonFiles(file1, file2);
    }
}
