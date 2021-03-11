package com.cej.addressbook;

// ListView에 표시될 한 개의 item
public class ItemData {
    // Member variable --------------------------------
    private String name;
    private String phone;
    private String email;
    private int imgResId;

    // Constructor Method --------------------------------
    public ItemData(String name, String phone, String email, int imgResId) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.imgResId = imgResId;
    }

    // Member variable 제어 메소드 --------------------------------
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getImgResId() {
        return imgResId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImgResId(int imgResId) {
        this.imgResId = imgResId;
    }
}
