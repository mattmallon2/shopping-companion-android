# shopping-companion-android

The Android application component of the Shopping Companion.

## Table of Contents

* [Getting Started](#getting-started)
* [Working with Files](#working-with-files)
  * [Editing Page Layout](#editing-page-layout)
  * [Editing Strings](#editing-strings)
* [Current Page Statuses](#current-page-statuses)

## Getting Started

`cd` into the directory you want to house the project. Clone the repo and `cd` into it.

After cloning, to see all the remote branches run `git branch -a`, or see [this Stack Overflow post](https://stackoverflow.com/questions/67699/how-to-clone-all-remote-branches-in-git).

## Working with Files

### Editing Page Layout

If there's a page that already looks pretty similar to the new one, it's easiest to copy and paste. Find page layouts to copy at ```app/res/layout/*.xml```

### Editing Strings

In Android Studio, strings are not hardcoded. They are stored at ```app/res/values/strings.xml```

## Current Page Statuses

* activity_main.xml
  * The main entry point to the app. Returning users may log in here.
  * **Finished layout. No functionality. No links between pages.**

* sign_up.xml
  * New users may sign in here.
  * **Just getting started.**