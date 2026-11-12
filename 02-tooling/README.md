# Week 2: Tooling

**Free jackets** · Reactor series, part 2 of 5 · [All weeks](../README.md)

## The problem

It's sale week: every jacket is 20% off. But the store sells the jackets for $0.

Find the bug and fix it. Copilot does the work with IntelliJ's own test runner, debugger and refactorings.

## Use

- **Customization panel**: a plugin, a custom agent and a skill.
- **Built-in MCP server**: Copilot runs IntelliJ's tests, debugger and rename refactoring.
- **Browser use**, optional: Copilot checks the page in a browser.

## Get started

Copilot uses IntelliJ's test runner and debugger this week, so set up the project in IntelliJ first:

- If the **Maven** tool window is empty, right-click the `pom.xml` at the top of the repo, and choose **Add as Maven Project**.
- In File → Project Structure → Project, set **SDK** to JDK 25.

Then run the tests:

```bash
cd 02-tooling
./mvnw -B -ntp verify
```

On Windows, use `.\mvnw.cmd -B -ntp verify`. `SaleTests` fails: the jackets should cost $79, $111 and $119.

## Done when

- [ ] All the tests pass.
- [ ] Copilot found the bug in IntelliJ's debugger.
- [ ] `all()` in `Catalog.java` is renamed to `products()`, by IntelliJ's rename refactoring.
- [ ] Customizations lists your plugin, agent and skill.

Stuck? Read the [solution](SOLUTION.md).
