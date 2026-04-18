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

| Роль       | Email                         | Пароль       |
|------------|-------------------------------|--------------|
| **ADMIN**  | `admin@bookingsystem.com`     | `admin123`   |
| **MANAGER**| `manager@bookingsystem.com`   | `manager123` |
| **USER**   | `user@bookingsystem.com`      | `user123`    |

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
| POST    | `/api/v1/auth/register`          | Регистрация нового пользователя   | Public       |
| POST    | `/api/v1/auth/refresh`           | Обновление JWT токена             | Public       |
| GET     | `/api/v1/users/me`               | Текущий пользователь              | USER+        |
| GET     | `/api/v1/categories`             | Список всех категорий             | Public       |
| GET     | `/api/v1/resources`              | Список ресурсов (пагинация)       | USER+        |
| GET     | `/api/v1/resources/available`    | Доступные ресурсы                 | USER+        |
| POST    | `/api/v1/bookings`               | Создать бронирование              | USER+        |
| GET     | `/api/v1/bookings/my-bookings`   | Мои бронирования                  | USER+        |
| GET     | `/api/v1/bookings/check-availability` | Проверка доступности ресурса | USER+        |
| PATCH   | `/api/v1/bookings/{id}/status`   | Изменить статус бронирования      | MANAGER+     |
| GET     | `/api/v1/notifications`          | Уведомления пользователя          | USER+        |
| PATCH   | `/api/v1/notifications/mark-all-read` | Отметить все как прочитанные | USER+        |

> Полный список всех эндпоинтов и моделей смотрите в Swagger UI.

---

## 🛠️ Используемые технологии

| Категория            | Технологии                                                      |
|----------------------|-----------------------------------------------------------------|
| **Язык**             | Java 17                                                         |
| **Фреймворк**        | Spring Boot 3.2 (Web, Data JPA, Security, Mail, Validation)      |
| **База данных**      | PostgreSQL 15 + Flyway (миграции)                               |
| **Аутентификация**   | JWT (JSON Web Token)                                            |
| **Маппинг сущностей**| MapStruct, Lombok                                               |
| **Документация**     | SpringDoc OpenAPI (Swagger)                                     |
| **Тестирование**     | JUnit 5, Mockito, Testcontainers                                |
| **Контейнеризация**  | Docker, Docker Compose                                          |

---

## 🗂️ Структура проекта (основные модули)

```
booking-system/
├── src/main/java/com/bookingsystem/
│   ├── controller/        # REST-контроллеры (Auth, Booking, User, Resource, Category, Notification)
│   ├── service/           # Бизнес-логика (сервисы и реализации)
│   ├── repository/        # JPA-репозитории
│   ├── entity/            # Сущности JPA (User, Booking, Resource, Category, Notification)
│   ├── dto/               # Data Transfer Objects (request/response/filter)
│   ├── mapper/            # MapStruct-мапперы
│   ├── security/          # JWT-провайдер, фильтры, UserDetailsService
│   ├── exception/         # Кастомные исключения и глобальный обработчик
│   ├── validation/        # Кастомные валидаторы
│   ├── scheduler/         # Планировщик напоминаний о бронированиях
│   ├── bootstrap/         # Заполнение БД начальными данными (DataBootstrap)
│   └── config/            # Конфигурации (Security, Swagger, Jackson, Web)
├── src/main/resources/
│   ├── application.yml    # Основной конфиг
│   ├── application-dev.yml   # Конфиг для разработки
│   ├── application-prod.yml  # Конфиг для production
│   ├── db/migration/      # SQL-миграции Flyway (V1__, V2__, V3__)
│   └── templates/email/   # HTML-шаблоны для писем
├── src/test/
│   ├── java/              # Юнит и интеграционные тесты
│   └── resources/         # Тестовые конфиги и данные
├── docker-compose.yml     # Docker Compose (app + postgres)
├── Dockerfile             # Многостадийная сборка
├── pom.xml                # Maven-зависимости
└── README.md              # Этот файл
```

