/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.userapp;

/**
 *
 * @author toan0
 */
import java.util.Scanner;

public class User {
    private String userId;
    private String email;

    public User(String userId, String email) {
        this.userId = userId;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void capNhatEmail(String emailMoi){
        if(emailMoi==null||!emailMoi.contains("@")){
            throw new IllegalArgumentException("loi email khong hop le!");
        }
        this.email = emailMoi;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhap ID nguoi dung:");
        String userId = scanner.nextLine();
        System.out.print("nhap email:");
        String email=scanner.nextLine();
        User user=new User(userId, email);
        System.out.println("\ntao nguoi dung thanh cong!");
        while(true){
            System.out.println("\n===MENU===");
            System.out.println("1.xem email hien tai");
            System.out.println("2.cap nhat email moi");
            System.out.println("3.thoat chuong trinh");
            System.out.print("chon chuc nang: ");
            int luaChon=scanner.nextInt();
            scanner.nextLine();
            switch(luaChon){
                case 1:
                    System.out.println("email hien tai:"+user.getEmail());
                    break;
                case 2:
                    System.out.print("nhap email moi:");
                    String emailMoi=scanner.nextLine();
                    try{
                        user.capNhatEmail(emailMoi);
                        System.out.println("cap nhat email thanh cong!");
                    }catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("thoat chuong trinh");
                    scanner.close();
                    return;
                default:
                    System.out.println("lua chon không hop le");
            }
        }
    }
}