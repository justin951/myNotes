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