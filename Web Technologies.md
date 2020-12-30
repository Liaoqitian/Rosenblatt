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
As we just learned, IP addresses are how computers identify other computers on the Internet. IP addresses are not particularly human-friendly. 
The **domain name system (DNS)** gives us humans an easy way to identify where we want to go on the Internet.
We simply type in a domain name like "www.wikipedia.org", and our computer connects us to the computers powering Wikipedia.

A domain name is a human-friendly address for a website, something that is easy for humans to remember and type in. 

## Anatomy of a domain name 
Each domain name is made up of parts: 
`third-level-domain.second-level-domain.top-level-domain`
There are a limited set of top level domains (TLD)s, and many websites use the most common TLDs, ".com", ".org", and ".edu". 
The second level domain is unique to the company or organization that registers it, like "wikipedia" or "khanacademy". 
The third level domain is also called a subdomain, because it is owned by the same group and that URL often directs you to a subset of the website, like "m.wikipedia.org" (mobile-optimzed Wikipedia) or "es.khanacademy.org" (Spanish-language Khan Academy). 

## Domains ↔ IP Addresses
Behind the scenes, each domain name maps to an IP address. When we type a URL in the address bar of our browser, the computer has to figure out its IP address. The computer cannot store a database of more than 300 million domain names locally, so it goes through a multi-step process to find out the IP address.

**Step 1: Check the local cache**
If you've visited a website once, there's a fairly good chance you'll visit it again. That's why computers keep their own local cache of domain name to IP mappings. The cache stays small, because it kicks out domains you haven't visited in a while or domains that send down expiration dates.
🔍 In the Chrome browser, you can view the database yourself. Just type "chrome://net-internals/#dns" in the address bar.

**Step 2: Ask the ISP cache**
Every ISP provides a domain name resolving service and keeps its own cache. Perhaps you haven't visited a particular website, but your neighbor just did, so the ISP can lookup the IP from their visit.
If it's not in the ISP's cache, then it's off to the next step.

**Step 3: Ask the name servers**
There are domain name servers scattered around the globe that are responsible for keeping track of a subset of the millions of domain names.
The servers are ordered in a hierarchy:
Root name servers → TLD name servers → Host name servers.
The ISP starts by asking the root name servers: "hey, which name server knows about .org domains?" The root name server responds with the IP address of a TLD name server that tracks ".org" domains.

Next, the ISP asks the TLD name server: "so, who knows about wikipedia domains?" The TLD name server responds with the IP address of a host name server that contains the "wikipedia" records.

Finally, the ISP asks the host name server: "okay, so where's www.wikipedia.org?" The host name server responds with an exact IP address.



What is HTTP (Hypertext Transfer Protocol)?
The Hypertext Transfer Protocol is an application protocol for distributed, collaborative, hypermedia information systems that allows users to communicate data on the World Wide Web.
What is the purpose of HTTP?
HTTP was invented alongside HTML to create the first interactive, text-based web browser: the original World Wide Web. Today, the protocol remains one of the primary means of using the Internet.
How does HTTP work?
As a request-response protocol, HTTP gives users a way to interact with web resources such as HTML files by transmitting hypertext messages between clients and servers. HTTP clients generally use Transmission Control Protocol (TCP) connections to communicate with servers.

HTTP utilizes specific request methods in order to perform various tasks:

GET requests a specific resource in its entirety
HEAD requests a specific resource without the body content
POST adds content, messages, or data to a new page under an existing web resource
PUT directly modifies an existing web resource or creates a new URI if need be
DELETE gets rid of a specified resource
TRACE shows users any changes or additions made to a web resource
OPTIONS shows users which HTTP methods are available for a specific URL
CONNECT converts the request connection to a transparent TCP/IP tunnel
PATCH partially modifies a web resource
All HTTP servers use the GET and HEAD methods, but not all support the rest of these request methods.