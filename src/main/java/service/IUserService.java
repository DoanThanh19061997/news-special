package service;

import model.UserModel;
import model.request.Auth;

public interface IUserService {
    UserModel findUserNameAndPass(Auth auth);
    void createUser(UserModel userModel);
    void updateUser(Long id, UserModel userModel);
}
