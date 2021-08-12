# The Shoe Store Android App

This app project consist of five screens for a fictitious shoe store as follows:

1. Login screen: Email and password fields and labels plus create and login buttons
2. Welcome onboarding screen
3. Instructions onboarding screen
4. Shoe Listing screen
5. Shoe Detail screen for adding a new shoe


### Notes for Assessor
- The app is error free, compiles and runs, however, there are a few warnings in some of the fragment files that when implementing the suggested fix completely breaks the app. Therefore, I have left those warnings as is since the rubric doesn’t specify app should be free of warnings. I believe these are predominately due to the age of the starter file.

- onboarding screens are the welcome and instructions screens. These screens cannot be navigated to once user navigates away from them (without going back to the login screen and traversing the navigation pathway again)

- When navigating from the instructions screen to the shoe list screen, a sample shoe item is created for example purposes and so the list always has at least one shoe item

- When saved button is pressed on the details screen, if any (or all) edit text field/s is null, empty or blank, then a default value (such as “<field> not provided”) is provided for that edit text field. This is to handle any null values and ensure the shoe item list contains a value for each shoe item property

- Safe args have been setup to pass data between details screen and shoe list screen, however, they are not used to update the view model data or UI. I have left the args code in place for future feature updates to the app

- Although a more modern approach for handling lists is to use recyclerview, this project seems to want students to not use recyclerview, therefore list view has been used for displaying the list of shoe items


## Getting Started

This project's repository can be cloned via git or downloaded as a zip file.

### Installation

Once the project files are downloaded, open and run the project using the lastest stable version of Android Studio.

### Dependencies

None. (All project dependencies have already been included in the project gradel files).

