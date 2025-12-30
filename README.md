# skkjure

An SKK (Simple Kana to Kanji conversion) server implementation written in Clojure.

## Overview

skkjure provides a lightweight SKK server that communicates via stdio using the LSP4CLJ library. It is designed for integration with editors and input method frameworks that support SKK protocol.

## Requirements

- Java 11 or later
- Clojure 1.12.0 or later

## Installation

Clone the repository:

```bash
git clone https://github.com/conao3/clojure-skkjure.git
cd clojure-skkjure
```

## Usage

### Running the Server

Start the skkjure server:

```bash
clj -M -m skkjure.skkjure serve
```

### Building an Uberjar

Create a standalone JAR file:

```bash
clj -T:build uber
```

Run the built JAR:

```bash
java -jar target/skkjure-standalone.jar serve
```

### Available Commands

| Command | Description |
|---------|-------------|
| `serve` | Start the SKK server |
| `help`  | Display available commands |

## Development

### Running Tests

```bash
clj -M:dev:test
```

### Starting a REPL

```bash
clj -M:dev:repl
```

## Project Structure

```
src/
  skkjure/
    core.clj      # Component system and lifecycle management
    serve.clj     # Server implementation using lsp4clj
    skkjure.clj   # CLI entry point and command handling
```

## Dependencies

- [lsp4clj](https://github.com/clojure-lsp/lsp4clj) - Language Server Protocol library for Clojure
- [component](https://github.com/stuartsierra/component) - Lifecycle management
- [http-kit](https://github.com/http-kit/http-kit) - HTTP client/server library

## License

Apache License 2.0
