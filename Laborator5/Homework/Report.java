package Homework.commands;

import Homework.Catalog;
import Homework.Command;
import Homework.exceptions.InvalidCatalogException;
import Homework.exceptions.InvalidParameter;
import Homework.exceptions.InvalidPathException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Report implements Command {

    private String typeOfPath(String location){
        int index = location.lastIndexOf("/");
        int i;
        String part = "";
        part = part.copyValueOf(location.toCharArray(),index,location.length() - index);

        if(part.contains(".")){
            return "File";
        }
        return "INVALID";
    }
    @Override
    public Object command(Object obj, Catalog catalog) throws InvalidCatalogException,IOException, FileNotFoundException, InvalidPathException, InvalidParameter,  TemplateException {
        if(catalog == null){
            throw new InvalidCatalogException();
        }
        if(!(obj instanceof String)){
            throw new InvalidPathException();
        }
        String path = (String) obj;
        if(path == null  || (typeOfPath(path).compareTo("INVALID")) == 0){
            throw new InvalidPathException();
        }

        File fileFtl =new File(path);
        if(!fileFtl.exists()) {
            String contentFtl = "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Title</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<p>Catalog: ${content}</p>\n" +
                    "</body>\n" +
                    "</html>";
            FileWriter writer = new FileWriter(fileFtl);
            writer.write(contentFtl);
            writer.flush();
            writer.close();

        }

        Configuration configuration = null;
        Map<String,String> contentCatalog = new HashMap<>();
        contentCatalog.put("content",catalog.toString());

        FileReader reader =new FileReader(new File(path));
        Template template = new Template("content", reader, configuration);
        template.process(contentCatalog,new FileWriter(new File(path)));

        return 1;
    }

}
