package core.mapper

interface Mapper<I : Any, O : Any> {
    fun map(input: I): O
}