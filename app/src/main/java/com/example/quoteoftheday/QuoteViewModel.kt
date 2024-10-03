package com.example.quoteoftheday

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class QuoteViewModel: ViewModel() {
    private val quotes = listOf(
        Quote(
            "It is better to fail in originality than to succeed in imitation.",
            "Herman Melville"
        ),
        Quote(
            "Nothing in the world can take the place of persistence. Talent will not; nothing is more common than unsuccessful men with talent. Genius will not; unrewarded genius is almost a proverb. Education will not; the world is full of educated derelicts. The slogan ‘Press On’ has solved and always will solve the problems of the human race.",
            "Calvin Coolidge"
        ),
        Quote(
            "Success is getting what you want; happiness is wanting what you get.",
            "W. P. Kinsella"
        ),
        Quote(
            "To know how much there is to know is the beginning of learning to live.",
            "Dorothy West"
        ),
        Quote(
            "Experience is a hard teacher because she gives the test first, the lesson afterward.",
            "Vernon Sanders Law"
        ),
        Quote(
            "The most difficult thing is the decision to act; the rest is merely tenacity.",
            "Amelia Earhart"
        ),
        Quote("Believe you can and you're halfway there.", "Theodore Roosevelt"),
        Quote("The only way to do great work is to love what you do.", "Steve Jobs"),
        Quote(
            "Success is not how high you have climbed, but how you make a positive difference to the world.",
            "Roy T. Bennett"
        ),
    )

    fun getRandomQuote(): Quote {
        return quotes[Random.nextInt(quotes.size)]
    }
}

data class Quote(val text: String, val author: String)
