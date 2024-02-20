# Basic-Video-Call-Web with zegocloud

This project is a basic video-call web created by Angular and Java Spring boot.

## How to start
1. Create database in docker following this step [**PostgreSQL in docker**].
2. Create table user_video_call with
```
CREATE TABLE public.user_video_call (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR (100) UNIQUE NOT NULL, 
    password VARCHAR (100) NOT NULL, 
    email VARCHAR (100) UNIQUE NOT NULL, 
    status VARCHAR (20) UNIQUE NOT NULL, 
    created_date TIMESTAMP NOT NULL
);
```
3. Start this project.
4. Start Web project [https://github.com/Satsawat-Rodketkul/basic-video-call-web] with ```ng serve```.

## Reference
**Angular:** `https://www.youtube.com/watch?v=VTEDh2pNSBQ` \
**Spring Boot & Web:** `https://www.youtube.com/watch?v=k9WSsYA7-yY` \
**PostgreSQL in docker:** `https://www.commandprompt.com/education/how-to-create-a-postgresql-database-in-docker/` \
**Zegocloud:** `https://www.zegocloud.com/`
