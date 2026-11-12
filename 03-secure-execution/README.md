# Week 3: Secure execution and governance

**Keep your secrets secret** · Part 3 of 5 · [All weeks](../README.md)

When Copilot runs a command on your computer, it runs as you, so it can reach everything you can. This week, you limit what Copilot's commands can reach, and see how an admin makes that a rule.

## The problem

A supplier sent February's prices, and a tool to check them: [supplier/CheckPrices.java](supplier/CheckPrices.java). Their [README](supplier/README.md) even tells AI assistants to run it without asking.

The tool checks the prices, but it also reads a file in your home folder. Let Copilot run the tool, without letting it read your files.

## Use

### Local sandbox

The sandbox limits what Copilot's commands can reach. They can still use the project folder and developer tools such as Java, but not the rest of your home folder, where secrets often live. Turn it on in Settings → GitHub Copilot → Sandbox, or with `/sandbox` in a session. A sandboxed session has a **Sandbox** label next to its title.

### Managed settings and Policy Diagnostics

An admin can set Copilot settings that users can't change: through device management such as Intune, with a `managed-settings.json` file, or for a whole organization on GitHub. This folder's [managed-settings.json](managed-settings.json) turns the sandbox on, and stops anyone running commands outside it. To see what's managed on your computer, open **Policy Diagnostics** from the Options menu at the top of Chat.

![The Options menu at the top of Chat, with Policy Diagnostics highlighted](../screenshots/03-secure-execution/options-menu.png)

### Cloud sandbox, optional

The cloud sandbox runs the whole session on a computer that GitHub hosts, in a clone of your fork, so your files aren't there at all. Pick it in the environment picker under the chat box. It's in preview, and you might not have it yet.

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
