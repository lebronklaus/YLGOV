package com.ftms.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * JPositionTown entity. @author MyEclipse Persistence Tools
 */

public class JPositionTown  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Long countyId;
     private Long townId;
     private String townName;
     private Set users = new HashSet(0);
     private Set exams = new HashSet(0);


    // Constructors

    /** default constructor */
    public JPositionTown() {
    }

	/** minimal constructor */
    public JPositionTown(Long countyId, Long townId, String townName) {
        this.countyId = countyId;
        this.townId = townId;
        this.townName = townName;
    }
    
    /** full constructor */
    public JPositionTown(Long countyId, Long townId, String townName, Set users, Set exams) {
        this.countyId = countyId;
        this.townId = townId;
        this.townName = townName;
        this.users = users;
        this.exams = exams;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCountyId() {
        return this.countyId;
    }
    
    public void setCountyId(Long countyId) {
        this.countyId = countyId;
    }

    public Long getTownId() {
        return this.townId;
    }
    
    public void setTownId(Long townId) {
        this.townId = townId;
    }

    public String getTownName() {
        return this.townName;
    }
    
    public void setTownName(String townName) {
        this.townName = townName;
    }

    public Set getUsers() {
        return this.users;
    }
    
    public void setUsers(Set users) {
        this.users = users;
    }

    public Set getExams() {
        return this.exams;
    }
    
    public void setExams(Set exams) {
        this.exams = exams;
    }
   








}