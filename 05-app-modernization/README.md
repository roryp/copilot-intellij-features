# Week 5: App modernization

**An old app, a new home** · Part 5 of 5 · [All weeks](../README.md)

> 🚧 TBC

Old apps get harder to run and to keep secure as Java and its libraries move on. This week, you let Copilot bring one up to date, and move it to Azure.

## The problem

An old Java app runs on an old Java version, with old libraries. Bring it up to date and run it on Azure, without rewriting it.

## Use

### GitHub Copilot modernization

This separate plugin for IntelliJ modernizes an app in steps: it assesses the app, upgrades Java and the dependencies, and migrates and deploys the app to Azure.

## Get started

- Install the **GitHub Copilot modernization** plugin from JetBrains Marketplace.
- For the deploy step, you need an Azure subscription and the [Azure CLI](https://learn.microsoft.com/cli/azure/install-azure-cli).
- The sample app: TBC.

## Done when

- [ ] The app builds, and its tests pass, on the new Java version.
- [ ] The app runs on Azure.
- [ ] You deleted the Azure resources.

Stuck? Read the [solution](SOLUTION.md).
