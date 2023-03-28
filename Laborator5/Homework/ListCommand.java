package Homework.commands;

import Homework.Catalog;
import Homework.Command;
import Homework.exceptions.EmptyListOfDocuments;
import Homework.exceptions.InvalidCatalogException;

public class ListCommand implements Command {
    @Override
    public Object command(Object obj, Catalog catalog) throws InvalidCatalogException, EmptyListOfDocuments {
        if(catalog == null){
            throw new InvalidCatalogException();
        }
        else {
            if (catalog.getDocs().size() == 0)
                throw new EmptyListOfDocuments("Lista de documente goala!");
            else {
                System.out.println(catalog.getDocs().toString());
            }
        }
        return 1;
    }

    /*public Catalog command(String path, Catalog catalog){
        System.out.println("this function doesn't have an implementation in ListCommand");
        return catalog;
    }*/
}
