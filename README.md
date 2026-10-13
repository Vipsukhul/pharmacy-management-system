# Pharmacy Management System

**Stack:** Java 21 + Spring Boot 3.3.2 + Spring Security + Spring Data JPA + Thymeleaf + MySQL

**Live Demo:** https://pharmacy-management-system-production-a6a5.up.railway.app/login

## Features

- **Authentication** — Spring Security, DB-backed login, BCrypt-hashed passwords, role-based access (ADMIN / PHARMACIST)
- **Medicine Management** — list, search, add, update, delete, low-stock badges
- **Supplier Management** — list, add, delete
- **Purchase (Stock In)** — select supplier + medicines + quantities, auto-increments stock
- **Sale (Checkout)** — cart-style checkout, auto-deducts stock, generates a printable PDF invoice
- **Messages** — inbox, direct messages, and broadcast to all employees (simulated SMS)
- **Reports** — stock summary, low stock, expiry alerts, daily sales/earnings, purchase history
- **Employee Management** — Admin-only: add, activate/deactivate employees
- **User Accounts** — Admin-only login account management, separate from employee HR records
- **OTC Medicine Lookup** — rule-based recommender: enter patient age + symptom category, get ranked non-prescription medicine suggestions with dosage/warnings
- **Platform Assistant Chatbot** — rule-based floating widget that helps navigate the app

---

## Getting Started

### Prerequisites
- **Java 21** or later
- **MySQL 8.x** running locally or via Docker

### 1. Environment Configuration
Create a `.env` file in the project root by copying the template:
```bash
cp .env.example .env
```
Configure your credentials in `.env`:
```env
DB_URL=jdbc:mysql://127.0.0.1:3306/pharmacy_db?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
DB_USERNAME=root
DB_PASSWORD=your_mysql_password

SERVER_PORT=8080

ADMIN_USERNAME=admin
ADMIN_PASSWORD=your_admin_password
ADMIN_EMAIL=admin@gmail.com
```

### 2. Build & Run
Using the included Maven Wrapper:

- **Windows:**
  ```cmd
  mvnw.cmd spring-boot:run
  ```
- **Linux / macOS:**
  ```bash
  ./mvnw spring-boot:run
  ```

### 3. Access Application
Open `http://localhost:8080` in your browser.
Log in using the admin credentials specified in your `.env` file.
