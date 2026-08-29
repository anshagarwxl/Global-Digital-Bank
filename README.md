# Global Digital Bank (GDB)

A high-performance, secure, and intelligent command-line banking platform designed as a hands-on case study for robust software engineering and system design. 

This repository implements the GDB specification in **Java**, evolving from a basic account model to a sophisticated enterprise-grade banking CLI incorporating 30+ features, strict compliance rules, and future integration with Agentic AI.

---

## 🏛️ Project Architecture & Layers
The system is built on SOLID design principles with a decoupled, multi-layered architecture to ensure clean separation of concerns, testability, and future database scalability:

1. **Presentation Layer (Controller)**: A role-based command-line interface (CLI) with separate menus for Customers and Administrators. Handles input parsing and delegates requests.
2. **Business Logic Layer (Services)**: The core engine (e.g., transaction processing, rules validation, analytics). Decoupled from storage and display mechanisms.
3. **AI / Automation Layer**: Leverages LLMs and tools (planned via LangChain4j/LangChain) for natural language querying, smart savings advice, and predictive analytics.
4. **Data Access Layer (FileManager)**: Responsible for reading/writing persistent data atomically.
5. **Data Layer**: Contains domain entities (e.g., `AccountEnhanced`) and physical data stores (`accounts.csv` and `transactions.log`).

---

## 🚀 Key Features

### 1. Base Core Features
*   **Account Creation**: Automatic generation of unique account numbers (starting at 1001). Rejects age under 18.
*   **Transactions**: Core deposits and withdrawals with basic limit checking.
*   **Account Status**: Basic active/inactive lifecycle states.
*   **File Persistence**: Local data saved to/loaded from `accounts.csv`.

### 2. Extended Features (In Progress / Completed)
*   **Advanced Account Management**: Name and account number search, list active/closed accounts in tabular views, rename account holders (requires PIN validation).
*   **Transactions & Rules**: 
    *   Minimum balance enforcement (₹500 for Savings, ₹1000 for Current).
    *   Daily transaction limits (maximum withdrawal of ₹50,000 per day).
    *   Inter-account fund transfers (logged as atomic credit/debit steps).
    *   Transaction logging to `transactions.log`.
*   **Security & Encryption**: 
    *   4-digit numeric PIN protection for sensitive actions.
    *   Plans for AES-256 encryption at rest for `accounts.csv`.
*   **Analytics**: Average balance calculations, Oldest/Youngest account finder, and Simple Interest calculator.
*   **Administrative Operations**: Bulk import/export from CSV files and administrative overrides.

### 3. Agentic AI Features (Roadmap)
*   **Intelligent Fraud Detection Agent**: Real-time transaction pattern monitoring and automatic PIN challenges for anomalous transactions.
*   **Automated Financial Advisor (Smart Savings)**: Scans transaction history to suggest and run savings sweeps (e.g., round-ups).
*   **Natural Language Query Interface (NLQI)**: Text-based banking interactions.
*   **Predictive Analytics Dashboard**: Churn risk and dormancy prediction for admin users.

---

## 📈 Non-Functional Requirements (NFR) Targets
*   **Performance**: Targeting 500+ TPS with optimized File I/O.
*   **Latency**: `<100ms` read latency / `<250ms` write latency for 99% of requests.
*   **Capacity**: Efficiently handle 10,000+ accounts and 1M+ transaction log entries.
*   **Reliability**: 99.9% uptime, atomic transactions (ACID properties), and automated CSV backups before destructive actions.
*   **Test Coverage**: Aiming for $\ge 80\%$ unit and integration test coverage.

---

## 🗺️ Project Roadmap
*   **Phase 1: Core Foundation** (Completed): Account modeling, base features, basic CLI structure, and file persistence.
*   **Phase 2: Extended Features** (Current): Rule modules, security layers, analytics, and administrative tools.
*   **Phase 3: Agentic AI Integration**: Integrating LangChain/LangChain4j agents.
*   **Phase 4: Optimization & Security Hardening**: Caching layers, data encryption at rest, and performance benchmarking.
*   **Phase 5: Final Review & Submission**: Code review, bug fixing.

---

## 💻 Setup & Compilation

### Prerequisites
*   Java Development Kit (JDK) 8 or higher.
*   Git.

### Compilation
Compile the project from the root directory:
```bash
javac AccountEnhanced.java TestAccountEnhanced.java
```

### Run Tests
To run the automated verification test suite:
```bash
java TestAccountEnhanced
```
