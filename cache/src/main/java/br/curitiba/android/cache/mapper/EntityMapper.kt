package br.curitiba.android.cache.mapper

interface EntityMapper<ENTITY, DATA> {

    fun mapToData(cache: ENTITY): DATA

    fun mapToEntity(data: DATA): ENTITY
}
