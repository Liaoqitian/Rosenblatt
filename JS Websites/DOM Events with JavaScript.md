# DOM Events with JavaScript

## Table of Contents



## What is an Event?

When you refresh your email inbox, double tap on a post, or scroll through a newsfeed — something cool happens in your browser. These actions are known as *events*!

Events on the web are user interactions and browser manipulations that you can program to trigger functionality. Some other examples of events are:

- A mouse clicking on a button
- Webpage files loading in the browser
- A user swiping right on an image

When a user does any of the above actions, they’re causing the event to be *fired* or be *triggered*. As in, “a click event fired when the button was clicked”. Being able to respond to these events makes your website interactive and therefore *dynamic*.



## "Firing" Events

After a specific event fires on a specific element in the [document object model](https://www.codecademy.com/paths/web-development/tracks/build-interactive-websites/modules/web-dev-interactive-websites/lessons/intro-dom/exercises/what-is-the-dom) (or DOM), an *event handler* function can be created to run as a response. In this lesson, we will learn about event handler functions that modify and update DOM elements after an event fires.

Let’s compare the firing of events to something more familiar: a dog trained to eat when they hear the sound of a bell! (This is known as the [Pavlovian conditioning](https://en.wikipedia.org/wiki/Classical_conditioning).)

As you can see in the diagram, the ringing of the bell is analogous to a JavaScript event *firing*. The dog is trained to anticipate the ringing of the bell and this action is analogous to creating an *event listener*. After the dog hears the bell, it’ll come over and eat its food! This response is like an *event handler function* that executes code which, in a website, could change an element’s color, text, and much more!”

Most events in the browser take place without being noticed — the events are undetected because there is no event handler associated with the event to execute an action. Event handlers are crucial for creating interactive websites with JavaScript.



## Event Handler Registration

Now it’s time to dive into using event handler functions to create interactivity.

Using the `.addEventListener()` method, we can have a DOM element listen for a specific event and execute a block of code when the event is detected. The DOM element that listens for an event is called the **event target** and the block of code that runs when the event happens is called the **event handler**.

Let’s take a look at the code below:

```js
let eventTarget = document.getElementById('targetElement');

eventTarget.addEventListener('click', function() {
  // this block of code will run when click event happens on eventTarget element
});
```

Let’s break down the code block: 

- We selected our event target from the DOM using `document.getElementById('targetElement')`.
- We used the `.addEventListener()` method on the `eventTarget` DOM element.
- The `.addEventListener()` method takes two arguments: an event name in *string* format and an event handler function. We will learn about different values we can use as event names in a later lesson.
- In this example, we used the `'click'` event, which fires when the user clicks on `eventTarget`.
- The code block in the event handler function will execute when the `'click'` event is detected.

Instead of using an anonymous function as the event handler, it’s best practice to create a named event handler function. Your code will remain organized and reusable this way, even if your code gets complex. Check out the syntax:

```js
function eventHandlerFunction() {
  // this block of code will run when click event happens
}

eventTarget.addEventListener('click', eventHandlerFunction);
```

The named function `eventHandlerFunction` is passed as the second argument of the `.addEventListener()` method instead of defining an anonymous function within the method!