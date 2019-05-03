package com.example.demo

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * TODO include class javadoc here
 * @author JB Nizet
 */
class PhoneServiceTest {
    @Test
    fun `should list phones in uppercase`() {
        val fakePhoneDao = mockk<PhoneDao>()

        every { fakePhoneDao.listPhones() } returns listOf("a", "b")

        val phoneService = PhoneService(fakePhoneDao)
        assertThat(phoneService.listPhonesInUppercase()).containsExactly("A", "B")
    }
}
