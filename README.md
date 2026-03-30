# 📋 Task Manager — Learn GitHub Features

A simple **Spring Boot REST API** for managing tasks, built to demonstrate and learn every major GitHub feature.

![CI](https://github.com/TanmaySaxenaCf/learn-github-features/actions/workflows/ci.yml/badge.svg)
![CodeQL](https://github.com/TanmaySaxenaCf/learn-github-features/actions/workflows/codeql.yml/badge.svg)

## 🎯 Purpose

This repository is a **learning playground** that demonstrates:

| Feature | What It Does | Where to Look |
|---------|-------------|---------------|
| **GitHub Actions** | CI/CD automation | [`.github/workflows/`](.github/workflows/) |
| **Issue Templates** | Structured bug reports & feature requests | [`.github/ISSUE_TEMPLATE/`](.github/ISSUE_TEMPLATE/) |
| **PR Templates** | Standardized pull request descriptions | [`.github/PULL_REQUEST_TEMPLATE.md`](.github/PULL_REQUEST_TEMPLATE.md) |
| **GitHub Pages** | Static documentation site | [`docs/`](docs/) |
| **GitHub Security** | Dependabot, CodeQL, security policy | [`SECURITY.md`](SECURITY.md), [`.github/dependabot.yml`](.github/dependabot.yml) |
| **GitHub Wiki** | Project documentation | [Wiki](../../wiki) |
| **GitHub Projects** | Kanban project board | [Projects](../../projects) |

## 🚀 Quick Start

### Prerequisites
- Java 21 (JDK)
- Maven 3.9+

### Run Locally
```bash
# Clone the repo
git clone https://github.com/TanmaySaxenaCf/learn-github-features.git
cd learn-github-features

# Build & test
mvn clean test

# Start the app
mvn spring-boot:run
```

The API runs at `http://localhost:8080`.

## 📡 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/tasks` | List all tasks |
| `GET` | `/api/tasks/{id}` | Get a specific task |
| `GET` | `/api/tasks/status/{status}` | Filter tasks by status (TODO, IN_PROGRESS, DONE) |
| `POST` | `/api/tasks` | Create a new task |
| `PUT` | `/api/tasks/{id}` | Update a task |
| `DELETE` | `/api/tasks/{id}` | Delete a task |

### Example: Create a Task
```bash
curl -X POST http://localhost:8080/api/tasks \
  -H "Content-Type: application/json" \
  -d '{"title": "Learn GitHub Actions", "description": "Set up CI/CD pipeline"}'
```

## 🏗️ Project Structure
```
learn-github-features/
├── .github/
│   ├── workflows/          # GitHub Actions CI/CD
│   │   ├── ci.yml          # Build & test workflow
│   │   ├── deploy-pages.yml# Pages deployment
│   │   └── codeql.yml      # Security scanning
│   ├── ISSUE_TEMPLATE/     # Issue form templates
│   ├── PULL_REQUEST_TEMPLATE.md
│   ├── CONTRIBUTING.md
│   └── dependabot.yml      # Dependency updates
├── docs/                   # GitHub Pages static site
├── src/
│   ├── main/java/...       # Spring Boot application
│   └── test/java/...       # Unit tests
├── SECURITY.md             # Security policy
├── LICENSE                 # MIT License
└── pom.xml                 # Maven build config
```

## 🤝 Contributing

See [CONTRIBUTING.md](.github/CONTRIBUTING.md) for guidelines.

## 📄 License

This project is licensed under the MIT License — see the [LICENSE](LICENSE) file.
