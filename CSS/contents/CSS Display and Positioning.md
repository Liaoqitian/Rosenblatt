# CSS Display and Positioning

## Table of Contents 

- [Flow of HTML](#Flow-of-HTML)
- [Position](#Position)
- [Position: Relative](#Position-Relative)



## Flow of HTML

A browser will render the elements of an HTML document that has no CSS from left to right, top to bottom, in the same order as they exist in the document. This is called the *flow* of elements in HTML.

In addition to the properties that it provides to style HTML elements, CSS includes properties that change how a browser *positions* elements. These properties specify where an element is located on a page, if the element can share lines with other elements, and other related attributes.

In this lesson, you will learn five properties for adjusting the position of HTML elements in the browser:

- `position`
- `display`
- `z-index`
- `float`
- `clear`

Each of these properties will allow us to position and view elements on a web page. They can be used in conjunction with any other styling properties you may know.



## Position

Take a look at the *block-level* elements in the image below:

![img](https://content.codecademy.com/courses/web-101/unit-7/alex-clark-experiment/static.png)

Block-level elements like these boxes create a *block* the full width of their parent elements, and they prevent other elements from appearing in the same horizontal space. The boxes in the image above were created with the following CSS:

```css
.boxes {
  width: 120px;
  height: 70px;
}
```

and the following HTML:

```html
<div class="boxes"></div>
<div class="boxes"></div>
```

Notice the block-level elements in the image above take up their own line of space and therefore do not overlap each other. Block-level elements also consistently appear on the left side of the browser. This is the default *position* for block-level elements.

The default position of an element can be changed by setting its `position` property. The `position` property can take one of four values:

1. `static` - the default value (it does not need to be specified)
2. `relative`
3. `absolute`
4. `fixed`



## Position: Relative

One way to modify the default position of an element is by setting its `position` property to `relative`.

This value allows you to position an element *relative* to its default static position on the web page.

```
.box-bottom {
  background-color: DeepSkyBlue;
  position: relative;
}
```

Although the code in the example above instructs the browser to expect a relative positioning of the div, it does not specify where the div should be positioned on the page.

```
.box-bottom {
  background-color: DeepSkyBlue;
  position: relative;
  top: 20px;
  left: 50px;
}
```

In the example above, the `<div>` has been positioned using two of the four *offset properties*. The valid offset properties are:

1. `top` - moves the element down.
2. `bottom` - moves the element up.
3. `left` - moves the element right.
4. `right` - moves the element left.

In the example above, the `<div>` will be moved down 20 pixels and to the right 50 pixels from its default static position. The image below displays the new position of the box. The dotted line represents where the statically positioned (default) box was positioned.

![img](https://content.codecademy.com/courses/web-101/unit-7/alex-clark-experiment/relative.png)

Units for offset properties can be specified in pixels, ems, or percentages. Note that offset properties will not work if the value of the element’s `position` property is the default `static`.