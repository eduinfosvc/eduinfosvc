package com.sanctuary.eduinfosvc.domain;

import org.springframework.stereotype.Component;

@Component
public class Page {
    private int pageNum;
    private int pageSize;
    private int begin;

    public int getPageNum() {
        return pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getBegin() {
        return begin;
    }
    public void setBegin(int begin) {
        this.begin = begin;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", begin=" + begin +
                '}';
    }
}
