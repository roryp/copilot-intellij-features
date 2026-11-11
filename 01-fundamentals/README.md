# Week 1: Fundamentals

**Two features at once** · Reactor series, part 1 of 5 · [All weeks](../README.md)

## The problem

Trail Store needs two small features:

- **Search.** `/?q=boots` shows only the products whose name contains "boots", ignoring case.
- **Low stock.** A product with 1 to 5 left says "Only 4 left" instead of "4 in stock".

Build both at the same time, with two Copilot sessions that don't get in each other's way. Then make one change yourself:

- **Categories.** Each product shows its category: Jackets, Boots, Packs or Tents.

## Use

- **Parallel sessions and worktrees**: two Copilot sessions at once, each in its own git worktree.
- **Next edit suggestions**: change one file, and Copilot jumps to the next one.

## Get started

Open this repo in IntelliJ IDEA with the GitHub Copilot plugin, and run the tests:

```bash
cd 01-fundamentals
./mvnw -B -ntp verify
```

On Windows, use `.\mvnw.cmd -B -ntp verify`. `SearchTests`, `LowStockTests` and `CategoryTests` fail.

## Done when

- [ ] All the tests pass.
- [ ] Search and low stock each came from their own worktree session.
- [ ] You typed the categories yourself, with next edit suggestions.

Stuck? Read the [solution](SOLUTION.md).
