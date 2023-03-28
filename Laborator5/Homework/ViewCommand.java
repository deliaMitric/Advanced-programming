package Homework.commands;

import Homework.Catalog;
import Homework.Command;
import Homework.Document;
import Homework.exceptions.InvalidCatalogException;
import Homework.exceptions.InvalidParameter;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ViewCommand implements Command {

    private String typeOfLocation(String location){
        int index = location.lastIndexOf("/");
        int i;
        String part = "";
        part = part.copyValueOf(location.toCharArray(),index,location.length() - index);

        if(part.contains(".")){
            return "File";
        }
        return "URI";
    }
    @Override
    public Object command(Object obj, Catalog catalog) throws InvalidCatalogException, IOException, FileNotFoundException, InvalidParameter, URISyntaxException {
        if(!(obj instanceof Document)){
            throw new InvalidParameter("The parameter isn't an instance of document.");
        }
        Document doc =(Document) obj;
        Desktop desktop = Desktop.getDesktop();
        String location =  doc.getLocation().toString();

        if( typeOfLocation(location).compareTo("File") == 0){
            File file =new File(location);
            desktop.open(file);
        }
        if(typeOfLocation(location).compareTo("URI") == 0){
            URI uri =new URI(location);
            desktop.browse(uri);
        }
        return 1;
    }

}
