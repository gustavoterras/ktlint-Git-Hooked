package com.example.rules

import com.pinterest.ktlint.core.RuleSet
import com.pinterest.ktlint.core.RuleSetProvider

class CustomRuleSetProvider : RuleSetProvider {
    override fun get(): RuleSet = RuleSet("my-custom-rule", OneLineFunctionRule(), NoVarRule())
}
