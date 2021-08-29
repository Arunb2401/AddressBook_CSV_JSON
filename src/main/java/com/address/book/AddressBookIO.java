package com.address.book;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookIO {
    static AddressBookIO addressBookNew = new AddressBookIO();
    static Scanner sc = new Scanner(System.in);
    public boolean addContact(ArrayList<Contact> contact) {
        try {
            if (addressBookNew.checkAndWriteIntoFile(contact)) {
                System.out.println("\nContacts added Successfully");
            }
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred.\nContact not added.");
            return false;
        }
    }

    public boolean checkAndWriteIntoFile(ArrayList<Contact> contact) throws IOException {
        String HOME = System.getProperty("user.dir");
        String fileName = "AddressBookopen.txt";
        Path homePath = Paths.get(HOME);
        if (Files.exists(homePath)) {
            Path filePath = Paths.get(HOME + "/" + fileName);
            try {
                if (Files.exists(filePath)) {
                    if (writeIntoFile(new File(fileName), contact)) {    //creating new file and passing contact
                        return true;
                    }
                } else {
                    Files.createFile(filePath);								//creating a file:createFile(args-path)
                    if (writeIntoFile(new File(fileName), contact)) {
                        return true;
                    }
                }
                return true;
            } catch (IOException e) {
                return false;
            }
        }
        return false;
    }

    public boolean writeIntoFile(File filename, ArrayList<Contact> contact) {
        try {
            FileWriter myWriter = new FileWriter(filename);
            for (Contact content : contact) {
                myWriter.write(content + "\n");
            }
            myWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
    }


    public boolean viewContact() {
        String HOME = System.getProperty("src\\main\\resources\\AddressBookIO.txt");
        String fileName = "AddressBookIO";
        Path homePath = Paths.get(HOME);
        if (Files.exists(homePath)) {
            Path filePath = Paths.get(HOME + "/" + fileName);            //getting the path of a file
            if (Files.exists(filePath)) {
//             File filename = new File("AddressBookIO.txt");
                Scanner myReader = new Scanner("AddressBookIO.txt");
                while (myReader.hasNextLine()) {						// we can use int method(unicode) also here.
                    String data = myReader.nextLine();
                    System.out.println(data);
                    myReader.close();
                }
                return true;
            }
        }
        return false;
    }

}