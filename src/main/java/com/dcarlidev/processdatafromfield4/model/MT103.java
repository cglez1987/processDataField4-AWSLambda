/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.processdatafromfield4.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "mt103")
@XmlRootElement
public class MT103 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "field20")
    private String field20;
    @Column(name = "field21")
    private String field21;
    @Column(name = "field25")
    private String field25;
    @Column(name = "field28")
    private String field28;
    @Column(name = "field60")
    private String field60;
    @Column(name = "field61")
    private String field61;
    @Column(name = "field61a")
    private String field61a;
    @Column(name = "field61b")
    private String field61b;
    @Column(name = "field62")
    private String field62;
    @Column(name = "field64")
    private String field64;
    @Column(name = "field86")
    private String field86;

    public MT103() {
    }

    public MT103(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getField20() {
        return field20;
    }

    public void setField20(String field20) {
        this.field20 = field20;
    }

    public String getField21() {
        return field21;
    }

    public void setField21(String field21) {
        this.field21 = field21;
    }

    public String getField25() {
        return field25;
    }

    public void setField25(String field25) {
        this.field25 = field25;
    }

    public String getField28() {
        return field28;
    }

    public void setField28(String field28) {
        this.field28 = field28;
    }

    public String getField60() {
        return field60;
    }

    public void setField60(String field60) {
        this.field60 = field60;
    }

    public String getField61() {
        return field61;
    }

    public void setField61(String field61) {
        this.field61 = field61;
    }

    public String getField61a() {
        return field61a;
    }

    public void setField61a(String field61a) {
        this.field61a = field61a;
    }

    public String getField61b() {
        return field61b;
    }

    public void setField61b(String field61b) {
        this.field61b = field61b;
    }

    public String getField62() {
        return field62;
    }

    public void setField62(String field62) {
        this.field62 = field62;
    }

    public String getField64() {
        return field64;
    }

    public void setField64(String field64) {
        this.field64 = field64;
    }

    public String getField86() {
        return field86;
    }

    public void setField86(String field86) {
        this.field86 = field86;
    }

}
