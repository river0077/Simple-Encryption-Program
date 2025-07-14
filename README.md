# Simple Encryption App (Java Swing)

This is a simple desktop application built using Java Swing that allows users to encrypt and decrypt text using a basic XOR encryption method. It features a clean graphical user interface with menu options for usability.

## 🧩 Features

- 🧪 **XOR-Based Encryption & Decryption**
- 🖥️ **Simple GUI** built with Java Swing
- 🧾 **File operations** using menus
- ✨ **Resizable** and user-friendly interface

## 📁 Project Structure

```bash
├── AppUI.java               # Main UI layout and menu configuration
├── Main_App.java            # Entry point of the application
└── Script_Encryption.java   # XOR encryption and decryption logic
```
## ⚙️ How It Works
- The app uses a basic XOR algorithm:
```bash
char encryptedChar = (char) (inputChar ^ keyChar);
```
- This operation is reversible, meaning the same function is used for both encryption and decryption.

## 🚀 Getting Started

- Requirements
- Java JDK 8 or newer
- Any IDE (Eclipse, IntelliJ, NetBeans) or terminal

## Steps to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/Simple-Encryption-App.git
   cd Simple-Encryption-App
   ```
2. Compile the Java files:
   ```bash
   javac *.java
   ```
3. Run the app:
   ```bash
   java Main_App
   ```
## ⚠️ Note
- This project is for educational purposes only. The XOR cipher is not secure for real-world encryption. Do not use it to protect sensitive data.

<img width="1506" height="829" alt="help" src="https://github.com/user-attachments/assets/72793a86-1764-4559-8e9b-c389391dfed2" />



