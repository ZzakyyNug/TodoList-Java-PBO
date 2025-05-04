# Todo List Application

Aplikasi Todo List berbasis Java dengan arsitektur MVC (Model-View-Controller) dan koneksi database MySQL.

## Deskripsi Aplikasi

Aplikasi ini merupakan sistem pengelolaan daftar tugas (Todo List) sederhana yang dilengkapi dengan sistem user. Aplikasi ini dibuat dengan bahasa pemrograman Java dan menggunakan database MySQL untuk penyimpanan data.

## Fitur Aplikasi

- Menampilkan seluruh daftar tugas (Todo List)
- Menambahkan tugas baru
- Mengedit tugas yang sudah ada
- Menghapus tugas
- Menampilkan daftar pengguna (User)

## Persiapan Database

1. Buat database dengan nama `java_mvc` di MySQL
2. Buat dua tabel berikut:

```sql
CREATE TABLE todolist (
    id INT PRIMARY KEY AUTO_INCREMENT,
    todo VARCHAR(255) NOT NULL
);

CREATE TABLE user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);
```

3. Tambahkan beberapa data awal (opsional):

```sql
INSERT INTO todolist (todo) VALUES ('Belajar Java');
INSERT INTO todolist (todo) VALUES ('Belajar MySQL');
INSERT INTO todolist (todo) VALUES ('Belajar MVC');

INSERT INTO user (username, password) VALUES ('admin', 'admin123');
INSERT INTO user (username, password) VALUES ('user', 'user123');
```

## Konfigurasi Koneksi Database

Pastikan Anda mengubah konfigurasi koneksi database di file `DatabaseUtilities.java` sesuai dengan konfigurasi MySQL Anda:

```java
String url = "jdbc:mysql://localhost:3306/java_mvc";
String user = "root";           // Sesuaikan dengan username MySQL Anda
String password = "";     // Sesuaikan dengan password MySQL Anda
```

## Cara Menjalankan Aplikasi

1. Pastikan Anda telah menginstal Java Development Kit (JDK) dan MySQL
2. Impor project ke IDE favorit Anda (NetBeans, Eclipse, IntelliJ IDEA, dll)
3. Pastikan driver MySQL Connector/J sudah ditambahkan ke project
4. Jalankan file `Main.java` di package `com.telu.todo.run`

## Penggunaan Aplikasi

Setelah aplikasi berjalan, Anda akan melihat menu utama seperti berikut:

```
==================
Todo List Saya
==================
1. Belajar Java
2. Belajar MySQL
3. Belajar MVC
-------------------
Menu:
-------------------
1. Tambah
2. Hapus
3. Edit Todo
4. Tampilkan User
x. Keluar
Pilih Menu: 
```

### Menambah Todo

1. Pilih menu `1`
2. Masukkan deskripsi todo yang ingin ditambahkan
3. Tekan Enter untuk menyimpan, atau ketik `x` untuk membatalkan

### Menghapus Todo

1. Pilih menu `2` 
2. Masukkan ID todo yang ingin dihapus
3. Tekan Enter untuk menghapus, atau ketik `x` untuk membatalkan

### Mengedit Todo

1. Pilih menu `3`
2. Masukkan ID todo yang ingin diedit
3. Masukkan deskripsi baru untuk todo tersebut
4. Tekan Enter untuk menyimpan perubahan, atau ketik `x` untuk membatalkan

### Menampilkan Daftar User

1. Pilih menu `4`
2. Sistem akan menampilkan seluruh daftar user
3. Tekan Enter untuk kembali ke menu utama

### Keluar dari Aplikasi

Ketik `x` pada menu utama untuk keluar dari aplikasi

## Struktur Project

Aplikasi ini menggunakan pola desain MVC (Model-View-Controller) dengan struktur sebagai berikut:

- **Model**: Berisi kelas-kelas yang merepresentasikan data (`TodoList.java`, `User.java`)
- **View**: Berisi kelas-kelas untuk tampilan dan interaksi dengan pengguna (`TodoListView.java`)
- **Controller/Service**: Berisi kelas-kelas untuk logika bisnis dan manipulasi data (`TodoListService.java`, `UserService.java`, `TodoListServiceImpl.java`, `UserServiceImpl.java`)
- **Utilities**: Berisi kelas utilitas seperti koneksi database (`DatabaseUtilities.java`)


## Kontributor

- Zakk
- miawtelyu@zakk.my.id
