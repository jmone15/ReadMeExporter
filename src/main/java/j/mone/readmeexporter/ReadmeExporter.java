package j.mone.readmeexporter;

import com.google.gson.Gson;
import j.mone.readmeexporter.generator.FileGenerator;
import j.mone.readmeexporter.model.Collection;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author jmone15
 */
public class ReadmeExporter {

    public static void main(String[] args) throws FileNotFoundException {
        FileGenerator fl = new FileGenerator();
        BufferedReader br = new BufferedReader(new FileReader("C:\\Your\\Path\\ForHome\\test.json"));
        Collection collection = new Gson().fromJson(br, Collection.class);
        System.out.println(collection.toString());
        fl.createFile(collection);
    }

}
