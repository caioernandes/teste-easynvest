package com.example.testeeasynvest

import com.example.testeeasynvest.util.Helpers
import org.junit.Assert
import org.junit.Test

class HelperTest {

    @Test
    fun enterCorrectDate() {
        Assert.assertEquals("11/02/1995", Helpers.formatDate("1995-02-11"))
    }

    @Test
    fun enterIncorrectDate() {
        Assert.assertEquals("11/02/1995", Helpers.formatDate("95-02-11"))
    }

    @Test
    fun enterCorrectDateReserve() {
        Assert.assertEquals("1995-02-11", Helpers.formatDateReverse("11/02/1995"))
    }

    @Test
    fun enterIncorrectDateReverse() {
        Assert.assertEquals("95-02-11", Helpers.formatDateReverse("11/02/1995"))
    }
}