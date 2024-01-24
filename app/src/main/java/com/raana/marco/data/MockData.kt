package com.raana.marco.data

import com.raana.marco.data.model.Place

class MockData{
    companion object{
        val placeList = listOf(
            Place(
                name = "Eiffel Tower",
                description = "The Eiffel Tower is a wrought-iron lattice tower on the Champ de Mars in Paris, France. It is one of the most iconic landmarks in the world.",
                imageUrl = "https://images.squarespace-cdn.com/content/v1/58fbfecf725e25a3d1966494/1617153558938-JPZWR94CWYCRICXG933L/image-asset.jpeg?format=500w"
            ),
            Place(
                name = "Grand Canyon",
                description = "The Grand Canyon is a steep-sided canyon carved by the Colorado River in Arizona, United States. It is known for its breathtaking views and unique rock formations.",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/3/31/Canyon_River_Tree_%28165872763%29.jpeg"
            ),
            Place(
                name = "Machu Picchu",
                description = "Machu Picchu is an ancient Inca citadel situated on a mountain ridge in the Andes of Peru. It is a UNESCO World Heritage Site and one of the New Seven Wonders of the World.",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Machu_Picchu%2C_Peru.jpg/1200px-Machu_Picchu%2C_Peru.jpg"
            ),
            Place(
                name = "Sydney Opera House",
                description = "The Sydney Opera House is a multi-venue performing arts center in Sydney, Australia. It is one of the most famous and distinctive buildings in the world.",
                imageUrl = "https://media.architecturaldigest.com/photos/63d82d299dd44a3242d15ade/3:2/w_3000,h_2000,c_limit/GettyImages-982774858.jpg"
            ),
            Place(
                name = "Great Wall of China",
                description = "The Great Wall of China is a series of fortifications made of stone, brick, tamped earth, wood, and other materials, generally built along the northern borders of China to protect against invasions.",
                imageUrl = "https://images.nationalgeographic.org/image/upload/t_edhub_resource_key_image/v1638892506/EducationHub/photos/the-great-wall-of-china.jpg"
            ),
            Place(
                name = "Victoria Falls",
                description = "Victoria Falls is a waterfall on the Zambezi River at the border between Zambia and Zimbabwe. It is one of the largest and most famous waterfalls in the world.",
                imageUrl = "https://cdn.britannica.com/91/5391-050-78522514/Victoria-Falls-bridge-Zambezi-River-Zimbabwe-Zambia.jpg"
            )
        )


    }
}