# CSS Visual Rules

## Table of Contents 

- [CSS Structure](#CSS-Structure)
- [Font Family](#Font-Family)
- [Font Size](#Font-Size)
- [Font-Weight](#Font-Weight)
- [Text Align](#Text-Align)
- [Color](#Color)
- [Opacity](#Opacity)
- [Background Image](#Background-Image)
- [Important](#Important)
- [Review Visual Rules](#Review-Visual-Rules)



## CSS Structure

To style an HTML element using CSS, you need to write a CSS declaration inside the body of a CSS selector.

```css
h1 {
  color: blue;
}
```

The example above selects the `<h1>` element. Inside of the selector’s body, we typed `color: blue`. This line is referred to as a CSS *declaration*. CSS declarations consist of a *property* and a *value*.

**Property** — the property you’d like to style of that element (i.e., size, color, etc.).

**Value** — the value of the property (i.e., 18px for size, blue for color, etc.).

In the example above, the property is `color` and the value is `blue`. The property and value are separated by a colon (`:`). A semicolon (`;`) should always be used at the end of a declaration.

Finally, the entire snippet of code in the example above is known as a CSS *rule* or *rule set*. A CSS rule consists of the selector (here, `h1`) and all declarations inside of the selector.



## Font Family

If you’ve ever used a formatted word processor, chances are that you probably also used a feature that allowed you change the font you were typing in. Font refers to the technical term [typeface](https://en.wikipedia.org/wiki/Typeface), or *font family*.

To change the typeface of text on your web page, you can use the `font-family` property.

```css
h1 {
  font-family: Garamond;
}
```

In the example above, the font family for all main heading elements has been set to `Garamond`.

When setting typefaces on a web page, keep the following points in mind:

1. The font specified in a stylesheet must be installed on a user’s computer in order for that font to display when a user visits the web page.
2. The default typeface for all HTML elements is `Times New Roman`. You may be familiar with this typeface if you have ever used a formatted word processor. If no `font-family` attribute is defined, the page will appear in `Times New Roman`.
3. It is a good practice to limit the number of typefaces used on a web page to 2 or 3. This helps the page load faster in some cases and is usually a good design decision.
4. When the name of a typeface consists of more than one word, it’s a best practice to enclose the typeface’s name in quotes, like so:

```css
h1 {
  font-family: "Courier New";
}
```

You can find a reference of web safe fonts [here](http://www.cssfontstack.com/).



## Font Size

Changing the typeface is not the only way to customize text. Often times, different sections of a web page are highlighted by modifying the *font size*.

To change the size of text on your web page, you can use the `font-size` property.

```
p {
  font-size: 18px;
}
```

In the example above, the `font-size` of all paragraphs was set to `18px`. `px` means pixels and is a way to measure font size.

**Question:** What is a pixel and is this the only measure of font size?

A pixel is one of several units of measure in web development. It is an absolute unit equal to 1/96 of an inch.

Rems and ems are scalable typographic units which are commonly used with the `font-size` property. As opposed to pixels, both of these units are relative. For example, an em is measured relative to the `font-size` of an element. When dealing with ems it is important to realize that the `font-size` of an element is often inherited from an ancestor element. On the other hand, rems are determined based on the `font-size` of the `html` element. If `font-size` is not defined on the `html` element, the browser’s default `font-size` is used instead (usually 16px).



## Font Weight

In CSS, the `font-weight` property controls how bold or thin text appears.

```css
p {
  font-weight: bold;
}
```

In the example above, all paragraphs on the web page would appear bolded.

The `font-weight` property has a another value: `normal`. 

If we wanted *all* text on a web page to appear bolded, we could select all text elements and change their font weight to `bold`. If a certain section of text was required to appear normal, however, we could set the font weight of that particular element to `normal`, essentially shutting off bold for that element.



## Text Align

No matter how much styling is applied to text (typeface, size, weight, etc.), text always appears on the left side of the browser.

To align text we can use the `text-align` property. The `text-align` property will align text to the element that holds it, otherwise known as its *parent*.

```css
h1 {
  text-align: right;
}
```

The `text-align` property can be set to one of the following three values:

1. `left` — aligns text to the left hand side of its parent element, which in this case is the browser.
2. `center` — centers text inside of its parent element.
3. `right` — aligns text to the right hand side of its parent element.



## Color

Before discussing the specifics of color, it is important to make two distinctions about color. Color can affect the following design aspects:

- Foreground color
- Background color

Foreground color is the color that an element appears in. For example, when a heading is styled to appear green, the *foreground color* of the heading has been styled.

Conversely, when a heading is styled so that its background appears yellow, the *background color* of the heading has been styled.

In CSS, these two design aspects can be styled with the following two properties:

- `color`: this property styles an element’s foreground color
- `background-color`: this property styles an element’s background color

```css
h1 {
  color: red;
  background-color: blue;
}
```

In the example above, the text of the heading will appear in red, and the background of the heading will appear blue.



## Opacity

Opacity is the measure of how transparent an element is. It is measured from 0 to 1, with 1 representing 100%, or fully visible and opaque, and 0 representing 0%, or fully invisible.

Opacity can be used to make elements fade into others for a nice overlay effect. To adjust the opacity of an element, the syntax looks like this:

```css
.overlay {
  opacity: 0.5;
}
```

In the example above, the `.overlay` element would be 50% visible, letting whatever is positioned behind it show through.



## Background Image

CSS has the ability to change the background of an element. One option is to make the background of an element an image. This is done through the CSS property `background-image`. Its syntax looks like this:

```
.main-banner {
  background-image: url("https://www.example.com/image.jpg");
}
```

1. The `background-image` property will set the element’s background to display an image.
2. The value provided to `background-image` is a `url`. The `url` should be a url to an image. The `url` can be a file within your project, or it can be a link to an external site. To link to an image inside an existing project, you must provide a relative file path. If there was an image folder in the project, with an image named `mountains.jpg`, the relative file path would look like:

```
.main-banner {
  background-image: url("images/mountains.jpg");
}
```



## Important

`!important` can be applied to specific attributes instead of full rules. It will override *any* style no matter how specific it is. As a result, it should almost never be used. Once `!important` is used, it is very hard to override.

The syntax of `!important` in CSS looks like this:

```css
p {
  color: blue !important;
}
 
 
.main p {
  color: red;
}
```

Since `!important` is used on the `p` selector’s `color` attribute, all `p` elements will appear `blue`, even though there is a more specific `.main p` selector that sets the `color` attribute to `red`.

One justification for using `!important` is when working with multiple stylesheets. For example, if we are using the [Material Design Lite](https://getmdl.io/) style library and want to override the styles for one specific HTML element, we can use the `!important` property.



## Review Visual Rules

- CSS declarations are structured into property and value pairs.
- The `font-family` property defines the typeface of an element.
- `font-size` controls the size of text displayed.
- `font-weight` defines how thin or thick text is displayed.
- The `text-align` property places text in the left, right, or center of its parent container.
- Text can have two different color attributes: `color` and `background-color`. `color` defines the color of the text, while `background-color` defines the color behind the text.
- CSS can make an element transparent with the `opacity` property.
- CSS can also set the background of an element to an image with the `background-image` property.
- The `!important` flag will override any style, however it should almost never be used, as it is extremely difficult to override.