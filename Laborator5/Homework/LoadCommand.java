package Homework.commands;

import Homework.Catalog;
import Homework.Command;
import Homework.exceptions.InvalidCatalogException;
import Homework.exceptions.InvalidPathException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadCommand implements Command {

    @Override
    public Object command(Object obj, Catalog catalog) throws InvalidCatalogException,  IOException, FileNotFoundException, InvalidPathException {
        if(catalog == null){
            throw new InvalidCatalogException();
        }
        if(!(obj instanceof String)){
            throw new InvalidPathException();
        }
        String path = (String) obj;
        if(path == null){
            throw new InvalidPathException();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog1 = objectMapper.readValue(new File(path), Catalog.class);
        return catalog1;
    }

    /*public void command(Object obj, Catalog catalog){
        System.out.println("this function doesn't have an implementation in LoadCommand");
    }*/

}
