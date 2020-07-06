package com.legend.home

import android.content.Context
import android.widget.TextView
import com.allin.commonadapter.ViewHolder
import com.allin.commonadapter.recyclerview.RecyclerViewBaseAdapter
import com.legend.R
import com.legend.entity.ArticleBean
import com.legend.entity.ArticleListBean

/**
 * @author wanglezhi
 * @date   2020/7/1 10:17
 * @discription
 */
class ArticleAdapter( mContext: Context,dataList:List<ArticleListBean>) :RecyclerViewBaseAdapter<ArticleListBean>(mContext, R.layout.item_article,dataList) {
    override fun convert(holder: ViewHolder?, item: ArticleListBean?, position: Int) {
        holder?.let {h ->
            item?.let { i->
                h.getView<TextView>(R.id.tvTitle).text = i.title
                h.getView<TextView>(R.id.tvChapter).text = i.chapterName

            }
        }


    }
}