package Homework;

import Homework.commands.*;
import Homework.exceptions.EmptyListOfDocuments;
import Homework.exceptions.InvalidCatalogException;
import Homework.exceptions.InvalidParameter;
import Homework.exceptions.InvalidPathException;
import freemarker.template.TemplateException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws InvalidParameter, InvalidCatalogException, EmptyListOfDocuments, TemplateException, IOException, URISyntaxException, InvalidPathException {
        Catalog c= new Catalog("c1");
        Catalog c2 =new Catalog("c2");

        Document d =new Article(12,"articol2","C:/Users/Delia/Desktop/Laborator5/view.txt",10,"Revista1");
        d.addTag("name","Ema");

        c.add(d);
        //---------------------------------LIST
        ListCommand list = new ListCommand();
        try{
            list.command("listeaza",c);
        }
        catch (InvalidCatalogException e) {
            System.err.println("Invalid Catalog in LISTCOMMAND");
        } catch (EmptyListOfDocuments e) {
            System.err.println("Catalog have an empty list of documents in LISTCOMMAND");
        }
        //---------------------------------LOAD
        //---------------------------------VIEW
        ViewCommand view =new ViewCommand();
        try{
            view.command(c.findById(12),c2);
        } catch (InvalidParameter e) {
            System.err.println("Invalid parameter in VIEWCOMMAND");
        } catch (InvalidCatalogException e) {
            System.err.println("Invalid Catalog in VIEWCOMMAND");
        }  catch (FileNotFoundException e) {
            System.err.println("File not found in VIEWCOMMAND");
        } catch (IOException e) {
            System.err.println("IO exception in VIEWCOMMAND");
        } catch (URISyntaxException e) {
            System.err.println("URI exception in VIEWCOMMAND");
        }
        //---------------------------------REPORT
            Report report =new Report();
            try{
                report.command("C:/Users/Delia/Desktop/Laborator5/src/main/resources/templates/catalog2.ftl",c);
            } catch (InvalidCatalogException e) {
                System.err.println("INvalid Catalog in REPORTCOMMAND");
            }  catch (IOException e) {
                System.err.println("IO exception in REPORTCOMMAND");
            } catch (InvalidPathException e) {
                System.err.println("Invalid path in REPORTCOMMAND");
            } catch (InvalidParameter e) {
                System.err.println("Invalid parameter in REPORTCOMMAND");
            } catch (TemplateException e) {
                System.err.println("Template error in REPORTCOMMAND");
            }

        SaveCommand save =new SaveCommand();
            save.command("C:/Users/Delia/Desktop/Laborator5/catalog.json",c);

        LoadCommand load = new LoadCommand() ;
            load.command("C:/Users/Delia/Desktop/Laborator5/catalog.json",c);

    }
}
