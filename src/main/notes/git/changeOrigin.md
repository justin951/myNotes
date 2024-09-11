To reset the origin of your local repository after deleting the remote repository, you can follow these steps:

### 1. **Remove the current origin**:
First, you'll want to remove the old origin (which is now invalid due to the remote repository being deleted).

Run this command:

```bash
git remote remove origin
```

This will delete the reference to the old remote repository.

### 2. **Add the new remote repository**:
After deleting the remote, you can set a new remote repository by running the following command:

```bash
git remote add origin <new-remote-repository-URL>
```

Replace `<new-remote-repository-URL>` with the URL of the new remote repository you want to set (e.g., `https://github.com/justin951/new-repo.git`).

### 3. **Verify the new remote origin**:
After setting the new remote repository, you can verify that the origin has been updated correctly by running:

```bash
git remote -v
```

This should display the new origin URL you just set.

### 4. **Push the changes to the new repository**:
Finally, push the local repository to the new remote repository using:

```bash
git push -u origin main
```

If your default branch is named something other than `main` (e.g., `master`), replace `main` with the appropriate branch name.
