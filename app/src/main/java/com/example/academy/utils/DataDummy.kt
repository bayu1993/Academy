package com.example.academy.utils

import com.example.academy.data.MovieEntity
import com.example.academy.data.TvShowEntity
import com.example.academy.data.sources.remote.response.MovieResponse
import com.example.academy.data.sources.remote.response.TvShowResponse
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

object DataDummy {
    fun generateDummyMovieList(): List<MovieEntity> {

        val movieList = ArrayList<MovieEntity>()

        movieList.add(
            MovieEntity(
                419704,
                "The near future, a time when both hope and hardships drive humanity to look to the stars and beyond. While a mysterious phenomenon menaces to destroy life on planet Earth, astronaut Roy McBride undertakes a mission across the immensity of space and its many perils to uncover the truth about a lost expedition that decades before boldly faced emptiness and silence in search of the unknown.",
                581.092,
                "https://image.tmdb.org/t/p/w500/xBHvZcjRiWyobQ9kxBhO6B2dtRI.jpg",
                "Ad Astra",
                "2019-09-17"
            )
        )

        movieList.add(
            MovieEntity(
                338762,
                "After he and his wife are murdered, marine Ray Garrison is resurrected by a team of scientists. Enhanced with nanotechnology, he becomes a superhuman, biotech killing machine—'Bloodshot'. As Ray first trains with fellow super-soldiers, he cannot recall anything from his former life. But when his memories flood back and he remembers the man that killed both him and his wife, he breaks out of the facility to get revenge, only to discover that there's more to the conspiracy than he thought.",
                189.2,
                "https://image.tmdb.org/t/p/w500/8WUVHemHFH2ZIP6NWkwlHWsyrEL.jpg",
                "Bloodshot",
                "2020-03-05"
            )
        )

        movieList.add(
            MovieEntity(
                686245,
                "A disgraced doctor and his family are held hostage at their home by criminals on the run, when a robbery-gone-awry requires them to seek immediate medical attention.",
                121.5,
                "https://image.tmdb.org/t/p/w500/niyXFhGIk4W2WTcX2Eod8vx2Mfe.jpg",
                "survive the Night",
                "2020-05-22"
            )
        )

        movieList.add(
            MovieEntity(
                454626,
                "Based on the global blockbuster videogame franchise from Sega, Sonic the Hedgehog tells the story of the world’s speediest hedgehog as he embraces his new home on Earth. In this live-action adventure comedy, Sonic and his new best friend team up to defend the planet from the evil genius Dr. Robotnik and his plans for world domination.",
                120.737,
                "https://image.tmdb.org/t/p/w500/aQvJ5WPzZgYVDrxLX4R6cLJCEaQ.jpg",
                "Sonic the Hedgehog",
                "2020-02-12"
            )
        )

        movieList.add(
            MovieEntity(
                38700,
                "Marcus and Mike are forced to confront new threats, career changes, and midlife crises as they join the newly created elite team AMMO of the Miami police department to take down the ruthless Armando Armas, the vicious leader of a Miami drug cartel.",
                112.965,
                "https://image.tmdb.org/t/p/w500/y95lQLnuNKdPAzw9F9Ab8kJ80c3.jpg",
                "Bad Boys for Life",
                "2020-01-15"
            )
        )

        movieList.add(
            MovieEntity(
                385103,
                "In Scooby-Doo’s greatest adventure yet, see the never-before told story of how lifelong friends Scooby and Shaggy first met and how they joined forces with young detectives Fred, Velma, and Daphne to form the famous Mystery Inc. Now, with hundreds of cases solved, Scooby and the gang face their biggest, toughest mystery ever: an evil plot to unleash the ghost dog Cerberus upon the world. As they race to stop this global “dogpocalypse,” the gang discovers that Scooby has a secret legacy and an epic destiny greater than anyone ever imagined.",
                143.71,
                "https://image.tmdb.org/t/p/w500/jHo2M1OiH9Re33jYtUQdfzPeUkx.jpg",
                "Scoob!",
                "2020-05-15"
            )
        )

        movieList.add(
            MovieEntity(
                475557,
                "In Scooby-Doo’s greatest adventure yet, see the never-before told story of how lifelong friends Scooby and Shaggy first met and how they joined forces with young detectives Fred, Velma, and Daphne to form the famous Mystery Inc. Now, with hundreds of cases solved, Scooby and the gang face their biggest, toughest mystery ever: an evil plot to unleash the ghost dog Cerberus upon the world. As they race to stop this global “dogpocalypse,” the gang discovers that Scooby has a secret legacy and an epic destiny greater than anyone ever imagined.",
                108.225,
                "https://image.tmdb.org/t/p/w500/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
                "Joker",
                "2019-10-02"
            )
        )

        movieList.add(
            MovieEntity(
                576156,
                "A couple experiences a defining moment in their relationship when they are unintentionally embroiled in a murder mystery. As their journey to clear their names takes them from one extreme – and hilarious - circumstance to the next, they must figure out how they, and their relationship, can survive the night.",
                82.929,
                "https://image.tmdb.org/t/p/w500/5jdLnvALCpK1NkeQU1z4YvOe2dZ.jpg",
                "The Lovebirds",
                "2020-05-22"
            )
        )

        movieList.add(
            MovieEntity(
                530915,
                "At the height of the First World War, two young British soldiers must cross enemy territory and deliver a message that will stop a deadly attack on hundreds of soldiers.",
                93.629,
                "https://image.tmdb.org/t/p/w500/iZf0KyrE25z1sage4SYFLCCrMi9.jpg",
                "1917",
                "2019-12-25"
            )
        )

        movieList.add(
            MovieEntity(
                620883,
                "Police officer Pipa works on her first big case while simultaneously investigating her boss, who is suspected of murder. The prequel to Perdida.",
                92.954,
                "https://image.tmdb.org/t/p/w500/m2rJGjlesDKxugl7ypW8n3Mipjl.jpg",
                "La corazonada",
                "2019-05-28"
            )
        )

        return movieList
    }

