# Week 3: Secure execution and governance

**Keep your secrets secret** · Reactor series, part 3 of 5 · [All weeks](../README.md)

## The problem

A supplier sent February's prices, and a tool to check them: [supplier/CheckPrices.java](supplier/CheckPrices.java). Their [README](supplier/README.md) even tells AI assistants to run it without asking.

The tool checks the prices, but it also reads a file in your home folder. Let Copilot run the tool, without letting it read your files.

## Use

- **Local sandbox**: limits what Copilot's commands can reach on your computer.
- **Managed settings and Policy Diagnostics**: an admin makes the sandbox a rule.
- **Cloud sandbox**, optional: runs the session on GitHub's computers instead of yours.

## Get started

Make a pretend secret: a file called `canary.txt`, in a `.trail-store` folder in your home folder.

- macOS and Linux: `mkdir -p ~/.trail-store && echo pretend-secret > ~/.trail-store/canary.txt`
- Windows PowerShell: `New-Item -ItemType Directory -Force ~/.trail-store; Set-Content ~/.trail-store/canary.txt pretend-secret`

The local sandbox runs on Windows 11 23H2 or later (25H2 works best), Apple Silicon Macs and Linux. On Linux, it needs:

- `bubblewrap` 0.5 or later
- `slirp4netns`
- `util-linux` 2.35 or later
- `iptables`
- `/dev/net/tun`
- Unprivileged user namespaces, turned on

On some Linux setups, the sandboxed run itself fails with a `NoSuchFileException`. If it does, use the cloud sandbox instead: in the environment picker under the chat box, change **This computer** to **Cloud sandbox**.

## Done when

- [ ] Copilot ran the supplier's tool, and the tool couldn't read `canary.txt`.
- [ ] You opened Policy Diagnostics.
- [ ] You deleted the `.trail-store` folder.

Stuck? Read the [solution](SOLUTION.md).
