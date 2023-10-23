package com.alex.wordslcore.repository;

import com.alex.wordslcore.model.WordsRecord;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WordsRecordRepository extends CrudRepository<WordsRecord, Integer> {
    @Query(value = "select * from recordsl r where r.user_id = :userId", nativeQuery = true)
    public List<WordsRecord> findByUserId( String userId);
}
