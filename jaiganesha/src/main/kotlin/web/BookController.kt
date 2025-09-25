
package com.example.jaiganesha.web

import com.example.jaiganesha.model.Book
import com.example.jaiganesha.repo.BookRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/books")
class BookController(private val repo: BookRepository) {

    @GetMapping
    fun all(): List<Book> = repo.findAll()

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): ResponseEntity<Book> =
        repo.findById(id).map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())

    @PostMapping
    fun create(@RequestBody book: Book): Book = repo.save(book)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody updated: Book): ResponseEntity<Book> {
        return repo.findById(id)
            .map { existing ->
                existing.title = updated.title
                existing.author = updated.author
                ResponseEntity.ok(repo.save(existing))
            }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        return if (repo.existsById(id)) {
            repo.deleteById(id)
            ResponseEntity.noContent().build()
        } else ResponseEntity.notFound().build()
    }
}