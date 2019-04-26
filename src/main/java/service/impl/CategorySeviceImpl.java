package service.impl;

import dao.ICategoryDAO;
import dao.impl.CategoryDAOImpl;
import model.CategoryModel;
import service.ICategorySevice;

import java.util.List;

public class CategorySeviceImpl implements ICategorySevice {
    private ICategoryDAO iCategoryDAO ;

    public CategorySeviceImpl() {
        this.iCategoryDAO = new CategoryDAOImpl();
    }



    @Override
    public List<CategoryModel> findAll() {
       return iCategoryDAO.findAll();

    }
}
