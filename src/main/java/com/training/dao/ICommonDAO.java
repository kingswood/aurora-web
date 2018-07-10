package com.training.dao;

import java.util.List;
import com.training.entity.*;


public interface ICommonDAO<T extends BaseEntity>
{
	List<T> getAll();
	T getById(int id);
	void add(T model);
    void update(T model);
    void deleteById(int id);

}
