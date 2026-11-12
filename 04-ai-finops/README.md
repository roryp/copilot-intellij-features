# Week 4: AI FinOps

**What does a task cost?** · Part 4 of 5 · [All weeks](../README.md)

## The problem

Your manager asks what a Copilot task costs. Find out: give Copilot the same small task twice, with two different settings, and compare.

The task is a JSON API for the store:

- `GET /api/products` returns all six products.
- `GET /api/products/{sku}` returns one product, or 404 when there's no such product.

## Use

- **Copilot Fusion**: one choice instead of a model, with Standard or Max effort.
- **Agent debug logs**: what each session used, in tokens and AI credits.
- **OpenTelemetry**, optional: the same data in a trace viewer. It needs Docker, installed and running.

## Get started

Run the tests:

```bash
cd 04-ai-finops
./mvnw -B -ntp verify
```

On Windows, use `.\mvnw.cmd -B -ntp verify`. `ApiTests` fails.

## Done when

- [ ] All the tests pass.
- [ ] [cost-report.md](cost-report.md) has the numbers for both runs.
- [ ] You can say which run cost more, and why.

Stuck? Read the [solution](SOLUTION.md).
