# Security Policy

## Supported Versions

| Version | Supported          |
| ------- | ------------------ |
| 0.x.x   | :white_check_mark: |

## Reporting a Vulnerability

We take security seriously. If you discover a security vulnerability, please report it responsibly.

### How to Report

1. **DO NOT** open a public GitHub issue for security vulnerabilities
2. Go to the [Security tab](https://github.com/TanmaySaxenaCf/learn-github-features/security) of this repository
3. Click **"Report a vulnerability"** to create a private security advisory
4. Provide as much detail as possible:
   - Description of the vulnerability
   - Steps to reproduce
   - Potential impact
   - Suggested fix (if any)

### What to Expect

- **Acknowledgment**: We will acknowledge your report within 48 hours
- **Assessment**: We will assess the vulnerability and determine its severity
- **Fix**: We will work on a fix and coordinate disclosure with you
- **Credit**: We will credit you in the security advisory (unless you prefer to remain anonymous)

### Scope

This security policy covers:
- The Task Manager REST API application code
- Dependencies used by the project
- GitHub Actions workflows and CI/CD pipeline

### Security Best Practices

This project follows these security practices:
- 🔍 **CodeQL Analysis** - Automated code scanning on every push and PR
- 📦 **Dependabot** - Automated dependency update monitoring
- 🔒 **Secret Scanning** - GitHub's built-in secret detection
- ✅ **Branch Protection** - Required reviews and status checks on main branch
