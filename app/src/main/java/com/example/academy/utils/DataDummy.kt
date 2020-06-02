package com.example.academy.utils

import com.example.academy.data.MovieEntity
import com.example.academy.data.TvShowEntity

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
                id = 1622,
                popularity = 114.544,
                poster_path = "https://image.tmdb.org/t/p/w500/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
                overview = "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. ",
                name = "Supernatural",
                first_air_date = "2005-09-13"
            )
        )

        return tvShowList
    }
}