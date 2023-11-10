package com.mylabs.pds.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.util.List;

@Getter
@Setter
@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String testName;

    @Column
    private String originPathToTest;

    @Column
    private String type; //TESTFOLDER, TESTCLASS, TESTMETHOD


    public String getOriginPathToTest() {
        return originPathToTest;
    }

    public void setOriginPathToTest(String originPathToTest) {
        this.originPathToTest = originPathToTest;
    }

    @Column(columnDefinition = "varchar(2000)")
    private String contents;

    @Column
    private Long parentId;

    @ManyToOne
    @JoinColumn(name = "parent_task_id")
    @JsonIgnore
    //@Column(name = "parent_task_id")
    private Tarea parentTaskId;

    @OneToMany(mappedBy = "parentTaskId", cascade = CascadeType.ALL)
    //@Transient
    private List<Tarea> childrenTasks;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getContents() {
        return contents;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Tarea getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(Tarea parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    public void setParentId(Long idParent) {
        this.parentId = idParent;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public List<Tarea> getChildrenTasks() {
        return childrenTasks;
    }

    public void setChildrenTasks(List<Tarea> childrenTasks) {
        this.childrenTasks = childrenTasks;
    }
}
