package com.threads.app.utils

import com.threads.app.data.Post
import java.util.Random

class Utils {

    fun generateDummyPosts(): List<Post> {
        val postTypes = listOf("image", "text")
        val titles = listOf(
            "Beautiful Sunset",
            "City Skyline",
            "Amazing Nature",
            "Wonderful Day",
            "Incredible View",
            "Stunning Landscape",
            "Epic Adventure",
            "Cool Breeze",
            "Dreamy Night",
            "Serene Moments"
        )
        val descriptions = listOf(
            "A stunning sunset over the mountains with vivid colors and breathtaking views. The sky transforms into a canvas of fiery reds, oranges, and pinks as the sun dips below the horizon. The mountains silhouette against the vibrant backdrop, creating a tranquil scene that evokes a sense of peace and wonder. This magnificent display of nature's beauty reminds us of the simple joys of life and the importance of taking a moment to appreciate the world around us.",
            "A breathtaking view of the city skyline at night with sparkling lights and towering buildings. The city comes alive after dark, with illuminated skyscrapers creating a dazzling display of colors and shapes. Street lights and neon signs add a vibrant energy to the scene, reflecting off the water below and creating a mesmerizing cityscape. This urban panorama captures the dynamic spirit of the metropolis and the excitement that comes with the nighttime hustle and bustle.",
            "An incredible landscape with lush greenery and picturesque scenery that captures the essence of nature. Rolling hills covered in vibrant green grass stretch out as far as the eye can see, dotted with colorful wildflowers and framed by majestic trees. A meandering river winds through the landscape, adding a touch of serenity to the scene. This idyllic setting offers a perfect escape from the daily grind, inviting you to relax and immerse yourself in the beauty of the natural world.",
            "A cool breeze on a warm day, providing relief and tranquility with gentle whispers of nature. The refreshing wind rustles through the trees and caresses your skin, offering a welcome respite from the heat. The air is filled with the subtle sounds of nature, from the distant chirping of birds to the soft rustling of leaves. This simple pleasure is a reminder of the small but meaningful ways that nature enhances our lives and brings comfort and peace.",
            "A dreamy night under the stars, offering a serene and peaceful experience with the twinkling sky. The vast expanse of the night sky is dotted with countless stars, creating a breathtaking display of celestial beauty. The quiet of the night is interrupted only by the occasional shooting star or the distant call of nocturnal creatures. This tranquil scene invites contemplation and relaxation, allowing you to connect with the cosmos and appreciate the vastness of the universe.",
            "A wonderful day spent exploring new places and experiencing the beauty of the world around us. From hiking through lush forests to strolling along picturesque beaches, each moment is filled with discovery and adventure. The sights and sounds of nature offer a sensory feast, while the sense of accomplishment from exploring new terrain adds to the joy of the experience. This day of exploration is a celebration of the wonders of the natural world and the thrill of adventure.",
            "An epic adventure filled with excitement and exploration, discovering new horizons and unforgettable moments. The journey takes you through diverse landscapes, from rugged mountains to serene valleys, each offering its own unique charm. The thrill of new experiences and the camaraderie of fellow adventurers create lasting memories and a sense of accomplishment. This epic quest is a testament to the spirit of exploration and the rewards of pushing beyond the familiar.",
            "A serene moment by the water, with calm reflections and soothing sounds of nature. The stillness of the water creates a perfect mirror, reflecting the surrounding landscape and the clear blue sky above. The gentle lapping of the water against the shore and the distant call of birds add to the sense of tranquility. This peaceful setting offers a chance to relax and unwind, providing a much-needed escape from the demands of everyday life.",
            "An amazing nature scene with vibrant colors and rich textures, showcasing the splendor of the outdoors. The landscape is alive with the hues of fall foliage, the intricate patterns of a butterfly's wings, and the sparkling surface of a crystal-clear lake. Each element contributes to a vibrant and dynamic tapestry of natural beauty, inviting you to immerse yourself in the richness of the environment. This scene highlights the incredible diversity and splendor of the natural world.",
            "A day of relaxation and joy, enjoying simple pleasures and the beauty of everyday life. From sipping a cup of coffee on a sunny morning to sharing laughter with friends in the evening, the day is filled with small moments of happiness and contentment. The beauty of the ordinary is celebrated through simple experiences and cherished memories, reminding us to find joy in the little things and appreciate the everyday miracles that enrich our lives."
        )

        val random = Random()
        val posts = mutableListOf<Post>()

        for (i in 1..150) {
            val type = postTypes[random.nextInt(postTypes.size)]
            val imageUrl = if (type == "image") {
                val width = random.nextInt(100) + 600
                val height = random.nextInt(100) + 600
                "https://picsum.photos/$width/$height"
            } else {
                null
            }
            val title = titles[random.nextInt(titles.size)]
            val description = descriptions[random.nextInt(descriptions.size)]

            posts.add(
                Post(
                    id = i,
                    imageUrl = imageUrl,
                    type = type,
                    title = title,
                    videoUrl = if (type == "video") "https://example.com/video$i.mp4" else null,
                    description = if (type == "text") description else description
                )
            )
        }
        return posts
    }

//    fun generateDummyPosts(): List<Post> {
//        return listOf(
//            Post(
//                id = 1,
//                imageUrl = "https://picsum.photos/200/300",
//                type = "image",
//                title = "Beautiful Sunset",
//                videoUrl = null,
//                description = "A stunning sunset over the mountains."
//            ),
//            Post(
//                id = 3,
//                imageUrl = null,
//                type = "text",
//                title = "This is Text only Post",
//                videoUrl = null,
//                description = "Here is a motivational quote: 'Believe in yourself and all that you are.'"
//            ),
//            Post(
//                id = 4,
//                imageUrl = "https://picsum.photos/200/400",
//                type = "image",
//                title = "City Skyline",
//                videoUrl = null,
//                description = "A breathtaking view of the city skyline at night."
//            ),
//
//        )
//    }
}