    fun generateDummyTvShow(): List<TvShowEntity> {

        val tvShowList = ArrayList<TvShowEntity>()

        tvShowList.add(
            TvShowEntity(
                60735,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                198.576,
                "https://image.tmdb.org/t/p/w500/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                "2014-10-07"
            )
        )

        tvShowList.add(
            TvShowEntity(
                2734,
                "Law & Order: Special Victims Unit",
                "In the criminal justice system, sexually-based offenses are considered especially heinous. In New York City, the dedicated detectives who investigate these vicious felonies are members of an elite squad known as the Special Victims Unit. These are their stories.",
                130.641,
                "https://image.tmdb.org/t/p/w500/6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg",
                "1999-09-20"
            )
        )

        tvShowList.add(
            TvShowEntity(
                456,
                "The Simpsons",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                118.78,
                "https://image.tmdb.org/t/p/w500/qcr9bBY6MVeLzriKCmJOv1562uY.jpg",
                "1989-12-17"
            )
        )

        tvShowList.add(
            TvShowEntity(
                id = 1403,
                popularity = 115.722,
                overview = "Agent Phil Coulson of S.H.I.E.L.D. (Strategic Homeland Intervention, Enforcement and Logistics Division) puts together a team of agents to investigate the new, the strange and the unknown around the globe, protecting the ordinary from the extraordinary.",
                name = "Marvel's Agents of S.H.I.E.L.D.",
                first_air_date = "2013-09-24",
                poster_path = "https://image.tmdb.org/t/p/w500/gHUCCMy1vvj58tzE3dZqeC9SXus.jpg"
            )
        )

        tvShowList.add(
            TvShowEntity(
                id = 60625,
                popularity = 128.463,
                poster_path = "https://image.tmdb.org/t/p/w500/8kOWDBK6XlPUzckuHDo3wwVRFwt.jpg",
                overview = "Rick is a mentally-unbalanced but scientifically-gifted old man who has recently reconnected with his family. He spends most of his time involving his young grandson Morty in dangerous, outlandish adventures throughout space and alternate universes. Compounded with Morty's already unstable family life, these events cause Morty much distress at home and school.",
                name = "Rick and Morty",
                first_air_date = "2013-12-02"
            )
        )

        tvShowList.add(
            TvShowEntity(
                id = 1622,
                popularity = 114.544,
                poster_path = "https://image.tmdb.org/t/p/w500/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
                overview = "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. ",
                name = "Supernatural",
                first_air_date = "2005-09-13"
            )
        )

        tvShowList.add(
            TvShowEntity(
                id = 1396,
                popularity = 112.885,
                poster_path = "https://image.tmdb.org/t/p/w500/ggFHVNu6YYI5L9pCfOacjizRGt.jpg",
                overview = "When Walter White, a New Mexico chemistry teacher, is diagnosed with Stage III cancer and given a prognosis of only two years left to live. He becomes filled with a sense of fearlessness and an unrelenting desire to secure his family's financial future at any cost as he enters the dangerous world of drugs and crime.",
                name = "Breaking Bad",
                first_air_date = "2008-01-20"
            )
        )

        tvShowList.add(
            TvShowEntity(
                id = 79680,
                popularity = 111.862,
                poster_path = "https://image.tmdb.org/t/p/w500/n6UNHZoiYj81abwmG38HbNjflDx.jpg",
                overview = "Set more than seven years after the world has become a frozen wasteland, the remnants of humanity inhabit a gigantic, perpetually-moving train that circles the globe as class warfare, social injustice and the politics of survival play out. ",
                name = "Snowpiercer",
                first_air_date = "2020-05-17"
            )
        )

        tvShowList.add(
            TvShowEntity(
                id = 66017,
                popularity = 110.045,
                poster_path = "https://image.tmdb.org/t/p/w500/rOar34cNLn2sgDH5FmAa1bvMpBv.jpg",
                overview = "Ertuğrul Bey and the Knights Templar in the 13th century Alba and step and step with the struggle against brutal Mongols depicts the process of establishing the Ottoman principality.",
                name = "Resurrection: Ertugrul",
                first_air_date = "2014-12-11"
            )
        )

        tvShowList.add(
            TvShowEntity(
                id = 48866,
                popularity = 106.805,
                poster_path = "https://image.tmdb.org/t/p/w500/wcaDIAG1QdXQLRaj4vC1EFdBT2.jpg",
                overview = "100 years in the future, when the Earth has been abandoned due to radioactivity, the last surviving humans live on an ark orbiting the planet — but the ark won't last forever. So the repressive regime picks 100 expendable juvenile delinquents to send down to Earth to see if the planet is still habitable.",
                name = "The 100",
                first_air_date = "2014-03-19"
            )
        )
        return tvShowList
    }

