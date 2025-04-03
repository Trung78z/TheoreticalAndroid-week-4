# 📱 Android App: Ứng dụng Android thu thập thông tin của sinh viên và các tính năng gọi, nhắn tin, camera

Ứng dụng Android thu thập dữ liệu về sinh viên với mục đích đánh giá khả năng và triển vọng học thuật của họ trong tương lai và xử lí các tính năng cơ bản như chuyển tiếp sang cuộc gọi, nhắn tin, sử dụng camera.

---
## 🎬 Chương trình ứng dụng và kiểm thử
<img src="images/output.gif" width="200" alt="Demo GIF">
---

##  🎬 Xem tại Youtube
[![Watch the video](https://img.youtube.com/vi/cjbWnHLpAec/maxresdefault.jpg)](https://youtube.com/shorts/cjbWnHLpAec)



---

## 🚀 1. Tạo Project mới trong Android Studio
Tạo một dự án mới trong **Android Studio**:
![Create new project](images/1.png)

---

## 🏗️ 2. Chọn loại Activity
Chọn **Basic View Activity** để có giao diện cơ bản:
![Choose basic view](images/2.png)

---

## ✏️ 3. Đặt tên project và chọn cấu hình Android
Nhập tên ứng dụng, package name, và chọn ngôn ngữ **Java/Kotlin**:
![Project name](images/3.png)

---

## 🖥️ 4. Màn hình chính trong Android Studio
Khi mở dự án, bạn sẽ thấy giao diện chính gồm **XML Layouts** và **MainActivity**:
![Android Studio Coding](images/4.png)

---

## 🎨 5. Thiết kế giao diện (Layout)

### 🔹 Main Activity
Màn hình chính giới thiệu thông tin ứng dụng và các tính năng được tích hợp
![Main Activity UI](images/a2.png)

### 🔹 GetInfo Activity (Xử lí input)
Màn hình hiển thị nơi nhập thông tin:
![Result Activity UI](images/6.png)

### 🔹 ShowInfo Activity (Hiển thị thông tin đã nhập ra màn hình)
Màn hình hiển thị thông tin sinh viên:
![Result Activity UI](images/6.png)
---

## ⚙️ 6. Cách hoạt động

1. **Hiển thị thông tin giới thiệu ứng dụng tại màn hình chính**.
2. **Khi sinh viên nhấn nút gửi thông tin sẽ chuyển tiếp đến trang nhập thông tin**
3. **Tại trang nhập thông tin, sinh viên cần nhập đầy đủ thông tin**
4. **Khi thông tin được nhập đầy đủ và nhấn nút gửi !! Nếu thông tin không đầy đủ sẽ thông báo ""Vui lòng nhập đầy đủ thông tin""**
5. **Khi thông tin đã đầy đủ và nút nhấn được kích hoạt sẽ chuyển tiếp sang màn hình show thông tin**
6. **Tại mỗi màn hình thu thập thông tin và hiển thị thông tin đều có nút trở lại trang chủ. Khi nhấn nút thì sẽ quay lại trang chủ và mọi thông tin đều được xóa**
---

## Thông tin thêm và các hoạt động giữa các tính năng!
1. Sử dụng chức năng nghe gọi:
```
   Khi người dùng nhấn vào nhút nhấn call thì hệ thống sẽ tự dộng chuyển tiếp tới màn hình gọi trên điện thoại với thông tin số điện thoại được tích hợp sẵn trên ứng dụng(Ở đây sử dụng số mặc định '+1234567890')
```
2. Sử dụng chức năng nhắn tin(sms)
```
   Từ màn hình ứng dụng khi người dùng nhấn vào nút nhận sms thì hệ thống sẽ chuyển tiếp tới trang tin nhắn của hệ thống kèm theo message và số điện thoại được tích hợp sẵn trong hệ thống(mặc định được gửi tới ứng dụng tin nhắn là 'Hello, this is a test message!' và số điện thoại cần gửi là '+1234567890')
```
3. Sử dụng chức năng camera 
```
   Khi người dùng nhấn vào nút camera thì ứng dụng sẽ chuyển tiếp tới ứng dụng camera của hệ thống. Khi hệ thống có camera thì thiết bị sẽ tự động mở lên, khi không có thiết bị thì hệ thống sẽ không mở lên mà sẽ hiện thị thông báo "Can't found camera"
```
### !!! Lưu ý quan trọng !!!
> **Note:** Khi người dùng lần đầu truy cập vào camera, ứng dụng sẽ yêu cầu quyền truy cập camera từ người dùng.

## 🛠️ 7. Cách chạy ứng dụng

1. Clone repo này về máy:
   ```sh
   git clone https://github.com/Trung78z/AndroidPractice1.git
   ```
2. Mở **Android Studio** và import project.
3. Chạy ứng dụng trên **Emulator** hoặc **thiết bị thật**.


---

## 📩 8. Liên hệ
Nếu có thắc mắc hoặc góp ý, vui lòng liên hệ qua email: `quanh.0807@gmail.com` & `trungpspy@gmail.com`.