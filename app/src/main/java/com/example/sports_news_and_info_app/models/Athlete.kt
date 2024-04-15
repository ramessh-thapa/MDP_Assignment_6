package com.example.sports_news_and_info_app.models

class Athlete(val name:String,val sport:String, val performance:String,
val country:String, val medal:String, val facts:String
) {}

object athletesData {
    val data = mutableListOf(
        Athlete(
        "Cristiano Ronaldo",
        "Football",
        "Ronaldo is one of the greatest footballers of all time. He has won numerous titles with clubs like Manchester United, Real Madrid, and Juventus, and has achieved remarkable success with the Portuguese national team.",
        "Portugal",
        "Gold",
        "Cristiano Ronaldo's exceptional goal-scoring ability and athleticism have earned him multiple Ballon d'Or awards and widespread acclaim."
        ),
        Athlete(
            "Katie Ledecky",
            "Swimming",
            "Ledecky is a dominant force in distance swimming, holding multiple world records and winning numerous Olympic gold medals.",
            "United States",
            "Gold",
            "Katie Ledecky's incredible endurance and technique make her nearly unbeatable in long-distance swimming events."
        ),
        Athlete(
            "Simone Biles",
            "Gymnastics",
            "Biles is considered one of the greatest gymnasts of all time. She has won numerous Olympic and World Championship titles.",
            "United States",
            "Gold",
            "Simone Biles' gravity-defying routines have redefined what is possible in gymnastics."
        ),
        Athlete(
            "Virat Kohli",
            "Cricket",
            "Kohli is one of the best cricketers in the world, known for his aggressive batting style and exceptional leadership as captain of the Indian cricket team.",
            "India",
            "Gold",
            "Virat Kohli's consistency and determination make him a standout performer in both Test and limited-overs cricket."
        ),
        Athlete(
            "Ellen van Dijk",
            "Cycling",
            "Van Dijk is a Dutch road and track cyclist, known for her time-trialing abilities. She has won multiple world championships and Olympic medals.",
            "Netherlands",
            "Gold",
            "Ellen van Dijk's powerful riding style and strategic prowess make her a force to be reckoned with in cycling competitions."
        ),
        Athlete(
            "Serena Williams",
            "Tennis",
            "Williams is one of the most successful tennis players of all time, with multiple Grand Slam titles to her name.",
            "United States",
            "Gold",
            "Serena Williams' powerful and dominant style of play has made her a legend in the world of tennis."
        ),
        Athlete(
            "Ellen Hoog",
            "Hockey",
            "Hoog is a Dutch field hockey player who has won multiple Olympic gold medals with the Netherlands women's national field hockey team.",
            "Netherlands",
            "Gold",
            "Ellen Hoog's skillful playmaking and scoring ability have been instrumental in the success of the Dutch field hockey team."
        ),
        Athlete(
            "Jesse Owens",
            "Athletics",
            "Owens was a track and field athlete who won four gold medals at the 1936 Berlin Olympics, disproving Nazi theories of Aryan supremacy.",
            "United States",
            "Gold",
            "Jesse Owens' historic victories at the 1936 Olympics were a powerful statement against racism and discrimination."
        ))

    fun add(news: Athlete) {
        data.add(news)
    }
    fun getAll(): List<Athlete>{
        return this.data;
    }
}