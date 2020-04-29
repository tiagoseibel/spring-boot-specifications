package br.com.tecnologics.wr.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person", schema = "person")
public class Person implements Serializable {
    @Id
    @Column(name = "businessentityid")
    private Integer id;
    private String persontype;
    private String title;
    private String firstname;
    private String middlename;
    private String lastname;
    private LocalDate modifieddate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersontype() {
        return persontype;
    }

    public void setPersontype(String persontype) {
        this.persontype = persontype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(LocalDate modifieddate) {
        this.modifieddate = modifieddate;
    }
}
