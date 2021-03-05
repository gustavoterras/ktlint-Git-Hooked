package com.example.rules

import com.pinterest.ktlint.core.RuleSet
import com.pinterest.ktlint.core.RuleSetProvider

class NeonRuleSetProvider : RuleSetProvider {
    override fun get(): RuleSet = RuleSet(
        "neon-style-rule",
        OneLineFunctionRule(),
        NoVarRule()




    

    )
}
