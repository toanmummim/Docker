package com.mycompany.userapp;

import java.util.Scanner;

public class User {
    private String userId; // Biến lưu ID người dùng
    private String email; // Biến lưu email người dùng

  // Constructor khởi tạo đối tượng User
    public User(String userId, String email) {
        this.userId = userId;
        this.email = email;
    }
    

    // Getter lấy email của người dùng
    public String getEmail() {
        return email;
    }

// Setter cập nhật email người dùng
    public void setEmail(String email) {
        this.email = email;
    }
// Getter lấy ID người dùng
    public String getUserId() {
        return userId;
    }
    
    // Phương thức cập nhật email mới với kiểm tra hợp lệ
    public void capNhatEmail(String emailMoi) {
        if (emailMoi == null || !emailMoi.contains("@")) { // Kiểm tra email hợp lệ
            throw new IllegalArgumentException("Lỗi: Email không hợp lệ!");
        }
        this.email = emailMoi; // Cập nhật email mới
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Khởi tạo Scanner để nhập dữ liệu từ bàn phím
        
        System.out.print("Nhập ID người dùng: ");
        String userId = scanner.hasNextLine() ? scanner.nextLine() : ""; // Đọc ID người dùng
        
        System.out.print("Nhập email: ");
        String email = scanner.hasNextLine() ? scanner.nextLine() : ""; // Đọc email người dùng
        
        User user = new User(userId, email); // Tạo đối tượng User với ID và email vừa nhập
        System.out.println("\nTạo người dùng thành công!");
        
        while (true) { // Vòng lặp hiển thị menu
            System.out.println("\n=== MENU ===");
            System.out.println("1. Xem email hiện tại");
            System.out.println("2. Cập nhật email mới");
            System.out.println("3. Thoát chương trình");
            System.out.print("Chọn chức năng: ");
            
            if (!scanner.hasNextInt()) { // Kiểm tra đầu vào có phải số không
                System.out.println("Lỗi: Vui lòng nhập một số từ 1 đến 3.");
                scanner.next(); // Bỏ qua đầu vào không hợp lệ
                continue; // Quay lại vòng lặp
            }
            
            int luaChon = scanner.nextInt(); // Đọc lựa chọn từ người dùng
            scanner.nextLine(); // Tiêu thụ ký tự xuống dòng tránh lỗi khi nhập tiếp
            
            switch (luaChon) {
                case 1:
                    System.out.println("Email hiện tại: " + user.getEmail()); // Hiển thị email hiện tại
                    break;
                case 2:
                    System.out.print("Nhập email mới: ");
                    String emailMoi = scanner.hasNextLine() ? scanner.nextLine() : ""; // Đọc email mới
                    try {
                        user.capNhatEmail(emailMoi); // Cập nhật email
                        System.out.println("Cập nhật email thành công!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage()); // Hiển thị lỗi nếu email không hợp lệ
                    }
                    break;
                case 3:
                    System.out.println("Thoát chương trình");
                    scanner.close(); // Đóng Scanner
                    return; // Kết thúc chương trình
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại!"); // Thông báo lỗi nếu nhập sai
            }
        }
    }
}