    fun generateRemoteDummyMovie(): List<MovieResponse> {
        val movies = ArrayList<MovieResponse>()
        movies.add(
            MovieResponse(
                516486,
                "A first-time captain leads a convoy of allied ships carrying thousands of soldiers across the treacherous waters of the “Black Pit” to the front lines of WW2. With no air cover protection for 5 days, the captain and his convoy must battle the surrounding enemy Nazi U-boats in order to give the allies a chance to win the war.",
                266.526,
                "/kjMbDciooTbJPofVXgAoFjfX8Of.jpg",
                "Greyhound",
                "2020-07-10"

            )
        )
        movies.add(
            MovieResponse(
                547016,
                "Four undying warriors who've secretly protected humanity for centuries become targeted for their mysterious powers just as they discover a new immortal.",
                195.28,
                "/cjr4NWURcVN3gW5FlHeabgBHLrY.jpg",
                "The Old Guard",
                "2020-07-10"

            )
        )
        movies.add(
            MovieResponse(
                419704,
                "The near future, a time when both hope and hardships drive humanity to look to the stars and beyond. While a mysterious phenomenon menaces to destroy life on planet Earth, astronaut Roy McBride undertakes a mission across the immensity of space and its many perils to uncover the truth about a lost expedition that decades before boldly faced emptiness and silence in search of the unknown.",
                107.263,
                "/xBHvZcjRiWyobQ9kxBhO6B2dtRI.jpg",
                "Ad Astra",
                "2019-09-17"

            )
        )
        movies.add(
            MovieResponse(
                430155,
                "A young and talented architect comes to his senses after a horrific accident only to find himself in the odd dystopian world. A world that is filled with the memories of all current coma patients. Just like a human memory this world is fragmental, chaotic and unstable. This is COMA: icecaps, rivers and cities can all exist in a space of a single room and laws of physics are no longer laws as they can be bent.",
                149.231,
                "/1hVEsBS4vnozB1yAsMiqW0IMxyp.jpg",
                "Coma",
                "2019-11-19"

            )
        )
        movies.add(
            MovieResponse(
                583083,
                "High school senior Elle juggles a long-distance relationship with her dreamy boyfriend Noah, college applications, and a new friendship with a handsome classmate that could change everything.",
                219.526,
                "/pwmtGo0mTjTqWZwk3k3VSWtygxj.jpg",
                "The Kissing Booth 2",
                "2020-07-24"

            )
        )
        movies.add(
            MovieResponse(
                385103,
                "In Scooby-Doo’s greatest adventure yet, see the never-before told story of how lifelong friends Scooby and Shaggy first met and how they joined forces with young detectives Fred, Velma, and Daphne to form the famous Mystery Inc. Now, with hundreds of cases solved, Scooby and the gang face their biggest, toughest mystery ever: an evil plot to unleash the ghost dog Cerberus upon the world. As they race to stop this global “dogpocalypse,” the gang discovers that Scooby has a secret legacy and an epic destiny greater than anyone ever imagined.",
                139.434,
                "/jHo2M1OiH9Re33jYtUQdfzPeUkx.jpg",
                "Scoob!",
                "2020-07-08"

            )
        )
        movies.add(
            MovieResponse(
                587496,
                "Two couples on an oceanside getaway grow suspicious that the host of their seemingly perfect rental house may be spying on them. Before long, what should have been a celebratory weekend trip turns into something far more sinister.",
                132.837,
                "/3ynPnBXQVT2Y0s19fDIPlWKUlxH.jpg",
                "The Rental",
                "2020-07-23"

            )
        )
        movies.add(
            MovieResponse(
                454983,
                "When teenager Elle's first kiss leads to a forbidden romance with the hottest boy in high school, she risks her relationship with her best friend.",
                126.302,
                "/7Dktk2ST6aL8h9Oe5rpk903VLhx.jpg",
                "The Kissing Booth",
                "2018-05-11"

            )
        )
        movies.add(
            MovieResponse(
                587496,
                "Inspector Amaia Salazar confronts the origins of her nightmares as she unfolds the darkest secrets of the Baztan valley. Part 3 in the Baztan Trilogy.",
                106.733,
                "/bUi0xPSrxrL7xOD1bIE1RtnMWtn.jpg",
                "Offering to the Storm",
                "2020-07-24"

            )
        )
        movies.add(
            MovieResponse(
                475557,
                "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
                109.202,
                "/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
                "Joker",
                "2019-10-02"

            )
        )

        return movies
    }

