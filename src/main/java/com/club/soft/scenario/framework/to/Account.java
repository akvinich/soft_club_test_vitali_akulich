package com.club.soft.scenario.framework.to;

import java.util.Objects;

public class Account implements Comparable<Account>, Cloneable {

    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public Account withLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Account withPassword(String password) {
        this.password = password;
        return this;
    }

    public Account build() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(login, account.login)
                && Objects.equals(password, account.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }

    @Override
    public int compareTo(Account o) {
        return this.login.length() * this.password.length() - o.login.length() * o.password.length();
    }

    @Override
    public Account clone() {
        Account clone = null;
        try {
            clone = (Account) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        clone.password = (String) this.password;
        clone.login = (String) this.login;
        return clone;
    }

}
