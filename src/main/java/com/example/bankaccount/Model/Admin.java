package com.example.bankaccount.Model;


public class Admin {
    private String adminId;
    private String adminPw;

    public Admin(String adminId, String adminPw) {
        this.adminId = adminId;
        this.adminPw = adminPw;
    }

    public static Admin of(String adminId, String adminPw) {
        return new Admin(adminId, adminPw);
    }

    public String getAdminId() {
        return adminId;
    }

    public String getAdminPw() {
        return adminPw;
    }
}


