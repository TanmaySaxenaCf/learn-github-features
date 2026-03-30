# Contributing to Task Manager

Thank you for considering contributing to this project! Here's how you can help.

## Getting Started

1. **Fork** the repository
2. **Clone** your fork: `git clone https://github.com/YOUR_USERNAME/learn-github-features.git`
3. **Create a branch**: `git checkout -b feature/your-feature-name`
4. **Make your changes** and commit them
5. **Push** to your fork: `git push origin feature/your-feature-name`
6. **Open a Pull Request** against the `main` branch

## Development Setup

### Prerequisites
- Java 21 (JDK)
- Maven 3.9+
- Git

### Build & Run
```bash
# Build the project
mvn clean compile

# Run tests
mvn test

# Start the application
mvn spring-boot:run

# The API is available at http://localhost:8080/api/tasks
```

## Code Style

- Follow standard Java conventions
- Use meaningful variable and method names
- Add Javadoc for public methods
- Keep methods short and focused

## Commit Messages

Use conventional commit format:
```
type(scope): description

Examples:
feat(api): add task filtering by date range
fix(model): correct null pointer in task update
docs(readme): update API documentation
test(controller): add tests for delete endpoint
```

## Pull Request Guidelines

- Fill out the PR template completely
- Link related issues using `Closes #123`
- Ensure all tests pass before requesting review
- Keep PRs focused — one feature or fix per PR
- Add tests for any new functionality

## Reporting Issues

- Use the **Bug Report** template for bugs
- Use the **Feature Request** template for new ideas
- Search existing issues before creating a new one

## Code of Conduct

Be respectful and constructive. We're all here to learn!
