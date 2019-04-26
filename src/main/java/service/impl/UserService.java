package service.impl;

import dao.IUserDAO;
import dao.impl.UserDaoImpl;
import model.UserModel;
import model.request.Auth;
import service.IUserService;

import java.sql.Timestamp;

public class UserService implements IUserService {
    private IUserDAO UserDAO;

    public UserService(){
        this.UserDAO = new UserDaoImpl();
    }

    public UserModel findUserNameAndPass(Auth auth) {
        return UserDAO.findOne(auth.getUserName(), auth.getPassword());
    }

    public void createUser(UserModel userModel) {
        userModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        UserDAO.insertUser(userModel);
    }

    public void updateUser(Long id, UserModel userModel) {
        UserDAO.updateUser(id, userModel);
    }
}
