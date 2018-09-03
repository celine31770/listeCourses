package com.listecourses.dao;

public interface IAbstractDao <T> {
	 
	public void create(T entity);

	 public T update(T entity);

	 public void delete(T entity);
	 
	 public T findObject(T entity);

}


// T c'est pour les classes g�n�riques. On a pas besoin de pr�ciser le type de T.
// Donc on peut delete ou create ... nimporte quel type.
