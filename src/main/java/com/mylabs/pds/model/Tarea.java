package com.mylabs.pds.model;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Tarea {

    @Id
    private Long id;
    private String testName;

    private String originPathToTest;

    private String type; //TESTFOLDER, TESTCLASS, TESTMETHOD

    public String getOriginPathToTest() {
        return originPathToTest;
    }

    public void setOriginPathToTest(String originPathToTest) {
        this.originPathToTest = originPathToTest;
    }

    private String contents;

    private Long parentId;

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
