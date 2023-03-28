package Homework;

import Homework.exceptions.EmptyListOfDocuments;
import Homework.exceptions.InvalidCatalogException;
import Homework.exceptions.InvalidParameter;
import Homework.exceptions.InvalidPathException;
import freemarker.template.TemplateException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public interface Command {
    Object command(Object obj, Catalog catalog) throws InvalidCatalogException, EmptyListOfDocuments, IOException, FileNotFoundException, InvalidPathException, InvalidParameter, URISyntaxException, TemplateException;
    //Catalog command(String path, Catalog catalog) throws InvalidCatalogException, EmptyListOfDocuments, IOException, FileNotFoundException,InvalidPathException;

}
