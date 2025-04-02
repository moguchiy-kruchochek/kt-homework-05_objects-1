import org.junit.Test

import org.junit.Assert.*
import ru.netology.Likes
import ru.netology.Post
import ru.netology.WallService

class WallServiceTest {

    @Test
    fun add() {
        val service = WallService()
        val likes = Likes()
        val post = Post(3, "31.10.21", "text33", true, "NEauthor", true, true, false, likes)

        val result = service.add(post)
        assertEquals(1, result.id)
    }

    @Test
    fun updateExistingWithTrueResult() {
        val service = WallService()
        val likes = Likes()
        service.add(Post(0, "11.11.20", "text51", true, "authorr", true, false, true, likes))
        service.add(Post(0, "23.12.21", "super text", false, "corp", false, true, false, likes))
        service.add(Post(0, "03.03.25", "important", false, "mine", true, false, false, likes))

        val update = Post(3, "03.04.25", "IMPORTANT!", false, "me", true, false, false, likes)
        val result = service.update(update)

        assertTrue("The Post updated!", result)
    }

    @Test
    fun updateWithFalseResult() {
        val service = WallService()
        val likes = Likes()
        service.add(Post(0, "11.11.20", "text51", true, "authorr", true, false, true, likes))
        service.add(Post(0, "23.12.21", "super text", false, "corp", false, true, false, likes))
        service.add(Post(0, "03.03.25", "important", false, "mine", true, false, false, likes))

        val update = Post(6, "03.04.25", "IMPORTANT!", false, "me", true, false, false, likes)
        val result = service.update(update)

        assertFalse("No Posts with such ID :(", result)
    }
}