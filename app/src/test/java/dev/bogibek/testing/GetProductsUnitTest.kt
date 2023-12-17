package dev.bogibek.testing

import dev.bogibek.testing.data.remote.ApiClient
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class GetProductsUnitTest {

    /*
    * getProducts test
    */
    @Test
    fun checkStatusCode() {
        val response = ApiClient.service.getProducts().execute()
        assertEquals(response.code(), 200)
    }

    @Test
    fun `Get Product is Successful`() {
        val response = ApiClient.service.getProducts().execute()
        assertTrue(response.isSuccessful)
    }

    @Test
    fun `Products list is not null`() {
        val response = ApiClient.service.getProducts().execute()
        assertNotNull(response.body())
    }

    /*
    * other test
    */


}