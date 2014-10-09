package com.vjia.test.transientTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationExampleMain {

    public static void main(String[] args) throws ClassNotFoundException {
        
        // Create a student and populate the fields.
        Student student = new Student("Bill", 20, 8, "No comments from me!");
        System.out.println("Before serialization:\n\t" + student.toString());
        
        
        // Serialization of the object.
        try {
            FileOutputStream file = new FileOutputStream("student.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(student);
           
            System.out.printf("\nStudent serialized and saved.\n\n");
           
            out.close();
            file.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        
        // Deserialization of the object.
        try {
            FileInputStream file = new FileInputStream("student.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            Student st = (Student) in.readObject();
            
            System.out.println("After serialization:\n\t" + st.toString());
            
            in.close();
            file.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}