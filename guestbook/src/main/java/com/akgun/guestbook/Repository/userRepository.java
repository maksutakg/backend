package com.akgun.guestbook.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akgun.guestbook.Entity.User;

public interface userRepository extends JpaRepository<User,Long> {

}
