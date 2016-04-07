(ns epxlabs-site.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [epxlabs-site.core-test]))

(doo-tests 'epxlabs-site.core-test)
