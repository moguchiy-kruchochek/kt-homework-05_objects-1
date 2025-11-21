import org.junit.Test

import org.junit.Assert.*
import ru.netology.*

class WallServiceTest {

    @Test
    fun add() {
        val service = WallService()
        val likes = Likes()

        val video = Video(1,1,"video_title",50)
        val videoAttachment = VideoAttachment(video)

        val audio = Audio(2,2,"artist", "song")
        val audioAttachment = AudioAttachment(audio)

        val photo = Photo(1,1,"description here",640,480)
        val photoAttachment = PhotoAttachment(photo)

        val note = Note(1, 1,"note","note's text")
        val noteAttachment = NoteAttachment(note)

        val link = Link("www.url.com","link","good link")
        val linkAttachment = LinkAttachment(link)

        val post = Post(3,
            "31.10.21",
            "text33",
            true,
            "NEauthor",
            true,
            true,
            false,
            likes,
            arrayOf(videoAttachment,audioAttachment,photoAttachment,noteAttachment,linkAttachment))

        val result = service.add(post)
        assertEquals(1, result.id)
    }

    @Test
    fun updateExistingWithTrueResult() {
        val service = WallService()
        val likes = Likes()

        val video = Video(1,1,"video_title",50)
        val videoAttachment = VideoAttachment(video)

        val audio = Audio(2,2,"artist", "song")
        val audioAttachment = AudioAttachment(audio)

        val photo = Photo(1,1,"description here",640,480)
        val photoAttachment = PhotoAttachment(photo)

        val note = Note(1, 1,"note","note's text")
        val noteAttachment = NoteAttachment(note)

        val link = Link("www.url.com","link","good link")
        val linkAttachment = LinkAttachment(link)

        service.add(Post(0,
            "11.11.20",
            "text51",
            true,
            "authorr",
            true,
            false,
            null,
            likes,
            arrayOf(videoAttachment,audioAttachment,photoAttachment,noteAttachment,linkAttachment)))
        service.add(Post(0,
            "23.12.21",
            "super text",
            false,
            "corp",
            null,
            true,
            false,
            likes,
            arrayOf(videoAttachment,audioAttachment,photoAttachment,noteAttachment,linkAttachment)))
        service.add(Post(0,
            "03.03.25",
            "important",
            null,
            "mine",
            true,
            false,
            false,
            likes,
            arrayOf(videoAttachment,audioAttachment,photoAttachment,noteAttachment,linkAttachment)))

        val update = Post(3,
            "03.04.25",
            "IMPORTANT!",
            null,
            "me",
            null,
            null,
            null,
            likes,
            arrayOf(videoAttachment,audioAttachment,photoAttachment,noteAttachment,linkAttachment))

        val result = service.update(update)

        assertTrue("The Post updated!", result)
    }

    @Test
    fun updateWithFalseResult() {
        val service = WallService()
        val likes = Likes()

        val video = Video(1,1,"video_title",50)
        val videoAttachment = VideoAttachment(video)

        val audio = Audio(2,2,"artist", "song")
        val audioAttachment = AudioAttachment(audio)

        val photo = Photo(1,1,"description here",640,480)
        val photoAttachment = PhotoAttachment(photo)

        val note = Note(1, 1,"note","note's text")
        val noteAttachment = NoteAttachment(note)

        val link = Link("www.url.com","link","good link")
        val linkAttachment = LinkAttachment(link)

        service.add(Post(0,
            "11.11.20",
            "text51",
            true,
            "authorr",
            true,
            false,
            true,
            likes,
            arrayOf(videoAttachment,audioAttachment,photoAttachment,noteAttachment,linkAttachment))
            )
        service.add(Post(0,
            "23.12.21",
            "super text",
            false,
            "corp",
            false,
            true,
            false,
            likes,
            arrayOf(videoAttachment,audioAttachment,photoAttachment,noteAttachment,linkAttachment))
            )
        service.add(Post(0,
            "03.03.25",
            "important",
            false,
            "mine",
            true,
            false,
            false,
            likes,
            arrayOf(videoAttachment,audioAttachment,photoAttachment,noteAttachment,linkAttachment))
            )

        val update = Post(6,
            "03.04.25",
            "IMPORTANT!",
            null,
            "me",
            null,
            null,
            null,
            likes,
            arrayOf(videoAttachment,audioAttachment,photoAttachment,noteAttachment,linkAttachment))

        val result = service.update(update)

        assertFalse("No Posts with such ID :(", result)
    }
}