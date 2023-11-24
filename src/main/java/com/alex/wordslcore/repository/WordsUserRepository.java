package com.alex.wordslcore.repository;

import com.alex.wordslcore.model.WordsLUser;
import com.alex.wordslcore.model.WordsRecord;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WordsUserRepository extends CrudRepository<WordsLUser, Integer> {
    @Query(value = "select * from usersl u where u.user_id = :userId", nativeQuery = true)
    public List<WordsLUser> findByUserId(String userId);
}
