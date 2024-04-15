package com.example.sports_news_and_info_app.models

class Event(val name:String,val description:String, val date:String) {}

object eventData {
    val data = mutableListOf(
        Event(
            "UEFA Champions League Final",
            "Experience the pinnacle of European club football as the top teams compete for glory.",
            "May, 28 2024"
        ),
        Event(
            "NBA Finals",
            "Witness the excitement of the NBA Finals as the best teams in basketball battle for the championship title.",
            "June, 1 2024"
        ),
        Event(
            "Tokyo Olympic Games",
            "Get ready for the world's biggest sporting event as athletes from around the globe gather in Tokyo, Japan.",
            "July, 23 2024"
        ),
        Event(
            "Wimbledon Championships",
            "Enjoy the elegance and intensity of tennis at the Wimbledon Championships, one of the most prestigious events in the sport.",
            "June, 24 2024"
        ),
        Event(
            "Tour de France",
            "Follow the thrilling action of the Tour de France, cycling's most prestigious stage race.",
            "July, 6 2024"
        )
    )

    fun add(item: Event) {
        data.add(item)
    }
    fun getAll(): List<Event>{
        return this.data;
    }
}