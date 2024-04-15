package com.example.sports_news_and_info_app.models

class Sport(val sportType:String,val sportName:String, val instruction:String) {}

object SportsData {
    val newsList = mutableListOf(Sport("Measure", "High Jump", "The high jump is an athletics event in which competitors must jump over a horizontal bar placed at measured heights without dislodging it. Athletes sprint towards the bar and use a technique involving a curved approach, a 'flop' or 'scissors' kick, and clearance over the bar. The winner is the athlete who clears the highest height."),
        Sport("Precision", "Dart", "Darts is a precision sport where players throw small, pointed missiles known as darts at a circular target, called a dartboard. The objective is to hit specific sections of the board to score points, with the highest points awarded for hitting the center bullseye. Players must demonstrate accuracy and consistency to excel in this game."),
        Sport("Spectacle", "Skating", "Skating includes various disciplines such as figure skating, speed skating, and ice hockey, each offering its own unique spectacle. Figure skating combines athleticism and artistry with graceful routines performed on ice, while speed skating focuses on pure speed and endurance. Ice hockey is a fast-paced team sport characterized by skillful plays, physicality, and intense competition."),
        Sport("Combat", "UFC", "The Ultimate Fighting Championship (UFC) is the premier organization for mixed martial arts (MMA) competition. Fighters from diverse martial arts backgrounds face off in the octagon, using a combination of striking and grappling techniques to defeat their opponents. UFC events are known for their intensity, excitement, and unpredictability."),
        Sport("Play", "Football", "Football, also known as soccer in some regions, is the world's most popular sport. Played between two teams of eleven players each, the objective is to score goals by kicking the ball into the opponent's net. Football is characterized by its dynamic pace, skillful ball control, strategic gameplay, and passionate fanbase."))

    fun add(news: Sport) {
        newsList.add(news)
    }
    fun getAll(): List<Sport>{
        return this.newsList;
    }
}