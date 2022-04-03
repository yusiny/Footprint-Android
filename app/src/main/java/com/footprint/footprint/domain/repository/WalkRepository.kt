package com.footprint.footprint.domain.repository

import com.footprint.footprint.data.dto.BaseResponse
import com.footprint.footprint.data.dto.Result
import com.footprint.footprint.domain.model.Badge
import com.footprint.footprint.domain.model.Walk
import com.footprint.footprint.ui.walk.model.WalkUIModel

interface WalkRepository {
    suspend fun getWalkByIdx(walkIdx: Int): Result<Walk>
    suspend fun deleteWalk(walkIdx: Int): Result<BaseResponse>
    suspend fun writeWalk(walk: WalkUIModel): Result<List<Badge>>
}