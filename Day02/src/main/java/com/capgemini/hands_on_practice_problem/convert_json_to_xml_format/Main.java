package com.capgemini.hands_on_practice_problem.convert_json_to_xml_format;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/capgemini/hands_on_practice_problem/convert_json_to_xml_format/sample_data.json"; // Path to your JSON file

        String xml = Converter.convertJsonFileToXml(filePath);
        System.out.println("Converted XML:");
        System.out.println(xml);
    }
}
