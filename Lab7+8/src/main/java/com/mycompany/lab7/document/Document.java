package com.mycompany.lab7.document;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stefan
 */
@Entity(name="Document")
@Table(name="Document")
@XmlRootElement
public class Document implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String author;
    private String file;
    private Integer number;

    public Document() {
    }
    
    public Document(String name, String author, String file,Integer number) {
        this.name = name;
        this.author = author;
        this.file = file;
        this.number=number;
    }

    public Integer getId() {
        return id;
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

    public void setId(Integer id) {
        this.id = id;
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
