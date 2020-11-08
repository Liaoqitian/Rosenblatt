# Deploy Your Website to GitHub Pages 

## Table of Contents 
- [Create a GitHub Account](#Create-a-GitHub-Account)
- [Create Your Repo](#Create-Your-Repo)
- [Initialize Your Repo](#Initialize-Your-Repo)
- [Add the Remote](#Add-the-Remote)
- [Commit Your Changes](#Commit-Your-Changes)
- [Deploy Your Site](#Deploy-Your-Site)
- [Review](#Review)


## Create a GitHub Account

There are many different ways to deploy a website to the public Internet. In this unit, we’ll use GitHub Pages to deploy your website.

GitHub Pages is a service offered by GitHub. Specifically, GitHub Pages are public webpages that are hosted and published through GitHub.

Why GitHub Pages? In the last unit, we generated a site using Jekyll. GitHub Pages offers extensive integration and support for Jekyll. By using both, you’ll benefit from:

- Easy setup
- Troubleshooting your site
- Updating and maintaining your site

**Note:** Remember, it is possible to follow all of the steps outlined in this course with your *own* content — just make sure that your HTML is inside of a file called **index.html** (a GitHub Pages requirement).


## Create Your Repo

In order to publish your site using GitHub Pages, you’ll need to create a repository (repo) on GitHub.

A GitHub repository is an online, central storage place where you can store files and all the versions of those files. We’ll use the repo you create to store the contents of your website.

Your repo’s name *must* also follow GitHub Pages’ naming convention, otherwise your site will not publish at all.

Specifically, the repo’s name must be in the following format:

```bash
your-user-name.github.io
```

In the example above, you would replace `your-user-name` with your actual GitHub user name.


## Initialize Your Repo

Now that you’ve created a repo with the proper naming convention, let’s upload your site to GitHub.

We’ll use Git to push (upload) the contents of your site’s directory to your new repo.

To do so, we’ll first initalize a Git repository in your site’s directory.

First use the `cd` command to navigate to your site's directory, then initialize a Git repository with the following command: 

```bash
git init
```


## Add the Remote

Next, Git needs to know what repo will store your site’s content.

In this case, the repo will be the one you created on GitHub earlier.

To specify the repo using Git, we’ll have to *add* the *remote* and label it as the *origin*.

1. The *remote* is the URL of the repo that will store your site’s contents.
2. The *origin* is an alias for the remote. You can think of an alias as an abbreviation or a substitute name. This means that instead of having to always type the lengthy remote URL over and over again, you can simply refer to it as `origin` later on.

In the terminal, you can add the remote with the following command:

```bash
git remote add origin https://github.com/your-user-name/your-user-name.github.io.git
```

In the example above, `https://github.com/your-user-name/your-user-name.github.io.git` is the remote URL that refers to the repository you created on GitHub earlier. Again, you would replace `your-user-name` with your actual GitHub username.

**Important:** If you accidentally make a mistake when adding the remote URL, you can start over and remove the remote with the following command:

```bash
git remote rm origin
```

To confirm that the remote was successfully added, we type 

```bash
git remote -v
```

This command lists all the Git remotes and their corresponding URLs. 


## Commit Your Changes

Then Git also needs to know exactly which files should be pushed to your repo.

In this case, we want to push *all* of your site’s content to the repo. This means we will do the following two things (in order):

1. Add all of your site’s content to the Git staging area

   ```bash
   git add . 
   ```

2. Commit (save) your changes

   ```bash
   git commit -m "commit message"
   ```

## Deploy Your Site

Now it’s time to deploy your site with Git. 

This time, we’ll use Git’s `push` command and push the contents of your site up to your repo using the following command:

```bash
git push -u origin master
```


## Review

Now you now have your site published on the public Internet. You can now navigate to your newly published website in your preferred browser.

The URL for your GitHub Pages site is: `your-user-name.github.io`, where `your-user-name` is your actual GitHub username.

Let’s review what you accomplished in this unit:

1. Created a GitHub account
2. Created the required GitHub repo
3. Used Git to add, commit, and push your website to the repo
4. Succesfully used GitHub Pages to deploy your site to the Internet!

Note that your site’s URL matches your repo’s name — a GitHub Pages requirement. 