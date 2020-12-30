# Web Technologies

## The World Wide Web
### World Wide Web (WWW)
The web is a massive network of webpages, programs, and files that are accessible via URLs. We call it a web because of its vast interconnectedness. Starting from one URL, such as http://google.com, we can follow links to eventually reach millions of webpages from across the globe. 

### Powered by protocols
A web browser loads a webpage using various protocols: 
1. It uses the **Domain Name System (DNS) protocol** to convert a domain name into an IP address. 
2. It uses the **HyperText Transfer Protocol (HTTP)** to request the webpage contents from that IP address. 

It may also use the **Transport Layer Security (TLS) protocol** to serve the website over a secure, encrypted connection. The web browser uses these protocols on top of the internet protocols, so every HTTP request also uses TCP and IP. The Web is just one of the applications built on top of the Internet protocols, but it is by far the most popular. 

## Domain Name System (DNS)
IP addresses are how computers identify other computers on the Internet. IP addresses are not particularly human-friendly. 
The **domain name system (DNS)** gives us humans an easy way to identify where we want to go on the Internet.
We simply type in a domain name like "www.wikipedia.org", and our computer connects us to the computers powering Wikipedia.

A domain name is a human-friendly address for a website, something that is easy for humans to remember and type in. 

### Anatomy of a domain name 

Each domain name is made up of parts: 
`third-level-domain.second-level-domain.top-level-domain`
There are a limited set of top level domains (TLD)s, and many websites use the most common TLDs, ".com", ".org", and ".edu". 
The second level domain is unique to the company or organization that registers it, like "wikipedia" or "khanacademy". 
The third level domain is also called a subdomain, because it is owned by the same group and that URL often directs you to a subset of the website, like "m.wikipedia.org" (mobile-optimzed Wikipedia) or "es.khanacademy.org" (Spanish-language Khan Academy). 

### Domains ↔ IP Addresses

Behind the scenes, each domain name maps to an IP address. When we type a URL in the address bar of our browser, the computer has to figure out its IP address. The computer cannot store a database of more than 300 million domain names locally, so it goes through a multi-step process to find out the IP address.

**Step 1: Check the local cache**
If you've visited a website once, there's a fairly good chance you'll visit it again. That's why computers keep their own local cache of domain name to IP mappings. The cache stays small, because it kicks out domains you haven't visited in a while or domains that send down expiration dates.
In the Chrome browser, you can view the database yourself. Just type "chrome://net-internals/#dns" in the address bar.

**Step 2: Ask the ISP cache**
Every ISP provides a domain name resolving service and keeps its own cache. Perhaps you haven't visited a particular website, but your neighbor just did, so the ISP can lookup the IP from their visit.
If it's not in the ISP's cache, then it's off to the next step.

**Step 3: Ask the name servers**
There are domain name servers scattered around the globe that are responsible for keeping track of a subset of the millions of domain names.
The servers are ordered in a hierarchy:
Root name servers → TLD name servers → Host name servers.
The ISP starts by asking the root name servers: "hey, which name server knows about .org domains?" The root name server responds with the IP address of a TLD name server that tracks ".org" domains.

