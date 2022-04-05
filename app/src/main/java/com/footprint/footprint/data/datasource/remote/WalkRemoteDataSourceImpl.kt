package com.footprint.footprint.data.datasource.remote

import com.footprint.footprint.data.dto.BaseResponse
import com.footprint.footprint.data.dto.Result
import com.footprint.footprint.data.repository.remote.BaseRepository
import com.footprint.footprint.data.retrofit.WalkService
import okhttp3.MultipartBody
import okhttp3.RequestBody

class WalkRemoteDataSourceImpl(private val api: WalkService): BaseRepository(), WalkRemoteDataSource {
    override suspend fun getWalkByIdx(walkIdx: Int): Result<BaseResponse> {
        return safeApiCall { api.getWalkByIdx(walkIdx).body()!! }
    }

    override suspend fun deleteWalk(walkIdx: Int): Result<BaseResponse> {
        return safeApiCall { api.deleteWalk(walkIdx).body()!! }
    }

    override suspend fun writeWalk(
        walk: RequestBody,
        footprintList: RequestBody,
        photos: List<MultipartBody.Part>
    ): Result<BaseResponse> {
        return safeApiCall { api.writeWalk(walk, footprintList, photos).body()!! }
    }
}