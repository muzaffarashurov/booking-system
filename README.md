# Booking System

[![Java](https://img.shields.io/badge/Java-17-blue.svg)](https://openjdk.org/projects/jdk/17/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue.svg)](https://www.postgresql.org/)
[![License](https://img.shields.io/badge/License-Apache%202.0-green.svg)](LICENSE)
[![Docker](https://img.shields.io/badge/Docker-Ready-2496ED?logo=docker)](docker-compose.yml)

**Booking System** — это мощное REST API для бронирования ресурсов (переговорных комнат, рабочих мест, оборудования и т.д.).  
Система поддерживает пользователей с разными ролями (ADMIN, MANAGER, USER), управление бронированиями, проверку доступности, уведомления по email и JWT-аутентификацию.

---

## 📌 Особенности

- ✅ **Аутентификация и авторизация** через JWT  
- ✅ **Управление пользователями** (регистрация, роли, активация/деактивация)  
- ✅ **Ресурсы и категории** (гибкая настройка, удобный поиск)  
- ✅ **Бронирование с проверкой конфликтов**  
- ✅ **Автоматический расчёт стоимости** (почасовая оплата)  
- ✅ **Email-уведомления** (подтверждение, отмена, напоминания)  
- ✅ **Встроенная документация** (Swagger/OpenAPI)  
- ✅ **Docker‑контейнеризация** (готовый `docker-compose.yml`)  
- ✅ **Тестовые данные** (Bootstrap‑класс заполняет БД начальными записями)

---

## 🚀 Быстрый старт

### 1. Клонирование репозитория

```bash
git clone https://github.com/muzaffarashurov/booking-system.git
cd booking-system
```

### 2. Запуск с помощью Docker (рекомендуемый способ)

```bash
docker-compose up -d
```

Приложение станет доступно по адресу: [http://localhost:8080](http://localhost:8080)

### 3. Локальный запуск (без Docker)

**Требования:** Java 17, Maven 3.8+, PostgreSQL 15

- Создайте базу данных `booking_system`
- Скопируйте и настройте `application.yml` (или используйте переменные окружения)
- Выполните:

```bash
./mvnw spring-boot:run
```

---

## 🔐 Демо-аккаунты

| Роль      | Email                         | Пароль     |
|-----------|-------------------------------|------------|
| **ADMIN** | `admin@bookingsystem.com`     | `admin123` |
| **MANAGER**| `manager@bookingsystem.com`   | `manager123` |
| **USER**  | `user@bookingsystem.com`      | `user123`  |

> 💡 **Подсказка:** после авторизации в ответе приходит `token`. Его нужно передавать в заголовке:  
> `Authorization: Bearer <token>`

---

## 📚 Документация API

После запуска приложения документация доступна в формате OpenAPI 3.0:

- **Swagger UI:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **OpenAPI JSON:** [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

### Основные эндпоинты

| Метод   | URL                              | Описание                          | Доступ       |
|---------|----------------------------------|-----------------------------------|--------------|
| POST    | `/api/v1/auth/login`             | Вход в систему                    | Public       |
| POST    | `/api/v1/auth/register`          | Регистрация нового пользователя    | Public       |
| GET     | `/api/v1/users/me`               | Текущий пользователь              | USER+        |
| GET     | `/api/v1/categories`             | Список всех категорий             | Public       |
| GET     | `/api/v1/resources`              | Список ресурсов (пагинация)       | USER+        |
| POST    | `/api/v1/bookings`               | Создать бронирование              | USER+        |
| GET     | `/api/v1/bookings/my-bookings`   | Мои бронирования                  | USER+        |
| PATCH   | `/api/v1/bookings/{id}/status`   | Изменить статус бронирования      | MANAGER+     |

> Полный список всех эндпоинтов и моделей смотрите в Swagger UI.

---

## 🛠️ Используемые технологии

| Категория           | Технологии                                                      |
|---------------------|-----------------------------------------------------------------|
| **Язык**            | Java 17                                                         |
| **Фреймворк**       | Spring Boot 3.2 (Web, Data JPA, Security, Mail, Validation)    |
| **База данных**     | PostgreSQL 15 + Flyway (миграции)                               |
| **Аутентификация**  | JWT (JSON Web Token)                                            |
| **Маппинг сущностей**| MapStruct, Lombok                                               |
| **Документация**    | SpringDoc OpenAPI (Swagger)                                     |
| **Тестирование**    | JUnit 5, Mockito, Testcontainers                                |
| **Контейнеризация** | Docker, Docker Compose                                          |

---

## 🗂️ Структура проекта (основные модули)

```
booking-system/
├── src/main/java/com/bookingsystem/
│   ├── controller/        # REST-контроллеры (Booking, User, Resource, Category)
│   ├── service/           # Бизнес-логика (сервисы и реализации)
│   ├── repository/        # JPA-репозитории
│   ├── entity/            # Сущности JPA (Booking, User, Resource, Category, Notification)
│   ├── dto/               # Data Transfer Objects (request/response)
│   ├── mapper/            # MapStruct-мапперы
│   ├── security/          # JWT-фильтры, провайдеры, UserDetailsService
│   ├── exception/         # Кастомные исключения и глобальный обработчик
│   ├── validation/        # Кастомные валидаторы
│   ├── bootstrap/         # Заполнение БД начальными данными (DataBootstrap)
│   └── config/            # Конфигурации (Security, Swagger, Jackson)
├── src/main/resources/
│   ├── application.yml    # Основной конфиг
│   ├── db/migration/      # SQL-миграции Flyway (V1__, V2__, V3__)
│   └── templates/email/   # HTML-шаблоны для писем
├── docker-compose.yml     # Docker Compose (app + postgres)
├── Dockerfile             # Многостадийная сборка
├── pom.xml                # Maven-зависимости
└── README.md              # Этот файл
```

---

## ⚙️ Конфигурация и переменные окружения

Все чувствительные параметры можно переопределить через переменные окружения.

| Переменная        | Описание                               | Значение по умолчанию          |
|-------------------|----------------------------------------|--------------------------------|
| `DB_USERNAME`     | Имя пользователя PostgreSQL            | `postgres`                     |
| `DB_PASSWORD`     | Пароль PostgreSQL                      | `postgres`                     |
| `JWT_SECRET`      | Секретный ключ для JWT (минимум 256 бит)| `mySecretKey...` (замените!)   |
| `MAIL_USERNAME`   | Логин SMTP (например, Gmail)           | –                              |
| `MAIL_PASSWORD`   | Пароль SMTP                            | –                              |

Пример запуска с переменными:

```bash
docker run -e JWT_SECRET=your_strong_secret -e DB_PASSWORD=my_pass ...
```

---

## 🧪 Тестирование

- **Юнит-тесты** сервисов и мапперов  
- **Интеграционные тесты** с Testcontainers (поднимается реальная PostgreSQL)

Запуск тестов:

```bash
./mvnw test
```

---

## 🐳 Развертывание на сервере

1. Установите Docker и Docker Compose на сервер.  
2. Скопируйте проект на сервер.  
3. Настройте переменные окружения (особенно `JWT_SECRET` и почтовые).  
4. Выполните:

```bash
docker-compose up -d --build
```

Приложение будет доступно на порту `8080`.  
При необходимости добавьте reverse proxy (Nginx) и HTTPS.

---

## 🤝 Как внести вклад

1. Форкните репозиторий.  
2. Создайте ветку для вашей фичи (`git checkout -b feature/new-feature`).  
3. Внесите изменения и напишите тесты.  
4. Запушьте ветку и откройте Pull Request.

---

## 📄 Лицензия

Проект распространяется под лицензией **Apache 2.0**.  
Подробности см. в файле [LICENSE](LICENSE).

---

## 📧 Контакты

По вопросам использования и разработки пишите на  
📬 `muzaffarashurov1982@gmail.com`
Телеграм какнал
✈️ `@MuzaffarAshurov`