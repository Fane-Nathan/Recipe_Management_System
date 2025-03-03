package RecipeManager.src.recipemanager.repository;

import java.util.*;

public interface CrudRepository<T> {
    T create(T entity);
    Optional<T> getById(String id);
    List<T> getAll();
    T update(T entity);
    void delete(String id);
}