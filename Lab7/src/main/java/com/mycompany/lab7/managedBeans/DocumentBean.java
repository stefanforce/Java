
package com.mycompany.lab7.managedBeans;

import com.mycompany.lab7.Logger;
import java.io.Serializable;
import java.sql.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.mycompany.lab7.document.Document;
import com.mycompany.lab7.repositories.interfaces.IDocumentRepository;
import com.mycompany.lab7.repositories.interfaces.IUserRepository;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.Produces;

@Logger
@Named(value = "documentBean")
@SessionScoped
public class DocumentBean implements Serializable {

    @Inject
    IDocumentRepository documentRepository;

    @Inject
    Event<Document> documentEvent;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_]*$")
    private String name;

    @NotNull
    @Size(min = 5, max = 50)
    private String author;
    private String file;

    @Produces
    public int getRegistrationNumber() {
        Random rn = new Random();
        return rn.nextInt();
    }

    public String addDocument() throws IOException {

        int generatedNumber = getRegistrationNumber();
        Document document = new Document(name, author, file, generatedNumber);
        documentRepository.create(document);
        documentEvent.fire(document);
        return "addDocument";
    }

    public void onDocumentAdd(@Observes Document entity) {
        System.out.println("Document added");
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getFile() {
        return file;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setFile(String file) {
        this.file = file;
    }

}
