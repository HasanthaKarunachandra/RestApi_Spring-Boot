package com.shototech.healthcare.system.service.impl;

import com.shototech.healthcare.system.repo.UserRepo;
import com.shototech.healthcare.system.repo.UserRoleHasUserRepo;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserServiceImpl {
    private final UserRepo userRepo;

    public ApplicationUserServiceImpl(UserRepo userRepo, UserRoleHasUserRepo userRoleHasUserRepo) {
        this.userRepo = userRepo;
        this.userRoleHasUserRepo = userRoleHasUserRepo;
    }

    private final UserRoleHasUserRepo userRoleHasUserRepo;
}
