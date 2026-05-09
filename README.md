# admin-portal

A modern enterprise admin dashboard built using React.js with secure JWT authentication, smart auto logout, maintenance mode, premium UI, dark mode, and real-time monitoring features.

---

## ✨ Features

- JWT Authentication
- Smart Auto Logout System
- Session Expiry Warning Popup
- Maintenance Mode
- Dark / Light Mode
- Real-time Metrics Dashboard
- Responsive Enterprise UI
- Glassmorphism Design
- Secure Logout Handling
- Toast Notifications
- Premium Animations

---

## 📊 Dashboard Modules

- CPU Usage Monitoring
- Memory Usage Monitoring
- Disk Usage
- Network Latency
- Active Users
- Infrastructure Health
- Security Center
- Audit Monitoring

---

## 🔐 Security Features

- JWT Token Validation
- Session Expiration Handling
- Automatic Logout
- Browser Tab Close Detection
- Maintenance Protection
- Secure API Integration

---

## 🛠️ Tech Stack

| Technology | Usage |
|---|---|
| React.js | Frontend |
| Axios | API Calls |
| Lucide React | Icons |
| React Hot Toast | Notifications |
| JWT | Authentication |
| CSS3 | Styling |

---

## 📂 Project Structure

```bash
src/
│
├── api/
│   └── adminAuthAPI.js
│
├── hooks/
│   └── useAdminAutoLogout.js
│
├── pages/
│   └── AdminDashboard.jsx
│
├── styles/
│   └── enterpriseDashboard.css
│
└── App.js
```

---

## ⚙️ Installation

### Clone Repository

```bash
git clone <repository-url>
```

### Move Into Project

```bash
cd admin-portal
```

### Install Dependencies

```bash
npm install
```

### Start Application

```bash
npm start
```

---

## 🌐 Application URL

```txt
http://localhost:3000
```

---

## 🔑 Authentication

Admin login uses JWT authentication.

Token stored in:

```txt
localStorage.admin
```

---

## ⏳ Auto Logout Flow

| Time | Action |
|---|---|
| 0–40 sec | Active Session |
| 40 sec | Warning Popup |
| Next 20 sec | Countdown |
| No Action | Auto Logout |

---

## 🌙 Dark Mode

Includes:

- Modern dark UI
- Smooth transitions
- Premium gradients
- Glassmorphism effects

---

## 📱 Responsive Design

Supports:

- Desktop
- Laptop
- Tablet
- Mobile Devices

---

## 🚀 Production Ready Features

- Enterprise UI
- Smart Auto Logout
- JWT Integration
- Maintenance Mode
- Responsive Layout
- Dark Mode
- Secure Session Handling
- Scalable Architecture

---

## 👨‍💻 Developed By

Ayush Gupta

Software Engineer
