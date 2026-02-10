const USERS_KEY = "users_v1";
const CURRENT_USER_KEY = "currentUser_v1";

function getUsers() {
  return JSON.parse(localStorage.getItem(USERS_KEY) || "[]");
}

function saveUsers(users) {
  localStorage.setItem(USERS_KEY, JSON.stringify(users));
}

function createId() {
  if (window.crypto && crypto.randomUUID) {
    return crypto.randomUUID();
  }
  return `user_${Date.now()}_${Math.floor(Math.random() * 10000)}`;
}

function ensureDefaultAdmin() {
  const users = getUsers();
  const hasAdmin = users.some((u) => u.username === "admin");
  if (!hasAdmin) {
    users.push({
      id: createId(),
      username: "admin",
      password: "1234",
      fullName: "Administrador",
      email: "admin@artesluis.com",
      role: "admin",
      active: true,
      createdAt: new Date().toISOString()
    });
    saveUsers(users);
  }
}

function setCurrentUser(user) {
  localStorage.setItem(CURRENT_USER_KEY, JSON.stringify(user));
  localStorage.setItem("isLoggedIn", "true");
}

function clearCurrentUser() {
  localStorage.removeItem(CURRENT_USER_KEY);
  localStorage.removeItem("isLoggedIn");
}

function getCurrentUser() {
  const raw = localStorage.getItem(CURRENT_USER_KEY);
  return raw ? JSON.parse(raw) : null;
}

document.addEventListener("DOMContentLoaded", () => {
  const currentPage = window.location.pathname.split("/").pop() || "index.html";
  document.querySelectorAll("nav.sidebar a").forEach((link) => {
    if (link.getAttribute("href") === currentPage) {
      link.classList.add("active");
    } else {
      link.classList.remove("active");
    }
  });

  ensureDefaultAdmin();

  const loginForm = document.getElementById("loginForm");
  if (loginForm) {
    loginForm.addEventListener("submit", (e) => {
      e.preventDefault();

      const username = document.getElementById("username").value.trim();
      const password = document.getElementById("password").value.trim();
      const message = document.getElementById("loginMessage");

      const users = getUsers();
      const user = users.find(
        (item) =>
          item.username.toLowerCase() === username.toLowerCase() &&
          item.password === password
      );

      if (!user) {
        message.textContent = "Usuario o contrasena incorrectos.";
        return;
      }

      if (!user.active) {
        message.textContent = "Usuario inactivo. Contacta al administrador.";
        return;
      }

      setCurrentUser({
        id: user.id,
        username: user.username,
        role: user.role,
        fullName: user.fullName
      });

      if (user.role === "admin") {
        window.location.href = "admin.html";
      } else {
        window.location.href = "index.html";
      }
    });
  }

  if (window.location.pathname.includes("admin.html")) {
    const currentUser = getCurrentUser();
    if (!currentUser || currentUser.role !== "admin") {
      window.location.href = "login.html";
    }
  }

  const logoutBtn = document.getElementById("logoutBtn");
  if (logoutBtn) {
    logoutBtn.addEventListener("click", () => {
      clearCurrentUser();
      window.location.href = "login.html";
    });
  }
});

function logout() {
  clearCurrentUser();
  window.location.href = "login.html";
}


