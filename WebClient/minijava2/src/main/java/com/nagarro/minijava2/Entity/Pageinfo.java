package com.nagarro.minijava2.Entity;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public class Pageinfo<T> extends PageImpl<T> {
	 
    private boolean hasNext;
    private boolean hasPrevious;
 
    public Pageinfo(List<T> content, PageRequest pageable, boolean hasNext, boolean hasPrevious) {
        super(content, pageable, content.size());
        this.hasNext = hasNext;
        this.hasPrevious = hasPrevious;
    }
 
    public boolean isHasNext() {
        return hasNext;
    }
 
    public boolean isHasPrevious() {
        return hasPrevious;
    }
}

