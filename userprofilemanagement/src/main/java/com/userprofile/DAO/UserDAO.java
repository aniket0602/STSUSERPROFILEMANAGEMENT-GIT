package com.userprofile.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userprofile.userentities.User;
public interface UserDAO  extends JpaRepository<User, Long> {

}
