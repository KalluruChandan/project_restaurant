Workflow
1. Development:

Create feature branches off develop.
Work on the feature, commit, and push changes to the feature branch.
When the feature is complete, open a pull request (PR) to merge into test.
2. Testing:

Merge feature branches into the test branch for unit and integration testing.
Fix any issues and merge test into develop once all tests pass.
3. Staging:

Merge develop into staging for user acceptance testing (UAT) and final validation.
Conduct thorough testing and approve features for production.
4. Production Deployment:

Once everything is validated on staging, merge staging into main.
Tag the release for tracking: v1.0.0, v1.1.0, etc.
5. Hotfixes (if necessary):

Branch off main for urgent fixes, and merge back into main, develop, and staging (if applicable).