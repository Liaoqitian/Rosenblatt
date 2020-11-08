# Javascript and the DOM 

## Table of Contents
- [The document keyword](#The-document-keyword)
- [Tweak an Element](#Tweak-an-Element)
- [Select and Modify Elements](#Select-and-Modify-Elements)
- [Style an element](#Style-an-element)
- [Create and Insert Elements](#Create-and-Insert-Elements)
- [Remove an Element](#Remove-an-Element)
- [Interactivity with onclick](#Interactivity-with-onclick)
- [Traversing the DOM](#Traversing-the-DOM)
- [Review](#Review)


## The document keyword

The *Document Object Model*, abbreviated DOM, is a powerful tree-like structure that organizes the elements on a web page and allows scripting languages to access them. This interface is implemented by every modern browser.

The `document` object in JavaScript is the door to the DOM structure. The `document` allows you to access the root node of the DOM tree. Before you can access a specific element in the page, first you must access the document structure itself. The `document` allows scripts to access children of the DOM as properties.

For example, if you wanted to access the `<body>` element in your script, you could access it as a property of the `document` by typing `document.body`. This property will return the body element of that DOM.

Similarly, you could access the `<title>` element with the `.title` property. See a [comprehensive list](https://developer.mozilla.org/en-US/docs/Web/API/Document) of all `document` properties.



## Tweak an Element

When using the DOM in your script to access an HTML element, you also have access to all of that element’s properties.

This includes the ability to modify the contents of the element as well as its attributes and properties— that can range from modifying the text inside a `p` element to assigning a new background color to a `div`.

You can access and set the contents of an element with the `.innerHTML` property.

For example, the following code reassigns the inner HTML of the body element to the text ‘The cat loves the dog’:

```js
document.body.innerHTML = 'The cat loves the dog.';
```

The `.innerHTML` property can also add any valid HTML, including properly formatted elements. The following example assigns an `h2` element as a child inside the `<body>` element:

```js
document.body.innerHTML = '<h2>This is a heading</h2>';
```



## Select and Modify Elements

The DOM interface allows us to access a specific element with CSS selectors. **CSS selectors** define the elements to which a set of CSS rules apply, but we can also use these same selectors to access DOM elements with our script! Selectors can include the name of the tag, a class, or an ID.

The `.querySelector()` method allows us to specify a CSS selector and then returns the first element that matches that selector. The following code would return the first paragraph in the document.

```js
document.querySelector('p');
```

You can also use other CSS selectors such as an element’s `.` class or its `#` ID.

Another option, if you want to access elements directly by their `id`, you can use the aptly named `.getElementByID()` function:

```js
document.getElementById('bio').innerHTML = 'The description';
```

The example chains so that it selects the element with an ID of ‘bio’ and set its `.innerHTML` to the text ‘The description’.



## Style an element

Another way to modify an element is by changing its CSS style. The `.style` property of a DOM element provides access to the inline style of that HTML tag.

The syntax follows an `element.style.property` format, with the `property` representing a CSS property.

For example, the following code selects the first element with a `class` of `blue` and assigns blue as the `background-color`:

```js
let blueElement = document.querySelector('.blue');
blueElement.style.backgroundColor = 'blue';
```

Unlike CSS, the DOM style property does not implement a hyphen such as `background-color`, but rather camel case notation `backgroundColor`. Check out this [MDN reference page](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Properties_Reference) to see a list of how CSS properties are converted into JavaScript.

The following *chaining* syntax would also work:

```js
document.querySelector('.blue').style.fontFamily = 'Roboto';
```



## Create and Insert Elements

Just as the DOM allows scripts to modify existing elements, it also allows for the creation of new ones.

The `.createElement(tagName)` method creates a new element based on the specified tag name passed into it as an argument. However, it does not append it to the document. It creates an empty element with no inner HTML.

In order to create an element and add it to the web page, you must **assign it to be the child of an element that already exists on the DOM**. We call this process appending. The `.appendChild()` method will add a child element as the last child node.

The following code creates a new paragraph element, gives it an `id`, adds text to the new element’s `.innerHTML`, and appends it to the body of the document:

```js
let paragraph = document.createElement('p');
paragraph.id = 'info'; 
paragraph.innerHTML = 'The text inside the paragraph';
document.body.appendChild(paragraph);
```

Unlike the `.innerHTML` property, the `.appendChild()` method does not replace the content inside of the parent, in this case `body`. Rather, it appends the element as the last child of that parent.



## Remove an Element

In addition to modifying or creating an element from scratch, the DOM also allows for the removal of an element. The `.removeChild()` method removes a specified child from a parent.

Because the `.querySelector()` method returns the first paragraph, the following code would remove the first paragraph in the document:

```js
let paragraph = document.querySelector('p');
document.body.removeChild(paragraph);
```

It’s possible to also specify a different parent with the `.querySelector()` method, as long as you remove an element nested within that parent element.

If you want to hide an element because it does not need to be loaded initially, the `.hidden` property allows you to hide it by assigning it as true or false:

```js
document.getElementById('sign').hidden = true;
```

The code above did not remove the element from the DOM, but rather hid it. This is not the same as setting the CSS visibility property to hidden. For a list of the best use cases for this property, read a list in the [MDN documentation](https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/hidden).



## Interactivity with onclick

You can add interactivity to DOM elements by assigning a function to run based on an [event](https://developer.mozilla.org/en-US/docs/Web/Events).

Events can include anything from a click to a user mousing over an element.

The `.onclick` property allows you to assign a function to run on a click event on an element:

```js
let element = document.getElementById('interact');
element.onclick = function() { element.style.backgroundColor = 'blue' };
```



## Traversing the DOM

In the DOM hierarchy, parent and children relationships are defined in relation to the position of the root node.

A **parent node** is the closest connected node to another node in the direction towards the root.

A **child node** is the closest connected node to another node in the direction away from the root.

These relationships follow the nesting structure present in HTML code. Elements nested within one HTML tag are children of that parent element.

Each DOM element node has a `.parentNode` and `.children` property. The property will return a list of the element’s children and return `null` if the element has no children.

The `.firstChild` property will grant access to the first child of that parent element. 

See the example below where `first`‘s `.innerHTML` is modified to `'I am the child!'`, and the `.innerHTML` of `first`'s parent node is modified to `'I am the parent and my inner HTML has been replaced!'`. 

```js
let first = document.body.firstChild; 
first.innerHTML = 'I am the child!'; 

let parent = first.parentNode; 
parent.innerHTML = 'I am the parent and my inner HTML has been replaced!'; 
```



## Review

- The `document` keyword grants access to the root of the DOM in JavaScript
- The DOM Interface allows you to select a specific element with CSS selectors by using the `.querySelector()` method
- You can also access an element directly by its ID with `.getElementById()`
- The `.innerHTML` and `.style` properties allow you to modify an element by changing its contents or style respectively
- You can create, append, and remove elements by using the `.createElement()`,`.appendChild()` and `.removeChild()` methods respectively
- The `.onclick` property can add interactivity to a DOM element based on a click event