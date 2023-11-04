package com.mylabs.pds.model;

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
    private String name;

    @Column
    private Integer isGenerateToZip;

    @Column
    private String contents;

    @ManyToOne
    @JoinColumn(name = "parent_task_id")
    private Tarea parentTaskId;

    @OneToMany(mappedBy = "Tarea", cascade = CascadeType.ALL)
    private List<Tarea> childrenTasks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContents() {
        return contents;
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

    public Integer getIsGenerateToZip() {
        return isGenerateToZip;
    }

    public void setIsGenerateToZip(Integer isGenerateToZip) {
        this.isGenerateToZip = isGenerateToZip;
    }

    public List<Tarea> getChildrenTasks() {
        return childrenTasks;
    }

    public void setChildrenTasks(List<Tarea> childrenTasks) {
        this.childrenTasks = childrenTasks;
    }
}
