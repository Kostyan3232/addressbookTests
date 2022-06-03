package ru.stqa.pft.addressbook.generators;


import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactData;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    public static void  main(String[] args) throws IOException {

        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        List<ContactData> contacts = genereteContacts(count);
        savexml(contacts, file);
       // save(contacts, file) ;

    }

    public  static void savexml(List<ContactData> contacts, File file) throws IOException {
        XStream xStream = new XStream();
        xStream.alias("contact",ContactData.class);
        String xml = xStream.toXML(contacts);
       try( Writer writer = new FileWriter(file)){
           writer.write(xml);
       }
    }

    private static void save(List<ContactData> contacts, File file) throws IOException {
       Writer writer = new FileWriter(file);
        for(ContactData contact: contacts){
            writer.write(String.format("%s;%s;%s\n",contact.getFirstname(),contact.getLastname(),contact.getMiddlename()));
        }
        writer.close();
    }

    private static List<ContactData> genereteContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i =0; i<count;i++){
            contacts .add(new ContactData().withFirstname(String.format("NNNN %s",i)).withLastname(String.format("AAA %s",i)).
                    withMiddlename(String.format("RRR %s",i)));
        }
        return contacts;
    }
}


