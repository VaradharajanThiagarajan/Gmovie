| URI               | HTTP Method | HTTP Status |      Description            |       Request        |        Response        | 
|-------------------|-------------|-------------|----------------------      |----------------------|------------------------|
| /movies           |     Post     |201         |  Add movie to database     | { "title": "Aven" }`| None` |
  /movies           |     Get     | 201         |  Get all movie titles from database | None` | { "title": "Aven" }` |
  /movies           |     Get      | 201         |  Get movie by title name| { "title": "Aven" }  | { "title": "Aven" } |
