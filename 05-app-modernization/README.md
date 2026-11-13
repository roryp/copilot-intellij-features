# Week 5: App modernization

**An old app, a new home** · Part 5 of 5 · [All weeks](../README.md)

Old apps get harder to run and to keep secure as Java and its libraries move on. This week, you let Copilot move one to a new home: the latest Java and Spring Boot.

## The problem

This week's Trail Store is an old copy, on Java 8 and Spring Boot 2.7. It still builds, but Spring Boot 2.7 stopped getting free updates in 2023, and some of its libraries have known vulnerabilities (CVEs). Move it to Java 25 and Spring Boot 4, without rewriting it.

## Use

### GitHub Copilot modernization

A separate plugin, by Microsoft, that upgrades Java apps. By hand, an upgrade means chasing every renamed package, changed API and new library version. With the plugin, Copilot writes an upgrade plan, changes the code step by step, builds and tests after each step, and checks the libraries for known CVEs. It adds the **GitHub Copilot modernization** tool window on the left, and a **modernize-java-upgrade** agent to the chat. It works with any GitHub Copilot plan, and upgrades don't need an Azure account.

## Get started

- Open the `05-app-modernization` folder as its own project: choose File → Open, select the folder, and click **New Window**. The upgrade changes the whole project, so this keeps the other weeks out of it.
- Check that it builds: in the terminal, run `.\mvnw.cmd verify` (on macOS and Linux, `./mvnw verify`). It passes on Java 25, but the code still targets Java 8.
- Install the plugin: in Settings → Plugins → Marketplace, search for **GitHub Copilot modernization**, click **Install**, and restart IntelliJ.

With IntelliJ 2026.3, version 1.14.0 of the plugin can stop IntelliJ's terminal from starting ([known issue](https://github.com/microsoft/github-copilot-appmod/issues/213)). Until it's fixed, run `mvnw` in your system's terminal, and under the chat box, choose **Copilot**, not **Local**: the **Local** agent needs IntelliJ's terminal.

## Done when

- [ ] `pom.xml` uses Java 25 and Spring Boot 4.
- [ ] `.\mvnw.cmd verify` passes, and the tests still check what they checked before.
- [ ] Copilot's CVE check finds no known vulnerabilities in the dependencies.
- [ ] After `.\mvnw.cmd spring-boot:run`, http://localhost:8080 shows the six products, and Spring Boot 4.

Stuck? Read the [solution](SOLUTION.md).