![](https://cdn.kastatic.org/ka-perseus-images/b1d61ffbee75aaf2d02412b49e97d177fd7e5d73.svg)

Next, the ISP asks the TLD name server: "so, who knows about wikipedia domains?" The TLD name server responds with the IP address of a host name server that contains the "wikipedia" records.

![](https://cdn.kastatic.org/ka-perseus-images/c1519163562cff6256ebff41bd4585fc8512ce56.svg)

Finally, the ISP asks the host name server: "okay, so where's www.wikipedia.org?" The host name server responds with an exact IP address.

![](https://cdn.kastatic.org/ka-perseus-images/206f79ee6a96625d0bea1d730de2b601a3eb635c.svg)

A lot of information is cached along the way, so it is rare that a DNS lookup has to go through so many steps. When a lookup does have to go through all the steps, there are multiple name servers that can answer each question, so a computer does not have to wait too long for a response or worry about a name server going down. We have had the domain name system since 1985, and it has scaled impressively to match the growth of the Internet, thanks to its hierarchy, redundancy, and caching.

### DNS Spoofing

The domain name system is scalable, but it is not always secure. Cyber criminals figured out a way to exploit flaws in DNS name servers, in an attack known as DNS spoofing or DNS cache poisoning. As we saw above, a domain resolver service must ask name servers when it does not already know the mapping of a domain to an IP. If a cyber criminal manages to take control of a name server or redirect requests to its own server, then it can reply with any IP address it wants. The domain resolver now stores the new IP in its cache and sends that IP back to the requesting computer. The IP address often redirects users to a page that will download computer viruses or ask for their secure information.

DNS cache poisoning can happen at any level in the name server hierarchy. Imagine a cyber criminal intercepting requests to a root name server: they would be able to direct all traffic for .org domains! Once the domain ↔ IP mapping is poisoned in one server, it can spread to any other server that asks for information from that server. There is good news, however: DNS spoofing can be prevented. The DNSSEC protocol extends the original DNS protocol and specifies the best way for DNS resolvers to authenticate the information sent to them. Upgrading old systems takes time, so it may be years or decades before all DNS systems are using DNSSEC. In the meantime, be careful when you load a website and see an unexpected result. Not all websites are what they seem. 



## Hypertext Transfer Protocol (HTTP)

Whenever you visit a page on the web, your computer uses the **Hypertext Transfer Protocol (HTTP)** to download that page from another computer somewhere on the Internet. 

#### Step 1: Direct browser to URL

When we want to browse the web, we can use many types of computers (like laptops, desktops, and phones), as long as the computer has a **browser** application installed. The user either types a **Uniform Resource Locator (URL)** in the browser or follows a link from an already opened page. 

Notice something about that URL: it starts with "http". That's a signal to the browser that it needs to use HTTP to fetch the document for that URL.

#### Step 2: Browser looks up IP

We typically type nice human-friendly URLs into browsers, like "khanacademy.org" and "wikipedia.org". Those domain names map to IP addresses, the true location of the domain's computers. That is handled by the [Domain Name System](https://www.khanacademy.org/a/domain-name-system-dns). The browser uses a DNS resolver to map the domain to an IP address. 

#### Step 3: Browser sends HTTP request

Once the browser identifies the IP address of the computer hosting the requested URL, it sends an **HTTP request**.

An HTTP request can be as short as two lines of text:

```
GET /index.html HTTP/1.1
Host: www.example.com
```

The first word is the HTTP verb: "GET". There are other verbs for other actions on the web, like submitting form data ("POST"). The next part specifies the path: "/index.html". The host computer stores the content of the entire website, so the browser needs to be specific about which page to load. The final part of the first line specifies the protocol and the version of the protocol: "HTTP/1.1". The second line specifies the domain of the requested URL. That is helpful in case a host computer stores the content for multiple websites.

#### Step 4: Host sends back HTTP response

Once the host computer receives the HTTP request, it sends back a response with both the content and metadata about it.

The HTTP response starts similarly to the request:

```
HTTP/1.1 200 OK
```

The response begins with the protocol and version, "HTTP/1.1". The next number is the very important **HTTP status code**, and in this case, it is 200. That code represents a successful retrieval of the document ("OK"). If the server failed to retrieve the document, the status codes provide more information, like if the failure was due to user error or server error. For example, the most well known status code is 404 ("File not found"). That happens whenever you visit a path on a server that does not correspond to any document. Since users have a habit of typing URLs incorrectly, 404s happen frequently, so websites often have fun 404 webpages. 

The next part of an HTTP response are the **headers**. They give the browser additional details and help the browser to render the content.

These two headers are common to most requests:

```
Content-Type: text/html; charset=UTF-8
Content-Length: 208
```

The content-type tells the browser what type of document it is sending back. A common type on the web is "text/html", as all webpages are HTML text files. Other types are possible, like images ("image/png"), videos ("video/mpeg"), script ("application/javascript") and anything else you can load in your browser. The content-length gives the length of the document in bytes, which helps the browser know how long a file will take to download.

Finally, the HTTP response writes out the actual document requested. This page is a simple HTML file:

```html
<!DOCTYPE html>
<html>
  <head>
    <title>Example Domain</title>
  </head>
  <body>
    <h1>Example Domain</h1>
    <p>This domain is to be used for illustrative examples in documents.</p>
  </body>
</html>
```

#### Step 5: The browser renders the response

The browser now has all the information it needs to render the document requested.

### HTTP and TCP/IP

HTTP is a protocol that is built *on top* of the TCP/IP protocols. Each HTTP request is inside an IP packet, and each HTTP response is inside another IP packet--or more typically, multiple packets, since the response data can be quite large. There are many other protocols built on top of TCP/IP, like protocols for sending email (SMTP, POP, IMAP) and uploading files (FTP). All of these protocols enable us to use the Internet to connect with other computers in useful ways, and to communicate and collaborate across wide distances. 

The HTML of the webpage, the logo, the JavaScript code for the map pop-ups, each graphic file, and the custom font file are loaded using the Hypertext Transfer Protocol. 