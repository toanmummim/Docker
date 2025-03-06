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

/**
 *
 * @author toan0
 */
public class UserTest {

    // Test kiểm tra cập nhật email với định dạng hợp lệ
    @Test
    public void testUpdateEmail() {
        User user = new User("U001", "old@example.com");
        user.updateEmail("new@example.com");
        assertEquals("new@example.com", user.getEmail());
    }

    // Test kiểm tra ngoại lệ khi cập nhật email với định dạng không hợp lệ
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateEmailInvalidFormat() {
        User user = new User("U001", "old@example.com");
        user.updateEmail("invalidemail");
    }

    // Test kiểm tra setter cho email
    @Test
    public void testSetEmail() {
        User user = new User("U001", "test@example.com");
        user.setEmail("updated@example.com");
        assertEquals("updated@example.com", user.getEmail());
    }
}

