# #52WeekChallenge

## Task Background
Technology is only useful in as far as, it enables us to do more. We want you to develop a small and simple app that helps us project how much we would be able to save over a 52-week period if we started with a certain amount n, and progressively added n to our deposits for each subsequent week. For example if I started with a deposit of Kshs. 50/= in week 1 for a total savings of 50, in week 2 I would deposit Kshs. 100/= for a total savings of 150, in week 3, I would deposit Kshs. 150/= for total savings 300…..and so on… 
For reference visit https://52weekchallenge.site/ to understand how we want this app to function.

## Task Description
Create a simple Android app using good Material Design principles to enable users to enter any arbitrary starting amount and be able to see in real time;
- The total saving after the 52 week period
- A breakdown of each weeks deposit value and each weeks total savings

The app should use the following technologies
- Java 1.8+/Kotlin

#### Conventions to follow when working on this exercise:
- Commit your code to your local git repository and post this code to a repo on Github.
- The input text fields should handle error cases for all manner of edge cases
- You must write unit tests for your application and these tests must test the core logic of your app.
- Your app must be structured using a design pattern of your choice either MVP, MVVM, MVI, or Clean Code Architecture
- Bonus: Implement code coverage and add a coverage badge to your GitHub repo


### Functional requirements:
- Users should be able to enter any arbitrary integer amount between a range of 0<n<50,000,000, as a starting amount.
- User should be able to see in real time the calculation result for each digit they input. For example if I put in 120, the UI should be responsive enough to show me the calculations for the input “1” and the input “12” and finally the input “120”
- User should be able to scroll from the first week of saving to the last week of saving.
- Users should be able to delete starting amounts

### Non-functional requirements:
- Proper separation of concerns in terms of view logic, business logic, and models (if any).
- Unit tests
- README file for the technical set up of the project


### BONUS AREAS:
- Documentation in the code using document comments
- Create a splash screen animation on the first load of your app.
- Using any Android Architecture Components in your final app.
- Using RxJava
- Writing Espresso Tests for your UI
