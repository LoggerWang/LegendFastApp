package com.legend.api

import com.legend.entity.ArticleBean
import com.legend.entity.BaseDataBean
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * @author wanglezhi
 * @date   2020/6/30 14:05
 * @discription
 */
interface ArticleService {
    @GET("/article/list/{}/json")
    fun getArticleList():Observable<BaseDataBean<ArticleBean>>
}