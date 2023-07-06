package com.wordz.adapters.db;

import com.wordz.domain.WordRepository;

import javax.sql.DataSource;

public class WordRepositoryPostgres implements WordRepository {
    public WordRepositoryPostgres(DataSource dataSource) {
    }

    @Override
    public String fetchWordByNumber(int number) {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public int highestWordNumber() {
        throw new UnsupportedOperationException("not implemented");
    }
}
