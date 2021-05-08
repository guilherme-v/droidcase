package br.curitiba.android.domain.usecases.base

abstract class UseCase<T, in Params> {
    abstract suspend fun execute(params: Params? = null): T
}