If the `notes` folder was already being tracked by Git before you added it to the `.gitignore` file, Git will continue to track the folder despite the `.gitignore` rule.

Here’s how you can stop Git from tracking the `notes` folder:

1. **Remove the folder from the Git index**:
   Run the following command to remove the `notes` folder from Git's tracking, but keep it in your local file system:
   
   ```bash
   git rm -r --cached notes
   ```

   The `--cached` option removes the folder from the index (staging area) without deleting it from your local machine.

2. **Commit the changes**:
   After running the command, commit the removal of the folder:
   
   ```bash
   git commit -m "Stop tracking notes folder"
   ```

3. **Push the changes to the remote repository**:
   Finally, push the changes to the remote repository:
   
   ```bash
   git push origin main
   ```

This process will stop Git from tracking the `notes` folder, and since it’s now in the `.gitignore` file, future changes to this folder will not be tracked or pushed to the remote repository.

***
***
***

The error you're seeing indicates that Git is not tracking the `notes` folder at the moment. However, if the folder is still being pushed to the remote repository, it may be due to one of the following reasons:

1. **The folder is named differently**: Double-check that the folder you are trying to ignore is indeed named `notes` and that the name is spelled correctly in both the `.gitignore` file and the file system.

2. **The `.gitignore` file may not be working as expected**: Make sure that your `.gitignore` file is in the root of your repository and contains the correct path for the `notes` folder.

Here’s how you can troubleshoot:

1. **Check if Git is tracking the folder**:
   Run the following command to see if Git is currently tracking anything inside the `notes` folder:
   
   ```bash
   git ls-files | grep notes
   ```

   If nothing appears, Git is not tracking the `notes` folder or its contents.

2. **Check if the `.gitignore` file is correctly configured**:
   Ensure your `.gitignore` contains the correct entry to ignore the `notes` folder:
   
   ```
   /notes/
   ```

   This line ensures that Git will ignore the `notes` folder at the root level of your project.

3. **Force a recheck of the `.gitignore` file**:
   Sometimes Git caching causes problems with `.gitignore`. You can run this command to ensure Git properly re-evaluates the `.gitignore` rules:

   ```bash
   git rm -r --cached .
   git add .
   ```

   Then, commit the changes:

   ```bash
   git commit -m "Reapply .gitignore rules"
   ```

   This command removes all files from the cache and then re-adds them according to the current `.gitignore` rules, ensuring the `notes` folder stays ignored.

***
***
***

It seems like the `revature` folder is being re-added due to either a misconfiguration in your `.gitignore` file or a misunderstanding of how paths are handled in `.gitignore`. To resolve this issue, let's go through a few things:

### Check and Update `.gitignore` for the `revature` Folder

1. **Verify the path in `.gitignore`:**

   The line in your `.gitignore` for ignoring the `revature` folder is:
   
   ```
   /java/revature/
   ```

   This seems incorrect for your folder structure. Since your `revature` folder is located under `src/main/java`, you should adjust the `.gitignore` entry like this:
   
   ```bash
   /src/main/java/revature/
   ```

   This tells Git to ignore the `revature` folder at the specific path: `src/main/java/revature/`.

2. **Remove tracking for `revature` folder**:

   After fixing the `.gitignore` entry, use the following command to stop tracking the folder again:

   ```bash
   git rm -r --cached src/main/java/revature
   ```

3. **Add the changes to Git:**

   After running the `git rm` command, stage the changes:

   ```bash
   git add .gitignore
   git add src/main/java/revature/
   ```

   This ensures that Git knows about the removal of the folder from its tracking.

4. **Commit the changes**:

   Now, commit these changes to finalize:

   ```bash
   git commit -m "Fix .gitignore and stop tracking revature folder"
   ```

5. **Push the changes to the remote repository** (if necessary):

   ```bash
   git push origin main
   ```

### Double Check:
- Ensure that there are no trailing spaces or extra characters in the `.gitignore` file.
- If `.gitignore` still doesn’t seem to be working, try specifying the full path relative to the root of your repository.

After these steps, Git should properly ignore the `revature` folder, and it should no longer be added during `git add .`.