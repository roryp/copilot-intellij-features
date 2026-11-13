# Week 5 solution: An old app, a new home

How to solve [the challenge](README.md) with GitHub Copilot in IntelliJ IDEA.

## The steps

Open `05-app-modernization` in its own window, and install the **GitHub Copilot modernization** plugin, as in the README.

1. **Turn on the plugin's tools.** In the chat box, click **Configure tools** (the sliders icon). Search for `appmod`, and make sure **appmod-mcp-server** is ticked. If it says **Stopped**, click **Start**. Then click **Apply**. With these tools, Copilot plans the upgrade, builds the app, runs the tests and checks for CVEs.

   ![Configure Tools, with appmod-mcp-server ticked and running, and its upgrade plan, build, CVE and test tools](../screenshots/05-app-modernization/tools.png)

2. **Ask the upgrade agent.** Start a new chat, and choose the **modernize-java-upgrade** agent. Under the chat box, make sure it says **Copilot**, not **Local**. Then send:

   > Upgrade this app to Java 25 and the latest Spring Boot 4

   ![The modernize-java-upgrade agent with the prompt, running on this computer with Copilot](../screenshots/05-app-modernization/prompt.png)

   The **Upgrade Runtime & Frameworks** button in the tool window starts the same upgrade, but in a **Local** chat. With version 1.14.0 of the plugin, that chat stops at its first command, because the plugin stops IntelliJ's terminal from starting ([known issue](https://github.com/microsoft/github-copilot-appmod/issues/213)). The **Copilot** chat runs commands without IntelliJ's terminal.

3. **Check the plan.** Copilot writes an upgrade plan, `plan.md`, in `.github/modernize/java-upgrade/`: the goals, and each library's current and new version. Then it makes a branch, `appmod/java-upgrade-<id>`, and upgrades in steps. It builds the app after each step, and commits it.

   ![plan.md: the goals are Java 25 and Spring Boot 4.1.2, and a table lists each technology's current version and the version it needs](../screenshots/05-app-modernization/plan.png)

4. **Read the summary.** At the end, Copilot checks the libraries for known CVEs, runs the tests, and writes `summary.md` next to the plan. In this run, the upgrade took about 7 minutes.

   ![summary.md: Java 1.8 to 25, Spring Boot 2.7.18 to 4.1.2, javax to jakarta, JUnit 4 to JUnit 5, Guava 28.1 to 33.8, and no known CVEs](../screenshots/05-app-modernization/summary.png)

5. **Check the tests.** Review what Copilot changed, especially in the tests. Spring Boot 4 moved MockMvc to its own test starter. So, in this run, Copilot rewrote the MockMvc test of the home page as a unit test of the controller: it passed, but it no longer tested the page. If yours did that too, send:

   > Keep the MockMvc test of the home page in StoreApplicationTests. Add the test starter that Spring Boot 4 needs for it, instead of rewriting the test.

   ![The follow-up prompt, after the upgrade changed 8 files](../screenshots/05-app-modernization/fix-prompt.png)

6. **Run the store.** Click **Keep All**. Press Ctrl+Shift+O to load the Maven changes, and run **StoreApplication** from the toolbar. http://localhost:8080 shows the six products, and Spring Boot 4.

   ![Trail Store on Spring Boot 4.1.2, with the six products](../screenshots/05-app-modernization/store.png)

## What you used

- **GitHub Copilot modernization**: its **modernize-java-upgrade** agent plans the upgrade, changes the code in steps, and builds and tests the app after each step. Its **appmod-mcp-server** tools do the planning, building, testing and CVE check. The plan, progress and summary stay in `.github/modernize/java-upgrade/`, which git ignores.

## The code

Copilot's changes, after the follow-up prompt. In `pom.xml`:

```diff
-        <version>2.7.18</version>
+        <version>4.1.2</version>

-        <java.version>1.8</java.version>
+        <java.version>25</java.version>

-            <version>28.1-jre</version>
+            <version>33.8.0-jre</version>

-            <groupId>org.junit.vintage</groupId>
-            <artifactId>junit-vintage-engine</artifactId>
+            <groupId>org.springframework.boot</groupId>
+            <artifactId>spring-boot-starter-webmvc-test</artifactId>
```

In `Catalog.java` and `StoreController.java`, `javax` becomes `jakarta`:

```diff
-import javax.annotation.PostConstruct;
+import jakarta.annotation.PostConstruct;

-import javax.servlet.http.HttpServletResponse;
+import jakarta.servlet.http.HttpServletResponse;
```

In `CatalogTest.java` and `StoreApplicationTests.java`, JUnit 4 becomes JUnit 5, and `AutoConfigureMockMvc` moves to a new package:

```diff
-import static org.junit.Assert.assertEquals;
+import static org.junit.jupiter.api.Assertions.assertEquals;

-import org.junit.Test;
+import org.junit.jupiter.api.Test;

-import org.junit.runner.RunWith;
-import org.springframework.test.context.junit4.SpringRunner;
-@RunWith(SpringRunner.class)

-import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
+import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
```
