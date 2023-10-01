package com.alex.wordslcore.repository;

import com.alex.wordslcore.model.WordsRecord;
import org.springframework.data.repository.CrudRepository;

public interface WordsRecordRepository extends CrudRepository<WordsRecord, Integer> {
}