---

## ⚙️ Конфигурация и переменные окружения

Все чувствительные параметры можно переопределить через переменные окружения.

| Переменная        | Описание                                | Значение по умолчанию          |
|-------------------|-----------------------------------------|--------------------------------|
| `DB_HOST`         | Хост PostgreSQL                         | `localhost`                    |
| `DB_PORT`         | Порт PostgreSQL                         | `5432`                         |
| `DB_NAME`         | Имя базы данных                         | `booking_system`               |
| `DB_USERNAME`     | Имя пользователя PostgreSQL             | `postgres`                     |
| `DB_PASSWORD`     | Пароль PostgreSQL                       | `postgres`                     |
| `JWT_SECRET`      | Секретный ключ для JWT (минимум 256 бит)| `mySecretKey...` (замените!)   |
| `JWT_EXPIRATION`  | Время жизни токена (мс)                 | `86400000` (24 часа)           |
| `MAIL_HOST`       | SMTP сервер                             | `smtp.gmail.com`               |
| `MAIL_PORT`       | SMTP порт                               | `587`                          |
| `MAIL_USERNAME`   | Логин SMTP                              | –                              |
| `MAIL_PASSWORD`   | Пароль SMTP                             | –                              |

Пример запуска с переменными:

```bash
docker run -e JWT_SECRET=your_strong_secret -e DB_PASSWORD=my_pass -p 8080:8080 booking-system
```

---

## 🧪 Тестирование

- **Юнит-тесты** сервисов и мапперов  
- **Интеграционные тесты** с Testcontainers (поднимается реальная PostgreSQL)

Запуск тестов:

```bash
./mvnw test
```

Запуск с профилем test:

```bash
./mvnw test -Dspring.profiles.active=test
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

### Пример docker-compose для production

```yaml
version: '3.8'
services:
  app:
    build: .
    ports:
      - "8080:8080"
    environment:
      - SPRING_PROFILES_ACTIVE=prod
      - JWT_SECRET=your_very_strong_secret_key_here
      - DB_PASSWORD=secure_password
      - MAIL_USERNAME=your@email.com
      - MAIL_PASSWORD=your_app_password
    depends_on:
      - postgres
    restart: unless-stopped
    
  postgres:
    image: postgres:15-alpine
    environment:
      - POSTGRES_DB=booking_system
      - POSTGRES_USER=postgres
      - POSTGRES_PASSWORD=secure_password
    volumes:
      - postgres-data:/var/lib/postgresql/data
    restart: unless-stopped

volumes:
  postgres-data:
```

---

## 🔧 Полезные команды

```bash
# Сборка проекта
./mvnw clean package

# Сборка без тестов
./mvnw clean package -DskipTests

# Генерация отчета о покрытии тестами
./mvnw jacoco:report

# Проверка зависимостей на уязвимости
./mvnw dependency-check:check

# Запуск только интеграционных тестов
./mvnw test -Dtest=*IntegrationTest
```

---

## 🤝 Как внести вклад

1. Форкните репозиторий.  
2. Создайте ветку для вашей фичи (`git checkout -b feature/new-feature`).  
3. Внесите изменения и напишите тесты.  
4. Запушьте ветку и откройте Pull Request.

---

## 📝 Что планируется

- [ ] Интеграция с календарями (Google Calendar, Outlook)
- [ ] Push-уведомления (Firebase Cloud Messaging)
- [ ] Мобильное приложение (Flutter/React Native)
- [ ] Аналитика и отчеты (графики загрузки ресурсов)
- [ ] Поддержка рекуррентных бронирований

---

## 📄 Лицензия

Проект распространяется под лицензией **Apache 2.0**.  
Подробности см. в файле [LICENSE](LICENSE).

---

## 📧 Контакты

По вопросам использования и разработки:

- 📬 Email: `muzaffarashurov1982@gmail.com`  
- ✈️ Telegram: `@MuzaffarAshurov`
```