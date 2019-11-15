# Microservice Basics

Simple Spring Boot app to show the basics of Microservice architectures:
 
 - Spring Cloud Configserver
 - Spring Cloud Gateway
 - Circuit Breaker
 - Distributed Tracing

With the `manifest.yml` the project can be deployed to Cloud Foundry. Easiest way is to downlod the development version of Pivotal Cloud Foundry:

https://network.pivotal.io/products/pcfdev

Starting local pcf:

`cf dev start -f Documents/pcfdev-v1.2.0-darwin.tgz`