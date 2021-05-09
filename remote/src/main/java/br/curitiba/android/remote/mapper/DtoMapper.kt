package br.curitiba.android.remote.mapper

interface DtoMapper<in DTO, out DATA> {

    fun mapToData(dto: DTO): DATA
}