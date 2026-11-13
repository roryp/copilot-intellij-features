# Week 3 solution: Keep your secrets secret

How to solve [the challenge](README.md) with GitHub Copilot in IntelliJ IDEA.

## 1. Run the tool without the sandbox

At the top of Chat, click **+** to start a new session. The sandbox is off, unless you turned it on in Settings. Send:

> In 03-secure-execution, run the supplier's price checker. Run it as is: don't change user.home, and don't use a temporary home folder.

Copilot runs the tool. If it asks first, tell it to run the tool without the sandbox, and without changing `user.home`. Its output shows that it read your secret:

```text
Checked 6 prices: OK
Reading C:\Users\you\.trail-store\canary.txt: done, it says "pretend-secret"
```

![Copilot's answer: the price checker read the pretend secret](../screenshots/03-secure-execution/run-without-sandbox.png)

## 2. Run it in the sandbox

If you turned on IntelliJ's MCP server in week 2, turn it off first: in Settings → MCP Server (in some versions, under AI), untick **Enable MCP Server**. The sandbox covers only Copilot's own commands, not IntelliJ's MCP server: in a sandboxed session, its `execute_terminal_command` can still read `canary.txt`, and it may run commands without asking.

Turn on Settings → GitHub Copilot → Sandbox → **Enable Sandbox by default for new Copilot sessions**. The setting only affects new sessions, so start a new session after you turn it on.

![Settings, GitHub Copilot, Sandbox, with Enable Sandbox by default for new Copilot sessions selected](../screenshots/03-secure-execution/sandbox-setting.png)

Check that the new session has a **Sandbox** label next to its title, and send the same prompt. If Copilot wants to change `user.home` or use a temporary home folder, tell it not to. This time the tool can't read the file, so it prints `failed`:

```text
Checked 6 prices: OK
Reading C:\Users\you\.trail-store\canary.txt: failed, java.nio.file.AccessDeniedException: ...
```

![Copilot's answer in a session labeled Sandbox: the price checker couldn't read the secret](../screenshots/03-secure-execution/run-in-sandbox.png)

*A sandboxed session has a **Sandbox** label next to its title.*

Then check which tool ran the price checker. In Chat, its step must say **Ran**, followed by the command: that's Copilot's own command tool. A step that says **Invoked**, followed by a server's name such as `intellij-idea`, is an MCP server's tool, outside the sandbox: turn that server off, and try again in a new session.

It worked only if all four are true: the session has the **Sandbox** label, Copilot's own command tool ran the price checker, it printed `Checked 6 prices: OK`, and it couldn't read `canary.txt`, which step 1 showed is there. That shows that this command ran in the sandbox. It doesn't prove that every tool is contained: IntelliJ's MCP server, for one, runs outside it.

On Linux, a working sandbox looks the same, except the failure is a `NoSuchFileException` instead of `AccessDeniedException`. If the run itself fails, with no `OK` line, use the [cloud sandbox](#4-try-the-cloud-sandbox-optional) instead.

Sandboxed commands can use the project folder and developer tools such as Java, but not the rest of your home folder. If Copilot asks to run something outside the sandbox, choose **Reject**.

In a session that has started, `/sandbox enable` and `/sandbox disable` turn the sandbox on and off for that session.

## 3. Make it a rule

An admin can require the sandbox for everyone with managed settings. [managed-settings.json](managed-settings.json) turns the sandbox on, and stops anyone running Copilot's own commands outside it:

```json
{
  "sandbox": {
    "enabled": true,
    "allowBypass": false
  }
}
```

It doesn't control IntelliJ's MCP server, whose commands run outside the sandbox, so keep that server off.

To see what your organization manages, open **Policy Diagnostics** from the Options menu at the top of Chat. It's only in a **This computer** session.

![The Options menu at the top of Chat, with Policy Diagnostics highlighted](../screenshots/03-secure-execution/options-menu.png)

![The Policy Diagnostics report, open in an editor tab](../screenshots/03-secure-execution/policy-diagnostics.png)

*The report opens in an editor tab. Managed settings with no value show `null`.*

To demo it, on a computer where you're an admin, copy the file into one of these folders and restart IntelliJ:

- Windows: `C:\Program Files\GitHubCopilot\`
- macOS: `/Library/Application Support/GitHubCopilot/`
- Linux: `/etc/github-copilot/`

Now **Enable Sandbox by default for new Copilot sessions** is locked on, `/sandbox disable` is refused, and Policy Diagnostics shows the `sandbox` settings. Delete the file and restart IntelliJ when you're done.

If your organization already manages Copilot on that computer, for example with a Windows registry policy, the file is ignored. Policy Diagnostics shows what's managed.

## 4. Try the cloud sandbox (optional)

The cloud sandbox is in preview, and rolling out in phases. In the row under the chat box, change **This computer** to **Cloud sandbox**. The session runs on a Linux computer that GitHub hosts, in a clone of your GitHub fork, so your local files aren't there at all. The cloud session's model picker is different from a **This computer** session.

![The environment picker under the chat box, listing This computer and Environments](../screenshots/03-secure-execution/environment-picker.png)

*The environment picker. **Cloud sandbox** is listed here once it reaches your account.*

## 5. Clean up

Delete the `.trail-store` folder from your home folder.

## What you used

- **GitHub Copilot:** the Sandbox setting, `/sandbox`, Policy Diagnostics, the cloud sandbox.
- **IntelliJ IDEA:** Settings, and the terminal, to make the pretend secret.
