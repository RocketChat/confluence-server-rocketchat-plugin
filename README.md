# Rocket.Chat for Confluence

This plugin sends notifications to a Rocket.Chat server when pages are created and updated in your [Confluence](https://www.atlassian.com/software/confluence)

**Please note that you will need the Confluence Server Integration Rocket.Chat App installed on your Rocket.Chat server as well**

Compiling from source
---------------------

You first need to [Set up the Atlassian Plugin SDK](https://developer.atlassian.com/docs/getting-started/set-up-the-atlassian-plugin-sdk-and-build-a-project). Then, at the project top level (where the pom.xml is) :

1. Compile : `atlas-mvn compile`
2. Run : `atlas-run`
3. Debug : `atlas-debug`