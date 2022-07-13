# POO
**THÀNH VIÊN**
- [Trần Xuân Hương](https://www.facebook.com/TXHuong.HUST/) - 20204753
- [Lê Đức Anh](https://www.facebook.com/profile.php?id=100021833977082) - 20204628
- [Vũ Minh Hiếu](https://www.facebook.com/profile.php?id=100008986909307) - 20204831
- [Nông Hoàng Lâm](https://www.facebook.com/profile.php?id=100026791365278) - 20204575
- [Nguyễn Thành Minh](https://www.facebook.com/minh14092002) - 20200409
- [Lữ Thanh Tùng](https://www.facebook.com/tung.luthanh.2002) - 20204702

**LỜI NÓI ĐẦU**
Game SimpleRPG là 1 đề tài rất phù hợp để vận dụng phương pháp lập trình hướng đối tượng. Trong game rất đa dạng về chủng loại, chúng giống nhau về bản chất nhưng mỗi phiên bản đều có đặc tính riêng tạo nên nét đặc trưng của mỗi chủng loại. Và điều này cũng xảy tương tự trong thực tế, hầu sự vật hiện tượng nào cũng có nhiều hơn 1 cách giải thích vì tính đa dạng của nó. OOP thì lại rất phù hợp với những vấn đề mang tính đa dạng. Nhóm chúng em đã quyết định cùng nhau phát triển một game nhập vai với mục tiêu đáp ứng nhu cầu giải trí của người chơi và xa hơn nữa là hướng tới các game thủ chuyên nghiệp. Tuy nhiên, vì thời gian không có nhiều nên nhóm chúng em quyết định chỉ thiết kế một game nhập vai đơn giản.

**MÔ TẢ**
- Người chơi điều khiển một hoặc nhiều nhân vật trong một bản đồ được lưu trong một cấu trúc dữ liệu tương tự như hình bên, trong đó mỗi ô tương ứng với một dạng bản đồ khác nhau (đất, cỏ, nước…) Trên bản đồ có các quái vật có thể di chuyển được.
- Các nhân vật người chơi điều khiển và quái vật có các chỉ số xác định tình trạng và thể lực (ví dụ HP, MP, Attack, Defense, Speed…). Người chơi có thể tấn công quái vật và sử dụng các kỹ năng đặc biệt. Tương tự, quái vật cũng có thể tìm đến và tấn công người chơi.
- Người chơi có thể di chuyển qua lại giữa các bản đồ khác nhau (ví dụ khi đi vào vùng M0, M1, M2… trên bản đồ) hoặc đi đến kết thúc của trò chơi (ví dụ khi đi vào vùng END trên bản đồ)
![image](image.png)
**CÔNG NGHỆ**
- Java
**UML**
![image](image.png)
**TỔNG QUAN**
1.	Hướng dẫn người chơi
- Khi bắt đầu vào game, người chơi sẽ có 3 lựa chọn:
+ Play game: Vào thẳng Intro và bỏ qua hướng dẫn chơi
+ Instruction: Vào màn hình hướng dẫn chơi
+ Exit: Thoát
- Khi chọn Instruction, người chơi sẽ được dẫn đến màn hình hướng dẫn cách chơi. Sau khi người chơi hoàn thành các nhiệm vụ di chuyển và đánh quái, người chơi sẽ được chuyển đến phần Intro đầu game.
2.	Intro đầu game
Đây là một câu chuyện bao quanh các nhân vật và player có trong game. Người chơi có thể ấn ESC để bỏ qua và vào thẳng game
3.	Player
![image](image.png)
Player có thể thực hiện các hành động sau đây:
-	Di chuyển xung quanh bản đồ bằng phím:
+ W: Lên trên
+ S: Xuống dưới
+ A: Sang trái
+ D: Sang phải
-	Đánh quái:
+ SPACE: Đánh thường
+ K: Đánh quái bằng skill (Sử dụng cung)
-	Mua đồ: Khi di chuyển đến gặp NPC, người chơi có thể lựa chọn mua những món đồ với thông tin thuộc tính được hiện bên cạnh
+ P: Nói chuyện với NPC
+ Dùng các phím W, S, A, D để di chuyển lựa chọn đồ
+ B: Mua đồ
+ Chọn Exit để thoát
-	Kiểm tra đồ hiện có trong inventory:
+ I: Hiện inventory
+ Sử dụng phím PgUp, PgDn, Home, End để di chuyển chọn món đồ
+ Ấn U để sử dụng món đồ và thuộc tính món đồ sẽ cộng vào thuộc tính của người chơi
+ Ấn phím SPACE để thoát
-	Nhặt đồ sau khi đánh quái:
+ Người chơi có thể nhặt được các bình HP, MP 
+ Người chơi có thể nhặt được các trang bị quý hiếm
+ Các món đồ sau khi nhặt sẽ được lưu trong inventory
4.	Các loại quái
Trong game có 3 loại quái chính:
- TinyBox
![image](image.png)
- TinyMon
![image](image.png)
- Boss: Đây là loại quái mạnh nhất trong game.
![image](image.png)
Người chơi sẽ thực hiện đánh quái để nhặt trang bị nhằm tăng sức mạnh hoặc nhặt xu để mua trang bị, sau khi đủ mạnh mới có thể đánh thắng được Boss.
5.	NPC – Shop
-	Đây là vị trí người chơi có thể mua,bán đồ:
+ Có tất cả các loại đồ giúp người chơi có thể tăng phòng thủ, sát thương, HP, MP, …
+ Người chơi phải dùng xu để mua các món đồ trong shop
+ Người chơi có thể bán đề trong inventory để nhận xu
6.	Map
Trong game có 3 map, người chơi có thể đi đến cổng để chuyển map. Mỗi map sẽ có các loại quái khác nhau, giao diện khác nhau. Độ khó của các map sẽ tăng dần và Boss nằm ở map thứ 3. 
- Map 1:
![image](image.png)
- Map 2:
![image](image.png)
- Map 3:
![image](image.png)
7.	Menu
Menu trong game sẽ hiện khi người chơi chết hoặc khi ấn phím E
-	New game: Bắt đầu một game mới
-	Restart Level: Đưa level về 0
-	Difficulty: Chọn độ khó (Khó, trung bình, dễ)
-	Sound: Cài đặt âm thanh
-	Exit to main menu: Thoát ra đầu game
![image](image.png)
- HD chơi:
![image](image.png)
- Intro: 
![image](image.png)
- Bắt đầu game, map 1:
![image](image.png)
- NPC
![image](image.png)
- Buy
![image](image.png)
- Sell
![image](image.png)
- Inventory
![image](image.png)
- Map 2:
![image](image.png)
- Map 3: 
![image](image.png)
- Boss
![image](image.png)
-Die
![image](image.png)
game over: 
![image](image.png)

**KẾT LUẬN**
Mặc dù còn nhiều thiếu sót nhưng Game là sản phẩm đầu tay. Mong mọi người có một trải nghiệm thật thú vị