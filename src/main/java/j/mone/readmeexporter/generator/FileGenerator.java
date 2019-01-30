/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j.mone.readmeexporter.generator;

import j.mone.readmeexporter.model.Collection;
import j.mone.readmeexporter.model.Item;
import j.mone.readmeexporter.model.Query;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jmone15
 */
public class FileGenerator {

    public void createFile(Collection col) {
        try {
            PrintStream out = new PrintStream(new FileOutputStream("C:\\Your\\Path\\ForHome\\EXPORTED.md"));
            out.println("# " + col.getInfo().getName());

            out.println("## " + col.getInfo().getDescription());
            out.println("----");
            for (Item it : col.getItems()) {
                out.println("### **`" + it.getRequest().getMethod() + "`** : `" + it.getItemName() + "`");
                out.println("#### " + it.getRequest().getDescription());
                out.println("* **URL Params**\n");
                out.println("  * **Required**\n");
                for (Query q : it.getRequest().getUrl().getQuery()) {
                    if (!q.isDisabled()) {
                        out.println("    * `" + q.getKey() + "`" + "\n");
                    }
                }
                out.println("\n");
                out.println("  * **Optional**\n");
                for (Query q : it.getRequest().getUrl().getQuery()) {
                    if (q.isDisabled()) {
                        out.println("    * `" + q.getKey() + "`" + "\n");
                    }
                }
                out.println("*Example:*\n");
                out.println("```shell");
                out.println(it.getRequest().getUrl().getRaw());
                out.println("```");
                out.println("----");

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
