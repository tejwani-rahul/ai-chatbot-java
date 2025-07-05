# Java Swing Chatbot

A desktop chatbot application built with **Java SE**, **Swing GUI**, **JDBC**, and the **OpenAI GPT API**.  
It features secure login and signup functionality, a user-friendly chat interface, and dynamic AI responses.

---

## 🚀 **Features**

✅ Modern Java Swing GUI for Login, Signup, and Chat Interface  
✅ User authentication with MySQL database using JDBC  
✅ Secure password storage and login validation  
✅ OpenAI GPT API integration to generate real-time AI responses  
✅ Clear Chat and Logout functionality  
✅ Well-structured Java code with MVC-style separation

---

## 🛠️ **Tech Stack**

- **Java SE** — Core Java programming  
- **Java Swing** — GUI design  
- **JDBC (MySQL)** — Database connection and operations  
- **OpenAI GPT API** — AI-powered chatbot responses

---

## 📸 **Screenshots**

| Login | Signup | Chat Interface |
|-------|--------|----------------|
| ![Login](#) | ![Signup](#) | ![Chat](#) |

*(Add screenshots to show your GUI!)*

---

## ⚙️ **Setup Instructions**

### 1. Clone the repository

```bash
git clone https://github.com/yourusername/java-swing-chatbot.git
cd java-swing-chatbot
```
### 2. Configure Database
Create a MySQL database named chatbot.

Create a users table:

```bash
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255)
);
```
Update your database credentials in Conn.java:

```bash
con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/chatbot", "root", "your_password"
);
```
3. Add your OpenAI API key
In ChatGPT.java, replace:
```bash
con.setRequestProperty("Authorization", "Bearer YOUR_API_KEY");
```

🖥️ Run the Project
Compile and run the main class
Sign up for a new account, then log in to start chatting!

## 📌 Author
👨‍💻 Rahul Tejwani
[![GitHub](https://img.shields.io/badge/-GitHub-181717?style=flat-square&logo=github)](https://github.com/tejwani-rahul)
