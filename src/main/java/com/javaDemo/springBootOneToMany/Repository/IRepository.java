package com.javaDemo.springBootOneToMany.Repository;

import java.util.List;

import com.javaDemo.springBootOneToMany.Entities.IEntity;

public interface IRepository <T extends IEntity> {
	List<T> getAll();
	T save(T entity);
	T update(T entity);
	int delete(int id);
	List<T> criteriaSearch(T entity);
	List<T> saveAll(List<T> entities);
}
