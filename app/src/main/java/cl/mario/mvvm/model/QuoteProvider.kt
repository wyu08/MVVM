package cl.mario.mvvm.model


class QuoteProvider {
    companion object {
        fun random(): QuoteModel{
            val position = (0..10).random()
            return quote[position]
        }
        private val quote = listOf<QuoteModel>(
            QuoteModel(
                quote = "No temo a los ordenadores; lo que temo es quedarme sin ellos",
                author = "Isaac Asimov"
            ),
            QuoteModel(
                quote = "Una vez un ordenador me venció jugando al ajedrez, pero no me opuso resistencia cuando pasamos al kick boxing",
                author = "Emo Philips"
            ),
            QuoteModel(
                quote = "La física es el sistema operativo del Universo",
                author = "Steven R Garman"
            ),
            QuoteModel(
                quote = "Sólo hay un problema con el sentido común: que no es demasiado común",
                author = "Milt Bryce"
            ),
            QuoteModel(
                quote = "Hazlo todo tan simple como sea posible, pero no más simple ",
                author = "Albert Einstein"
            ),
            QuoteModel(
                quote = "En dos años el problema del spam se habrá resuelto",
                author = "Bill Gates,2004"
            ),
            QuoteModel(
                quote = "Veo poco potencial comercial en Internet, al menos durante diez años",
                author = "Bill Gates, 1994"
            ),
            QuoteModel(
                quote = "El problema de los virus es pasajero. En un par de años estará resuelto",
                author = "John McAfee, 1988"
            ),
            QuoteModel(
                quote = "Los virus informáticos son una leyenda urbana",
                author = "Peter Norton, 1988"
            ),
            QuoteModel(
                quote = "En realidad no trato de destruir a Microsoft: eso será sólo un efecto colateral no intencionado",
                author = "Linus Torvalds"
            ),
            QuoteModel(
                quote = "Las contraseñas son como la ropa interor. No puedes dejar que nadie la vea, debes cambiarla regularmente y no debes compartirla con extraños",
                author = "Chris Pirillo"
            ),
            QuoteModel(
                quote = "En el futuro es posible que los ordenadores no pesen más de 1,5 toneladas",
                author = "Popular mechanics, 1949"
            )
        )
    }
}