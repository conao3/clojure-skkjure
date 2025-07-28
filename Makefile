.PHONY: all
all: native

UNAME_OS := $(shell uname -s)

ifeq ($(UNAME_OS),Darwin)
GRAAL_BUILD_ARGS += -H:-CheckToolchain
endif

.PHONY: repl
repl:
	clj -M:dev:build:repl

.PHONY: test
test:
	clojure -M:dev:test

.PHONY: uber
uber: target/skkjure-standalone.jar

target/skkjure-standalone.jar:
	clojure -T:build uber

.PHONY: native
native: target/skkjure

target/skkjure: target/skkjure-standalone.jar
	native-image -jar $< \
	--features=clj_easy.graal_build_time.InitClojureClasses \
	--verbose \
	--no-fallback \
	$(GRAAL_BUILD_ARGS) \
	$@

.PHONY: clean
clean:
	rm -rf target
