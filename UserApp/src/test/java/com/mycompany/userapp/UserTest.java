/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.userapp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author toan0
 */
public class UserTest {
    // Kiểm tra constructor của User
    @Test
    public void testConstructor() {
        User user = new User("U001", "test@example.com");
        assertEquals("U001", user.getUserId()); // Đảm bảo UserId được khởi tạo đúng
        assertEquals("test@example.com", user.getEmail()); // Đảm bảo email được khởi tạo đúng
    }

    // Kiểm tra phương thức getEmail
    @Test
    public void testGetEmail() {
        User user = new User("U002", "user@example.com");
        assertEquals("user@example.com", user.getEmail()); // Kiểm tra email trả về đúng
    }

    // Kiểm tra phương thức setEmail
    @Test
    public void testSetEmail() {
        User user = new User("U003", "old@example.com");
        user.setEmail("new@example.com"); // Cập nhật email
        assertEquals("new@example.com", user.getEmail()); // Kiểm tra email đã được cập nhật
    }

    // Kiểm tra cập nhật email hợp lệ
    @Test
    public void testCapNhatEmail() {
        User user = new User("U004", "old@example.com");
        user.capNhatEmail("valid@example.com"); // Cập nhật email hợp lệ
        assertEquals("valid@example.com", user.getEmail()); // Kiểm tra email mới
    }

    // Kiểm tra cập nhật email không hợp lệ (không chứa @)
    @Test(expected = IllegalArgumentException.class)
    public void testCapNhatEmailKhongHopLe() {
        User user = new User("U005", "old@example.com");
        user.capNhatEmail("invalidemail"); // Không có @ nên phải ném ngoại lệ
    }

    // Kiểm tra cập nhật email với giá trị null
    @Test(expected = IllegalArgumentException.class)
    public void testCapNhatEmailNull() {
        User user = new User("U006", "old@example.com");
        user.capNhatEmail(null); // Email null phải ném ngoại lệ
    }

    // Kiểm tra cập nhật email hợp lệ sau khi nhập sai
    @Test
    public void testCapNhatEmailHopLeSauThatBai() {
        User user = new User("U007", "old@example.com");
        try {
            user.capNhatEmail("invalidemail"); // Thử nhập email sai
        } catch (IllegalArgumentException e) {
            // Bỏ qua ngoại lệ cho mục đích kiểm thử
        }
        user.capNhatEmail("valid@example.com"); // Sau đó nhập email đúng
        assertEquals("valid@example.com", user.getEmail()); // Kiểm tra email mới
    }

    // Kiểm tra UserId không bị thay đổi sau khi khởi tạo
    @Test
    public void testUserIdKhongThayDoi() {
        User user = new User("U008", "test@example.com");
        assertEquals("U008", user.getUserId()); // Đảm bảo UserId không bị thay đổi
    }
}