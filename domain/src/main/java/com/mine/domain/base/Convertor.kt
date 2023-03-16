package com.mine.domain.base

interface Convertor<INPUT, OUTPUT> {
    fun invoke(params: INPUT): OUTPUT
}

