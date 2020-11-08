# Create a static website using Jekyll 

## Table of Contents
- [Deploying: Overview](#Deploying-Overview)
- [Jekyll: Overview](#Jekyll-Overview)
- [Installing Jekyll](#Installing-Jekyll)
- [Generate a Static Site](#Generate-a-Static-Site)
- [Preview Your Site Locally](#Preview-Your-Site-Locally)
- [Jekyll's Directory Structure](#Jekyll's-Directory-Structure)
- [Review](#Review)


## Deploying: Overview

Deploying means making content or software accessible and available for use.

The website that you’ll deploy in this course will be public, or “live”, on the Internet. It will be accessible to anyone (with open Internet access), at anytime, anywhere in the world. We will learn how to

1. Generate a static site
2. Deploy it to the Internet
3. Give the website a custom domain name


## Jekyll: Overview

We’ll use a popular tool known as *Jekyll* to quickly generate a website. This will help keep the focus on the deployment process and quickly provide you with content to deploy, rather than focusing solely on website creation.

Jekyll is a simple static site generator. Using Jekyll is a very common way of generating a “ready-to-publish static website” within seconds. You can learn more about Jekyll [here](https://jekyllrb.com/docs/home/).

**An important note:**

With Jekyll we can generate the static website quickly and focus on deploying it. However, if we do not want to use the Jekyll-generated content, we just make sure that our HTML is inside of a file called **index.html**. As you’ll see, even Jekyll uses a file called **index.html**.


## Installing Jekyll

Before we can generate a website, we must install Jekyll.

Jekyll is a Ruby gem (also known as a [RubyGem](http://guides.rubygems.org/what-is-a-gem/)) and can be installed from the command line. Once Jekyll is installed, we can use it to generate your website.

```
gem install jekyll
```


## Generate a Static Site

Now that Jekyll is installed, let’s generate your website.

To do so, we’ll use Jekyll’s `new` command and specify a directory name. The directory will contain all of your site’s default content that can be customized later.

For example, to generate a website in a directory called `my-portfolio-site`, we can type:

```bash
jekyll new my-portfolio-site
```

The command will create a directory called `my-portfolio-site` and fill it with Jekyll’s site content. 


## Preview Your Site Locally

We can use Jekyll to view your site *locally*. On the web, a server hosts your site’s files and makes your website available for everyone to see.

However, viewing a website locally means that you’re viewing the site on your *own* computer (hence the term “locally” or “local”). The site is not, however, available on the public Internet. Instead, your computer is acting as the server that hosts your site.

You can view your site locally by using Jekyll’s `serve` command, like so:

```bash
jekyll serve
```

This command starts a local server that will server the files to your computer. The `serve` command will also come in handy when you want to preview changes you make to your site.

By default, the address for the local server that *Jekyll’s* `serve` command starts is `http://localhost:4000/`.


## Jekyll's Directory Structure

The website that Jekyll generates differs from a website that you’d create on your own. It offers a standard directory structure, as well as components that help speed up development.

It’s important to understand Jekyll’s default directory structure and contents of your site:

1. **_config.yml** - This is a configuration file that contains many values that need to be edited only once. These values are used across your site, for example, your site’s title, your e-mail, and more. Note that this is a **.yml** file, which you can learn more about [here](http://www.yaml.org/start.html).
2. **_includes/** - This directory contains all the partials (code templates that keep you from repeating your code over and over) that your site uses to load common components, like the header and the footer.
3. **_posts/** - This directory is where [blog posts](https://en.wikipedia.org/wiki/Blog) are stored. New blog posts can be added and will be rendered with the site’s styling, as long as the file name follows Jekyll’s standard naming convention.
4. **_layouts/** - This directory contains templates that are used to style certain types of posts within the site. For example, new blog posts will use the HTML layout defined in `post.html`.

You can learn more about the Jekyll directory structure [here](https://jekyllrb.com/docs/structure/).


## Review

1. Installed Jekyll
2. Used Jekyll to generate a static site
3. Started a local server to view your site

Jekyll quickly provided us with that content and now we can focus on the deployment process.