# Week 5 solution: An old app, a new home

How to solve [the challenge](README.md) with GitHub Copilot in IntelliJ IDEA.

> 🚧 TBC

## The steps

Open the **GitHub Copilot modernization** tool window on the left.

1. **Assess.** Click **Start Assessment**. The plugin scans the app's code, configuration and dependencies, and opens an **Assessment Report**.
2. **Upgrade.** Click **Upgrade Runtime & Frameworks**. Copilot upgrades Java and the dependencies, fixes the build, and runs the tests.
3. **Migrate.** In the report, choose a solution, and click **Run Task**. Copilot changes the code to use Azure services.
4. **Deploy.** Under **Deployment Tasks**, run **Provision Infrastructure and Deploy to Azure**. Copilot writes the infrastructure files and deploys the app with the Azure CLI.

When you're done, delete the resource group, for example with `az group delete --name <resource-group>`.
