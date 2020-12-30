# Web Technologies

## The World Wide Web
### World Wide Web (WWW)
The web is a massive network of webpages, programs, and files that are accessible via URLs. We call it a web because of its vast interconnectedness. Starting from one URL, such as http://google.com, we can follow links to eventually reach millions of webpages from across the globe. 

### Powered by protocols
A web browser loads a webpage using various protocols: 
1. It uses the **Domain Name System (DNS) protocol** to convert a domain name into an IP address. 
2. It uses the **HyperText Transfer Protocol (HTTP)** to request the webpage contents from that IP address. 

It may also use the **Transport Layer Security (TLS) protocol** to serve the website over a secure, encrypted connection. 

The web browser uses these protocols on top of the internet protocols, so every HTTP request also uses TCP and IP. 

The Web is just one of the applications built on top of the Internet protocols, but it is by far the most popular. 

## Domain Name System (DNS)
As we just learned, IP addresses are how computers identify other computers on the Internet. IP addresses are not particularly human-friendly. 
The **domain name system (DNS)** gives us humans an easy way to identify where we want to go on the Internet.
We simply type in a domain name like "www.wikipedia.org", and our computer connects us to the computers powering Wikipedia.

A domain name is a human-friendly address for a website, something that is easy for humans to remember and type in. 

##




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