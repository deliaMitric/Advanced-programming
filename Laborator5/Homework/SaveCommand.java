package Homework.commands;

import Homework.Catalog;
import Homework.Command;
import Homework.exceptions.InvalidCatalogException;
import Homework.exceptions.InvalidPathException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SaveCommand implements Command {

    @Override
    public Object command(Object obj, Catalog catalog) throws InvalidCatalogException, IOException, InvalidPathException {
        if(catalog == null){
            throw new InvalidCatalogException();
        }
        else{
            if(!(obj instanceof String)){
                throw new InvalidPathException();
            }
                String path = (String) obj;
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(
                new File(path),
                catalog.toString());

        }
        return 1;

    }
}
