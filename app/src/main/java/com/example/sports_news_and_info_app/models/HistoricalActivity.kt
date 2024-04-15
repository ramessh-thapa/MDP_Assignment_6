package com.miu.mdp.sporty.Pages.HistoricalActivitys.Model

class HistoricalActivity(val name:String,val description:String, val date:String) {}

object historicalEventData {
    val data = mutableListOf(
        HistoricalActivity(
            "Berlin 1936 Summer Olympics",
            "The Berlin 1936 Summer Olympics, officially known as the Games of the XI Olympiad, were held in Berlin, Germany.",
            "August, 1 1936"
        ),
        HistoricalActivity(
            "Miracle on Ice",
            "The 'Miracle on Ice' was a medal-round men's ice hockey game during the 1980 Winter Olympics in Lake Placid, New York.",
            "February, 22 1980"
        ),
        HistoricalActivity(
            "The Rumble in the Jungle",
            "The Rumble in the Jungle was a historic boxing event between Muhammad Ali and George Foreman in Kinshasa, Zaire (now Democratic Republic of the Congo) on October 30, 1974.",
            "October, 30 1974"
        ),
        HistoricalActivity(
            "The Thrilla in Manila",
            "The Thrilla in Manila was the third and final boxing match between Muhammad Ali and Joe Frazier. It took place on October 1, 1975, in Manila, Philippines.",
            "October, 1 1975"
        ),
        HistoricalActivity(
            "The Hand of God",
            "The Hand of God refers to a goal scored by Diego Maradona during the 1986 FIFA World Cup quarter-final match between Argentina and England.",
            "June, 22 1986"
        )
    )

    fun add(item: HistoricalActivity) {
        data.add(item)
    }
    fun getAll(): List<HistoricalActivity>{
        return this.data;
    }
}