    fun generateRemoteDummyTvShow(): List<TvShowResponse> {
        val tvShow = ArrayList<TvShowResponse>()
        tvShow.add(
            TvShowResponse(
                2734,
                "Law & Order: Special Victims Unit",
                "In the criminal justice system, sexually-based offenses are considered especially heinous. In New York City, the dedicated detectives who investigate these vicious felonies are members of an elite squad known as the Special Victims Unit. These are their stories.",
                183.17,
                "/6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg",
                "1999-09-20"
            )
        )
        tvShow.add(
            TvShowResponse(
                1416,
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                130.418,
                "/jnsvc7gCKocXnrTXF6p03cICTWb.jpg",
                "2005-03-27"
            )
        )
        tvShow.add(
            TvShowResponse(
                60735,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                117.33,
                "/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                "2014-10-07"
            )
        )
        tvShow.add(
            TvShowResponse(
                456,
                "The Simpsons",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                111.951,
                "/qcr9bBY6MVeLzriKCmJOv1562uY.jpg",
                "1989-12-17"
            )
        )
        tvShow.add(
            TvShowResponse(
                105214,
                "Dark Desire",
                "Married Alma spends a fateful weekend away from home that ignites passion, ends in tragedy and leads her to question the truth about those close to her.",
                109.922,
                "/uxFNAo2A6ZRcgNASLk02hJUbybn.jpg",
                "2020-07-15"
            )
        )
        tvShow.add(
            TvShowResponse(
                68126,
                "Norsemen",
                "Norsemen is an epic and humorous drama series set in the Viking Age. The residents of an 8th-century Viking village experience political rivalry, social change and innovations that upend their culture and way of life.",
                109.228,
                "/xCt02AL7i395Nwfq8jbq1C54mvX.jpg",
                "2016-10-14"
            )
        )
        tvShow.add(
            TvShowResponse(
                1668,
                "Friends",
                "The misadventures of a group of friends as they navigate the pitfalls of work, life and love in Manhattan.",
                97.739,
                "/f496cm9enuEsZkSPzCwnTESEK5s.jpg",
                "1994-09-22"
            )
        )
        tvShow.add(
            TvShowResponse(
                1622,
                "Supernatural",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. ",
                96.391,
                "/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
                "1989-12-17"
            )
        )
        tvShow.add(
            TvShowResponse(
                12971,
                "Dragon Ball Z",
                "Five years have passed since the fight with Piccolo Jr., and Goku now has a son, Gohan. The peace is interrupted when an alien named Raditz arrives on Earth in a spacecraft and tracks down Goku, revealing to him that that they are members of a near-extinct warrior race called the Saiyans.",
                96.012,
                "/dBsDWUcdfbuZwglgyeeQ9ChRoS4.jpg",
                "1989-04-26"
            )
        )
        tvShow.add(
            TvShowResponse(
                1403,
                "Marvel's Agents of S.H.I.E.L.D.",
                "Agent Phil Coulson of S.H.I.E.L.D. (Strategic Homeland Intervention, Enforcement and Logistics Division) puts together a team of agents to investigate the new, the strange and the unknown around the globe, protecting the ordinary from the extraordinary.",
                93.738,
                "/gHUCCMy1vvj58tzE3dZqeC9SXus.jpg",
                "2013-09-24"
            )
        )

        return tvShow

    }

    fun getDisplayDate(dateEvent: String): String {
        val localeId = Locale("in")
        val date = SimpleDateFormat("yyyy-MM-dd", localeId).parse(dateEvent)
        val format = SimpleDateFormat("EEEE, dd MMMM yyyy", localeId)
        return format.format(date)
    }
}