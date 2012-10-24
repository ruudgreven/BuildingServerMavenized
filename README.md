# Prerequisites 
This project is meant to run under Java 7 and Tomcat 7. Please make sure you have these installed.

You need to have GIT installed on your local system (with SSH key support). Check https://help.github.com/articles/generating-ssh-keys

You also need to have Eclipse JEE installed (We tested it with Eclipse JEE Juno).


# Add Eclipse plugins
- Start Eclipse, just choose a workspace (I suggest an empty one)
- Open Eclipse Market Place (Help -> Eclipse Market Eclipse)
- Find the following plugins and install them:
    - eGit
    - Maven Integration For Eclipse
    - Checkstyle Plug-in
    - FindBugs Eclipse Plugin
- Open Preferences -> Maven -> Discovery -> "Open Catalog" and choose to install the following:
    - m2e-egit connector
    - Checkstyle M2E
    - (when you also want to developer for Android: Android Connector)
- Set JAVA_HOME environmental variable (on Mac or Linux add the line "export JAVA_HOME=\`/usr/libexec/java_home\`" to .profile, additionally for mac run the following command in a terminal "defaults write $HOME/.MacOSX/environment JAVA_HOME "/Library/Java/Home"". For Windows check http://www.robertsindall.co.uk/blog/setting-java-home-variable-in-windows/ )
- Restart Eclipse


# Load the project
- Start with a new workspace
- Go to the "Git Repository Exploring" perspective.
- Choose "Clone a Git repository and add the clone to this view" (One of the small buttons on top of the Git repositories view).
- Add the SSH path to your Git repository (e.g. git@github.com:ruudgreven/BuildingServerMavenized.git )
- Click next, your project should be found, then finish
- Right click on the imported repository and choose "Import Maven Project". Select the project and click Finish. This takes some time.
- Switch back to the Java EE Perspective.
- Choose Team -> Share Project
- Choose Git, click next and finish.
- Right click on project -> Choose Run As -> Maven install to prepare and build your project.

# Run the project
- Just run the project in the same way as always, just click the run button, choose run on server.

# Commit code
- Right click on project -> Team -> Commit
- Enable the checkbox "Push changes to GitHub" to push changes immediately to GitHub

# Clean up project using Maven
- Right click on project -> Run As -> Maven Clean

# Build a war with Maven
- Right click on project -> Run As -> Maven install
- Under target you find your builded project. (The war file does not contain the external libraries default, it assumes the server contains them).

