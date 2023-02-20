package com.mine.domain.base

interface Convertor<INPUT, OUTPUT> {
    fun invoke(param: INPUT): OUTPUT
}

