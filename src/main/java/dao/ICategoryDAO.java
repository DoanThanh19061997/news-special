package dao;

import model.CategoryModel;

import java.util.List;

public interface ICategoryDAO extends IGenericDao<CategoryModel> {
    List<CategoryModel> findAll();
}
