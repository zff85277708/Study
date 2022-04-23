package com.designPattern.structure.agency;

public class UserController implements IUserController {
    @Override
    public UserVo login(String telephone, String password) {
        return new UserVo("Jack-login", 30);
    }

    @Override
    public UserVo register(String telephone, String password) {
        return new UserVo("Jack-register", 30);
    }
}
