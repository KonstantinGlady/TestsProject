/*
package com.gik.testsProject.gik.opt;

import java.util.Comparator;

class Account {
    private final String owner;
    private final long balance;
    private final boolean locked;

    Account(String owner, long balance, boolean locked) {
        this.owner = owner;
        this.balance = balance;
        this.locked = locked;
    }

    public static Comparator<com.gik.testsProject.gik.lambda.fuq.Account> getComparatorByLockedBalanceAndOwner() {
        // write your code here
        //return Comparator.comparing(Account::getOwner);
        return Comparator.comparing(com.gik.testsProject.gik.lambda.fuq.Account::isLocked,Comparator.reverseOrder())
                .thenComparing((x,y) -> Long.compare(x.getBalance(), y.getBalance() ))//.thenComparing(Account::getBalance, Comparator.reverseOrder())
                .thenComparing(com.gik.testsProject.gik.lambda.fuq.Account::getOwner);

    }

    public String getOwner() {
        return owner;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isLocked() {
        return locked;
    }

    @Override
    public String toString() {
        return owner + " " + balance + " " + locked;
    }
}
*/
