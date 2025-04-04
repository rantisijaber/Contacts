# 📇 Contact Manager (In Progress)

A secure, full-featured contact management system built with **Spring Boot**.  
Supports **user authentication**, **AES-256 encrypted data**, and **profile image storage via AWS S3**.

---

## 🛠️ Tech Stack

- **Backend:** Spring Boot, Spring Security, Spring Data JPA 
- **Authentication:** JWT + BCrypt  
- **Database:** MySQL  
- **Encryption:** AES-256 with custom `@Converter`  
- **Cloud Storage:** AWS S3 (for profile pictures)  
- **Security:** Custom filters, role-based access control  
- **Build Tool:** Maven 
- **Language:** Java  

---

## ✨ Features

- 🔐 Secure user authentication with JWT & BCrypt  
- 🧑‍🤝‍🧑 Register & login endpoints  
- ➕ Add, edit, delete, and view contacts  
- 🛡️ Custom security filters for handling JWT verification  
- 🔒 AES-256 encryption on sensitive contact data (email, phone, notes, etc.)  
- 🖼️ Upload contact profile pictures to AWS S3  
- ✅ Spring Security with role-based authorization  
- 🌐 Fully RESTful API for client integration
---

## 🔐 Security

- **BCrypt** is used to hash user passwords securely  
- **JWT** provides stateless, token-based authentication  
- **Custom security filters** validate tokens and manage authorization  
- **Spring Security** restricts access to endpoints based on user roles  

---

## 📦 AWS S3 Integration

- Profile pictures for contacts are uploaded to an **Amazon S3 Bucket**  
- Uploads and access are handled securely via the backend  

---
