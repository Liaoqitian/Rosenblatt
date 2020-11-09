# CSS Setup and Selectors

## Table of Contents 

- [Introduction to CSS](#Introduction-to-CSS)
- [Inline Styles](#Inline-Styles)
- [The <style> Tag](#The-<style>-Tag)
- [The .css file](The-css-file)
- [Linking the CSS File](Linking-the-CSS-File)
- [Tag Name](#Tag-Name)
- [Class Name](#Class-Name)
- [Multiple Classes](#Multiple-Classes)
- [ID Name](#ID-Name)
- [Classes and IDs](#Classes-and-IDs)
- [Specificity](#Specificity)
- [Chaining Selectors](#Chaining-Selectors)
- [Nested Elements](#Nested-Elements)
- [Chaining and Specificity](#Chaining-and-Specificity)
- [Multiple Selectors](#Multiple-Selectors)
- [Review CSS Selectors](#Review-CSS-Selectors)



## Introduction to CSS

The basic structure of every web page, HTML, is very plain on its own. The beautiful websites that we see across the internet are styled with a variety of tools, including CSS.

*CSS*, or Cascading Style Sheets, is a language that web developers use to *style* the HTML content on a web page. CSS can help developers to modify colors, font types, font sizes, shadows, images, element positioning, and more. 

Here we will learn how to select which HTML elements we wish to style and set up our CSS file structure.

```html
<link href="style.css" type="text/css" rel="stylesheet">
```

**Question: **What does "cascading" in CSS mean? 

The “cascading” in CSS refers to the fact that styling rules “cascade” down from several sources. This means that CSS has an inherent hierarchy and styles of a higher precedence will overwrite rules of a lower precedence. 



## Inline Styles

Although CSS is a different language than HTML, it is possible to write CSS code directly within HTML code using *inline styles*.

To style an HTML element, we can add the `style` attribute directly to the opening tag. After we add the attribute, we can set it equal to the CSS style(s) we’d like applied to that element.

```html
<p style="color: red;">I'm learning to code!</p>
```

The code in the example above demonstrates how to use inline styling. The paragraph element has a `style` attribute within its opening tag. Next, the `style` attribute is set equal to `color: red;`, which will set the color of the paragraph text to red within the browser.

If we would like to add *more* than one style with inline styles, simply keep adding to the `style` attribute. Make sure to end the styles with a semicolon (`;`).

```html
<p style="color: red; font-size: 20px;">I'm learning to code!</p>
```



## The <style> Tag

Inline styles are a fast way of styling HTML, but they also have limitations. If we wanted to style, for example, multiple `<h1>` elements, we would have to add inline styling to each element manually. In addition, we would also have to maintain the HTML code when additional `<h1>` elements are added.

Fortunately, HTML allows we to write CSS code in its own dedicated section with the `<style>` element. CSS can be written between opening and closing `<style>` tags. To use the `<style>` element, it must be placed inside of the `<head>` element.

```html
<head>
  <style>


  </style>
</head>
```

After adding a `<style>` tag in the head section, we can begin writing CSS code.

```html
<head>
  <style>
    p {
      color: red;
      font-size: 20px;
    }
  </style>
</head>
```

The CSS code in the example above changes the color of all paragraph text to red and also changes the size of the text to 20 pixels. Note how the syntax of the CSS code matches (for the most part) the syntax we used for inline styling. The main difference is that we can specify which elements to apply the styling to.



## The .css file

Developers avoid mixing code by storing HTML and CSS code in separate files (HTML files contain only HTML code, and CSS files contain only CSS code).

We can create a CSS file by using the **.css** file name extension, like so: **style.css**

With a CSS file, we can write all the CSS code needed to style a page without sacrificing the readability and maintainability of our HTML file.



## Linking the CSS File

Now we successfully separated structure (HTML) from styling (CSS), but the web page still looks bland. 

This is because when HTML and CSS code are in separate files, the files must be linked. Otherwise, the HTML file will not be able to locate the CSS code, and the styling will not be applied.

We can use the `<link>` element to link HTML and CSS files together. The `<link>` element must be placed within the head of the HTML file. It is a self-closing tag and requires the following three attributes:

1. `href` — like the anchor element, the value of this attribute must be the address, or path, to the CSS file.
2. `type` — this attribute describes the type of document that you are linking to (in this case, a CSS file). The value of this attribute should be set to `text/css`.
3. `rel` — this attribute describes the relationship between the HTML file and the CSS file. Because you are linking to a stylesheet, the value should be set to `stylesheet`.

When linking an HTML file and a CSS file together, the `<link>` element will look like the following:

```html
<link href="https://www.github.com/stylesheets/style.css" type="text/css" rel="stylesheet">
```

Note that in the example above the path to the stylesheet is a URL:

```
https://www.github.com/stylesheets/style.css
```

Specifying the path to the stylesheet using a URL is one way of linking a stylesheet.

If the CSS file is stored in the same [directory](https://en.wikipedia.org/wiki/Directory_(computing)) as your HTML file, then you can specify a [relative path](https://en.wikipedia.org/wiki/Path_(computing)#Absolute_and_relative_paths) instead of a URL, like so:

```html
<link href="./style.css" type="text/css" rel="stylesheet">
```

Using a relative path is very common way of linking a stylesheet.



## Tag Name

CSS can select HTML elements by using an element’s tag name. A tag name is the word (or character) between HTML angle brackets.

For example, in HTML, the tag for a paragraph element is `<p>`. The CSS syntax for selecting `<p>` elements is:

```css
p {

}
```

In the example above, all paragraph elements will be selected using a CSS *selector*. The selector in the example above is `p`. Note that the CSS selector matches the HTML tag for that element, but without the angle brackets.

In addition, two curly braces follow immediately after the selector (an opening and closing brace, respectively). Any CSS properties will go inside of the curly braces to style the selected elements.



## Class Name

CSS is not limited to selecting elements by tag name. HTML elements can have more than just a tag name; they can also have *attributes*. One common attribute is the `class` attribute. It is also possible to select an element by its `class` attribute.

For example, consider the following HTML:

```html
<p class="brand">Sole Shoe Company</p>
```

The paragraph element in the example above has a `class` attribute within the `<p>` tag. The `class` attribute is set to `"brand"`. To select this element using CSS, we could use the following CSS selector:

```css
.brand {

}
```

To select an HTML element by its class using CSS, a period (`.`) must be prepended to the class’s name. In the example above case, the class is `brand`, so the CSS selector for it is `.brand`.



## Multiple Classes

We can use CSS to select an HTML element’s `class` attribute by name.

So far, we have selected elements using only one class name per element. If every HTML element had a single class, all the style information for each element would require a new class.

Luckily, it’s possible to add more than one class name to an HTML element’s `class` attribute.

For instance, perhaps there’s a heading element that needs to be green and bold. You could write two CSS rules like so:

```css
.green {
  color: green;
}

.bold {
  font-weight: bold;
}
```

Then, you could include both of these classes on one HTML element like this:

```html
<h1 class="green bold"> ... </h1>
```

We can add multiple classes to an HTML element’s `class` attribute by separating them with a space. This enables us to mix and match CSS classes to create many unique styles without writing a custom class for every style combination needed.



## ID Name

If an HTML element needs to be styled uniquely (no matter what classes are applied to the element), we can add an ID to the element. To add an ID to an element, the element needs an `id` attribute:

```html
<h1 id="large-title"> ... </h1>
```

Then, CSS can select HTML elements by their `id` attribute. To select an `id` element, CSS prepends the `id` name with a hashtag (`#`). For instance, if we wanted to select the HTML element in the example above, it would look like this:

```css
#large-title {

}
```

The `id` name is `large-title`, therefore the CSS selector for it is `#large-title`.



## Classes and IDs

CSS can select HTML elements by their tag, class, and ID. CSS classes and IDs have different purposes, which can affect which one you use to style HTML elements.

CSS classes are meant to be reused over many elements. By writing CSS classes, you can style elements in a variety of ways by mixing classes on HTML elements.

For instance, imagine a page with two headlines. One headline needs to be bold and blue, and the other needs to be bold and green. Instead of writing separate CSS rules for each headline that repeat each other’s code, it’s better to write a `.bold` CSS rule, a `.green` CSS rule, and a `.blue` CSS rule. Then you can give one headline the `bold green` classes, and the other the `bold blue` classes.

While classes are meant to be used many times, an ID is meant to style only one element. IDs override the styles of tags and classes. Since IDs override class and tag styles, they should be used sparingly and only on elements that need to always appear the same.



## Specificity

Specificity is the order by which the browser decides which CSS styles will be displayed. A best practice in CSS is to style elements while using the lowest degree of specificity, so that if an element needs a new style, it is easy to override.

IDs are the most specific selector in CSS, followed by classes, and finally, tags. For example, consider the following HTML and CSS:

```html
<h1 class="headline">Breaking News</h1>
h1 {
  color: red;
}

.headline {
  color: firebrick;
}
```

In the example code above, the color of the heading would be set to `firebrick`, as the class selector is more specific than the tag selector. If an ID attribute (and selector) were added to the code above, the styles within the ID selector’s body would override all other styles for the heading. The only way to override an ID is to add *another* ID with additional styling.

Over time, as files grow with code, many elements may have IDs, which can make CSS difficult to edit, since a new, more specific style must be created to change the style of an element.

To make styles easy to edit, it’s best to style with a tag selector, if possible. If not, add a class selector. If that is not specific enough, then consider using an ID selector.



## Chaining Selectors

When writing CSS rules, it is possible to require an HTML element to have two or more CSS selectors at the same time.

This is done by combining multiple selectors, which we will refer to as chaining. For instance, if there was a `.special` class for `h1` elements, the CSS would look like:

```css
h1.special {

}
```

The code above would select only the `h1` elements that have a class of `special`. If a `p` element also had a class of `special`, the rule in the example would not style the paragraph.



## Nested Elements

In addition to chaining selectors to select elements, CSS also supports selecting elements that are nested within other HTML elements. For instance, consider the following HTML:

```html
<ul class='main-list'>
  <li> ... </li>
  <li> ... </li>
  <li> ... </li>
</ul>
```

The nested `<li>` elements are selected with the following CSS:

```css
.main-list li {

}
```

In the example above, `.main-list` selects the `.main-list` element (the unordered list element). The nested `<li>` are selected by adding `li` to the selector, separated by a space, resulting in `.main-list li` as the final selector (note the space in the selector).

Selecting elements in this way can make our selectors even more specific by making sure they appear in the context we expect.



## Chaining and Specificity

To create a selector that targets all of the `h5` elements nested inside elements with class `.description`, we write `.description h5`. This CSS selector was more specific than writing only `h5`. Adding more than one tag, class, or ID to a CSS selector increases the specificity of the CSS selector.

For instance, consider the following CSS:

```css
p {
  color: blue;
}


.main p {
  color: red;
}
```

Both of these CSS rules define what a `p` element should look like. Since `.main p` has a class and a `p` tag as its selector, only the `p` elements inside the `.main` element will appear `red`. This occurs despite there being another more general rule that states `p` elements should be `blue`.



## Multiple Selectors

In order to make CSS more concise, it is possible to add CSS styles to multiple CSS selectors all at once. This prevents writing repetitive code.

For instance, the following code has repetitive style attributes:

```css
h1 {
  font-family: Georgia;
}

.menu {
  font-family: Georgia;
}
```

Instead of writing `font-family: Georgia` twice for two selectors, we can separate the selectors by a comma to apply the same style to both, like this:

```css
h1, 
.menu {
  font-family: Georgia;
}
```

By separating the CSS selectors with a comma, both the `h1` and the `.menu` elements will receive the `font-family: Georgia` styling.



## Review CSS Selectors

- CSS can change the look of HTML elements. In order to do this, CSS must select HTML elements, then apply styles to them.
- CSS can select HTML elements by tag, class, or ID.
- Multiple CSS classes can be applied to one HTML element.
- Classes can be reusable, while IDs can only be used once.
- IDs are more specific than classes, and classes are more specific than tags. That means IDs will override any styles from a class, and classes will override any styles from a tag selector.
- Multiple selectors can be chained together to select an element. This raises the specificity, but can be necessary.
- Nested elements can be selected by separating selectors with a space.
- Multiple unrelated selectors can receive the same styles by separating the selector names with commas.