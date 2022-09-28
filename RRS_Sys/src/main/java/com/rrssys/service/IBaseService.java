package com.rrssys.service;

import com.rrssys.entity.Video;

import java.util.List;

public interface IBaseService<T> {
    //create T
    public T add(T entity);
    //update T
    public T update(Long id, T entity);
    //delete T
    public boolean delete(Long id);
    //get list T
    public List<T> getAll();
    //get T by id
    public T getByID(Long id);
    //get T by serial number
    public T getBySeri(Long seri);
}
