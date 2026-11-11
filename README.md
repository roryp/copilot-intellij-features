# GitHub Copilot in IntelliJ IDEA: workshop

Each week has a simple challenge to solve in IntelliJ IDEA with GitHub Copilot, and a separate solution that shows how, with screenshots.

| Week | Session | Features | Challenge | Solution |
|---|---|---|---|---|
| 1 | Fundamentals | Parallel sessions and worktrees, next edit suggestions | [Two features at once](01-fundamentals/README.md) | [Solution](01-fundamentals/SOLUTION.md) |
| 2 | Tooling | Customization panel, built-in MCP server, browser use | [Free jackets](02-tooling/README.md) | [Solution](02-tooling/SOLUTION.md) |
| 3 | Secure execution and governance | Local sandbox, managed settings and Policy Diagnostics, cloud sandbox | [Keep your secrets secret](03-secure-execution/README.md) | [Solution](03-secure-execution/SOLUTION.md) |
| 4 | AI FinOps | Copilot Fusion, agent debug logs, OpenTelemetry | [What does a task cost?](04-ai-finops/README.md) | [Solution](04-ai-finops/SOLUTION.md) |
| 5 | App modernization | GitHub Copilot modernization plugin | [An old app, a new home](05-app-modernization/README.md) (TBC) | [Solution](05-app-modernization/SOLUTION.md) (TBC) |

## What you need

- IntelliJ IDEA 2026.3, with the GitHub Copilot plugin 1.21.1 or later
- Java 25
- Git

## Get started

Fork this repo, clone your fork, and open the folder in IntelliJ IDEA. Then start with [week 1](01-fundamentals/README.md).

Each week's folder has the challenge in `README.md` and the solution in `SOLUTION.md`. Weeks 1, 2 and 4 are copies of Trail Store, a small Spring Boot store from [spring-ai-webstore](https://github.com/roryp/spring-ai-webstore). Failing tests show what to fix. The weeks don't depend on each other.

Browser use, the cloud sandbox and Copilot Fusion are still rolling out, so you might not have them yet. You can still finish every week without them.
