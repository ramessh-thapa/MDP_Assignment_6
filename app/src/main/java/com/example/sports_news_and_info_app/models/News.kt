package com.example.sports_news_and_info_app.models

class News(val newsUrl:String,val newsName:String, val description:String) {}

object newsData {
    val newsList = mutableListOf(
        News(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFma0ml-RHnFRT_ULGsz-DPNpesC9el7RtadYFD69jlBDglkGIrFQUwypuj5Gjewbebwo&usqp=CAU",
            "Cricket World Cup 2023",
            "The Cricket World Cup 2023 is set to be held in India. With excitement building up among fans around the world, anticipation is high for what promises to be an exhilarating tournament featuring the best cricketing nations."
        ),
        News(
            "https://e00-marca.uecdn.es/assets/multimedia/imagenes/2022/05/23/16532937089620.jpg",
            "Football Transfer News",
            "The football transfer window is in full swing, with clubs across Europe vying for top talent. From blockbuster signings to surprise moves, the transfer market is heating up as teams strengthen their squads for the upcoming season."
        ),
        News(
            "https://img.olympics.com/images/image/private/t_s_pog_staticContent_hero_lg/f_auto/primary/h7396yowrdrk6nufnzbm",
            "Field Hockey World Cup",
            "The Field Hockey World Cup is underway, with teams from around the globe competing for glory. As the world's premier international field hockey tournament, fans can expect intense matches and unforgettable moments on the pitch."
        )
    )

    fun addNews(news: News) {
        newsList.add(news)
    }
    fun getAllNews(): List<News>{
        return this.newsList;
    }
}