package pl.proexe.junior.model

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import pl.proexe.junior.model.data.TvProgrammeCategoryEnum
import pl.proexe.junior.model.repository.LocalEpgRepository
import java.util.*

class EpgRepositoryTest {

    lateinit var repository: LocalEpgRepository

    @BeforeEach
    fun setupBeforeEach() {
        repository = LocalEpgRepository()
    }

    @Test
    fun `getProgrammeForDay should return list of programmes`() {
        val dateTime = getCurrentDateTime()
        assertTrue(repository.getProgrammesForDateTime(dateTime).isNotEmpty())
    }

    @Test
    fun `getProgrammeForDay should return list of programmes with size equal to passed amount`() {
        val dateTime = getCurrentDateTime()
        val amount = 4
        assertTrue(repository.getProgrammesForDateTime(dateTime, amount).size == amount)
    }

    @Test
    fun `getProgrammeForDay should use all distinct values for image url`() {
        val dateTime = getCurrentDateTime()
        val amount = LocalEpgRepository.IMAGE_URLS.size

        val result = repository.getProgrammesForDateTime(dateTime, amount)

        assertTrue(result.distinctBy { it.imageUrl }.size == amount)
    }

    @Test
    fun `getProgrammeForDay should use all distinct values for titles`() {
        val dateTime = getCurrentDateTime()
        val amount = LocalEpgRepository.TITLES.size

        val result = repository.getProgrammesForDateTime(dateTime, amount)

        assertTrue(result.distinctBy { it.title }.size == amount)
    }

    @Test
    fun `getProgrammeForDay should use all distinct values for types`() {
        val dateTime = getCurrentDateTime()
        val amount = LocalEpgRepository.TYPES.size

        val result = repository.getProgrammesForDateTime(dateTime, amount)

        assertTrue(result.distinctBy { it.type }.size == amount)
    }

    @Test
    fun `getProgrammeForDay should use all distinct values for categories`() {
        val dateTime = getCurrentDateTime()
        val amount = TvProgrammeCategoryEnum.values().size

        val result = repository.getProgrammesForDateTime(dateTime, amount)

        assertTrue(result.distinctBy { it.categoryEnum }.size == amount)
    }

    @Test
    fun `getProgrammeForDay should use all distinct values for isFavourited`() {
        val dateTime = getCurrentDateTime()
        val amount = 10

        val result = repository.getProgrammesForDateTime(dateTime, amount)

        assertTrue(result.distinctBy { it.isFavourite }.size == 2)
    }

    @Test
    fun `getProgrammeForDay should return list with all progressPercentages positive`() {
        val dateTime = getCurrentDateTime()
        val amount = 10

        val result = repository.getProgrammesForDateTime(dateTime, amount)

        assertTrue(result.filterNot { it.progressPercent >= 0 }.isEmpty())
    }

    @Test
    fun `getProgrammeForDay should return list with some progressPercentages should not be zero`() {
        val dateTime = getCurrentDateTime()
        val amount = 10

        val result = repository.getProgrammesForDateTime(dateTime, amount)

        assertTrue(result.any { it.progressPercent > 0 })
    }

    @Test
    fun `getProgrammeForDay should return list with all startTimes happening after startTimes`() {
        val dateTime = getCurrentDateTime()
        val amount = 10

        val result = repository.getProgrammesForDateTime(dateTime, amount)

        assertTrue(result.all { it.startTime < it.endTime })
    }

    @Test
    @Disabled
    fun `print all programmes from getProgrammeForDay`() {
        val dateTime = getCurrentDateTime()
        val amount = 10

        val result = repository.getProgrammesForDateTime(dateTime, amount)

        result.forEach {
            println(it)
        }
    }

    private fun getCurrentDateTime(): Date = Calendar.getInstance().time
}