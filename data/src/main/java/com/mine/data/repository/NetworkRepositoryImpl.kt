package com.mine.data.repository



//class NetworkRepositoryImpl(
//    private val networkStorage: NetworkStorage,
//) : NetworkRepository {
//    override suspend fun getServers(): List<ServersDto> {
//        try {
//            val response = networkStorage.getServers()
//            if (response.isSuccessful) {
//                response.body()?.let { serversDto ->
//                    val oneList = mutableListOf<ServersDto>()
//                    oneList.add(ServersDto(serversDto.data.map { data ->
//                        Data(data.name, data.id, data.fields.map { field ->
//                            Field(
//                                field.title ?: "",
//                                field.ip ?: "",
//                                field.port ?: "",
//                                field.image ?: "",
//                                field.version ?: "",
//                                field.description ?: ""
//                            )
//                        })
//                    }))
//                    return oneList
//                }
//            }
//        } catch (e: Exception) {
//            println(e.message)
//        }
//        return emptyList()
//    }
//}

