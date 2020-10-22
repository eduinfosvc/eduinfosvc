package com.sanctuary.eduinfosvc.domain;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Organize {
    private int organizeId;
    private int parentId;
    private String organizeName;
    private String organizeNote;
    private List<Organize> children;          // roleManage时 父组孩子为子组, 子组孩子为用户
    private List<User> users;

    public Organize() {
    }

    public int getOrganizeId() {
        return organizeId;
    }
    public void setOrganizeId(int organizeId) {
        this.organizeId = organizeId;
    }

    public int getParentId() {
        return parentId;
    }
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getOrganizeName() {
        return organizeName;
    }
    public void setOrganizeName(String organizeName) {
        this.organizeName = organizeName;
    }

    public String getOrganizeNote() {
        return organizeNote;
    }
    public void setOrganizeNote(String organizeNote) {
        this.organizeNote = organizeNote;
    }

    public List<Organize> getChildren() {
        return children;
    }
    public void setChildren(List<Organize> children) {
        this.children = children;
    }

    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Organize{" +
                "organizeId=" + organizeId +
                ", parentId=" + parentId +
                ", organizeName='" + organizeName + '\'' +
                ", organizeNote='" + organizeNote + '\'' +
                ", children=" + children +
                ", users=" + users +
                '}';
    }
}
