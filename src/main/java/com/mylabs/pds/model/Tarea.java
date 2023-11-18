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
    private String qName;
    private String methodName;
    private String className;
    private String packageName;
    private Integer numDependencies;
    private Integer numLines;
    private byte[] arrayOfBytes;
    private Boolean coverage;
    private String contents;
    private Long parentId;
    private String originPathToTest;
    private String type; //TESTFOLDER, TESTCLASS, TESTMETHOD
    private List<Tarea> children;

    public byte[] getArrayOfBytes() {
        return arrayOfBytes;
    }

    public void setArrayOfBytes(byte[] arrayOfBytes) {
        this.arrayOfBytes = arrayOfBytes;
    }

    public Integer getNumDependencies() {
        return numDependencies;
    }

    public void setNumDependencies(Integer numDependencies) {
        this.numDependencies = numDependencies;
    }

    public Integer getNumLines() {
        return numLines;
    }

    public void setNumLines(Integer numLines) {
        this.numLines = numLines;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Boolean getCoverage() {
        return coverage;
    }

    public void setCoverage(Boolean coverage) {
        this.coverage = coverage;
    }

    public String getqName() {
        return qName;
    }

    public void setqName(String qName) {
        this.qName = qName;
    }

    public String getOriginPathToTest() {
        return originPathToTest;
    }

    public void setOriginPathToTest(String originPathToTest) {
        this.originPathToTest = originPathToTest;
    }

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

    public List<Tarea> getChildren() {
        return children;
    }

    public void setChildren(List<Tarea> children) {
        this.children = children;
    }
}
