# Introduction to Vue 

## Table of Contents 



## Front-End Frameworks

Now, we will cover some of the most exciting features of Vue, discuss how they have changed the world of web development, and see why Vue has become the popular front-end framework that it is today.

Before all of that, though, there is one preliminary question we’re excited to answer. Perhaps you have heard Vue referred to as a “front-end framework.” But what is a front-end framework? And, for that matter, what is a front-end? Well, we’ve prepared a video to answer these important questions once and for all!



## Adding Vue

Front-end frameworks aim to fix the following issues in front-end web development:

- Long development times
- Difficult bug fixes and updates
- Slow page rendering

Now, we will introduce some of the features that allow Vue to tackle these issues. 

The first thing you’ll need to do to begin using any front-end framework is to add the framework to your project. You can import Vue by adding a `<script>` tag inside the `<head>` of your project’s HTML file:

```html
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js" defer></script>
```

Above we load the current version of Vue, hosted by the Vue team, directly into your project. We use the `defer` attribute on the `<script>` tag to make sure that the page is loaded and ready to hook up to Vue before we actually load Vue.

Even at this preliminary step, the Vue team has found ways to shorten your development time. Many front-end frameworks, like React and Angular, have difficult setup processes that can make starting a project a hassle. The Vue team recognized that many complex front-end features aren’t useful until late in the front-end learning journey (or sometimes at all). As a result, they offered this simple alternative that provides most of Vue’s features to developers quickly and easily.

**Note**: This lesson will be using cutting edge browser features. If you are experiencing technical issues at any point during the lesson, we suggest you download and use the most up-to-date version of [Google Chrome](https://www.google.com/chrome/) to potentially fix these issues.