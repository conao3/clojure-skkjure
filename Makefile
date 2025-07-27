.PHONY: all
all:

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

.PHONY: repl
repl:
	clj -A:dev -Sdeps "$${REPL_DEPS}" -M -m nrepl.cmdline --interactive --middleware "[$${REPL_MIDDLEWARE}]"

.PHONY: test
test:
	clojure -M:dev:test
