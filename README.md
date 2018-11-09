# Carbon Https Proxy

This component is simple REST API server which receives the metrics data in from of JSON and forwards the data in Carbon plain text format to given TCP endpoint. 

There's no HTTP-based client for GraphiteReporter in dropwizard metrics. Code for such a client will be added soon.

## The purpose of component

Graphite's Carbon endpoint for submitting metrics data is plain-text based protocol over TCP sockets.

It doesn't support encryption or authorization out of the box.
Sometimes it also can be challenging to pass non-HTTP(s) traffic between networks.

Simple HTTP-based forwarder server can solve the problem of providing the secure way to report the metric values over public networks.

## Installation

*mvn install* builds an executable jar which will run web container which binds to port 8747

## Usage from the reporting application side

TBC
