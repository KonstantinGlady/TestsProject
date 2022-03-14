package com.gik.testsProject.gik.lambda.fuq;

import java.util.*;

class FindUserQuiz {

    public static Optional<User> findUserByAccountId(Set<User> users, String id) {
        // write your code here
     return users.stream().filter(user -> user.getAccount().get().getId().equals(id)).findFirst();
    }
}

class Account {
    private final String id;

    public Account(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

class User {
    private final String login;
    private final Account account;

    public User(String login, Account account) {
        this.login = login;
        this.account = account;
    }

    public String getLogin() {
        return login;
    }

    public Optional<Account> getAccount() {
        return Optional.ofNullable(account);
    }
}
