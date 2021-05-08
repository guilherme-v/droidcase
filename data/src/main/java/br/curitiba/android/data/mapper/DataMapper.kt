package br.curitiba.android.data.mapper

interface DataMapper<DATA, DOMAIN> {

    fun mapToDomain(data: DATA): DOMAIN

    fun mapToData(domain: DOMAIN): DATA
}

