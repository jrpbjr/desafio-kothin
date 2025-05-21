enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

// Usuário agora tem nome
data class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(
    val nome: String,
    val nivel: Nivel,
    var conteudos: List<ConteudoEducacional>
) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (usuario !in inscritos) {
            inscritos.add(usuario)
            println("Usuário ${usuario.nome} matriculado na formação $nome com sucesso!")
        } else {
            println("Usuário ${usuario.nome} já está matriculado na formação $nome.")
        }
    }

    fun listarInscritos() {
        println("Alunos inscritos na formação $nome:")
        inscritos.forEach { println("- ${it.nome}") }
    }
}

fun main() {
    // Criando conteúdos educacionais
    val kotlinBasico = ConteudoEducacional("Introdução ao Kotlin", 90)
    val pooKotlin = ConteudoEducacional("Programação Orientada a Objetos com Kotlin", 120)

    // Criando uma formação
    val formacaoKotlin = Formacao(
        nome = "Formação Kotlin Developer",
        nivel = Nivel.INTERMEDIARIO,
        conteudos = listOf(kotlinBasico, pooKotlin)
    )

    // Criando usuários
    val joao = Usuario("João")
    val maria = Usuario("Maria")

    // Matriculando usuários
    formacaoKotlin.matricular(joao)
    formacaoKotlin.matricular(maria)
    formacaoKotlin.matricular(joao) // Testando repetição

    // Listando alunos
    formacaoKotlin.listarInscritos()
}
