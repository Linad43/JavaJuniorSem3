package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sun.jdi.request.StepRequest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOStudent {
    public static final String FILE_JSON = "IOS.json";
    public static final String FILE_XML = "IOS.xml";
    public static final String FILE_BIN = "IOS.bin";

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();


    public static List<Student> outFile(String fileName){
        List<Student> result = new ArrayList<>();
        File file = new File(fileName);

        try{
            if (file.exists()) {
                if (fileName.endsWith(".json")) {
                    result = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
                } else if (fileName.endsWith(".bin")) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                        result = (List<Student>) ois.readObject();
                    }
                }
                else if (fileName.endsWith(".xml")) {
                    result = xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
                }
            }
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return result;
    }

    public static void inFile(String fileName, List<Student> student) {
        try {
            if (fileName.endsWith(".json")) {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(fileName), student);
            } else if (fileName.endsWith(".bin")) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                    oos.writeObject(student);
                }
            }
            else if (fileName.endsWith(".xml")) {
                xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                xmlMapper.writeValue(new File(fileName), student);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
