.PHONY: all
all: native

UNAME_OS := $(shell uname -s)

define REPL_DEPS
{:deps
  {nrepl/nrepl {:mvn/version "RELEASE"}
   cider/cider-nrepl {:mvn/version "RELEASE"}}}
endef
export REPL_DEPS

define REPL_MIDDLEWARE
cider.nrepl/cider-middleware,
endef
export REPL_MIDDLEWARE

ifeq ($(UNAME_OS),Darwin)
GRAAL_BUILD_ARGS += -H:-CheckToolchain
endif

.PHONY: repl
repl:
	clj -A:dev:build -Sdeps "$${REPL_DEPS}" -M -m nrepl.cmdline --interactive --middleware "[$${REPL_MIDDLEWARE}]"

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
