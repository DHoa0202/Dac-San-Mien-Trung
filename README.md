# Dac_San_Mien_Trung
Dự án thực tập `ĐẶC SẢN MIỀN TRUNG`

[dsmt demo video](https://youtu.be/2ofh31OEFwE)

```diff
! Phần quên mật khẩu không sài `cookie`
`Nếu 2 tài khoản đăng sử dụng quên mật khẩu cùng lúc thì thay cookie vào biến code`
* 
  - B1 random code + username lưu vào cookie 
    EX 
      Cookie cookie = new Cookie("RRs_jEka4mKalsjen", 'admin')
      cookie.setMaxAge(60 * 5);
      response.addCookie(cookie);
      -- gửi code form tới email

  - B2 sau khi xác nhận từ email chuyển action tới server EX: "http://localhost:8080/forget-pass"
      bên nhận SecurityController nhận "/forget-pass" xử lý đúng -> xóa cookie || sai -> callback
```

Thành viên nhóm:
  - Hồ Nguyên Quốc
  - Ngô Duy Hòa

Các chức năng cần xây dựng trong hệ thống
  - RESTful
  - Bảo mật
    + Trang riêng cho OWNER(chủ website) nắm toàn bộ quyền trong hệ thống
    + AMDIN sử lý các đơn hàng
    + SELLER: đối tác bán bán hàng
    + SHIPPER: Người giao hàng
    + BUYER: Khách hàng tham gia mua hàng

Kiến trúc MVC
Công nghệ sử dụng
  - Frontend: Bootstrap, AngularJS(1)
  - Backend: Spring-boot
  - Hệ quản trị: MSSQL (SQL Server 2019)
